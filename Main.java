import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Password length: ");
        int length = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Lowercase (y/n): ");
        boolean lower = scanner.nextLine().equals("y");

        System.out.print("Uppercase (y/n): ");
        boolean upper = scanner.nextLine().equals("y");

        System.out.print("Numbers (y/n): ");
        boolean numbers = scanner.nextLine().equals("y");

        System.out.print("Symbols (y/n): ");
        boolean symbols = scanner.nextLine().equals("y");

        String password = generatePassword(length, lower, upper, numbers, symbols);

        System.out.println("Password: " + password);
        System.out.println("Strength: " + checkStrength(password));
    }

    private static String generatePassword(int length, boolean lower, boolean upper, boolean numbers, boolean symbols) {
        StringBuilder password = new StringBuilder();
        StringBuilder chars = new StringBuilder();

        if (lower) chars.append("abcdefghijklmnopqrstuvwxyz");
        if (upper) chars.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        if (numbers) chars.append("0123456789");
        if (symbols) chars.append("!@#$%^&*()-_=+[]{}|;:,.<>?/");

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randIndex = random.nextInt(chars.length());
            password.append(chars.charAt(randIndex));
        }

        return password.toString();
    }

    private static String checkStrength(String password) {
        int score = 0;
        if (password.length() >= 12) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[!@#$%^&*()-_=+\\[\\]{}|;:,.<>?/].*")) score++;

        if (score >= 4) return "Very Strong";
        if (score == 3) return "Strong";
        if (score == 2) return "Moderate";
        return "Weak";
    }
}

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a message to encrypt: ");
        String message = scanner.nextLine();
        System.out.print("Enter the shift value (1-25): ");
        int shift = scanner.nextInt();

        String encryptedMessage = caesarCipherEncrypt(message, shift);
        System.out.println("Encrypted message: " + encryptedMessage);

        String decryptedMessage = caesarCipherDecrypt(encryptedMessage, shift);
        System.out.println("Decrypted message: " + decryptedMessage);

        scanner.close();
    }

    static String caesarCipherEncrypt(String message, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) ((c - base + shift) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    static String caesarCipherDecrypt(String message, int shift) {
        return caesarCipherEncrypt(message, 26 - shift);
    }
}


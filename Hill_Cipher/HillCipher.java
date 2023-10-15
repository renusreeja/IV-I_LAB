import java.util.Scanner;

public class HillCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input key matrix (3x3)
        int[][] keyMatrix = {
            {6, 24, 1},
            {13, 16, 10},
            {20, 17, 15}
        };

        System.out.print("Enter the plaintext (in uppercase): ");
        String plaintext = scanner.nextLine();

        String ciphertext = encrypt(plaintext, keyMatrix);
        System.out.println("Encrypted text: " + ciphertext);

        String decryptedText = decrypt(ciphertext, keyMatrix);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }

    public static String encrypt(String plaintext, int[][] keyMatrix) {
        StringBuilder ciphertext = new StringBuilder();

        // Pad the plaintext with 'X' if its length is not a multiple of 3
        while (plaintext.length() % 3 != 0) {
            plaintext += 'X';
        }

        for (int i = 0; i < plaintext.length(); i += 3) {
            int[] plaintextVector = new int[3];
            int[] ciphertextVector = new int[3];

            for (int j = 0; j < 3; j++) {
                plaintextVector[j] = plaintext.charAt(i + j) - 'A';
            }

            for (int j = 0; j < 3; j++) {
                ciphertextVector[j] = 0;
                for (int k = 0; k < 3; k++) {
                    ciphertextVector[j] += keyMatrix[j][k] * plaintextVector[k];
                }
                ciphertextVector[j] %= 26;
            }

            for (int j = 0; j < 3; j++) {
                ciphertext.append((char) (ciphertextVector[j] + 'A'));
            }
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int[][] keyMatrix) {
        // Calculate the inverse of the key matrix (you can precompute this)
        int[][] inverseMatrix = {
            {8,  5, 10},
            {21, 8,  21},
            {21, 12, 8}
        };

        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 3) {
            int[] ciphertextVector = new int[3];
            int[] decryptedVector = new int[3];

            for (int j = 0; j < 3; j++) {
                ciphertextVector[j] = ciphertext.charAt(i + j) - 'A';
            }

            for (int j = 0; j < 3; j++) {
                decryptedVector[j] = 0;
                for (int k = 0; k < 3; k++) {
                    decryptedVector[j] += inverseMatrix[j][k] * ciphertextVector[k];
                }
                decryptedVector[j] = (decryptedVector[j] + 26) % 26; // Ensure non-negative values
            }

            for (int j = 0; j < 3; j++) {
                decryptedText.append((char) (decryptedVector[j] + 'A'));
            }
        }

        return decryptedText.toString();
    }
}


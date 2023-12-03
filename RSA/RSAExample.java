import java.security.*;
import javax.crypto.Cipher;

public class RSAExample {

    public static void main(String[] args) throws Exception {
        // Generate RSA key pair
        KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();

        // Get public and private keys
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Original text
        String originalText = "Hello!";

        // Encrypt the text using the public key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(originalText.getBytes());

        // Decrypt the text using the private key
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes);

        // Display results
        System.out.println("Original Text: " + originalText);
        System.out.println("Encrypted Text: " + new String(encryptedBytes));
        System.out.println("Decrypted Text: " + decryptedText);
    }
}


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class BlowfishExample {

    public static void main(String[] args) throws Exception {
        String plaintext = "Hello world";

        // Generate a Blowfish key
        SecretKey blowfishKey = generateBlowfishKey();

        // Create Blowfish cipher
        Cipher blowfish = Cipher.getInstance("Blowfish");
        blowfish.init(Cipher.ENCRYPT_MODE, blowfishKey);

        // Encrypt the text
        byte[] encryptedBytes = blowfish.doFinal(plaintext.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        System.out.println("Original Text: " + plaintext);
        System.out.println("Encrypted Text: " + encryptedText);
    }

    private static SecretKey generateBlowfishKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        return keyGenerator.generateKey();
    }
}


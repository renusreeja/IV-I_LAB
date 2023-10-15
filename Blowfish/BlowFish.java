
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class BlowFish {

    public String encrypt(String password, String key) throws
        NoSuchAlgorithmException, NoSuchPaddingException,
        InvalidKeyException, IllegalBlockSizeException,
        BadPaddingException, UnsupportedEncodingException {
       
        byte[] KeyData = key.getBytes();
        SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, KS);
        String encryptedtext = Base64.getEncoder().
            encodeToString(cipher.doFinal(password.getBytes("UTF-8")));
        return encryptedtext;
    }

    public String decrypt(String encryptedtext, String key)
        throws NoSuchAlgorithmException, NoSuchPaddingException,
        InvalidKeyException, IllegalBlockSizeException,
        BadPaddingException {
       
        byte[] KeyData = key.getBytes();
        SecretKeySpec KS = new SecretKeySpec(KeyData, "Blowfish");
        byte[] ecryptedtexttobytes = Base64.getDecoder().
            decode(encryptedtext);
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, KS);
        byte[] decrypted = cipher.doFinal(ecryptedtexttobytes);
        String decryptedString = new String(decrypted, Charset.forName("UTF-8"));
        return decryptedString;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        System.out.print("Enter the encryption key: ");
        String key = scanner.nextLine();

        System.out.println("Password: " + password);
        BlowFish obj = new BlowFish();
        String enc_output = obj.encrypt(password, key);
        System.out.println("Encrypted text: " + enc_output);
        String dec_output = obj.decrypt(enc_output, key);
        System.out.println("Decrypted text: " + dec_output);

        scanner.close();
    }
}

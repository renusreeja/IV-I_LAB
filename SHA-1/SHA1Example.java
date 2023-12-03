import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA1Example {

    public static void main(String[] args) {
        String text = "Hello, SHA-1!";
        
        try {
            String sha1Hash = calculateSHA1(text);
            
            System.out.println("Original Text: " + text);
            System.out.println("SHA-1 Hash: " + sha1Hash);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-1 algorithm not available.");
            e.printStackTrace();
        }
    }

    private static String calculateSHA1(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] hashBytes = digest.digest(text.getBytes());

        // Convert the byte array to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
}


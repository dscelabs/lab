import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class pgm4 {
    public static void main(String[] args) {
        try {
            // Read text from file
            String text = new String(Files.readAllBytes(Paths.get("InputFile.txt")));

            // Generate Blowfish key
            KeyGenerator keyGen = KeyGenerator.getInstance("Blowfish");
            SecretKey key = keyGen.generateKey();

            // Create cipher object
            Cipher cipher = Cipher.getInstance("Blowfish");

            // Encrypt
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(text.getBytes());

            // Convert to base64 for readable output
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

            System.out.println("Original Text : " + text);
            System.out.println("Encrypted Text: " + encryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

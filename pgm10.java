import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class pgm10 {
    public static void main(String[] args) {
        try {
            // 1. Generate RSA Key Pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);     // key size
            KeyPair pair = keyGen.generateKeyPair();

            PublicKey publicKey = pair.getPublic();
            PrivateKey privateKey = pair.getPrivate();

            String text = "Hello RSA Encryption";

            // 2. Encrypt using PUBLIC key
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = encryptCipher.doFinal(text.getBytes());

            // Convert encrypted bytes to string (Base64)
            String encryptedText = java.util.Base64.getEncoder().encodeToString(encryptedBytes);

            // 3. Decrypt using PRIVATE key
            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = decryptCipher.doFinal(java.util.Base64
                    .getDecoder().decode(encryptedText));

            String decryptedText = new String(decryptedBytes);

            // Output
            System.out.println("Original Text  : " + text);
            System.out.println("Encrypted Text : " + encryptedText);
            System.out.println("Decrypted Text : " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

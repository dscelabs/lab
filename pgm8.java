import java.security.*;
import java.util.Base64;

public class pgm8 {
    public static void main(String[] args) {
        try {
            String message = "Hello, this is a digital signature test.";

            // 1. Generate RSA key pair
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair pair = keyGen.generateKeyPair();

            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();

            // 2. Create Signature object
            Signature sign = Signature.getInstance("SHA256withRSA");

            // 3. Sign the message using the private key
            sign.initSign(privateKey);
            sign.update(message.getBytes());
            byte[] signatureBytes = sign.sign();
            String signature = Base64.getEncoder().encodeToString(signatureBytes);

            // 4. Verify the signature using the public key
            Signature verifySign = Signature.getInstance("SHA256withRSA");
            verifySign.initVerify(publicKey);
            verifySign.update(message.getBytes());

            boolean isValid = verifySign.verify(signatureBytes);

            // Output
            System.out.println("Message        : " + message);
            System.out.println("Signature      : " + signature);
            System.out.println("Verification   : " + (isValid ? "Valid" : "Invalid"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

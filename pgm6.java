import java.security.MessageDigest;

public class pgm6 {
    public static void main(String[] args) {
        try {
            String text = "Hello World";  // your message

            // Create SHA-1 object
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Convert text to bytes and hash it
            byte[] digest = md.digest(text.getBytes());

            // Convert hash bytes to hexadecimal string
            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b));
            }

            System.out.println("Original Text: " + text);
            System.out.println("SHA-1 Digest : " + hex.toString());

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

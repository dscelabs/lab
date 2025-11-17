import java.security.MessageDigest;

public class pgm7 {
    public static void main(String[] args) {
        try {
            String text = "Hello World";  // your input text

            // Create MD5 object
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Convert text to bytes and calculate digest
            byte[] digest = md.digest(text.getBytes());

            // Convert bytes to hexadecimal format
            StringBuilder hex = new StringBuilder();
            for (byte b : digest) {
                hex.append(String.format("%02x", b));
            }

            System.out.println("Original Text: " + text);
            System.out.println("MD5 Digest   : " + hex.toString());

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

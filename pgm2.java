public class pgm2 {
    public static void main(String[] args) {
        String text = "Hello World";
        int key = 127;

        // Encrypt
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char encryptedChar = (char)(c ^ key);
            encrypted.append(encryptedChar);
        }

        // Decrypt (XOR again with the same key)
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            char decryptedChar = (char)(c ^ key);
            decrypted.append(decryptedChar);
        }

        System.out.println("Original:   " + text);
        System.out.println("Encrypted:  " + encrypted.toString());
        System.out.println("Decrypted:  " + decrypted.toString());
    }
}

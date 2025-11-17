public class pgm3a {
    public static void main(String[] args) {
        String text = "HELLO WORLD";
        int shift = 3; // Caesar cipher shift

        // Encrypt
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'A' && c <= 'Z') { 
                char e = (char)((c - 'A' + shift) % 26 + 'A');
                encrypted.append(e);
            } else {
                encrypted.append(c); // keep spaces as they are
            }
        }

        // Decrypt
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                char d = (char)((c - 'A' - shift + 26) % 26 + 'A');
                decrypted.append(d);
            } else {
                decrypted.append(c);
            }
        }

        System.out.println("Original:   " + text);
        System.out.println("Encrypted:  " + encrypted.toString());
        System.out.println("Decrypted:  " + decrypted.toString());
    }
}

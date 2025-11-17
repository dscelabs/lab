public class pgm3b {
    public static void main(String[] args) {

        String text = "HELLO WORLD";

        // Substitution mapping (A→Q, B→W, C→E, ... just an example)
        String normal =      "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String substitute =  "QWERTYUIOPASDFGHJKLZXCVBNM";

        // Encrypt
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                int index = normal.indexOf(c);
                encrypted.append(substitute.charAt(index));
            } else {
                encrypted.append(c); // keep spaces
            }
        }

        // Decrypt (reverse mapping)
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                int index = substitute.indexOf(c);
                decrypted.append(normal.charAt(index));
            } else {
                decrypted.append(c);
            }
        }

        System.out.println("Original:   " + text);
        System.out.println("Encrypted:  " + encrypted.toString());
        System.out.println("Decrypted:  " + decrypted.toString());
    }
}

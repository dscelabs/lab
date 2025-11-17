class pgm1 {
    public static void main(String[] args) {
        String text = "Hello World";

        // Convert the string into characters and XOR each with 0
        for (int i = 0; i < text.length(); i++) {
            char original = text.charAt(i);
            char xorResult = (char)(original ^ 0); // XOR with 0

            System.out.print(xorResult); // Print the result
        }
    }
}

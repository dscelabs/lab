import java.util.*;

public class pgm5 {

    // Convert keyword to numeric key order
    public static int[] generateKey(final String keyword) {
        String kw = keyword.toUpperCase();
        int len = kw.length();
        Integer[] order = new Integer[len];

        for (int i = 0; i < len; i++)
            order[i] = i;

        Arrays.sort(order, (a, b) -> Character.compare(kw.charAt(a), kw.charAt(b)));

        int[] numericKey = new int[len];
        for (int i = 0; i < len; i++)
            numericKey[order[i]] = i + 1;

        return numericKey;
    }

    // Encrypt using matrix + column order
    public static String encrypt(String plain, int[] key) {
        plain = plain.toUpperCase().replace(" ", "");

        int COLS = key.length;
        int len = plain.length();

        while (plain.length() % COLS != 0)
            plain += "X";

        int rows = plain.length() / COLS;
        char[][] mat = new char[rows][COLS];

        int k = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < COLS; j++)
                mat[i][j] = plain.charAt(k++);

        System.out.println("\nMatrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < COLS; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }

        StringBuilder cipher = new StringBuilder();

        for (int num = 1; num <= COLS; num++) {
            for (int j = 0; j < COLS; j++) {
                if (key[j] == num) {
                    for (int i = 0; i < rows; i++)
                        cipher.append(mat[i][j]);
                }
            }
        }

        return cipher.toString();
    }

    // Decrypt using matrix + column order
    public static String decrypt(String cipher, int[] key) {
        int COLS = key.length;
        int rows = cipher.length() / COLS;
        char[][] mat = new char[rows][COLS];

        int k = 0;
        for (int num = 1; num <= COLS; num++) {
            for (int j = 0; j < COLS; j++) {
                if (key[j] == num) {
                    for (int i = 0; i < rows; i++)
                        mat[i][j] = cipher.charAt(k++);
                }
            }
        }

        StringBuilder plain = new StringBuilder();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < COLS; j++)
                plain.append(mat[i][j]);

        return plain.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Key (Example: AUTHOR): ");
        String keyword = sc.next().toUpperCase();

        int[] key = generateKey(keyword);
        System.out.println("Numeric Key: " + Arrays.toString(key));

        System.out.println("\nEnter Plaintext: ");
        String plain = sc.next().toUpperCase();

        String cipher = encrypt(plain, key);
        System.out.println("\nCipher Text: " + cipher);

        String decrypted = decrypt(cipher, key);
        System.out.println("\nDecrypted Text: " + decrypted);

        sc.close();
    }
}

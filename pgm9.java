import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

public class pgm9 {

    public final static int pValue = 47;
    public final static int gValue = 71;
    public final static int XaValue = 9;
    public final static int XbValue = 14;

    public static void main(String[] args) throws Exception {

        // Create big integers for p, g, Xa, Xb
        BigInteger p = new BigInteger(Integer.toString(pValue));
        BigInteger g = new BigInteger(Integer.toString(gValue));

        BigInteger Xa = new BigInteger(Integer.toString(XaValue));  // Alice private
        BigInteger Xb = new BigInteger(Integer.toString(XbValue));  // Bob private

        System.out.println("Experiment 9 – Diffie Hellman Key Exchange");
        System.out.println("-----------------------------------------");

        // First: generate a random DH key pair
        createKey();

        // Generate random p and g for demonstration
        int bitLength = 512;
        SecureRandom rnd = new SecureRandom();
        p = BigInteger.probablePrime(bitLength, rnd);
        g = BigInteger.probablePrime(bitLength, rnd);

        // Second: generate key with specific p, g
        createSpecificKey(p, g);

        // Compute shared secret manually using formula: K = g^X mod p
        BigInteger Ya = g.modPow(Xa, p); // Alice public key
        BigInteger Yb = g.modPow(Xb, p); // Bob public key

        BigInteger Ka = Yb.modPow(Xa, p); // Alice secret
        BigInteger Kb = Ya.modPow(Xb, p); // Bob secret

        System.out.println("\nManual DH Secret Calculation:");
        System.out.println("Alice public key Ya = " + Ya);
        System.out.println("Bob public key   Yb = " + Yb);

        System.out.println("Alice secret Ka = " + Ka);
        System.out.println("Bob secret   Kb = " + Kb);

        if (Ka.equals(Kb)) {
            System.out.println("\nShared Secret MATCHED!");
        } else {
            System.out.println("\nShared Secret NOT matched.");
        }
    }

    // Generate a random DH key pair
    public static void createKey() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DiffieHellman");
        kpg.initialize(512);

        KeyPair kp = kpg.generateKeyPair();
        KeyFactory kfactory = KeyFactory.getInstance("DiffieHellman");

        DHPublicKeySpec kspec =
            (DHPublicKeySpec) kfactory.getKeySpec(kp.getPublic(), DHPublicKeySpec.class);

        System.out.println("Public key is: " + kspec);
    }

    // Generate key pair using specific p and g
    public static void createSpecificKey(BigInteger p, BigInteger g) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DiffieHellman");
        DHParameterSpec param = new DHParameterSpec(p, g);
        kpg.initialize(param);

        KeyPair kp = kpg.generateKeyPair();
        KeyFactory kfactory = KeyFactory.getInstance("DiffieHellman");

        DHPublicKeySpec kspec =
            (DHPublicKeySpec) kfactory.getKeySpec(kp.getPublic(), DHPublicKeySpec.class);

        System.out.println("\nPublic key is : " + kspec);
    }
}

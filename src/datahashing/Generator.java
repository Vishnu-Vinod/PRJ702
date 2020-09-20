package datahashing;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author hien
 */
public class Generator {

    private static final String SPEC = "secp256k1";
    private static final String ALGO = "SHA256withECDSA";

    

    public static String generateSHA256Hash(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            String encoded = Base64.getEncoder().encodeToString(hash);

            return encoded;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

     public static BigInteger getSHA(byte[] data) {

        BigInteger bigInteger = null;
        try {
            // Static getInstance method is called with hashing SHA-512
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            byte[] messageDigest = md.digest(data);

            // Convert byte array into signum representation
            bigInteger = new BigInteger(1, messageDigest);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bigInteger;
    }
    public static String[] GenerateHMAC(BigInteger sha512) {
        String[] HMAC = new String[2];
        String algo = "HMACSHA512";
        String dataMac = null;
        byte[] bigsha512byte;

        byte[] macb = null;
        String CommonHMACKey = null;

        bigsha512byte = sha512.toByteArray();

        SecretKey skey = new SecretKeySpec(bigsha512byte, 0, bigsha512byte.length, "HMACSHA512");
        CommonHMACKey = Base64.getEncoder().encodeToString(skey.getEncoded());
//        decode the base64 encoded string
//        byte[] decodedKey = Base64.getDecoder().decode(CommonHMACKey);
//        rebuild key using SecretKeySpec
//        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HMACSHA512");
        Mac mac = null;
        try {
            mac = Mac.getInstance(algo);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            mac.init(skey);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        InputStream in = new ByteArrayInputStream(bigsha512byte);
        try {
            macb = processFile(mac, in);
        } catch (IOException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataMac = Base64.getEncoder().encodeToString(macb);
        HMAC[0] = CommonHMACKey;
        HMAC[1] = dataMac;
        return HMAC;

    }

    public static String GenerateHMAC256(String Data, String SecretHMACKey) {
        String algo = "HMACSHA256";
        String dataMac = null;
        byte[] bigsha512byte;
        byte[] macb = null;
        String BlockHMACKey = null;

        byte[] SecretHMACKeyBytes = SecretHMACKey.getBytes();
        SecretKey skey = new SecretKeySpec(SecretHMACKeyBytes, 0, SecretHMACKeyBytes.length, "HMACSHA256");
        BlockHMACKey = Base64.getEncoder().encodeToString(skey.getEncoded());

        Mac mac = null;
        try {
            mac = Mac.getInstance(algo);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            mac.init(skey);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }

        InputStream in = new ByteArrayInputStream(Data.getBytes(StandardCharsets.UTF_8));
        try {
            macb = processFile(mac, in);
        } catch (IOException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataMac = Base64.getEncoder().encodeToString(macb);
        return dataMac;
    }

    private static byte[] processFile(Mac mac, InputStream in) throws java.io.IOException {
        byte[] ibuf = new byte[1024];
        int len;
        while ((len = in.read(ibuf)) != -1) {
            mac.update(ibuf, 0, len);
        }
        return mac.doFinal();
    }
    
    public static void main(String[] args) {
        
        String OrgMsg="Orignal_Message";
        BigInteger Hashedmsg = getSHA(OrgMsg.getBytes());
        System.out.println("Hash value :"+ Hashedmsg);
        String[] GenerateHMAC = GenerateHMAC(Hashedmsg);
        String CommonHMACKey = GenerateHMAC[0];
        String dataMac = GenerateHMAC[1];
        System.out.println("CommonHMACKey :"+ Hashedmsg);
        System.out.println("dataMac :"+ dataMac);


    }
}

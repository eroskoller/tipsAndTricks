/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zeros.tipsandtricks.cryto;

/**
 *
 * @author eros
 */
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class HMACDigest {

    

    public static String hmacDigest(String msg, String keyString, String algo) {
        String digest = null;
        try {
            SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
            Mac mac = Mac.getInstance(algo);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes("UTF-8"));

            StringBuffer hash = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }
            digest = hash.toString();
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (InvalidKeyException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return digest;
    }

    public static String hmacDigestHmac(String msg, String keyString) {
        return hmacDigest(msg, keyString, "HmacSHA1");
    }
    
    
//    public static void main(String[] args) throws Exception {
//        
//        System.out.println(hmacDigestHmac("The quick brown fox jumps over the lazy dog", "key"));
//
//    }
    
    
}
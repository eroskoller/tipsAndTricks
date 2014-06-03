/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zeros.tipsandtricks.cryto;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


/**
 *
 * @author eros
 */
public class EncryptionStrings {

    private static final String ALGORITHM = "AES";
    private static final String myEncryptionKey = "$*%&ß|@#|ç-_?!";
    private static final String UNICODE_FORMAT = "UTF8";

    private static Key generateKey() throws Exception {
        byte[] keyAsBytes;
        keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        Key key = new SecretKeySpec(keyAsBytes, ALGORITHM);
        return key;
    }


    public static String encrypt(String valueToEnc) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        String encryptedValue = new Base64().encodeToString(encValue);
        return encryptedValue;
    }

    public static String decrypt(String encryptedValue) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new Base64().decode(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);//////////LINE 50
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    public static void main(String[] args) throws Exception {

         String txt = "\n Brasília - O ministro Joaquim Barbosa deve confirmar a sua aposentadoria no início da sessão plenária desta quinta-feira (29/5), "
                + "\n em comunicação aos seus colegas. Ele almoçou com seus assessores no restaurante do Supremo Tribunal Federal, "
                + "\n mas a segurança não permitiu a aproximação dos repórteres. Não se sabe ainda se ele se aposenta em junho, "
                + "\n ou se depois da Copa do Mundo, em julho. Especula-se que o pedido de aposentadoria seria formalizado no dia 25 de junho, "
                + "\n exatamente 11 anos depois de sua posse como ministro do Supremo, em 2003, nomeado pelo então presidente Luiz Inácio da Silva. "
                + "\n Seu sucessor, pelo sistema de rodízio, é o atual vice-presidente, Ricardo Lewandowski. Em seu discurso, "
                + "\n Barbosa deverá usar como justificativa problemas de saúde e afirmar que não tem projetos políticos.";
         txt += txt; //txt += txt; txt += txt; txt += txt; txt += txt;
        String valueEnc = EncryptionStrings.encrypt(txt);
        String valueDec = EncryptionStrings.decrypt(valueEnc);

        System.out.println("Plain Text : " + txt);
        System.out.println("Encrypted : \n" + valueEnc);
        System.out.println("Decrypted : " + valueDec);
        System.out.println("DigestHmac Original: \n"+HMACDigest.hmacDigestHmac(txt, myEncryptionKey));
        System.out.println("DigestHmac  Refactory: \n"+HMACDigest.hmacDigestHmac(valueDec, myEncryptionKey));
        
    }

}


import br.com.zeros.tipsandtricks.StringsUtils;
import br.com.zeros.tipsandtricks.cryto.EncryptionStrings;
import br.com.zeros.tipsandtricks.cryto.HMACDigest;
import br.com.zeros.tipsandtricks.io.IOUtils;
import java.io.File;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eros
 */
public class TestTipsAndTricks {
    
    public static void main(String[] args) throws Exception {
        
//        String txt = "\n Brasília - O ministro Joaquim Barbosa deve confirmar a sua aposentadoria no início da sessão plenária desta quinta-feira (29/5), "
//                + "\n em comunicação aos seus colegas. Ele almoçou com seus assessores no restaurante do Supremo Tribunal Federal, "
//                + "\n mas a segurança não permitiu a aproximação dos repórteres. Não se sabe ainda se ele se aposenta em junho, "
//                + "\n ou se depois da Copa do Mundo, em julho. Especula-se que o pedido de aposentadoria seria formalizado no dia 25 de junho, "
//                + "\n exatamente 11 anos depois de sua posse como ministro do Supremo, em 2003, nomeado pelo então presidente Luiz Inácio da Silva. "
//                + "\n Seu sucessor, pelo sistema de rodízio, é o atual vice-presidente, Ricardo Lewandowski. Em seu discurso, "
//                + "\n Barbosa deverá usar como justificativa problemas de saúde e afirmar que não tem projetos políticos.";
//         txt += txt; //txt += txt; txt += txt; txt += txt; txt += txt;
//        String valueEnc = EncryptionStrings.encrypt(txt);
//        String valueDec = EncryptionStrings.decrypt(valueEnc);
//
//        System.out.println("Plain Text : " + txt);
//        System.out.println("Encrypted : \n" + valueEnc);
//        System.out.println("Decrypted : " + valueDec);
//        System.out.println("DigestHmac Original: \n"+HMACDigest.hmacDigestHmac(txt, EncryptionStrings.myEncryptionKey));
//        System.out.println("DigestHmac  Refactory: \n"+HMACDigest.hmacDigestHmac(valueDec, EncryptionStrings.myEncryptionKey));
        
        
        
//        System.out.println(OsUtils.isUnix());
        
//        System.out.println(Cpf.formatingCpf("21304365875"));
//        System.out.println(Cpf.cpfValidador(Cpf.formatingCpf("21304365875")));
//        System.out.println(RegexUtils.getStringFromStringBySeparator("<eroskoller@gmail.com/>", "<", "/>"));
        
//        System.out.println(IOUtils.grabAllFileNamesFromDir("/home/eros/Documents/TestWatcher/"));
//        IOUtils.dirMonitor("/home/eros/Documents/WatcherMonitor/");
        
//        System.out.println(StringsUtils.truncateAfterWords(6, "the lazy dog jumps over the quick brown fox."));
//        List<String>  fileName = IOUtils.grabListFilesNamesFromDir("/home/eros/Documents/", "*.doc");
//        for (String string : fileName) {
//            System.out.println(string);
//        }
        
//        IOUtils.deleteFilesByExtension("/home/eros/Documents/", "*.eros");
        
        
//        System.out.println(StringsUtils.replaceNoASCII("éros glauço kóller"));
        
        File file = new File("/home/eros/Documents/SISLU/url_test_sislu.txt");
        System.out.println(IOUtils.getLastLineFromFile(file,2));
        
        
    }
    
}

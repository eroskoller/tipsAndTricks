
import br.com.zeros.tipsandtricks.StringsUtils;
import br.com.zeros.tipsandtricks.io.IOUtils;
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
    
    public static void main(String[] args) {
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
        
        
        System.out.println(StringsUtils.replaceNoASCII("éros glauço kóller"));
        
    }
    
}

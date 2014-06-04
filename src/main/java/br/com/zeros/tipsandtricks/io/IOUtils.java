/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zeros.tipsandtricks.io;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

/**
 *
 * @author eros
 */
public class IOUtils {

    public static String grabStringFromFile(String filename) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader(filename), 256 * 1024);
            try {
                String s;
                while ((s = br.readLine()) != null) {
                    //System.out.println(s);
                    sb.append(s).append("\n");

                    //sb.append("\n");
                }
            } catch (IOException xcp) {
                System.err.println(xcp);
            } finally {
                br.close();
            }
        } catch (IOException xcp) {
            xcp.printStackTrace();
        }

        return sb.toString();
    }
    /**
     * 
     * @param filePath
     * @return A txt content of a file
     */
    public static String grabTxtFromFile(String filePath) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        Path pathFile = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(pathFile,StandardCharsets.UTF_8)) {
            String line;
            while((line = reader.readLine()) != null ){
                sb.append(line);
            }
        } catch (IOException xcp) {
            xcp.printStackTrace();
        }
        return sb.toString();
    }
    
     /**
     * 
     * @param filePath
     * @return the last line of a file
     */
    public static String grabLastLineFromFile(File file) {
        return grabLastLineFromFile(file, 1);
    }
    
    
    public static String grabLastLineFromFile( File file, int lines) {
    java.io.RandomAccessFile fileHandler = null;
    try {
        
        fileHandler = new java.io.RandomAccessFile( file, "r" );
        long fileLength = fileHandler.length() - 1;
        StringBuilder sb = new StringBuilder();
        int line = 0;

        for(long filePointer = fileLength; filePointer != -1; filePointer--){
            fileHandler.seek( filePointer );
            int readByte = fileHandler.readByte();

            if( readByte == 0xA ) {
                line = line + 1;
                if (line == lines) {
                    if (filePointer == fileLength) {
                        continue;
                    }
                    break;
                }
            } else if( readByte == 0xD ) {
                line = line + 1;
                if (line == lines) {
                    if (filePointer == fileLength - 1) {
                        continue;
                    }
                    break;
                }
            }
            System.out.println(new Character((char)readByte ))  ;
            sb.append( ( char ) readByte );
        }

        String lastLine = sb.reverse().toString();
        return lastLine;
    } catch( java.io.FileNotFoundException e ) {
        e.printStackTrace();
        return null;
    } catch( java.io.IOException e ) {
        e.printStackTrace();
        return null;
    }
    finally {
        if (fileHandler != null )
            try {
                fileHandler.close();
            } catch (IOException e) {
            }
    }
}
    
     /**
     * 
     * @param filePath
     * @return A txt content of a file
     */
    public static String testLastLine(String filePath) {
        String line = "";
        String lastLine = "";
        BufferedReader br = null;
//        StringBuilder sb = new StringBuilder();
        Path pathFile = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(pathFile,StandardCharsets.UTF_8)) {
             while((line = reader.readLine()) != null){ 
                 lastLine = line;
             }
//            lastLine =  reader.readLine();
             
        } catch (IOException xcp) {
            xcp.printStackTrace();
        }
        return lastLine;
    }
    
@Deprecated
    public static boolean saveStringToFile(String filename, String stringStream) {
        boolean save = false;
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filename), 256 * 1024);
            try {
                bw.write(stringStream);
                save = true;
            } catch (IOException xcp) {
                System.err.println(xcp);
            } finally {
                bw.close();
            }
        } catch (IOException xcp) {
            System.err.println(xcp);
        }

        return save;
    }
    
    public static void writeStringToFile(String pathToFile, String stringStream) {
         Path logFile = Paths.get(pathToFile);
        try (BufferedWriter writer = Files.newBufferedWriter(logFile,StandardCharsets.UTF_8, StandardOpenOption.WRITE)) {
            writer.write(stringStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String grabExternalPageSourceCode(String strUrl) {
        try {
            URL url = new URL(strUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
//                builder.append("\\n");
            }
            reader.close();
            return builder.toString();

        } catch (MalformedURLException ex) {
            Logger.getLogger(IOUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException xcp) {

        }

        return null;
    }

    public static String grabStringFromInputStream(InputStream inputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
//                builder.append("\\n");
            }
            reader.close();
            return builder.toString();

        } catch (MalformedURLException ex) {
            Logger.getLogger(IOUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException xcp) {

        }

        return null;
    }

    public static InputStream grabInputStreamFromString(String strTxt) {
        try {
            return new ByteArrayInputStream(strTxt.getBytes(StandardCharsets.UTF_8));
        } catch (Exception xcp) {
            xcp.printStackTrace();
        }
        return null;
    }

    public static String convertRTF_to_String(String strRTF) {
        try {
            RTFEditorKit rtfParser = new RTFEditorKit();
            Document document = rtfParser.createDefaultDocument();
            rtfParser.read(IOUtils.grabInputStreamFromString(strRTF), document, 0);
            return document.getText(0, document.getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(IOUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(IOUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public static String[] grabAllFileNamesFromDir(String pathURI) {
//        List<String>  listFileNames = null;
//         try {
//            //
//            // Create a WatchService and register the logDir path with the
//            // WatchService for ENTRY_CREATE.
//            //
//             listFileNames = new ArrayList<>();
//            WatchService watcher = FileSystems.getDefault().newWatchService();
//            Path logDir = Paths.get(pathURI);
//            logDir.register(watcher, ENTRY_CREATE);
// 
//            while (true) {
//                WatchKey key = watcher.take();
//                for (WatchEvent<?> event : key.pollEvents()) {
//                    if (event.kind() == ENTRY_CREATE) {
//                        //
//                        // Get the name of created file.
//                        //
//                        WatchEvent<Path> ev = (WatchEvent<Path>) event;
//                        Path filename = ev.context();
// 
//                        System.out.printf("A new file %s was created.%n",
//                                filename.getFileName());
//                        listFileNames.add(filename.getFileName().toString());
//                    }
//                }
//            }
////            return (String[]) listFileNames.toArray();
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
//        
//        return null;
//    }
    
    public static void dirMonitor(String uri){
        try {
            //
            // Creates a instance of WatchService.
            //
            WatchService watcher = FileSystems.getDefault().newWatchService();
 
            //
            // Registers the logDir below with a watch service.
            //
            Path logDir = Paths.get(uri);
            logDir.register(watcher,
                    ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
 
            //
            // Monitor the logDir at listen for change notification.
            //
            while (true) {
                WatchKey key = watcher.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
 
                    if (kind == ENTRY_CREATE) {
                        System.out.println("Entry was created on log dir.");
                    } else if (kind == ENTRY_MODIFY) {
                        System.out.println("Entry was modified on log dir.");
                    } else if (kind == ENTRY_DELETE) {
                        System.out.println("Entry was deleted from log dir.");
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param pathToDir  /home/eros/seilah
     * @param fileExtintion  "*.txt"
     * @return list of file names
     */
    public static List<String> grabListFilesNamesFromDir(String pathToDir,String fileExtension){
        Path logPath = Paths.get(pathToDir);
        List<String>  listFileNames = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(logPath, fileExtension)) {
            for (Path entry : stream) {
//                System.out.println(entry.getFileName());
                listFileNames.add(entry.getFileName().toString());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listFileNames;
    }
/**
 * 
 * @param pathToDir
 * @param fileExtension 
 */    
    public static void deleteFilesByExtension(String pathToDir,String fileExtension){
        Path logPath = Paths.get(pathToDir);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(logPath, fileExtension)) {
            for (Path entry : stream) {
                new File(entry.toAbsolutePath().toString()).delete();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    
}

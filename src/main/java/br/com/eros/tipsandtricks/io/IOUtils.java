/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eros.tipsandtricks.io;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

/**
 *
 * @author eros
 */
public class IOUtils {

    public static String getStringFromFile(String filename) {

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
    public static String getTxtFromFile(String filePath) {

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

    public static String getExternalPageSourceCode(String strUrl) {
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

    public static String getStringFromInputStream(InputStream inputStream) {
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

    public static InputStream getInputStreamFromString(String strTxt) {
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
            rtfParser.read(IOUtils.getInputStreamFromString(strRTF), document, 0);
            return document.getText(0, document.getLength());
        } catch (BadLocationException ex) {
            Logger.getLogger(IOUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(IOUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

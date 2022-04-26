package webapplication.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.*;

public class FileIManager {

    public static String getLog(String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty(Config.LiNE_SEPARATOR);
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        return stringBuilder.toString();
    }

    public static byte[] getScreenShot(){
        return Base64.encodeBase64(BrowserManager.getBrowser().getScreenshot());
    }

    public static String getParameterValue(String fileName, String key) {
        return Environment.getCurrentJsonFile(String.format(fileName.concat("%s"),Config.JSON_EXTENSION)).getValue(String.format("/%s", key)).toString();
    }
}

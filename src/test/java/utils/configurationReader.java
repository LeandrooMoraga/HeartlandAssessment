package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configurationReader {

    public static Properties prop;

    public static Properties readProperties(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException i) {
            i.printStackTrace();
        }
        return prop;
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

}




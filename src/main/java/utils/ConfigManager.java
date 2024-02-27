package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigManager {

    private static final Logger logger = LogManager.getLogger(ConfigManager.class);

    private static final Properties properties = new Properties();

    InputStream inputStream;

    static {
        try (InputStream inputStream = ConfigManager.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            properties.load(inputStream);
            logger.info("Application properties loaded successfully.");
        } catch (Exception e) {
            logger.error("Could not load application properties.", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value){
        try {
            properties.load(new FileInputStream("application.properties"));
            properties.setProperty(key, value);
            properties.store(new FileOutputStream("application.properties"), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }}


}



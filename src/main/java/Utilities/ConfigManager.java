package Utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private String configFileName;
    private Properties properties = new Properties();
    private String fileSeperator = System.getProperty("file.separator");
    private String ConfigFilePath=System.getProperty("user.dir") + fileSeperator +"TestData"+fileSeperator+ "App.properties";

    private void loadProperties() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(ConfigFilePath);
            properties.load(fis);
            fis.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public String getProperty(String key) {
        String value = "";
        if (key != "") {
            loadProperties();
            try {
                if (!properties.getProperty(key).trim().equals(null))
                    value = properties.getProperty(key).trim();
            } catch (NullPointerException e) {

            }
        }
        return value;
    }

}
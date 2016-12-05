package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Provides functionality of extracting property-values from files.
 * @author Yury Suponev
 */
public class PropertiesExtractor {
    public static Properties getProperties(String resourcePath) {
        Properties properties = null;
        try {
            InputStream sourceStream = PropertiesExtractor.class.getClassLoader().getResourceAsStream(resourcePath);
            if (sourceStream != null) {
                properties = new Properties();
                properties.load(sourceStream);
            } else {
                throw new RuntimeException("There is no properties at specified path.");
            }
        } catch (IOException e) {
            // Handle some IOException
        }
        return properties;
    }

    public static Properties getPropertiesForPrefix(String resourcePath, String prefix) {
        Properties sourceProperties = getProperties(resourcePath);
        Properties result = new Properties();
        sourceProperties.keySet().stream()
                .filter(key -> key != null)
                .map(Object::toString)
                .filter(key -> key.startsWith(prefix))
                .forEach(key -> result.setProperty(key, sourceProperties.getProperty(key)));
        return result;
    }
}

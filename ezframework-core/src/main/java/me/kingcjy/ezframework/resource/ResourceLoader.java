package me.kingcjy.ezframework.resource;

import me.kingcjy.ezframework.EzFramework;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class ResourceLoader {

    public static final String HELP_FORMAT = "me/kingcjy/ezframework/resource/help.ez";

    private static ResourceLoader instance;
    private Map<String, String> cache = new HashMap<>();
    private Class<?> mainClass;

    private ResourceLoader(Class<?> mainClass) {
        this.mainClass = mainClass;
    }

    public static ResourceLoader getInstance() {
        if(instance != null) {
            return instance;
        }
        throw new RuntimeException("ResourceLoader is not initialized");
    }

    public static void initialize(Class<?> mainClass) {
        ResourceLoader.instance = new ResourceLoader(mainClass);
    }

    public String read(String filename) {
        InputStream inputStream = getStreamFrom(this.mainClass, filename);

        if(inputStream == null) {
            inputStream = getStreamFrom(EzFramework.class, filename);
        }

        try {
            return IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException e) {
            return "";
        }
    }

    private InputStream getStreamFrom(Class<?> targetClass, String fileName) {
        return targetClass.getClassLoader().getResourceAsStream(fileName);
    }
}

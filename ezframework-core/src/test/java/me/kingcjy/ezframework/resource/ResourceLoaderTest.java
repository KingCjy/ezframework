package me.kingcjy.ezframework.resource;

import me.kingcjy.ezframework.EzFramework;
import org.junit.Test;

public class ResourceLoaderTest {
    @Test
    public void ResourceLoadTest() throws Exception {
        ResourceLoader.initialize(EzFramework.class);
        String format = ResourceLoader.getInstance().read("me/kingcjy/ezframework/resource/help.ez");

        System.out.println(format);
    }
}

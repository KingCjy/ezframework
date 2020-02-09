package me.kingcjy.ezframework.resource;

import me.kingcjy.ezframework.EzFramework;
import org.junit.Test;

public class ResourceFormatTest {

    @Test
    public void ResourceFormatParseTest() throws Exception {
        ResourceLoader.initialize(EzFramework.class);
        String content = ResourceLoader.getInstance().read(ResourceLoader.HELP_FORMAT);

        ResourceFormat resourceFormat = new ResourceFormat(content);

//        캐싱으로인해 한번만 정규식 매칭 해야함
        System.out.println(resourceFormat.getFromTag("prefix"));
        System.out.println(resourceFormat.getFromTag("prefix"));
        System.out.println(resourceFormat.getFromTag("suffix"));
        System.out.println(resourceFormat.getFromTag("suffix"));
    }
}

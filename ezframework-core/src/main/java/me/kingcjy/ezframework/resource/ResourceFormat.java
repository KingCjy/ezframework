package me.kingcjy.ezframework.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResourceFormat {

    private String contents;

    private Map<String, String> cache = new HashMap<>();

    public ResourceFormat(String contents) {
        this.contents = contents;
    }

    public String getFromTag(String tag) {
        String result = cache.get(tag);

        if(result == null) {
            result = parseFromTag(tag);
            cache.put(tag, result);
        }

        return result;
    }

    private String parseFromTag(String tag) {
        String regex = "\\<" + tag + "\\>((.|\\n)*)\\<\\/" + tag + "\\>";
        Matcher matcher = Pattern.compile(regex).matcher(this.contents);
        matcher.find();

        return matcher.group(1).trim();
    }


}

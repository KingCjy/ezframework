package me.kingcjy.ezframework.util;

import org.junit.Assert;
import org.junit.Test;

public class PathPatternParserTest {
    @Test
    public void URI_TO_PATTERN_TEST() throws Exception {
        PathPatternParser pathPatternParser = new PathPatternParser("do <fromPlayer> <toPlayer>");
        String uri = "do ab cd";
        Assert.assertTrue(pathPatternParser.matches(uri));
    }

    @Test
    public void StringArrayJoinTest() {
        String[] args = { "from", "to", "be" };

        System.out.println(String.join(" ", args));
    }
}

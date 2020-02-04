package me.kingcjy.ezframework.util;

import org.junit.Assert;
import org.junit.Test;

public class PathPatternParserTest {

    @Test
    public void URIPatternTest() throws Exception {
        PathPatternParser pathPatternParser = new PathPatternParser("message send <fromPlayer> <toPlayer>");
        String uri = "message send from to";
        Assert.assertTrue(pathPatternParser.matches(uri));
    }

    @Test
    public void StringArrayJoinTest() {
        String[] args = { "from", "to", "be" };

        System.out.println(String.join(" ", args));
    }
}

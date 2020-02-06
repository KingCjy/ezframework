package me.kingcjy.ezframework.util;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathPatternParser {

    public static final String PATTERN = "\\ \\<(.*?)\\>";

    private Pattern URIPattern;
    private Set<String> keys = new HashSet<>();

    public PathPatternParser(String uri) {
        String regex = uri;
        Matcher matcher = Pattern.compile(PATTERN).matcher(uri);

        List<MatchingData> matchingDatas = new ArrayList<>();
        while(matcher.find()) {
            matchingDatas.add(new MatchingData(matcher.group(0), matcher.group(1)));
        }

        for (int i = 0; i < matchingDatas.size(); i++) {
            MatchingData matchingData = matchingDatas.get(i);

//            마지막 args의 경우에 space 무시  /message send <player> <message>
//            /message send KingCjy 안녕 하이

            if(i == matchingDatas.size() -1) {
                regex = regex.replace(matchingData.getMatchString(), " (?<" + matchingData.getVariableName() + ">.*)");
            } else {
                regex = regex.replace(matchingData.getMatchString(), " (?<" + matchingData.getVariableName() + ">[^\\s]*)");
            }
            this.keys.add(matchingData.getVariableName());
        }

        regex+="$";
        URIPattern = Pattern.compile(regex);
    }

    public boolean matches(String uri) {
        Matcher matcher = URIPattern.matcher(uri);
        return matcher.find();
    }

    public Map<String, String> getPathParameterMap(String uri) {
        Map<String, String> pathParameterMap = new HashMap<>();
        Matcher matcher = URIPattern.matcher(uri);
        boolean find = matcher.find();

        if(find == false) {
            return new HashMap<>();
        }

        keys.forEach(key -> {
            String value = matcher.group(key).replaceAll("[\\<\\>]", "");
            pathParameterMap.put(key, value);
        });
        return pathParameterMap;
    }

    private class MatchingData {
        private String matchString;
        private String variableName;

        public MatchingData(String matchString, String variableName) {
            this.matchString = matchString;
            this.variableName = variableName;
        }

        public String getMatchString() {
            return matchString;
        }

        public void setMatchString(String matchString) {
            this.matchString = matchString;
        }

        public String getVariableName() {
            return variableName;
        }

        public void setVariableName(String variableName) {
            this.variableName = variableName;
        }
    }
}

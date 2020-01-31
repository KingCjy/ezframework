package me.kingcjy.ezframework.executor;

import me.kingcjy.ezframework.util.PathPatternParser;
import java.util.Objects;

public class HandlerKey {
    private String command;
    private PathPatternParser parser;

    HandlerKey(String command) {
        this.command = command;
        parser = new PathPatternParser(command);
    }

    public String getCommand() {
        return command;
    }

    public boolean matches(String uri) {
        return parser.matches(uri);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlerKey that = (HandlerKey) o;
        return Objects.equals(command, that.command) &&
                Objects.equals(parser, that.parser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(command, parser);
    }

    @Override
    public String toString() {
        return "HandlerKey{" +
                "command='" + command + '\'' +
                ", parser=" + parser +
                '}';
    }
}

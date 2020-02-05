package me.kingcjy.ezframework.executor.method.support.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kingcjy.ezframework.annotations.*;
import me.kingcjy.ezframework.executor.CommandArgs;
import me.kingcjy.ezframework.executor.method.HandlerMethodParameterProvider;
import me.kingcjy.ezframework.executor.method.MethodParameter;
import me.kingcjy.ezframework.util.PathPatternParser;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class PathVariableHandlerMethodParameterProvider implements HandlerMethodParameterProvider {

    private static final Logger logger = Bukkit.getLogger();

    private Map<String, PathPatternParser> pathPatternParserCache = new HashMap<>();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(PathVariable.class) != null;
    }

    @Override
    public Object resolveParameter(CommandArgs commandArgs, MethodParameter parameter) {
        Command commandAnnotation = parameter.getMethod().getAnnotation(Command.class);
        PathVariable pathVariable = parameter.getParameterAnnotation(PathVariable.class);
        CommandService commandService = parameter.getMethod().getDeclaringClass().getAnnotation(CommandService.class);

        String command = getCommand(commandService, commandAnnotation);

        if(pathPatternParserCache.get(commandAnnotation.value()) == null) {
            PathPatternParser pathPatternParser = new PathPatternParser(command);
            pathPatternParserCache.put(command, pathPatternParser);
        }

        PathPatternParser pathPatternParser = pathPatternParserCache.get(command);

        Map<String, String> pathParameterMap = pathPatternParser.getPathParameterMap(commandArgs.getFullCommand());

        String parameterName = getParameterName(pathVariable, parameter);

        if(parameter.getParameterType().equals(String.class)) {
            return pathParameterMap.get(parameterName);
        }

        try {
            Object object =  objectMapper.readValue(pathParameterMap.get(parameterName), parameter.getParameterType());
            return object;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public String getCommand(CommandService commandService, Command commandAnnotation) {
        if("".equals(commandService.value())) {
            return commandAnnotation.value();
        }

        return commandService.value() +  " " + commandAnnotation.value();
    }

    private String getParameterName(PathVariable pathVariable, MethodParameter parameter) {
        if("".equals(pathVariable.value()) == false) {
            return pathVariable.value();
        }

        return parameter.getName();
    }
}
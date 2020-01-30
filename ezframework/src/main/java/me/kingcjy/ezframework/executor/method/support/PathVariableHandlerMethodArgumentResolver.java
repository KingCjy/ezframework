package me.kingcjy.ezframework.executor.method.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.kingcjy.ezframework.annotations.*;
import me.kingcjy.ezframework.executor.CommandArgs;
import me.kingcjy.ezframework.executor.method.HandlerMethodArgumentResolver;
import me.kingcjy.ezframework.executor.method.MethodParameter;
import me.kingcjy.ezframework.util.PathPatternParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class PathVariableHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Logger logger = LoggerFactory.getLogger(PathVariableHandlerMethodArgumentResolver.class);

    private Map<String, PathPatternParser> pathPatternParserCache = new HashMap<>();

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(PathVariable.class) != null;
    }

    @Override
    public Object resolveArgument(CommandArgs commandArgs, MethodParameter parameter) {
        Command commandAnnotation = parameter.getMethod().getAnnotation(Command.class);
        PathVariable pathVariable = parameter.getParameterAnnotation(PathVariable.class);
        CommandService commandService = parameter.getMethod().getDeclaringClass().getAnnotation(CommandService.class);

        String command = getCommand(commandService, commandAnnotation);

        if(pathPatternParserCache.get(commandAnnotation.value()) == null) {
            PathPatternParser pathPatternParser = new PathPatternParser(command);
            pathPatternParserCache.put(command, pathPatternParser);
        }

        PathPatternParser pathPatternParser = pathPatternParserCache.get(command);

        Map<String, String> pathParameterMap = pathPatternParser.getPathParameterMap(command);
        System.out.println(parameter.getMethod().getParameters()[0].getName());
        try {
            Object object =  objectMapper.readValue(pathParameterMap.get(pathVariable.value()), parameter.getParameterType());
            return object;
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String getCommand(CommandService commandService, Command commandAnnotation) {
        return commandService.value() +  " " + commandAnnotation.value();
    }
}
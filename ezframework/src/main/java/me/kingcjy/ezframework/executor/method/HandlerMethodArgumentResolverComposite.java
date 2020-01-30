package me.kingcjy.ezframework.executor.method;

import me.kingcjy.ezframework.executor.CommandArgs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerMethodArgumentResolverComposite implements HandlerMethodArgumentResolver {

    private Set<HandlerMethodArgumentResolver> argumentResolvers = new HashSet<>();

    private final Map<MethodParameter, HandlerMethodArgumentResolver> argumentResolverCache =
            new ConcurrentHashMap<>(256);

    public void addResolver(HandlerMethodArgumentResolver handlerMethodArgumentResolver) {
        argumentResolvers.add(handlerMethodArgumentResolver);
    }

    public void addResolver(HandlerMethodArgumentResolver ...handlerMethodArgmentResolvers) {
        argumentResolvers.addAll(Arrays.asList(handlerMethodArgmentResolvers));
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return getArgumentResolver(parameter) != null;
    }

    @Override
    public Object resolveArgument(CommandArgs commandArgs, MethodParameter parameter) {
        return getArgumentResolver(parameter).resolveArgument(commandArgs, parameter);
    }

    private HandlerMethodArgumentResolver getArgumentResolver(MethodParameter parameter) {
        HandlerMethodArgumentResolver result = this.argumentResolverCache.get(parameter);
        if (result == null) {
            for (HandlerMethodArgumentResolver methodArgumentResolver : this.argumentResolvers) {
                if (methodArgumentResolver.supportsParameter(parameter)) {
                    result = methodArgumentResolver;
                    this.argumentResolverCache.put(parameter, result);
                    break;
                }
            }
        }
        return result;
    }
}

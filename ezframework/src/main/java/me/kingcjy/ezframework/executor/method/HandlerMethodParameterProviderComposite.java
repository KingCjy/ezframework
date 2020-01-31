package me.kingcjy.ezframework.executor.method;

import me.kingcjy.ezframework.executor.CommandArgs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerMethodParameterProviderComposite implements HandlerMethodParameterProvider {

    private Set<HandlerMethodParameterProvider> parameterProviders = new HashSet<>();

    private final Map<MethodParameter, HandlerMethodParameterProvider> argumentResolverCache =
            new ConcurrentHashMap<>(256);

    public void addResolver(HandlerMethodParameterProvider handlerMethodParameterProvider) {
        parameterProviders.add(handlerMethodParameterProvider);
    }

    public void addResolver(HandlerMethodParameterProvider...handlerMethodArgmentResolvers) {
        parameterProviders.addAll(Arrays.asList(handlerMethodArgmentResolvers));
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return getArgumentResolver(parameter) != null;
    }

    @Override
    public Object resolveParameter(CommandArgs commandArgs, MethodParameter parameter) {
        return getArgumentResolver(parameter).resolveParameter(commandArgs, parameter);
    }

    private HandlerMethodParameterProvider getArgumentResolver(MethodParameter parameter) {
        HandlerMethodParameterProvider result = this.argumentResolverCache.get(parameter);
        if (result == null) {
            for (HandlerMethodParameterProvider methodArgumentResolver : this.parameterProviders) {
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

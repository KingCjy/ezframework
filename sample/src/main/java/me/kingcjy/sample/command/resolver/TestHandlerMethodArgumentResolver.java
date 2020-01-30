package me.kingcjy.sample.command.resolver;

import me.kingcjy.ezframework.annotations.Component;
import me.kingcjy.ezframework.executor.CommandArgs;
import me.kingcjy.ezframework.executor.method.HandlerMethodArgumentResolver;
import me.kingcjy.ezframework.executor.method.MethodParameter;

@Component
public class TestHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Long.class);
    }

    @Override
    public Object resolveArgument(CommandArgs commandArgs, MethodParameter parameter) {
        return 1L;
    }
}

package me.kingcjy.ezframework.executor.method;

import me.kingcjy.ezframework.executor.CommandArgs;

public interface HandlerMethodParameterProvider {
    boolean supportsParameter(MethodParameter parameter);
    Object resolveParameter(CommandArgs commandArgs, MethodParameter parameter);
}

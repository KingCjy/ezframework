package me.kingcjy.ezframework.executor.method;

import me.kingcjy.ezframework.executor.CommandArgs;

public interface HandlerMethodArgumentResolver {
    boolean supportsParameter(MethodParameter parameter);
    Object resolveArgument(CommandArgs commandArgs, MethodParameter parameter);
}

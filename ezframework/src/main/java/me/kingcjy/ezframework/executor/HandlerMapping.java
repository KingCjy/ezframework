package me.kingcjy.ezframework.executor;

import me.kingcjy.ezframework.executor.method.InvocableHandlerMethod;

public interface HandlerMapping {
    void initialize();

    InvocableHandlerMethod getHandler(String command);
}

package me.kingcjy.ezframework.executor;

import me.kingcjy.ezframework.executor.method.InvocableHandlerMethod;

import java.util.Set;

public interface HandlerMapping {
    void initialize();

    InvocableHandlerMethod getHandler(String command);

    Set<HandlerKey> getHandlerKeys();
}

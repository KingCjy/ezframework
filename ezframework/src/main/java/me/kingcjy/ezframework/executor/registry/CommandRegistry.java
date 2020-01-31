package me.kingcjy.ezframework.executor.registry;

import me.kingcjy.ezframework.executor.HandlerKey;
import me.kingcjy.ezframework.executor.HandlerMapping;

import java.util.List;

public interface CommandRegistry {
    void setHandlerMapping(HandlerMapping handlerMapping);
    void registerCommands();
}

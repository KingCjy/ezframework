package me.kingcjy.ezframework.executor.method.support;

import me.kingcjy.ezframework.annotations.Component;
import me.kingcjy.ezframework.executor.CommandArgs;
import me.kingcjy.ezframework.executor.method.HandlerMethodParameterProvider;
import me.kingcjy.ezframework.executor.method.MethodParameter;
import org.bukkit.entity.Player;

@Component
public class PlayerHandlerMethodParameterProvider implements HandlerMethodParameterProvider {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Player.class);
    }

    @Override
    public Object resolveParameter(CommandArgs commandArgs, MethodParameter parameter) {
        Player player = (Player) commandArgs.getCommandSender();
        return player;
    }
}

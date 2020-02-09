package me.kingcjy.ezframework.executor;


import me.kingcjy.ezframework.executor.method.invoke.InvocableHandlerMethod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EzCommandExecutor implements CommandExecutor {

    private HandlerMapping handlerMapping;

    public EzCommandExecutor(HandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        String cmd = getCommandString(label, args);
        CommandArgs commandArgs = new CommandArgs(commandSender, command, label, args, cmd);

        InvocableHandlerMethod invocableHandlerMethod = handlerMapping.getHandler(cmd);
        invocableHandlerMethod.invoke(commandArgs, commandArgs, commandSender, command);

        return true;
    }

    private String getCommandString(String label, String[] args) {
        return label + " " + String.join(" ", args);
    }
}

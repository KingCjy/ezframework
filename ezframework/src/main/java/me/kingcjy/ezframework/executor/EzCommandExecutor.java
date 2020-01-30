package me.kingcjy.ezframework.executor;

import me.kingcjy.ezframework.executor.method.InvocableHandlerMethod;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EzCommandExecutor implements CommandExecutor {

    private AnnotationHandlerMapping annotationHandlerMapping;

    public EzCommandExecutor(AnnotationHandlerMapping annotationHandlerMapping) {
        this.annotationHandlerMapping = annotationHandlerMapping;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        CommandArgs commandArgs = new CommandArgs(commandSender, command, label, args);
//        String cmd = getCommandString(label, args);
        String cmd = getCommandString("teleport", new String[]{"fromPlayer", "toPlayer"});

        InvocableHandlerMethod invocableHandlerMethod = annotationHandlerMapping.getHandler(cmd);
        invocableHandlerMethod.invoke(commandArgs);

        return true;
    }

    private String getCommandString(String label, String[] args) {
        return label + " " + String.join(" ", args);
    }
}

package me.kingcjy.ezframework.executor.method.invoke;

import me.kingcjy.ezframework.executor.CommandArgs;
import me.kingcjy.ezframework.resource.ResourceFormat;
import org.bukkit.entity.Player;

import java.util.List;

public class HelpCommandInvocableHandlerMethod extends InvocableHandlerMethod {

    private ResourceFormat resourceFormat;
    private List<HelpCommand> commands;

    public HelpCommandInvocableHandlerMethod(ResourceFormat resourceFormat, List<HelpCommand> commands) {
        this.commands = commands;
        this.resourceFormat = resourceFormat;
    }

    @Override
    public Object invoke(CommandArgs commandArgs, Object... providedArguments) {

        if(commandArgs.getCommandSender() instanceof Player) {
            Player player = (Player) commandArgs.getCommandSender();

            player.sendMessage(resourceFormat.getFromTag("prefix"));
            for (HelpCommand command : commands) {
                player.sendMessage(replaceCommandAndDescription(command.getCommand(), command.getDescription()));
            }
            player.sendMessage(resourceFormat.getFromTag("suffix"));
        }

        return new Object();
    }

    private String replaceCommandAndDescription(String command, String description) {
        return resourceFormat.getFromTag("command")
                .replaceAll("\\{help.command\\}", "/" + command)
                .replaceAll("\\{help.description\\}", description);
    }

    public static class HelpCommand {
        private String command;
        private String description;

        public HelpCommand(String command, String description) {
            this.command = command;
            this.description = description;
        }

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}

package me.kingcjy.ezframework.executor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandArgs {
    private CommandSender commandSender;
    private Command command;
    private String label;
    private String[] args;

    CommandArgs(CommandSender commandSender, Command command, String label, String[] args) {
        this.commandSender = commandSender;
        this.command = command;
        this.label = label;
        this.args = args;
    }

    public CommandSender getCommandSender() {
        return commandSender;
    }

    public void setCommandSender(CommandSender commandSender) {
        this.commandSender = commandSender;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}

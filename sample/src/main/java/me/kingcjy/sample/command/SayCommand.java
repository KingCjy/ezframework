package me.kingcjy.sample.command;

import me.kingcjy.ezframework.annotations.Command;
import me.kingcjy.ezframework.annotations.CommandService;
import me.kingcjy.ezframework.annotations.NotFound;
import me.kingcjy.ezframework.annotations.PathVariable;
import org.bukkit.Bukkit;

@CommandService
public class SayCommand {

    @Command("message <message>")
    public void onCommand(@PathVariable String message) {
        Bukkit.broadcastMessage("[ssibal] " + message);
    }

    @Command("message <message> aa <message2>")
    public void onCommand2(@PathVariable String message, @PathVariable String message2) {
        Bukkit.broadcastMessage(message + " aa " + message2);
    }
}

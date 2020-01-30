package me.kingcjy.sample.command;

import me.kingcjy.ezframework.annotations.Command;
import me.kingcjy.ezframework.annotations.CommandService;
import me.kingcjy.ezframework.annotations.NotFound;
import me.kingcjy.ezframework.annotations.PathVariable;
import me.kingcjy.ezframework.executor.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandService("teleport")
public class TeleportCommand {

    @Command("<toPlayer>")
    public void onTeleportTo(@PathVariable String toPlayer, Player player) {
        Player to = Bukkit.getPlayer(toPlayer);
        player.teleport(to);
    }

    @Command("<fromPlayer> <toPlayer>")
    public void onTeleportFromTo(@PathVariable String fromPlayer, @PathVariable String toPlayer, CommandArgs commandArgs, CommandSender commandSender, org.bukkit.command.Command command) {
        Player from = Bukkit.getPlayer(fromPlayer);
        Player to = Bukkit.getPlayer(toPlayer);
        from.teleport(to);
    }

    @NotFound
    public void notFound(Player player) {
        player.sendMessage("잘못된 명령어입니다.");
    }
}

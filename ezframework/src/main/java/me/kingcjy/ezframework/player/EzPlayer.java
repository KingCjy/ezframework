package me.kingcjy.ezframework.player;

import net.minecraft.server.EntityPlayer;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.entity.CraftPlayer;

public class EzPlayer extends CraftPlayer {
    public EzPlayer(CraftServer server, EntityPlayer entity) {
        super(server, entity);
    }
}

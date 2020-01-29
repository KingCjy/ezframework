package me.kingcjy.sample;

import me.kingcjy.ezframework.EzPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        EzPlugin.run(this);
    }
}

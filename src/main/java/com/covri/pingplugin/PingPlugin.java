package com.covri.pingplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class PingPlugin extends JavaPlugin {
    private static PingPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new PingListener(), this);
        getCommand("pingtoggle").setExecutor(new PingCommand());
        saveDefaultConfig();
    }

    public static PingPlugin getInstance() {
        return instance;
    }

    public PingListener getPingListener() {
        return (PingListener) getServer().getPluginManager().getPlugin("PingPlugin");
    }
}
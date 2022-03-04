package me.alnmgdev.recmanager;

import me.alnmgdev.recmanager.commands.*;
import me.alnmgdev.recmanager.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class recmanager extends JavaPlugin {

    private static recmanager Main;

    @Override
    public void onEnable() {
        Main = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        registerevents();
        registercommads();
    }

    public void registerevents()
    {
        Bukkit.getLogger().info("loading events");
        getServer().getPluginManager().registerEvents(new playerchatevent(), this);
        getServer().getPluginManager().registerEvents(new playerpvpevent(), this);
        getServer().getPluginManager().registerEvents(new interactevent(),this);
        getServer().getPluginManager().registerEvents(new buildevent(), this);
        getServer().getPluginManager().registerEvents(new hardcore(), this);

        Bukkit.getLogger().info("done");
    }
    public void registercommads()
    {
        Bukkit.getLogger().info("loading commands");

        getCommand("pvp").setExecutor(new pvpcommand());
        getCommand("chat").setExecutor(new chatcommand());
        getCommand("build").setExecutor(new buildcommand());
        getCommand("hardcore").setExecutor(new hardcorecommand());
        getCommand("interact").setExecutor(new interactcommand());

        Bukkit.getLogger().info("done");
    }

    @Override
    public void onDisable() {
        System.out.println("goodbye :)");
    }

    public static recmanager getPlugin() {
        return Main;
    }
}

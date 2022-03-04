package me.alnmgdev.recmanager.commands;

import me.alnmgdev.recmanager.recmanager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class chatcommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0 && player.hasPermission("recmanager.chat")) {
                if (args[0].equalsIgnoreCase("enable")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("enablechat")));

                    recmanager.getPlugin().getConfig().set("chat", true);
                    Bukkit.getLogger().info("" + recmanager.getPlugin().getConfig().getBoolean("chat"));
                }else if (args[0].equalsIgnoreCase("disable")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("disablechat")));

                    recmanager.getPlugin().getConfig().set("chat", false);
                    Bukkit.getLogger().info("" + recmanager.getPlugin().getConfig().getBoolean("chat"));
                }else{
                    player.sendMessage("you need to pass a valid argument");
                }
            }
        }
    return true;
    }
}

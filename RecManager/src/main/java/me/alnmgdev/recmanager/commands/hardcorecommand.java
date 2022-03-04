package me.alnmgdev.recmanager.commands;

import me.alnmgdev.recmanager.recmanager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hardcorecommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0 && player.hasPermission("recmanager.hardcore")) {
                if (args[0].equalsIgnoreCase("enable")) {
                    recmanager.getPlugin().getConfig().set("hardcore", true);
                    if(args[1].equalsIgnoreCase("spectator") || args[1].equalsIgnoreCase("kick")){
                        recmanager.getPlugin().getConfig().set("hardcoretype", args[1]);
                    }
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("enablehardcore") + recmanager.getPlugin().getConfig().getString("hardcoretype")));
                    Bukkit.getLogger().info("" + recmanager.getPlugin().getConfig().getBoolean("hardcore"));
                }else if (args[0].equalsIgnoreCase("disable")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("disablehardcore")));

                    recmanager.getPlugin().getConfig().set("hardcore", false);
                    Bukkit.getLogger().info("" + recmanager.getPlugin().getConfig().getBoolean("hardcore"));
                }else{
                    player.sendMessage("you need to pass a valid argument [2] \n /hardcore on spectator/kick");
                }
            }
        }
        return true;
    }
}

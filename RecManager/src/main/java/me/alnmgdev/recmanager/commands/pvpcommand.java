package me.alnmgdev.recmanager.commands;

import me.alnmgdev.recmanager.recmanager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class pvpcommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0 && player.hasPermission("recmanager.pvp")) {
                if (args[0].equalsIgnoreCase("enable")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("enablepvp")));

                    recmanager.getPlugin().getConfig().set("pvp", true);
                    Bukkit.getLogger().info("" + recmanager.getPlugin().getConfig().getBoolean("pvp"));
                }else if (args[0].equalsIgnoreCase("disable")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("disablepvp")));

                    recmanager.getPlugin().getConfig().set("pvp", false);
                    Bukkit.getLogger().info("" + recmanager.getPlugin().getConfig().getBoolean("pvp"));
                }else{
                    player.sendMessage("you need to pass a valid argument");
                }
            }
        }
        return true;
    }

}

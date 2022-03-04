package me.alnmgdev.recmanager.commands;

import me.alnmgdev.recmanager.recmanager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class interactcommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0 && player.hasPermission("recmanager.interact")) {
                if (args[0].equalsIgnoreCase("enable")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("enableinteract")));

                    recmanager.getPlugin().getConfig().set("interact", true);
                    Bukkit.getLogger().info("" + recmanager.getPlugin().getConfig().getBoolean("interact"));
                }else if (args[0].equalsIgnoreCase("disable")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("disableinteract")));

                    recmanager.getPlugin().getConfig().set("interact", false);
                    Bukkit.getLogger().info("" + recmanager.getPlugin().getConfig().getBoolean("interact"));
                }else{
                    player.sendMessage("you need to pass a valid argument");
                }
            }
        }
        return true;
    }
}

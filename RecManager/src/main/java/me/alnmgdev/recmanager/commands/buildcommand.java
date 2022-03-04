package me.alnmgdev.recmanager.commands;

import me.alnmgdev.recmanager.recmanager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class buildcommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0 && player.hasPermission("recmanager.build")) {
                if (args[0].equalsIgnoreCase("enable")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("enablebuild")));

                    recmanager.getPlugin().getConfig().set("build", true);
                    Bukkit.getLogger().info("" + recmanager.getPlugin().getConfig().getBoolean("build"));
                }else if (args[0].equalsIgnoreCase("disable")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("disablebuild")));

                    recmanager.getPlugin().getConfig().set("build", false);
                    Bukkit.getLogger().info("" + recmanager.getPlugin().getConfig().getBoolean("build"));
                }else{
                    player.sendMessage("you need to pass a valid argument");
                }
            }
        }
        return true;
    }
}

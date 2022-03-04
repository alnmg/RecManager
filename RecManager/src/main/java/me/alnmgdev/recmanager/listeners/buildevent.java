package me.alnmgdev.recmanager.listeners;

import me.alnmgdev.recmanager.recmanager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class buildevent implements Listener {

    @EventHandler
    public void onblockbreak(BlockBreakEvent event) {


        Player player = event.getPlayer();

        if (!player.hasPermission("recmanager.build.bypass")) {
            if (!recmanager.getPlugin().getConfig().getBoolean("build")) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("builddeny")));
            }

        }
    }

        @EventHandler
        public void onblockplace (BlockPlaceEvent event){


            Player player = event.getPlayer();

            if (!player.hasPermission("recmanager.build.bypass")) {
                if (!recmanager.getPlugin().getConfig().getBoolean("build")) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("builddeny")));
                }

            }
        }
}

package me.alnmgdev.recmanager.listeners;

import me.alnmgdev.recmanager.recmanager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class interactevent implements Listener {

    @EventHandler
    public void playerinteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        Block block = (Block) event.getClickedBlock();
        if (!player.hasPermission("recmanager.interact.bypass")) {
            if (!recmanager.getPlugin().getConfig().getBoolean("interact"))
            {
                if(block.equals(Material.CHEST) || block.equals(Material.BLAST_FURNACE) || block.equals(Material.CRAFTING_TABLE) || block.equals(Material.ENDER_CHEST) || block.equals(Material.TRAPPED_CHEST) || block.equals(Material.FURNACE)) {
                    event.setCancelled(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("interactdeny")));
                }
            }

        }
    }

}

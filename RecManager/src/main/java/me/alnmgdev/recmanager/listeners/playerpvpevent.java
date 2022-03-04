package me.alnmgdev.recmanager.listeners;

import me.alnmgdev.recmanager.recmanager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class playerpvpevent implements Listener {

    @EventHandler
    public void onhit(EntityDamageByEntityEvent damageevent)
    {
        if(damageevent.getDamager() instanceof Player player && damageevent.getEntity() instanceof Player)
        {
            if (!player.hasPermission("recmanager.pvp.bypass")) {
                if (!recmanager.getPlugin().getConfig().getBoolean("pvp")) {
                    damageevent.setCancelled(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("pvpdeny")));
                }

            }
        }


    }
}

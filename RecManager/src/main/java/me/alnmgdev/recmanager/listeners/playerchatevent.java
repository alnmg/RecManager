package me.alnmgdev.recmanager.listeners;

import me.alnmgdev.recmanager.recmanager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class playerchatevent implements Listener {

    @EventHandler
    public void playerchatevent(AsyncPlayerChatEvent chatEvent) {
        Player player = chatEvent.getPlayer();
        if (!player.hasPermission("recmanager.chat.bypass")) {
            if (!recmanager.getPlugin().getConfig().getBoolean("chat")) {
                chatEvent.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("prefix") + recmanager.getPlugin().getConfig().getString("chatdeny")));
            }
        }
    }
}

package me.alnmgdev.recmanager.listeners;

import me.alnmgdev.recmanager.recmanager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class hardcore implements Listener {

    @EventHandler
    public void onplayerdie(PlayerDeathEvent event){

        Player player = (Player) event.getEntity();

        if(!player.hasPermission("recmanager.hardcore.bypass"))
        {
            if(recmanager.getPlugin().getConfig().getBoolean("hardcore"))
            {
                if(recmanager.getPlugin().getConfig().getString("hardcoretype").equalsIgnoreCase("kick"))
                {
                    player.kickPlayer(ChatColor.translateAlternateColorCodes('&', recmanager.getPlugin().getConfig().getString("hardcorekickmsg")));
                }else if(recmanager.getPlugin().getConfig().getString("hardcoretype").equalsIgnoreCase("spectator"))
                {
                    player.setGameMode(GameMode.SPECTATOR);
                }
            }
        }


    }

}

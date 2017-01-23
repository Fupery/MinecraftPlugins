package com.ullarah.ujoinquit.event;

import com.ullarah.ujoinquit.JoinQuitFunctions;
import com.ullarah.ujoinquit.JoinQuitInit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoin implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void event(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        JoinQuitInit.lastPlayer = player.getPlayerListName();

        // Join message
        if (JoinQuitInit.playerJoinMessage.containsKey(playerUUID)) {

            String currentMessage = event.getJoinMessage();
            if (currentMessage != null && currentMessage.length() != 0) {

                JoinQuitFunctions joinQuitFunctions = new JoinQuitFunctions();
                String message = joinQuitFunctions.replacePlayerString(player,
                        joinQuitFunctions.getMessage(player, JoinQuitFunctions.Message.JOIN));

                event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', JoinQuitInit.joinChar + message));
            }
        }

        // Join location
        if (JoinQuitInit.playerJoinLocation.containsKey(playerUUID))
            player.teleport(JoinQuitInit.playerJoinLocation.get(playerUUID));

    }

}
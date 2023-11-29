package org.regicide.regicideui.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.entities.players.RegicideUIPlayerManager;

/**
 * Listens general player's activity.
 */
public final class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(@NotNull final PlayerJoinEvent e) {
        RegicideUIPlayerManager.addPlayer(e.getPlayer());
        //e.getPlayer().sendMessage(String.valueOf(RegicideUI.getEconomy().getBalance(e.getPlayer())));
    }

    @EventHandler
    public void onPlayerQuit(@NotNull final PlayerQuitEvent e) {
        RegicideUIPlayerManager.removePlayer(e.getPlayer());
    }
}

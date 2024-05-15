package org.regicide.regicideui.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.PlayerNameStorage;
import org.regicide.regicideui.objects.RegicideUIPlayer;

public class ClientJoinListener implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(@NotNull final PlayerJoinEvent e) {
        Player p = e.getPlayer();
        PlayerNameStorage.add(p.getName());
        RegicideUIPlayer.registerPlayer(new RegicideUIPlayer(p));
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerQuit(@NotNull final PlayerQuitEvent e) {
        Player p = e.getPlayer();
        PlayerNameStorage.remove(p.getName());
        RegicideUIPlayer.unregisterPlayer(p.getUniqueId());
    }
}

package org.regicide.regicideui.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.PlayerNameStorage;

public class ClientJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(@NotNull final PlayerJoinEvent e) {
        PlayerNameStorage.add(e.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerQuit(@NotNull final PlayerQuitEvent e) {
        PlayerNameStorage.remove(e.getPlayer().getName());
    }
}

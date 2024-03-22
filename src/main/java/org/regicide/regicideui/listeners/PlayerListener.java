package org.regicide.regicideui.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public final class PlayerListener implements Listener {
    public void onPlayerClickOnAnotherPlayer(PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player))
            return;

        Player p = e.getPlayer();
        p.playSound(p, Sound.BLOCK_NOTE_BLOCK_BELL, 1, 8);
        p.performCommand("profile "+e.getRightClicked().getName());
    }
}

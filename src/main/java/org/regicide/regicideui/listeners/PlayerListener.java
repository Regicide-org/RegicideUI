package org.regicide.regicideui.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.ui.profile.ProfileGUI;
import org.regicide.regicideui.utils.UtilManager;
import xyz.xenondevs.invui.window.Window;

public final class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerClickOnAnotherPlayer(@NotNull final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player))
            return;

        Player p = e.getPlayer();
        p.playSound(p, Sound.BLOCK_NOTE_BLOCK_BELL, 1, 8);

        Window window = Window.merged()
                .setViewer(e.getPlayer())
                .setTitle(RegicideUI.l().c().getString("profile-title"))
                .setGui(new ProfileGUI(null, p, (Player) e.getRightClicked()).getGui())
                .build();
        window.open();
    }

    @EventHandler
    public void onPlayerJoinServer(@NotNull final PlayerJoinEvent e) {
        UtilManager.addPlayer(e.getPlayer());
        RegicideUI.instance().getLogger().info(UtilManager.getOnlinePlayerNames().toString());
    }

    @EventHandler
    private void onPlayerLeaveServer(@NotNull final PlayerQuitEvent e) {
        UtilManager.removePlayer(e.getPlayer());
        RegicideUI.instance().getLogger().info(UtilManager.getOnlinePlayerNames().toString());
    }
}

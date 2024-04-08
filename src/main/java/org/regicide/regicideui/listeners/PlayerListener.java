package org.regicide.regicideui.listeners;

import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.ui.profile.Profile;
import xyz.xenondevs.invui.window.Window;

public final class PlayerListener implements Listener {
    @EventHandler
    public void onPlayerClickOnAnotherPlayer(@NotNull final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player))
            return;

        Player p = e.getPlayer();
        net.kyori.adventure.sound.Sound s = net.kyori.adventure.sound.Sound.sound(
                new NamespacedKey(Config.getExitButtonPathSpace(), Config.getOpenMenuPathSpace()),
                Sound.Source.PLAYER,
                Config.getExitButtonVolume(),
                Config.getExitButtonPitch()
        );
        p.playSound(s);

        Window window = Window.merged()
                .setViewer(e.getPlayer())
                .setTitle(Localization.get("ui.element.profile.title", p.locale().toString()))
                .setGui(new Profile(p).getGui())
                .build();
        window.open();
    }
}

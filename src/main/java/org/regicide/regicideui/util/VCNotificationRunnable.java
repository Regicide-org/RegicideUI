package org.regicide.regicideui.util;

import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.RegicideUI;

public class VCNotificationRunnable {
    public void showNotification(@NotNull final Player player) {
        new BukkitRunnable() {

            @Override
            public void run() {
                Sound s = Sound.sound(
                        new NamespacedKey(Config.instance().VC_NOTIFICATION_PATH_SPACE, Config.instance().VC_NOTIFICATION_PATH_NAME),
                        Sound.Source.PLAYER,
                        Config.instance().VC_NOTIFICATION_VOLUME,
                        Config.instance().VC_NOTIFICATION_PITCH
                );
                player.playSound(s);
                player.sendActionBar(Component.text("Привееет!"));
            }
        }.runTaskTimerAsynchronously(RegicideUI.instance(), Config.instance().VC_NOTIFICATION_DELAY, Config.instance().VC_NOTIFICATION_PERIOD);
    }
}

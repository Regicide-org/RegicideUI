package org.regicide.regicideui.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.PlayerNameStorage;
import org.regicide.regicideui.objects.RegicideUIPlayer;

public class VoiceChatChecker implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(@NotNull final PlayerJoinEvent e) {
        Player p = e.getPlayer();
        int vcLength = (PlaceholderAPI.setPlaceholders(p, "%voicechat_installed%")).length();

        // if uninstalled
        if (vcLength == 0) {

            if (Config.instance().VC_FIRST_MESSAGE_USE) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        p.sendMessage(Localization.get("message.notification.voicechat_not_installed.first_message", p.locale().toString()));
                    }
                }.runTaskLaterAsynchronously(RegicideUI.instance(), Config.instance().VC_FIRST_MESSAGE_DELAY);
            }

            if (Config.instance().VC_NOTIFICATION_USE)
                RegicideUIPlayer.getPlayer(p).runVoiceChatNotifications();
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(@NotNull final PlayerQuitEvent e) {
        Player p = e.getPlayer();
        PlayerNameStorage.remove(p.getName());
        RegicideUIPlayer.unregisterPlayer(p.getUniqueId());
    }
}

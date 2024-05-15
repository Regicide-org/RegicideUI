package org.regicide.regicideui.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.RegicideUIPlayer;

public class VoiceChatListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void afterVoiceChatChecked(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        RegicideUIPlayer ruiPlayer = RegicideUIPlayer.getPlayer(e.getPlayer());

        new BukkitRunnable() {
            @Override
            public void run() {
                if (ruiPlayer.isVCChecked())
                    return;
                ruiPlayer.setVCCheckStatus(true);
                if (Config.instance().VC_FIRST_MESSAGE_USE) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            p.sendMessage(Localization.get("message.notification.voicechat_not_installed.first_message", p.locale().toString()));
                        }
                    }.runTaskLaterAsynchronously(RegicideUI.instance(), Config.instance().VC_FIRST_MESSAGE_DELAY);
                }
                if (Config.instance().VC_NOTIFICATION_USE)
                    ruiPlayer.runVoiceChatNotifications();
            }
        }.runTaskLaterAsynchronously(RegicideUI.instance(), 100);
    }
}

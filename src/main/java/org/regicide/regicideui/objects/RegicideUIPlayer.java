package org.regicide.regicideui.objects;

import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.RegicideUI;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * An auxiliary container-class for the player.
 */
public class RegicideUIPlayer {

    // Storage
    private static Map<UUID, RegicideUIPlayer> REGICIDE_UI_PLAYER_MAP = new HashMap<>();

    public static void registerPlayer(@NotNull final RegicideUIPlayer ruiPlayer) {
        REGICIDE_UI_PLAYER_MAP.put(ruiPlayer.getBase().getUniqueId(), ruiPlayer);
    }

    public static void unregisterPlayer(@NotNull final UUID uuid) {
        REGICIDE_UI_PLAYER_MAP.remove(uuid);
    }

    public static void unregisterAll() {
        REGICIDE_UI_PLAYER_MAP.clear();
    }

    public static RegicideUIPlayer getPlayer(@NotNull final UUID uuid) {
        return REGICIDE_UI_PLAYER_MAP.get(uuid);
    }

    public static RegicideUIPlayer getPlayer(@NotNull final Player player) {
        return REGICIDE_UI_PLAYER_MAP.get(player.getUniqueId());
    }

    private final Player base;

    private BukkitTask voiceNotifications = null;
    private boolean voiceChatModStatus;

    private boolean voiceChatCheckStatus = false;

    public RegicideUIPlayer(@NotNull final Player player) {
        this.base = player;
    }

    public Player getBase() {
        return base;
    }

    public void setVCModStatus(boolean val) {
        this.voiceChatModStatus = val;
    }

    public void setVCCheckStatus(boolean val) {
        this.voiceChatCheckStatus = val;
    }

    public boolean isVCChecked() {
        return voiceChatCheckStatus;
    }

    public boolean hasVCMod() {
        return this.voiceChatModStatus;
    }

    public void runVoiceChatNotifications() {
        this.voiceNotifications = new BukkitRunnable() {
            @Override
            public void run() {
                if (Config.instance().VC_NOTIFICATION_SOUND_USE) {
                    Sound s = Sound.sound(
                            new NamespacedKey(Config.instance().VC_NOTIFICATION_PATH_SPACE, Config.instance().VC_NOTIFICATION_PATH_NAME),
                            Sound.Source.PLAYER,
                            Config.instance().VC_NOTIFICATION_VOLUME,
                            Config.instance().VC_NOTIFICATION_PITCH
                    );
                    getBase().playSound(s);
                }
                getBase().sendActionBar(Localization.get("message.notification.voicechat_not_installed.notification_message", getBase().locale().toString()));
            }
        }.runTaskTimerAsynchronously(RegicideUI.instance(), Config.instance().VC_NOTIFICATION_DELAY, Config.instance().VC_NOTIFICATION_PERIOD);
    }

    public void stopVoiceChatNotification() {
        this.voiceNotifications.cancel();
    }
}

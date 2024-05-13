package org.regicide.regicideui.objects;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

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
    private boolean checkedVC;

    public RegicideUIPlayer(@NotNull final Player player) {
        this.base = player;
    }

    public Player getBase() {
        return base;
    }

    public boolean isVcChecked() {
        return checkedVC;
    }

    public void setVcChecked(boolean value) {
        this.checkedVC = value;
    }
}

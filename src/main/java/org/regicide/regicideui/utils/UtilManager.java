package org.regicide.regicideui.utils;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class UtilManager {
    private static final Set<String> ONLINE_PLAYERS_NICKNAMES = new HashSet<>();

    public static void addPlayer(@NotNull final Player player) {
        ONLINE_PLAYERS_NICKNAMES.add(player.getName());
    }

    public static void removePlayer(@NotNull final Player player) {
        ONLINE_PLAYERS_NICKNAMES.remove(player.getName());
    }

    public static Set<String> getOnlinePlayerNames() {
        return ONLINE_PLAYERS_NICKNAMES;
    }
}

package org.regicide.regicideui.entities.players;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class RegicideUIPlayerManager {
    private static final Map<UUID, RegicideUIPlayer> REGICIDE_PLAYERS = new HashMap<>();

    public static void addPlayer(@NotNull final Player player) {
        REGICIDE_PLAYERS.put(player.getUniqueId(), new RegicideUIPlayer(player));
    }

    public static void loadAllPlayers() {
        Collection<? extends Player> players = RegicideUI.instance().getServer().getOnlinePlayers();
        players.forEach(RegicideUIPlayerManager::addPlayer);
    }
    public static void removePlayer(@NotNull final Player player) {
        REGICIDE_PLAYERS.remove(player.getUniqueId());
    }

    public static RegicideUIPlayer getRegicideUiPlayer(@NotNull final UUID uuid) {
        return REGICIDE_PLAYERS.get(uuid);
    }

    public static RegicideUIPlayer getRegicideUiPlayer(@NotNull final Player player) {
        return REGICIDE_PLAYERS.get(player.getUniqueId());
    }
}

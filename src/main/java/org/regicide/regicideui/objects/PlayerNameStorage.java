package org.regicide.regicideui.objects;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public final class PlayerNameStorage {
    private final static Set<String> ONLINE_PLAYERS_NAMES_SET = new HashSet<>();

    public static void add(@NotNull final String name) {
     ONLINE_PLAYERS_NAMES_SET.add(name);
    }

    public static boolean contains(@NotNull final String name) {
        return ONLINE_PLAYERS_NAMES_SET.contains(name);
    }

    public static void remove(@NotNull final String name) {
        ONLINE_PLAYERS_NAMES_SET.remove(name);
    }

    @NotNull
    public static Set<String> get() {
        return ONLINE_PLAYERS_NAMES_SET;
    }

    public static void clear() {
        ONLINE_PLAYERS_NAMES_SET.clear();
    }
}

package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.objects.ui.profile.collection.CollectionPlayers;
import xyz.xenondevs.invui.window.Window;

public class PlayerListCMD {
    public static void register() {
        new CommandAPICommand("playerlist")
                .withAliases("onlinelist", "online", "players")
                .withPermission("regicideui.command.playerlist")
                .executesPlayer(executor -> {
                    Player pe = executor.sender();

                    Window w = Window.merged()
                            .setViewer(pe)
                            .setGui(new CollectionPlayers(pe).getGui())
                            .setTitle(Localization.getRaw("ui.element.playerlist.title", pe.locale().toString()))
                            .build();
                    w.open();

                    Sound s = Sound.sound(
                            new NamespacedKey(Config.instance().OPEN_MENU_PATH_SPACE, Config.instance().OPEN_MENU_PATH_NAME),
                            Sound.Source.PLAYER,
                            Config.instance().OPEN_MENU_VOLUME,
                            Config.instance().OPEN_MENU_PITCH
                    );
                    pe.playSound(s);
                })
                .register();
    }
}

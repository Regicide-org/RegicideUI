package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.objects.ui.towns.collection.CollectionTowns;
import xyz.xenondevs.invui.window.Window;

public class TownListCMD {
    public static void register() {
        new CommandAPICommand("townlist")
                .withPermission("regicideui.command.townlist")
                .executesPlayer(executor -> {
                    Player pe = executor.sender();

                    Window w = Window.merged()
                            .setViewer(pe)
                            .setGui(new CollectionTowns(pe).getGui())
                            .setTitle(Localization.getRaw("ui.element.townlist.title", pe.locale().toString()))
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

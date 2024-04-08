package org.regicide.regicideui.commands;
;
import dev.jorel.commandapi.CommandAPICommand;
import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.objects.ui.menu.Menu;
import xyz.xenondevs.invui.window.Window;


public final class MenuCMD {
    public static void register() {
        new CommandAPICommand("menu")
                .withPermission("regicideui.command.menu")
                .executesPlayer(pExecutor -> {
                    Player pe = pExecutor.sender();

                    Window w = Window.merged()
                            .setViewer(pe)
                            .setGui(new Menu(pe).getGui())
                            .setTitle(Localization.get("ui.element.menu.title", pe.locale().toString()))
                            .build();
                    w.open();

                    Sound s = Sound.sound(
                            new NamespacedKey(Config.getOpenMenuPathSpace(), Config.getOpenMenuPathName()),
                            Sound.Source.PLAYER,
                            Config.getOpenMenuVolume(),
                            Config.getOpenMenuPitch()
                    );
                    pe.playSound(s);
                })
                .register();
    }

}

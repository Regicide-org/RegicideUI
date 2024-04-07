package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.ui.hrefs.Hrefs;
import xyz.xenondevs.invui.window.Window;

public final class HrefsCMD {
    public static void register() {
        new CommandAPICommand("hrefs")
                .withPermission("regicideui.command.hrefs")
                .executesPlayer(executor -> {
                    Player pe = executor.sender();

                    Window window = Window.merged()
                            .setViewer(pe)
                            .setTitle(Localization.get("ui.element.hrefs.title", pe.locale().toString()))
                            .setGui(new Hrefs(pe).getGui())
                            .build();
                    window.open();

                    Sound s = Sound.sound(
                            new NamespacedKey(RegicideUI.config().getOpenMenuPathSpace(), RegicideUI.config().getOpenMenuPathName()),
                            Sound.Source.PLAYER,
                            RegicideUI.config().getOpenMenuVolume(),
                            RegicideUI.config().getOpenMenuPitch()
                    );
                    pe.playSound(s);
                })
                .register();
    }
}

package org.regicide.regicideui.commands;

import dev.jorel.commandapi.annotations.Alias;
import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.ui.menu.MenuGUI;
import xyz.xenondevs.invui.window.Window;


@Command("menu")
@Alias({"main"})
public final class MenuCMD {
    @SuppressWarnings("ConstantConditions")
    @Default
    @Permission("regicideui.command.menu")
    public static void menu(@NotNull final CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only for players!");
            return;
        }

        Player p = (Player) sender;

        Window window = Window.merged()
                .setViewer(p)
                .setGui(new MenuGUI().getGui())
                .setTitle(RegicideUI.l().c().getString("menu-title"))
                .build();
        window.open();

        Sound s = Sound.sound(
                new NamespacedKey(RegicideUI.config().getOpenMenuPathSpace(), RegicideUI.config().getOpenMenuPathName()),
                Sound.Source.PLAYER,
                RegicideUI.config().getOpenMenuVolume(),
                RegicideUI.config().getOpenMenuPitch()
        );
        p.playSound(s);
    }
}

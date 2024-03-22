package org.regicide.regicideui.commands;

import dev.jorel.commandapi.annotations.Alias;
import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
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

        Window window = Window.merged()
                .setViewer((Player) sender)
                .setGui(new MenuGUI(null).getGui())
                .setTitle(RegicideUI.l().c().getString("menu-title"))
                .build();
        window.open();
    }
}

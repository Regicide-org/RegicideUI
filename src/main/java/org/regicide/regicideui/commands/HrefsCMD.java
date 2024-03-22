package org.regicide.regicideui.commands;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.ui.hrefs.HrefsGUI;
import xyz.xenondevs.invui.window.Window;

@Command("hrefs")
public final class HrefsCMD {
    @SuppressWarnings("ConstantConditions")
    @Default
    @Permission("regicideui.command.hrefs")
    public static void hrefs(@NotNull final CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only for players!");
            return;
        }

        Window window = Window.merged()
                .setViewer((Player) sender)
                .setTitle(RegicideUI.l().c().getString("hrefs-title"))
                .setGui(new HrefsGUI(null).getGui())
                .build();
        window.open();
    }
}

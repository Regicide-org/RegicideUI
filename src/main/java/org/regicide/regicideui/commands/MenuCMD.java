package org.regicide.regicideui.commands;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.ui.GUIManager;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.SimpleItem;
import xyz.xenondevs.invui.window.Window;


@Command("menu")
public final class MenuCMD {
    @Default
    @Permission("regicideui.command.menu")
    public static void menu(@NotNull final CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only for players!");
            return;
        }

        Window window = Window.merged()
                .setViewer((Player) sender)
                .setGui(GUIManager.getGui("menu"))
                .setTitle("\uF808\uF804§f\u0781")
                .build();
        window.open();
    }
}

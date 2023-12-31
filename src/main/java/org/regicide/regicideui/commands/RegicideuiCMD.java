package org.regicide.regicideui.commands;

import dev.jorel.commandapi.annotations.*;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;

@Command("regicideui")
public final class RegicideuiCMD {

    @Default
    @Permission("regicideui.command.regicideui")
    public static void regicideui(@NotNull final CommandSender sender) {
        sender.sendMessage("--- RegicideUI help ---");
        sender.sendMessage("/regicideui – Show this help.");
        sender.sendMessage("/regicideui reload – Reloads the plugin.");
    }

    @Subcommand("reload")
    @Permission("regicideui.command.reload")
    public static void reload(@NotNull final CommandSender sender){
        RegicideUI.instance().reload();
        sender.sendMessage("Plugin was successfully reload!");
    }

}

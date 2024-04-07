package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.regicide.regicideui.RegicideUI;

public final class RegicideuiCMD {

    public static void register() {
        CommandAPICommand reload = new CommandAPICommand("reload")
                .withPermission("regicideui.command.regicideui.reload")
                .executes((sender) -> {
                    RegicideUI.instance().reload();
                    sender.sender().sendMessage("Plugin was successfully reload!");
                });

        new CommandAPICommand("regicideui")
                .withPermission("regicideui.command.regicideui")
                .withSubcommand(reload)
                .executesPlayer(executor -> {
                    Player p = executor.sender();
                    p.sendMessage("--- RegicideUI help ---");
                    p.sendMessage("/regicideui – Show this help.");
                    p.sendMessage("/regicideui reload – Reloads the plugin.");
                })
                .executesConsole(executor -> {
                    ConsoleCommandSender s = executor.sender();
                    s.sendMessage("--- RegicideUI help ---");
                    s.sendMessage("/regicideui – Show this help.");
                    s.sendMessage("/regicideui reload – Reloads the plugin.");
                })
                .register();
    }
}

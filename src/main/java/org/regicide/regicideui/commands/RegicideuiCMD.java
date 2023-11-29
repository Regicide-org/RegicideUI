package org.regicide.regicideui.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RegicideuiCMD implements CommandExecutor {

    private final List<String> subCommands = new ArrayList<>(Arrays.asList(
            "reload"
    ));

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (!(commandSender.hasPermission(command.getPermission()))) {
            commandSender.sendMessage("You don't have permission to use this command!");
            return true;
        }

        // no args/incorrect args
        if (strings.length == 0 || !subCommands.contains(strings[0])) {
            commandSender.sendMessage("Incorrect arguments. Try:");
            commandSender.sendMessage("/regicideui reload – reloads the plugin.");
            return true;
        }

        // first arg = "reload"
        if (!(commandSender.hasPermission(command.getPermission() + ".reload"))) {
            commandSender.sendMessage("You don't have permission to use this command!");
            return true;
        }
        RegicideUI.instance().reload();
        commandSender.sendMessage("RegicideUI was successfully reloaded!");

        return true;
    }
}

package org.regicide.regicideui.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class MenuCMD implements CommandExecutor {

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean onCommand(@NotNull final CommandSender commandSender, @NotNull final Command command, @NotNull final String s, final @NotNull String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) commandSender;

        if (!(player.hasPermission(command.getPermission()))) {
            player.sendMessage("You don't have permission to use this command!");
        }

        return true;
    }
}

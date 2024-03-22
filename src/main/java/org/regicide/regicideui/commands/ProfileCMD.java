package org.regicide.regicideui.commands;

import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
import dev.jorel.commandapi.annotations.arguments.AStringArgument;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@Command("profile")
public final class ProfileCMD {

    @Default
    @Permission("regicideui.command.profile")
    public static void profile(@NotNull final CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players have profiles!");
            return;
        }

        sender.sendMessage("TODO: open profile window for " + sender.getName());
    }

    @Default
    public static void profileOther(@NotNull final CommandSender sender, @AStringArgument String playerName) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("TODO: send profile info for " + playerName);
            return;
        }

        sender.sendMessage("TODO: open profile window for " + playerName);
    }
}
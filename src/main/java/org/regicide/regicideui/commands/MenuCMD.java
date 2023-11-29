package org.regicide.regicideui.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.entities.players.RegicideUIPlayer;
import org.regicide.regicideui.entities.players.RegicideUIPlayerManager;
import org.regicide.regicideui.ui.inventory.inventories.menu.MenuGUI;

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

        RegicideUIPlayer rPlayer = RegicideUIPlayerManager.getRegicideUiPlayer(player);

        rPlayer.openIGUI(new MenuGUI(rPlayer, "menu-gui", RegicideUI.l().c().getString("menu-title"), 6));

        return true;
    }
}

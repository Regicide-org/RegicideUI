package org.regicide.regicideui.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.entities.players.RegicideUIPlayer;
import org.regicide.regicideui.entities.players.RegicideUIPlayerManager;
import org.regicide.regicideui.ui.inventory.inventories.menu.MenuGUI;

public final class MenuCMD implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull final CommandSender commandSender, @NotNull final Command command, @NotNull final String s, final @NotNull String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only players can use this command!");
            return true;
        }
        Player player = (Player) commandSender;
        RegicideUIPlayer rPlayer = RegicideUIPlayerManager.getRegicideUiPlayer(player);

        rPlayer.openIGUI(new MenuGUI(rPlayer, "menu-gui", "Главное меню", 1));

        return true;
    }
}

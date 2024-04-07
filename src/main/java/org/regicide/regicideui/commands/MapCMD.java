package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.RegicideUI;

import java.text.MessageFormat;

public final class  MapCMD {
    public static void register() {
        new CommandAPICommand("webmap")
                .withAliases("mapurl")
                .withPermission("regicideui.command.webmap")
                .executes(executor -> {
                    CommandSender sender = executor.sender();

                    String mapLink = RegicideUI.config().getMapLink();

                    if (!(sender instanceof Player)) {
                        sender.sendMessage("WEB-Map URL: " + mapLink);
                        return;
                    }

                    String msg = Localization.get("message.button.open.map", ((Player) sender).locale().toString());
                    msg = MessageFormat.format(msg, mapLink);

                    sender.sendMessage(MiniMessage.miniMessage().deserialize(msg));
                })
                .register();
    }

}

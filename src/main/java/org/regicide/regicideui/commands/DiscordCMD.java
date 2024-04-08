package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;

import java.text.MessageFormat;

public final class DiscordCMD {
    public static void register() {
        new CommandAPICommand("discord")
                .withAliases("ds")
                .withPermission("regicideui.command.discord")
                .executes(executor -> {
                    CommandSender sender = executor.sender();

                    String dsLink = Config.getDiscordLink();

                    if (!(sender instanceof Player)) {
                        sender.sendMessage("Discord group: " + dsLink);

                        return;
                    }
                    String msg = Localization.get("message.button.open.discord", ((Player) sender).locale().toString());
                    msg = MessageFormat.format(msg, dsLink);


                    sender.sendMessage(MiniMessage.miniMessage().deserialize(msg));
                })
                .register();
    }
}
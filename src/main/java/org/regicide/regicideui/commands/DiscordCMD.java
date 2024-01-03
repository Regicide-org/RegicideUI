package org.regicide.regicideui.commands;

import dev.jorel.commandapi.annotations.Alias;
import dev.jorel.commandapi.annotations.Command;
import dev.jorel.commandapi.annotations.Default;
import dev.jorel.commandapi.annotations.Permission;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;

@Command("discord")
@Alias("ds")
public final class DiscordCMD {
    @Default
    @Permission("regicideui.command.discord")
    public static void discord(@NotNull final CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Discord group: " + RegicideUI.instance().getConfig().getString("discord-group-url"));
            return;
        }

        String url = RegicideUI.instance().getConfig().getString("discord-group-url");
        String msgText = RegicideUI.l().c().getString("get-discord-message");
        String hoverText = RegicideUI.l().c().getString("get-discord-hover");
        String msg = "<hover:show_text:'"+ hoverText +"'><click:open_url:'"+ url +"'>"+msgText+"</click></hover>";

        sender.sendMessage(MiniMessage.miniMessage().deserialize(msg));
    }
}

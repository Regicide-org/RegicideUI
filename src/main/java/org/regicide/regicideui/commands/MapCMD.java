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

@Command("mapurl")
@Alias({"webmap"})
public final class  MapCMD {
    @Default
    @Permission("regicideui.command.map")
    public static void map(@NotNull final CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Map URL: " + RegicideUI.instance().getConfig().getString("map-URL"));
            return;
        }

        String url = RegicideUI.config().getMapLink();
        String msgText = RegicideUI.l().c().getString("get-map-message");
        String hoverText = RegicideUI.l().c().getString("get-map-hover");
        String msg = "<hover:show_text:'"+ hoverText +"'><click:open_url:'"+ url +"'>"+msgText+"</click></hover>";

        sender.sendMessage(MiniMessage.miniMessage().deserialize(msg));
    }
}

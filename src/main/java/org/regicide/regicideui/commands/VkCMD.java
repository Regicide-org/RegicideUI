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

@Command("vk")
@Alias({"vkontakte"})
public final class VkCMD {
    @Default
    @Permission("regicideui.command.vk")
    public static void vk(@NotNull final CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("VK group: " + RegicideUI.instance().getConfig().getString("vk-group-url"));
            return;
        }

        String url = RegicideUI.instance().getConfig().getString("vk-group-url");
        String msgText = RegicideUI.l().c().getString("get-vk-message");
        String hoverText = RegicideUI.l().c().getString("get-vk-hover");
        String msg = "<hover:show_text:'"+ hoverText +"'><click:open_url:'"+ url +"'>"+msgText+"</click></hover>";

        sender.sendMessage(MiniMessage.miniMessage().deserialize(msg));
    }
}

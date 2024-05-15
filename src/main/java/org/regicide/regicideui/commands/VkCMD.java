package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;
import java.text.MessageFormat;

public final class VkCMD {
    public static void register() {
        new CommandAPICommand("vk")
                .withAliases("vkurl")
                .withPermission("regicideui.command.vk")
                .executes(executor -> {
                    CommandSender sender = executor.sender();

                    String mapLink = Config.instance().VK_LINK;

                    if (!(sender instanceof Player)) {
                        sender.sendMessage("VK group: " + mapLink);
                        return;
                    }

                    String msg = Localization.getRaw("message.button.open.vk", ((Player) sender).locale().toString());
                    msg = MessageFormat.format(msg, mapLink);

                    sender.sendMessage(MiniMessage.miniMessage().deserialize(msg));
                })
                .register();
    }
}

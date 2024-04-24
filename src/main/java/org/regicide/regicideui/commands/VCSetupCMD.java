package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;

import java.text.MessageFormat;

public class VCSetupCMD {
    public static void register() {
        new CommandAPICommand("voicechatsetup")
                .withAliases("voicechatinstall", "vcsetup", "vcinstall", "vci", "vcs")
                .withPermission("regicideui.command.voicechatsetup")
                .executesPlayer(executor -> {
                    Player pExecutor = executor.sender();
                    pExecutor.sendMessage("РЕАЛИАЦЗИЯ");
                })
                .register();
    }
}

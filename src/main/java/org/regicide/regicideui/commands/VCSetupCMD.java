package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.objects.RegicideUIPlayer;

import java.text.MessageFormat;

public class VCSetupCMD {
    public static void register() {
        new CommandAPICommand("voicechatsetup")
                .withAliases("voicechatinstall", "vcsetup", "vcinstall", "vci", "vcs")
                .withPermission("regicideui.command.voicechatsetup")
                .executesPlayer(executor -> {
                    Player pExecutor = executor.sender();
                    String msg;
                    RegicideUIPlayer ruiPlayer = RegicideUIPlayer.getPlayer(pExecutor.getUniqueId());

                    if (ruiPlayer.hasVCMod()) {
                        msg = Localization.getRaw("message.successful.notification.voicechat_installed", pExecutor.locale().toString());
                    } else {
                        msg = MessageFormat.format(Localization.getRaw("message.button.open.vc_install_guide", pExecutor.locale().toString()), Config.instance().VC_GUIDE_URL);
                    }
                    pExecutor.sendMessage(MiniMessage.miniMessage().deserialize(msg));
                })
                .register();
    }
}

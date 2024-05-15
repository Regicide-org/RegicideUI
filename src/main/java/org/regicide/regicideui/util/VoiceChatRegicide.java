package org.regicide.regicideui.util;

import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.events.EventRegistration;
import de.maxhenkel.voicechat.api.events.PlayerConnectedEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.RegicideUIPlayer;

public class VoiceChatRegicide implements VoicechatPlugin {
    @Override
    public String getPluginId() {
        return RegicideUI.instance().getName();
    }

    @Override
    public void initialize(VoicechatApi api) {
        VoicechatPlugin.super.initialize(api);
    }

    @Override
    public void registerEvents(EventRegistration registration) {
        registration.registerEvent(PlayerConnectedEvent.class, this::onPlayerConnectEvent);
    }

    public void onPlayerConnectEvent(PlayerConnectedEvent e) {
        try {
            Player p = Bukkit.getPlayer(e.getConnection().getPlayer().getUuid());
            RegicideUIPlayer ruiPlayer = RegicideUIPlayer.getPlayer(p);

            ruiPlayer.setVCCheckStatus(true);
            ruiPlayer.setVCModStatus(true);
        } catch (NullPointerException ignored) { }
    }
}

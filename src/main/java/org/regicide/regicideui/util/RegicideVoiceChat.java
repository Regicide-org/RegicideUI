package org.regicide.regicideui.util;

import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.events.*;
import de.maxhenkel.voicechat.api.packets.Packet;
import org.bukkit.entity.Player;
import org.regicide.regicideui.RegicideUI;

public final class RegicideVoiceChat implements VoicechatPlugin {

    /**
     * @return the unique ID for this voice chat plugin
     */
    @Override
    public String getPluginId() {
        return RegicideUI.instance().getName();
    }

    /**
     * Called when the voice chat initializes the plugin.
     *
     * @param api the voice chat API
     */
    @Override
    public void initialize(VoicechatApi api) {

    }

    /**
     * Called once by the voice chat to register all events.
     *
     * @param registration the event registration
     */
    @Override
    public void registerEvents(EventRegistration registration) {
        registration.registerEvent(PlayerConnectedEvent.class, this::testEvent);
    }

    public void testEvent(PlayerConnectedEvent event) {
        System.out.println(event.getConnection().isConnected());
    }
}

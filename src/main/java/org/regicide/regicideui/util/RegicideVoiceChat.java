package org.regicide.regicideui.util;

import de.maxhenkel.voicechat.api.VoicechatApi;
import de.maxhenkel.voicechat.api.VoicechatPlugin;
import de.maxhenkel.voicechat.api.events.*;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.RegicideUIPlayer;

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
    public void registerEvents(@NotNull final EventRegistration registration) {
        registration.registerEvent(PlayerStateChangedEvent.class, this::playerStateChangeListener);
    }

    public void playerStateChangeListener(PlayerStateChangedEvent e) {
        RegicideUIPlayer ruiPlayer = RegicideUIPlayer.getPlayer(e.getPlayerUuid());
        if (ruiPlayer.isVcChecked())
            return;

        e.getConnection().isInstalled();
        ruiPlayer.setVcChecked(true);
    }
}

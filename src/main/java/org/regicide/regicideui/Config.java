package org.regicide.regicideui;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Configuration of the {@link RegicideUI}.
 */
public final class Config {
    private static Config instance;
    public final String DEFAULT_LOCALIZATION;
    public final boolean IS_CLIENT_BASED;
    public final String MAP_LINK;
    public final String VK_LINK;
    public final String DISCORD_LINK;
    public final String EXIT_BUTTON_PATH_NAME;
    public final String EXIT_BUTTON_PATH_SPACE;
    public final float EXIT_BUTTON_PITCH;
    public final float EXIT_BUTTON_VOLUME;
    public final String BACK_BUTTON_PATH_NAME;
    public final String BACK_BUTTON_PATH_SPACE;
    public final float BACK_BUTTON_PITCH;
    public final float BACK_BUTTON_VOLUME;
    public final String OPEN_MENU_PATH_NAME;
    public final String OPEN_MENU_PATH_SPACE;
    public final float OPEN_MENU_PITCH;
    public final float OPEN_MENU_VOLUME;
    public final boolean USE_CUSTOM_HELP;
    public final List<String> HELP_UNREGISTERED_COMMANDS;
    public final boolean VC_USE;
    public final int VC_NOTIFICATION_PERIOD;
    public final int VC_NOTIFICATION_DELAY;
    public final boolean VC_NOTIFICATION_SOUND_USE;
    public final String VC_NOTIFICATION_PATH_SPACE;
    public final String VC_NOTIFICATION_PATH_NAME;
    public final float VC_NOTIFICATION_PITCH;
    public final float VC_NOTIFICATION_VOLUME;

    public Config() throws IOException, InvalidConfigurationException {
        instance = this;

        File file;
        FileConfiguration fileConfig;

        file = new File(RegicideUI.instance().getDataFolder() + File.separator + "settings",
                "configuration.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            RegicideUI.instance().saveResource("settings"+ File.separator +"configuration.yml", false);
        }

        fileConfig = new YamlConfiguration();
        fileConfig.load(file);

        DEFAULT_LOCALIZATION = fileConfig.getString("language.default-localization");
        IS_CLIENT_BASED = fileConfig.getBoolean("language.client-based");

        MAP_LINK = fileConfig.getString("GUI.links.map");
        VK_LINK = fileConfig.getString("GUI.links.vk-group");
        DISCORD_LINK = fileConfig.getString("GUI.links.discord");

        EXIT_BUTTON_PATH_SPACE = fileConfig.getString("GUI.sounds.exit-button.path.space");
        EXIT_BUTTON_PATH_NAME = fileConfig.getString("GUI.sounds.exit-button.path.name");
        EXIT_BUTTON_PITCH = (float) fileConfig.getDouble("GUI.sounds.exit-button.pitch");
        EXIT_BUTTON_VOLUME = (float) fileConfig.getDouble("GUI.sounds.exit-button.volume");

        BACK_BUTTON_PATH_SPACE = fileConfig.getString("GUI.sounds.back-button.path.space");
        BACK_BUTTON_PATH_NAME = fileConfig.getString("GUI.sounds.back-button.path.name");
        BACK_BUTTON_PITCH = (float) fileConfig.getDouble("GUI.sounds.back-button.pitch");
        BACK_BUTTON_VOLUME = (float) fileConfig.getDouble("GUI.sounds.back-button.volume");

        OPEN_MENU_PATH_SPACE = fileConfig.getString("GUI.sounds.open-menu.path.space");
        OPEN_MENU_PATH_NAME = fileConfig.getString("GUI.sounds.open-menu.path.name");
        OPEN_MENU_PITCH = (float) fileConfig.getDouble("GUI.sounds.open-menu.pitch");
        OPEN_MENU_VOLUME = (float) fileConfig.getDouble("GUI.sounds.open-menu.volume");

        USE_CUSTOM_HELP = fileConfig.getBoolean("GUI.help.use-custom-help");
        HELP_UNREGISTERED_COMMANDS = fileConfig.getStringList("GUI.help.unregister-help");

        VC_USE = fileConfig.getBoolean("voice-chat.voice-chat");

        VC_NOTIFICATION_SOUND_USE = fileConfig.getBoolean("voice-chat.installation-notification.use-sound");
        VC_NOTIFICATION_PERIOD = fileConfig.getInt("voice-chat.installation-notification.period");
        VC_NOTIFICATION_DELAY = fileConfig.getInt("voice-chat.installation-notification.delay");
        VC_NOTIFICATION_PATH_SPACE = fileConfig.getString("voice-chat.installation-notification.sound.path.space");
        VC_NOTIFICATION_PATH_NAME = fileConfig.getString("voice-chat.installation-notification.sound.path.name");
        VC_NOTIFICATION_PITCH = (float) fileConfig.getDouble("voice-chat.installation-notification.pitch");
        VC_NOTIFICATION_VOLUME = (float) fileConfig.getDouble("voice-chat.installation-notification.volume");
    }

    public static Config instance() {
        return instance;
    }
}

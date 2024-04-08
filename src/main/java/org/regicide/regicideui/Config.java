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
    private static String defaultLocalization;
    private static boolean isClientBased;

    private static String mapLink;
    private static String vkLink;
    private static String discordLink;

    private static String exitButtonPathName;
    private static String exitButtonPathSpace;
    private static float exitButtonPitch;
    private static float exitButtonVolume;
    private static String backButtonPathName;
    private static String backButtonPathSpace;
    private static float backButtonPitch;
    private static float backButtonVolume;
    private static String openMenuPathName;
    private static String openMenuPathSpace;
    private static float openMenuPitch;
    private static float openMenuVolume;

    private static boolean useCustomHelp;
    private static List<String> helpUnregistered;

    public static void setup() throws IOException, InvalidConfigurationException {
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

        defaultLocalization = fileConfig.getString("language.default-localization");
        isClientBased = fileConfig.getBoolean("language.client-based");

        mapLink = fileConfig.getString("GUI.links.map");
        vkLink = fileConfig.getString("GUI.links.vk-group");
        discordLink = fileConfig.getString("GUI.links.discord");

        exitButtonPathSpace = fileConfig.getString("GUI.sounds.exit-button.path.space");
        exitButtonPathName = fileConfig.getString("GUI.sounds.exit-button.path.name");
        exitButtonPitch = (float) fileConfig.getDouble("GUI.sounds.exit-button.pitch");
        exitButtonVolume = (float) fileConfig.getDouble("GUI.sounds.exit-button.volume");

        backButtonPathSpace = fileConfig.getString("GUI.sounds.back-button.path.space");
        backButtonPathName = fileConfig.getString("GUI.sounds.back-button.path.name");
        backButtonPitch = (float) fileConfig.getDouble("GUI.sounds.back-button.pitch");
        backButtonVolume = (float) fileConfig.getDouble("GUI.sounds.back-button.volume");

        openMenuPathSpace = fileConfig.getString("GUI.sounds.open-menu.path.space");
        openMenuPathName = fileConfig.getString("GUI.sounds.open-menu.path.name");
        openMenuPitch = (float) fileConfig.getDouble("GUI.sounds.open-menu.pitch");
        openMenuVolume = (float) fileConfig.getDouble("GUI.sounds.open-menu.volume");

        useCustomHelp = fileConfig.getBoolean("GUI.help.use-custom-help");
        helpUnregistered = fileConfig.getStringList("GUI.help.unregister-help");
    }

    public static String getDefaultLocalization() {
        return defaultLocalization;
    }

    public static boolean isClientBased() {
        return isClientBased;
    }

    public static String getMapLink() {
        return mapLink;
    }

    public static String getVkLink() {
        return vkLink;
    }

    public static String getDiscordLink() {
        return discordLink;
    }

    public static String getExitButtonPathName() {
        return exitButtonPathName;
    }

    public static String getExitButtonPathSpace() {
        return exitButtonPathSpace;
    }

    public static float getExitButtonPitch() {
        return exitButtonPitch;
    }

    public static float getExitButtonVolume() {
        return exitButtonVolume;
    }

    public static String getBackButtonPathName() {
        return backButtonPathName;
    }

    public static String getBackButtonPathSpace() {
        return backButtonPathSpace;
    }

    public static float getBackButtonPitch() {
        return backButtonPitch;
    }

    public static float getBackButtonVolume() {
        return backButtonVolume;
    }

    public static String getOpenMenuPathName() {
        return openMenuPathName;
    }

    public static String getOpenMenuPathSpace() {
        return openMenuPathSpace;
    }

    public static float getOpenMenuPitch() {
        return openMenuPitch;
    }

    public static float getOpenMenuVolume() {
        return openMenuVolume;
    }

    public static boolean isUseCustomHelp() {
        return useCustomHelp;
    }

    public static List<String> getHelpUnregistered() {
        return helpUnregistered;
    }
}

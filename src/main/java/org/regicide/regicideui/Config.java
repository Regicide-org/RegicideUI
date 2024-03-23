package org.regicide.regicideui;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Configuration of the {@link RegicideUI}.
 */
public final class Config {
    private final String defaultLocalization;
    private final boolean isClientBased;

    private final String mapLink;
    private final String vkLink;
    private final String discordLink;

    private final String exitButtonPathName;
    private final String exitButtonPathSpace;
    private final float exitButtonPitch;
    private final float exitButtonVolume;
    private final String backButtonPathName;
    private final String backButtonPathSpace;
    private final float backButtonPitch;
    private final float backButtonVolume;
    private final String openMenuPathName;
    private final String openMenuPathSpace;
    private final float openMenuPitch;
    private final float openMenuVolume;

    public Config() throws IOException, InvalidConfigurationException {
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

        this.defaultLocalization = fileConfig.getString("language.default-localization");
        this.isClientBased = fileConfig.getBoolean("language.client-based");

        this.mapLink = fileConfig.getString("GUI.links.map");
        this.vkLink = fileConfig.getString("GUI.links.vk-group");
        this.discordLink = fileConfig.getString("GUI.links.discord");

        this.exitButtonPathSpace = fileConfig.getString("GUI.sounds.exit-button.path.space");
        this.exitButtonPathName = fileConfig.getString("GUI.sounds.exit-button.path.name");
        this.exitButtonPitch = (float) fileConfig.getDouble("GUI.sounds.exit-button.pitch");
        this.exitButtonVolume = (float) fileConfig.getDouble("GUI.sounds.exit-button.volume");

        this.backButtonPathSpace = fileConfig.getString("GUI.sounds.back-button.path.space");
        this.backButtonPathName = fileConfig.getString("GUI.sounds.back-button.path.name");
        this.backButtonPitch = (float) fileConfig.getDouble("GUI.sounds.back-button.pitch");
        this.backButtonVolume = (float) fileConfig.getDouble("GUI.sounds.back-button.volume");

        this.openMenuPathSpace = fileConfig.getString("GUI.sounds.open-menu.path.space");
        this.openMenuPathName = fileConfig.getString("GUI.sounds.open-menu.path.name");
        this.openMenuPitch = (float) fileConfig.getDouble("GUI.sounds.open-menu.pitch");
        this.openMenuVolume = (float) fileConfig.getDouble("GUI.sounds.open-menu.volume");
    }

    public String getDefaultLocalization() {
        return defaultLocalization;
    }

    public boolean isClientBased() {
        return isClientBased;
    }

    public String getMapLink() {
        return mapLink;
    }

    public String getVkLink() {
        return vkLink;
    }

    public String getDiscordLink() {
        return discordLink;
    }

    public String getExitButtonPathName() {
        return exitButtonPathName;
    }

    public String getExitButtonPathSpace() {
        return exitButtonPathSpace;
    }

    public float getExitButtonPitch() {
        return exitButtonPitch;
    }

    public float getExitButtonVolume() {
        return exitButtonVolume;
    }

    public String getBackButtonPathName() {
        return backButtonPathName;
    }

    public String getBackButtonPathSpace() {
        return backButtonPathSpace;
    }

    public float getBackButtonPitch() {
        return backButtonPitch;
    }

    public float getBackButtonVolume() {
        return backButtonVolume;
    }

    public String getOpenMenuPathName() {
        return openMenuPathName;
    }

    public String getOpenMenuPathSpace() {
        return openMenuPathSpace;
    }

    public float getOpenMenuPitch() {
        return openMenuPitch;
    }

    public float getOpenMenuVolume() {
        return openMenuVolume;
    }
}

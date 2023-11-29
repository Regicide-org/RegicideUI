package org.regicide.regicideui.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;

import java.io.File;
import java.io.IOException;

public final class CustomConfig {
    private File configFile;
    private FileConfiguration config;

    /**
     * Creates new custom configuration for the plugin.
     * @param name The path to the configuration file in plugin data folder and the full name.
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public CustomConfig(@NotNull final String name) {
        configFile = new File(RegicideUI.instance().getDataFolder(), name);
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            RegicideUI.instance().saveResource(name, false);
        }

        config = new YamlConfiguration();
        try {
            config.load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            RegicideUI.instance().getLogger().severe(e.toString());
        }
    }

    /**
     * @return The file configuration.
     */
    public FileConfiguration c() {
        return this.config;
    }
}

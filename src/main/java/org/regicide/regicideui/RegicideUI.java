package org.regicide.regicideui;

import dev.jorel.commandapi.CommandAPI;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.regicide.regicideui.commands.*;
import org.regicide.regicideui.utils.CustomConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Main plugin class.
 */
public final class RegicideUI extends JavaPlugin {

    private static Economy econ = null;

    private static RegicideUI instance;
    private static CustomConfiguration localization;
    private static Config config;

    @Override
    public void onLoad() {

    }

    /**
     * Plugin startup logic.
     */
    @Override
    public void onEnable() {
        getLogger().info("");
        instance = this;
        //RegicideUIPlayerManager.loadAllPlayers();

        // Config
        if (!configLoad()) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getLogger().info("Configuration was successfully loaded!");

        if (getConfig().getBoolean("vault")) {
            Plugin vault = getServer().getPluginManager().getPlugin("Vault");
            if (vault != null) {
                setupEconomy();
                getLogger().info(vault.getPluginMeta().getName() + " – " + vault.getPluginMeta().getVersion() + " was successfully found!");
            }
            else {
                getLogger().warning("Vault was not found! All plugin elements using Vault will be disabled!");
                this.getConfig().set("Vault", Boolean.FALSE);
            }
        }

        // TODO: переписать этот позор, используя Internalization (https://docs.papermc.io/velocity/dev/component-api/i18n)
        String localizationName = getConfig().getString("localization");
        localization = new CustomConfiguration("localization" + File.separator + localizationName + ".yml");
        getLogger().info(localizationName + " was successfully loaded!");

        getLogger().info("");
        getLogger().info("Loading listeners...");
        getLogger().info("All listeners successfully loaded!");

        getLogger().info("");
        getLogger().info("Loading commands...");
        CommandAPI.registerCommand(RegicideuiCMD.class);
        CommandAPI.registerCommand(MenuCMD.class);
        CommandAPI.registerCommand(MapCMD.class);
        CommandAPI.registerCommand(HrefsCMD.class);
        CommandAPI.registerCommand(DiscordCMD.class);
        CommandAPI.registerCommand(VkCMD.class);
        CommandAPI.registerCommand(ProfileCMD.class);
        getLogger().info("All commands successfully loaded!");
    }

    /**
     * Reloads the plugin.
     */
    public void reload() {
        //RegicideUIPlayerManager.loadAllPlayers();
        this.reloadConfig();
        localization = new CustomConfiguration("localization" + File.separator + getConfig().getString("localization") + ".yml");
        getLogger().info("Plugin was successfully reload!");
    }

    /**
     * Plugin shutdown logic.
     */
    @Override
    public void onDisable() {
    }

    private boolean configLoad() {
        try {
            config = new Config();
        } catch (IOException | InvalidConfigurationException e) {
            getLogger().severe("Critical error when creating the configuration file! Details below:");
            e.printStackTrace();
            getLogger().severe("RegicideUI will not work without configuration. Shutdown.");
            return false;
        }
        return true;
    }

    private void setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return;
        }
        econ = rsp.getProvider();
    }

    @SuppressWarnings("unused")
    public static Economy getEconomy() {
        return econ;
    }

    /**
     * @return The instance of the plugin
     */
    public static RegicideUI instance() {
        return instance;
    }

    /**
     * @return The localization of the {@link RegicideUI}.
     */
    public static CustomConfiguration l() { return localization; }

    /**
     * @return The configuration of the {@link RegicideUI}.
     */
    public static Config config() {
        return config;
    }
}

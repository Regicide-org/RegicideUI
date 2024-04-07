package org.regicide.regicideui;

import dev.jorel.commandapi.CommandAPIBukkit;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.regicide.regicideui.commands.*;
import org.regicide.regicideui.listeners.PlayerListener;

import java.io.File;
import java.io.IOException;

/**
 * Main plugin class.
 */
public final class RegicideUI extends JavaPlugin {

    private static Economy econ = null;
    private static RegicideUI instance;
    private static Config config;

    @Override
    public void onLoad() {

    }

    /**
     * Plugin startup logic.
     */
    @Override
    @SuppressWarnings("UnstableApiUsage")
    public void onEnable() {
        instance = this;
        //RegicideUIPlayerManager.loadAllPlayers();

        Bukkit.getLogger().info("=====================     RegicideUI     =====================");
        // Config
        if (!configLoad()) {
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getLogger().info("Configuration was successfully loaded!");

        // Vault
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

        // Localization
        try {
            Localization.setup(this, config.isClientBased(), "settings" + File.separator + "localization", "reference", config.getDefaultLocalization());
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        getLogger().info("Localization was successfully loaded!");

        listenersLoad();
        getLogger().info("All listeners successfully loaded!");

        commandsLoad();
        getLogger().info("All commands successfully loaded!");
        Bukkit.getLogger().info("==============================================================");
        getLogger().info("Version: "+ getPluginMeta().getVersion() + " – Plugin Enabled");
        Bukkit.getLogger().info("==============================================================");
    }

    /**
     * Reloads the plugin.
     */
    public void reload() {
        //RegicideUIPlayerManager.loadAllPlayers();
        this.reloadConfig();
        try {
            Localization.setup(this, config.isClientBased(), "settings" + File.separator + "localization", "reference", config.getDefaultLocalization());
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
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

    private void listenersLoad() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
    }

    private void commandsLoad() {
        RegicideuiCMD.register();
        MenuCMD.register();
        MapCMD.register();
        HrefsCMD.register();
        DiscordCMD.register();
        VkCMD.register();
        ProfileCMD.register();

        if (config().isUseCustomHelp()) {
            // TODO доделать
            new BukkitRunnable() {
                @Override
                public void run() {
                    CommandAPIBukkit.unregister("help", false, true);
                }
            }.runTaskLater(this, 0);

            HelpCMD.register();
        }
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
     * @return The configuration of the {@link RegicideUI}.
     */
    public static Config config() {
        return config;
    }
}

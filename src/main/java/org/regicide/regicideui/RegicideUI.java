package org.regicide.regicideui;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.commands.MenuCMD;
import org.regicide.regicideui.entities.players.RegicideUIPlayerManager;
import org.regicide.regicideui.listeners.PlayerListener;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Main plugin class.
 */
public final class RegicideUI extends JavaPlugin {

    private static Economy econ = null;

    private static RegicideUI instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        RegicideUIPlayerManager.loadAllPlayers();

        if (!new File(getDataFolder(), "config.yml").exists()) {
            saveDefaultConfig();
            getLogger().info("Configuration was successfully created and loaded!");
        } else getLogger().info("Configuration was successfully loaded!");

        getLogger().info(String.valueOf(getConfig().getBoolean("Vault")));

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

        getLogger().info(String.valueOf(getConfig().getBoolean("Vault")));

        getLogger().info("Loading listeners...");
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getLogger().info("All listeners successfully loaded!");

        getLogger().info("Loading commands...");
        Objects.requireNonNull(
                this.getCommand("Menu")).setExecutor(new MenuCMD());
        getLogger().info("All commands successfully loaded!");
    }

    /**
     * Reloads the plugin.
     */
    public void reload() {
        RegicideUIPlayerManager.loadAllPlayers();
        this.reloadConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    /**
     * @return The instance of the plugin
     */
    public static RegicideUI instance() {
        return instance;
    }
}

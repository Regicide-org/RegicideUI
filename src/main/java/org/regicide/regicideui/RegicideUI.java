package org.regicide.regicideui;

import dev.jorel.commandapi.CommandAPI;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.regicide.regicideui.commands.*;
import org.regicide.regicideui.utils.CustomConfig;

import java.io.File;

/**
 * Main plugin class.
 */
public final class RegicideUI extends JavaPlugin {

    private static Economy econ = null;

    private static RegicideUI instance;
    private static CustomConfig localization;

    @Override
    public void onLoad() {

    }

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        //RegicideUIPlayerManager.loadAllPlayers();

        if (!new File(getDataFolder(), "config.yml").exists()) {
            saveDefaultConfig();
            getLogger().info("Configuration was successfully created and loaded!");
        } else getLogger().info("Configuration was successfully loaded!");

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

        String localizationName = getConfig().getString("localization");
        localization = new CustomConfig("localization" + File.separator + localizationName + ".yml");
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
        localization = new CustomConfig("localization" + File.separator + getConfig().getString("localization") + ".yml");
        getLogger().info("Plugin was successfully reload!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
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
     * @return The plugin's loaded localization.
     */
    public static CustomConfig l() { return localization; }
}

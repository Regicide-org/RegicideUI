package org.regicide.regicideui;

import de.maxhenkel.voicechat.api.BukkitVoicechatService;
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
import org.regicide.regicideui.listeners.ClickOnPlayerSeeProfileListener;
import org.regicide.regicideui.util.RegicideVoiceChat;

import java.io.File;
import java.io.IOException;

/**
 * Main plugin class.
 */
public final class RegicideUI extends JavaPlugin {
    private static Economy econ = null;
    private static RegicideUI instance;

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

        additionalLoad();

        // Localization
        try {
            Localization.setup(this, Config.isClientBased(), "settings" + File.separator + "localization", "reference", Config.getDefaultLocalization());
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        getLogger().info("Localization was successfully loaded!");

        defaultListenersLoad();
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
        this.reloadConfig();
        try {
            Localization.setup(this, Config.isClientBased(), "settings" + File.separator + "localization", "reference", Config.getDefaultLocalization());
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
        /*if (vcr != null) {
            getServer().getServicesManager().unregister(vcr);
        }*/
    }

    private boolean configLoad() {
        try {
            Config.setup();
        } catch (IOException | InvalidConfigurationException e) {
            getLogger().severe("Critical error when creating the configuration file! Details below:");
            e.printStackTrace();
            getLogger().severe("RegicideUI will not work without configuration. Shutdown.");
            return false;
        }
        return true;
    }

    @SuppressWarnings({"UnstableApiUsage", "ConstantConditions"})
    private void additionalLoad() {
        // Vault
        Plugin vault = getServer().getPluginManager().getPlugin("Vault");
        if (vault != null) {
            setupEconomy();
            getLogger().info(vault.getPluginMeta().getName() + " – " + vault.getPluginMeta().getVersion() + " was successfully found!");
        } else {
            getLogger().warning("Vault was not found! All plugin elements using Vault will be disabled!");
        }

        // Protocol
        /*Plugin protocolLib = getServer().getPluginManager().getPlugin("ProtocolLib");
        if (protocolLib != null) {

            getLogger().info(protocolLib.getPluginMeta().getName() + " – " + protocolLib.getPluginMeta().getVersion() + " was successfully found!");
        }
        else {
            getLogger().warning("ProtocolLib was not found! All plugin elements using Vault will be disabled!");
        }*/

        // SimpleVoiceChat
        Plugin svc = getServer().getPluginManager().getPlugin("voicechat");
        if (svc != null) {
            BukkitVoicechatService service = getServer().getServicesManager().load(BukkitVoicechatService.class);
            service.registerPlugin(new RegicideVoiceChat());
            getLogger().info(svc.getPluginMeta().getName() + " – " + vault.getPluginMeta().getVersion() + " was successfully found!");
        }
        else {
            getLogger().warning("SimpleVoiceChat was not found! All plugin elements using Vault will be disabled!");
        }

    }

    private void defaultListenersLoad() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ClickOnPlayerSeeProfileListener(), this);
    }

    private void commandsLoad() {
        RegicideuiCMD.register();
        MenuCMD.register();
        MapCMD.register();
        HrefsCMD.register();
        DiscordCMD.register();
        VkCMD.register();
        ProfileCMD.register();

        if (Config.isUseCustomHelp()) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    CommandAPIBukkit.unregister("help", false, true);
                    HelpCMD.register();
                }
            }.runTaskLater(this, 0);
        }
    }

    /**
     * Setups vault economy.
     */
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

    /**
     * @return The vault economy.
     */
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

}

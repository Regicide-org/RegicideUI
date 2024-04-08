package org.regicide.regicideui.objects.ui.hrefs;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.DefaultElementGUI;
import xyz.xenondevs.invui.window.WindowManager;

import java.util.Objects;

public class DiscordBtn extends DefaultElementGUI {

    public DiscordBtn(@NotNull ContainerGUI container) {
        super(container, "ui.element.hrefs.button.discord.name", "ui.element.hrefs.button.discord.lore", 112);
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent inventoryClickEvent) {
        if (clickType.isLeftClick()) {
            Objects.requireNonNull(
                    WindowManager.getInstance().getOpenWindow(container.getViewer())
            ).close();
            player.performCommand("discord");

            net.kyori.adventure.sound.Sound s = net.kyori.adventure.sound.Sound.sound(
                    new NamespacedKey(Config.getOpenMenuPathSpace(), Config.getOpenMenuPathName()),
                    net.kyori.adventure.sound.Sound.Source.PLAYER,
                    Config.getOpenMenuVolume(),
                    Config.getOpenMenuPitch()
            );
            player.playSound(s);
        }
    }
}

package org.regicide.regicideui.objects.ui.menu;

import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.DefaultElementGUI;
import xyz.xenondevs.invui.window.WindowManager;

import java.util.Objects;

public class WebMapBtn extends DefaultElementGUI {

    public WebMapBtn(@NotNull final ContainerGUI container) {
        super(container, "ui.element.menu.button.webmap.name", "ui.element.menu.button.webmap.lore", 111);
        this.container = container;
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        if (clickType.isLeftClick()) {

            net.kyori.adventure.sound.Sound s = net.kyori.adventure.sound.Sound.sound(
                    new NamespacedKey(Config.getOpenMenuPathSpace(), Config.getOpenMenuPathName()),
                    Sound.Source.PLAYER,
                    Config.getOpenMenuVolume(),
                    Config.getOpenMenuPitch()
            );
            player.playSound(s);
            Objects.requireNonNull(
                    WindowManager.getInstance().getOpenWindow(container.getViewer())
            ).close();
            player.performCommand("mapurl");
        }
    }
}

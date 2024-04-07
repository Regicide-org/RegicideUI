package org.regicide.regicideui.objects.ui.universal;

import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.DefaultElementGUI;
import xyz.xenondevs.invui.window.Window;
import xyz.xenondevs.invui.window.WindowManager;

import java.util.Objects;

public class BackBtn extends DefaultElementGUI {
    private final Window prevWindow;
    public BackBtn(@NotNull final Window prevWindow, @NotNull final ContainerGUI container) {
        super(container, "ui.element.universal.button.back.name", "ui.element.universal.button.back.lore", 98);
        this.container = container;
        this.prevWindow = prevWindow;
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent inventoryClickEvent) {
        if (clickType.isLeftClick()) {

            Sound s = Sound.sound(
                    new NamespacedKey(RegicideUI.config().getExitButtonPathSpace(), RegicideUI.config().getExitButtonPathName()),
                    Sound.Source.PLAYER,
                    RegicideUI.config().getExitButtonVolume(),
                    RegicideUI.config().getExitButtonPitch()
            );
            prevWindow.open();
            player.playSound(s);
        }
    }
}

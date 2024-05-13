package org.regicide.regicideui.objects.ui.universal;

import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.DefaultElementGUI;
import xyz.xenondevs.invui.window.Window;

public class BackBtn extends DefaultElementGUI {
    private final Window prevWindow;
    public BackBtn(@NotNull final Window prevWindow, @NotNull final ContainerGUI container, int cmd) {
        super(container, "ui.element.universal.button.back.name", "ui.element.universal.button.back.lore", cmd);
        this.container = container;
        this.prevWindow = prevWindow;
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent inventoryClickEvent) {
        if (clickType.isLeftClick()) {

            Sound s = Sound.sound(
                    new NamespacedKey(Config.instance().BACK_BUTTON_PATH_SPACE, Config.instance().BACK_BUTTON_PATH_NAME),
                    Sound.Source.PLAYER,
                    Config.instance().BACK_BUTTON_VOLUME,
                    Config.instance().BACK_BUTTON_PITCH
            );
            prevWindow.open();
            player.playSound(s);
        }
    }
}

package org.regicide.regicideui.objects.ui.hrefs;

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

public class VkontakteBtn extends DefaultElementGUI  {

    public VkontakteBtn(@NotNull ContainerGUI container) {
        super(container, "ui.element.hrefs.button.vk.name", "ui.element.hrefs.button.vk.lore", 113);
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent inventoryClickEvent) {
        if (clickType.isLeftClick()) {
            Objects.requireNonNull(
                    WindowManager.getInstance().getOpenWindow(container.getViewer())
            ).close();
            player.performCommand("vk");

            Sound s = Sound.sound(
                    new NamespacedKey(Config.instance().OPEN_MENU_PATH_SPACE, Config.instance().OPEN_MENU_PATH_NAME),
                    Sound.Source.PLAYER,
                    Config.instance().OPEN_MENU_VOLUME,
                    Config.instance().OPEN_MENU_PITCH
            );
            player.playSound(s);
        }
    }
}

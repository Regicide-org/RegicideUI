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
import xyz.xenondevs.invui.window.Window;

public class DonateBtn extends DefaultElementGUI {

    public DonateBtn(@NotNull final ContainerGUI container) {
        super(container, "ui.element.menu.button.donate.name", "ui.element.menu.button.donate.lore", 103);
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        if (clickType.isLeftClick()) {

            Sound s = Sound.sound(
                    new NamespacedKey(Config.getExitButtonPathSpace(), Config.getExitButtonPathName()),
                    Sound.Source.PLAYER,
                    Config.getExitButtonVolume(),
                    Config.getExitButtonPitch()
            );
            player.playSound(s);
            player.sendMessage("");
            player.sendMessage("§lДонат не реализован (и в рамках ПД не подразумевает реализацию!)");
            player.sendMessage("");

            this.getWindows().forEach(Window::close);
        }
    }
}
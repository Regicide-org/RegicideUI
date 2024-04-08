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
import xyz.xenondevs.invui.window.WindowManager;

import java.util.Objects;


public class ExitBtn extends DefaultElementGUI {

    private final ContainerGUI container;

    public ExitBtn(@NotNull final ContainerGUI container, int cmd) {
        super(container, "ui.element.universal.button.exit.name", "ui.element.universal.button.exit.lore", cmd);
        this.container = container;
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

            Objects.requireNonNull(
                    WindowManager.getInstance().getOpenWindow(container.getViewer())
            ).close();
        }
    }
}
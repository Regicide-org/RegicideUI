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

public class MarketBtn extends DefaultElementGUI {

    private final ContainerGUI container;

    public MarketBtn(@NotNull final ContainerGUI container) {
        super(container, "ui.element.menu.button.market.name", "ui.element.menu.button.market.lore", 107);
        this.container = container;
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        if (clickType.isLeftClick()) {

            Sound s = Sound.sound(
                    new NamespacedKey(Config.instance().EXIT_BUTTON_PATH_SPACE, Config.instance().EXIT_BUTTON_PATH_NAME),
                    Sound.Source.PLAYER,
                    Config.instance().EXIT_BUTTON_VOLUME,
                    Config.instance().EXIT_BUTTON_PITCH
            );
            player.playSound(s);

            player.sendMessage("");
            player.sendMessage("§lРынок не реализован (и в рамках ПД не подразумевает реализацию!)");
            player.sendMessage("");

            Objects.requireNonNull(
                    WindowManager.getInstance().getOpenWindow(container.getViewer())
            ).close();
        }
    }
}
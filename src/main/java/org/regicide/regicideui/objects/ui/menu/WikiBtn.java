package org.regicide.regicideui.objects.ui.menu;

import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.Config;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.DefaultElementGUI;
import org.regicide.regicideui.objects.ui.help.Help;
import xyz.xenondevs.invui.window.Window;
import xyz.xenondevs.invui.window.WindowManager;

public class WikiBtn extends DefaultElementGUI {

    private final ContainerGUI container;

    public WikiBtn(@NotNull final ContainerGUI container) {
        super(container, "ui.element.menu.button.wiki.name", "ui.element.menu.button.wiki.lore", 106);
        this.container = container;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        if (clickType.isLeftClick()) {

            Window window = Window.merged()
                    .setViewer(player)
                    .setGui(new Help(WindowManager.getInstance().getOpenWindow(player), player).getGui())
                    .setTitle(Localization.get("ui.element.wiki.title", container.getViewer().locale().toString()))
                    .build();
            window.open();

            net.kyori.adventure.sound.Sound s = net.kyori.adventure.sound.Sound.sound(
                    new NamespacedKey(Config.getOpenMenuPathSpace(), Config.getOpenMenuPathName()),
                    Sound.Source.PLAYER,
                    Config.getOpenMenuVolume(),
                    Config.getOpenMenuPitch()
            );
            player.playSound(s);
        }
    }
}
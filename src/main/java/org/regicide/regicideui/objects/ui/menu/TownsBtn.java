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
import org.regicide.regicideui.objects.ui.profile.collection.CollectionPlayers;
import org.regicide.regicideui.objects.ui.towns.collection.CollectionTowns;
import xyz.xenondevs.invui.window.Window;
import xyz.xenondevs.invui.window.WindowManager;

public class TownsBtn extends DefaultElementGUI {

    public TownsBtn(@NotNull final ContainerGUI container) {
        super(container, "ui.element.menu.button.towns.name", "ui.element.menu.button.towns.lore", 108);
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        if (clickType.isLeftClick()) {

            Window window = Window.merged()
                    .setViewer(player)
                    .setGui(new CollectionTowns(WindowManager.getInstance().getOpenWindow(player), player).getGui())
                    .setTitle(Localization.getRaw("ui.element.townlist.title", container.getViewer().locale().toString()))
                    .build();
            window.open();

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
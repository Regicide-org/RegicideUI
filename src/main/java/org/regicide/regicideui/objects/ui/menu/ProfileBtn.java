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
import org.regicide.regicideui.objects.ui.hrefs.Hrefs;
import org.regicide.regicideui.objects.ui.profile.collection.CollectionPlayers;
import org.regicide.regicideui.objects.ui.profile.single.Profile;
import xyz.xenondevs.invui.window.Window;
import xyz.xenondevs.invui.window.WindowManager;

public class ProfileBtn extends DefaultElementGUI {

    private final ContainerGUI container;

    public ProfileBtn(@NotNull final ContainerGUI container) {
        super(container, "ui.element.menu.button.profile.name", "ui.element.menu.button.profile.lore", 110);
        this.container = container;
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        if (clickType.isLeftClick()) {

            Window window = Window.merged()
                    .setViewer(player)
                    .setGui(new CollectionPlayers(WindowManager.getInstance().getOpenWindow(player), player).getGui())
                    .setTitle(Localization.getRaw("ui.element.playerlist.title", container.getViewer().locale().toString()))
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
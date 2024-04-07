package org.regicide.regicideui.objects.ui.menu;

import net.kyori.adventure.sound.Sound;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.DefaultElementGUI;
import org.regicide.regicideui.objects.ui.profile.Profile;
import xyz.xenondevs.invui.window.Window;

public final class ProfileBtn extends DefaultElementGUI {

    private final ContainerGUI container;

    public ProfileBtn(@NotNull final ContainerGUI container) {
        super(container, "ui.element.menu.button.profile.name", "ui.element.menu.button.profile.lore", 110);
        this.container = container;
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        Window window = Window.merged()
                .setViewer(player)
                .setGui(new Profile(player).getGui())
                .setTitle(Localization.get("ui.element.profile.title", container.getViewer().locale().toString()))
                .build();
        window.open();

        net.kyori.adventure.sound.Sound s = net.kyori.adventure.sound.Sound.sound(
                new NamespacedKey(RegicideUI.config().getOpenMenuPathSpace(), RegicideUI.config().getOpenMenuPathName()),
                Sound.Source.PLAYER,
                RegicideUI.config().getOpenMenuVolume(),
                RegicideUI.config().getOpenMenuPitch()
        );
        player.playSound(s);
    }
}
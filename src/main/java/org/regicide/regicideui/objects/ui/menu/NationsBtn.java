package org.regicide.regicideui.objects.ui.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.DefaultElementGUI;

public class NationsBtn extends DefaultElementGUI {

    public NationsBtn(@NotNull final ContainerGUI container) {
        super(container, "ui.element.menu.button.nations.name", "ui.element.menu.button.nations.lore", 109);
        this.container = container;
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
    }
}
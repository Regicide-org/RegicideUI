package org.regicide.regicideui.objects.ui.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.DefaultElementGUI;

public class TownsBtn extends DefaultElementGUI {

    public TownsBtn(@NotNull final ContainerGUI container) {
        super(container, "ui.element.menu.button.towns.name", "ui.element.menu.button.towns.lore", 108);
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
    }
}
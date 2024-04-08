package org.regicide.regicideui.objects.ui.universal;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.DefaultElementGUI;

public class InfoBtn extends DefaultElementGUI {
    public InfoBtn(@NotNull final ContainerGUI container, @NotNull final String loreKey, int cmd) {
        super(container, "ui.element.universal.button.info.name", loreKey, cmd);
        this.container = container;
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent inventoryClickEvent) {
    }
}

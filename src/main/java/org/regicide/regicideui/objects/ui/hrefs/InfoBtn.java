package org.regicide.regicideui.objects.ui.hrefs;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.DefaultElementGUI;

public class InfoBtn extends DefaultElementGUI {
    public InfoBtn(@NotNull ContainerGUI container) {
        super(container, "ui.element.universal.button.info.name", "ui.element.hrefs.button.info.lore", 99);
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent inventoryClickEvent) {

    }
}

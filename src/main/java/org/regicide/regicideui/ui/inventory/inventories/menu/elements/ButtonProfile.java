package org.regicide.regicideui.ui.inventory.inventories.menu.elements;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.ui.inventory.IGUIElement;

public final class ButtonProfile extends IGUIElement {
    /**
     * Builder
     *
     * @param slotItem The functional inventory item.
     * @param slot     The inventory slot.
     */
    public ButtonProfile(@NotNull ItemStack slotItem, int slot) {
        super(slotItem, slot);
    }

    @Override
    public void onClick(@NotNull InventoryClickEvent e) {

    }

    @Override
    public void onUpdate() {

    }
}

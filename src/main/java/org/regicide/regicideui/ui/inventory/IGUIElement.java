package org.regicide.regicideui.ui.inventory;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * The functional element of the InventoryGUI.
 */
public abstract class IGUIElement {

    private ItemStack slotItem;
    private final int amount = 1;
    private final int slot;

    /**
     * Builder
     * @param slotItem The functional inventory item.
     * @param slot The inventory slot.
     */
    public IGUIElement(@NotNull final ItemStack slotItem, int slot) {
        this.slotItem = slotItem;
        this.slot = slot;
    }

    /**
     * @return The functional ItemStack.
     */
    public ItemStack getSlotItem() {
        return this.slotItem;
    }

    /**
     * @return The item's slot.
     */
    public int getSlot() {
        return slot;
    }

    /**
     * The executor of the inventory element on the click.
     * @param e InventoryClickEvent.
     */
    public abstract void onClick(@NotNull final InventoryClickEvent e);

    public abstract void onUpdate();

}

package org.regicide.regicideui.ui.inventory;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.util.HSVLike;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.entities.players.RegicideUIPlayer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The GUI based on chest-inventory.
 */
public abstract class InventoryGUI {

    protected final String identifier;
    protected final RegicideUIPlayer holder;
    protected String title;
    protected Inventory inv;
    protected int rows;
    protected final Map<Integer, IGUIElement> elementMap = new HashMap<>();

    public InventoryGUI(@NotNull final RegicideUIPlayer holder, @NotNull final String identifier, @NotNull String title, int rows) {
        this.holder = holder;
        this.identifier = identifier;
        this.rows = rows;
        this.title = title;
    }

    public void build() {
        Component titleComponent = MiniMessage.miniMessage().deserialize(title);
        Inventory inv = Bukkit.createInventory(null, rows * 9, titleComponent);

        for (IGUIElement el : elementMap.values()) {
            inv.setItem(el.getSlot(), el.getSlotItem());
        }
        this.inv = inv;
    }

    /**
     * @return The holder of the InventoryGUI.
     */
    public RegicideUIPlayer getHolder() {
        return holder;
    }

    /**
     * @return Element by the slot number.
     *
     * @param slot The number of the slot.
     */
    public IGUIElement getElement(int slot) {
        return elementMap.get(slot);
    }

    /**
     * @return The collection of all elements of the InventoryGUI.
     */
    public Collection<IGUIElement> getElements() {
        return elementMap.values();
    }

    /**
     * @param element Adds element to the InventoryGUI.
     */
    public void addElement(IGUIElement element) {
        this.elementMap.put(element.getSlot(), element);
    }

    /**
     * @return The title of InventoryGUI (Chest Inventory title).
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The amount of InventoryGUI rows.
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return The chest-inventory of the GUI.
     */
    public Inventory getInventory() {
        return inv;
    }

    /**
     * Sets the inventory for InventoryGUI.
     *
     * @param inv Minecraft inventory.
     */
    public void setInventory(@NotNull final Inventory inv) {
        this.inv = inv;
    }

    /**
     * What will happen on player open the InventoryGUI.
     *
     * @param e The inventory open event.
     */
    public abstract void onOpen(@NotNull final InventoryOpenEvent e);

    /**
     * What will happen on player close the InventoryGUI.
     *
     * @param e The inventory close event.
     */
    public abstract void onClose(@NotNull final InventoryCloseEvent e);
}

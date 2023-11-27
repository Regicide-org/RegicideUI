package org.regicide.regicideui.listeners.local;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.ui.inventory.InventoryGUI;

public final class InventoryGUIListener implements Listener {

    private final InventoryGUI inventoryGUI;

    public InventoryGUIListener(@NotNull final InventoryGUI inventoryGUI) {
        this.inventoryGUI = inventoryGUI;
    }

    @EventHandler
    public void onClick(@NotNull final InventoryClickEvent e) {
        if (!(e.getInventory().equals(inventoryGUI.getInventory())))
            return;

        e.setCancelled(true);
        int clickedSlot = e.getSlot();


        if (e.getCurrentItem() != null)
            inventoryGUI.getElement(clickedSlot).onClick(e);
    }

    @EventHandler
    public void onOpen(@NotNull final InventoryOpenEvent e) {
        if (!(e.getInventory().equals(inventoryGUI.getInventory())))
            return;

        RegicideUI.instance().getLogger().info("Кастомный инвентарь открыт! " + inventoryGUI.getTitle());

        inventoryGUI.onOpen(e);
    }

    @EventHandler
    public void onClose(@NotNull final InventoryCloseEvent e) {
        if (!(e.getInventory().equals(inventoryGUI.getInventory())))
            return;

        RegicideUI.instance().getLogger().info("Кастомный инвентарь закрыт! " + inventoryGUI.getTitle());
        inventoryGUI.onClose(e);

        RegicideUI.instance().getLogger().info("Листенеры этого ивнентаря ушли нахуй! " + inventoryGUI.getTitle());
        InventoryClickEvent.getHandlerList().unregister(this);
        InventoryOpenEvent.getHandlerList().unregister(this);
        InventoryCloseEvent.getHandlerList().unregister(this);
    }
}

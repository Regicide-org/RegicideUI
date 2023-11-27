package org.regicide.regicideui.entities.players;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.ui.inventory.InventoryGUI;
import org.regicide.regicideui.listeners.local.InventoryGUIListener;

public class RegicideUIPlayer {

    private final Player player;
    private InventoryGUI currentOpenedGUI = null;
    public RegicideUIPlayer(@NotNull final Player player) {
        this.player = player;
    }

    public void openIGUI(@NotNull final InventoryGUI inventoryGUI) {

        currentOpenedGUI = inventoryGUI;
        RegicideUI pl = RegicideUI.instance();

        inventoryGUI.build();

        pl.getServer().getPluginManager().registerEvents(new InventoryGUIListener(inventoryGUI), pl);
        this.player.openInventory(inventoryGUI.getInventory());
    }

    public InventoryGUI getCurrentOpenedGUI() {
        return currentOpenedGUI;
    }

    public void setCurrentOpenedGUI(@Nullable final InventoryGUI currentOpenedGUI) {
        this.currentOpenedGUI = currentOpenedGUI;
    }

    /**
     * @return True if player currently has opened InventoryGUI and False if not.
     */
    public boolean isGUIOpened() {
        return currentOpenedGUI != null;
    }

    /**
     * @return The player object of RegicideUIPlayer.
     */
    public Player getPlayer() {
        return player;
    }
}

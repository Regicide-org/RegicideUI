package org.regicide.regicideui.ui.inventory.inventories.menu;

import net.kyori.adventure.text.Component;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.entities.players.RegicideUIPlayer;
import org.regicide.regicideui.ui.inventory.InventoryGUI;

import java.util.ArrayList;
import java.util.List;

public final class MenuGUI extends InventoryGUI {

    public MenuGUI(@NotNull RegicideUIPlayer holder, @NotNull String identifier, @NotNull String title, int rows) {
        super(holder, identifier, title, rows);

        List<Component> lore = new ArrayList<>();
        Component lc1 = Component.text("А я вот в армии служил!").toBuilder().build();
        lore.add(lc1);

        //addElement(new HealElement(Material.APPLE, 5, Component.text("Менюшечка-хуюшечка").toBuilder().build(), lore));
    }

    @Override
    public void onOpen(@NotNull InventoryOpenEvent e) {

    }

    @Override
    public void onClose(@NotNull InventoryCloseEvent e) {

    }
}

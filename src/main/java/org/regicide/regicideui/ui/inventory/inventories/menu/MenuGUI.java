package org.regicide.regicideui.ui.inventory.inventories.menu;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.entities.players.RegicideUIPlayer;
import org.regicide.regicideui.ui.inventory.InventoryGUI;
import org.regicide.regicideui.ui.inventory.inventories.menu.elements.*;

import java.util.ArrayList;
import java.util.List;

public final class MenuGUI extends InventoryGUI {

    public MenuGUI(@NotNull RegicideUIPlayer holder, @NotNull String identifier, @NotNull String title, int rows) {
        super(holder, identifier, title, rows);

        ItemStack uItem;

        ItemMeta itemMeta;
        Component name;
        List<Component> lore;


        
        // Profile
        uItem = new ItemStack(Material.FLINT_AND_STEEL);

        itemMeta = uItem.getItemMeta();
        itemMeta.setCustomModelData(100);

        name = MiniMessage.miniMessage().deserialize(RegicideUI.l().c().getString("profile-button-name"));
        itemMeta.displayName(name);
        lore = new ArrayList<>();

        for (String s : RegicideUI.l().c().getStringList("profile-button-lore")) {
            Component c = MiniMessage.miniMessage().deserialize(s);
            lore.add(c);
        }
        itemMeta.lore(lore);

        uItem.setItemMeta(itemMeta);

        for (int i = 0; i <= 3; i++)
            addElement(new ButtonProfile(uItem, i));
        for (int i = 9; i <= 12; i++)
            addElement(new ButtonProfile(uItem, i));
        for (int i = 18; i <= 21; i++)
            addElement(new ButtonProfile(uItem, i));

        
        
        // Encyclopedia
        uItem = new ItemStack(Material.FLINT_AND_STEEL);

        itemMeta = uItem.getItemMeta();
        itemMeta.setCustomModelData(100);

        name = MiniMessage.miniMessage().deserialize(RegicideUI.l().c().getString("encyclopedia-button-name"));
        itemMeta.displayName(name);
        lore = new ArrayList<>();

        for (String s : RegicideUI.l().c().getStringList("encyclopedia-button-lore")) {
            Component c = MiniMessage.miniMessage().deserialize(s);
            lore.add(c);
        }
        itemMeta.lore(lore);

        uItem.setItemMeta(itemMeta);

        for (int i = 27; i <= 30; i++)
            addElement(new ButtonEncyclopedia(uItem, i));
        for (int i = 36; i <= 39; i++)
            addElement(new ButtonEncyclopedia(uItem, i));
        for (int i = 45; i <= 48; i++)
            addElement(new ButtonEncyclopedia(uItem, i));

        
        
        // Towns
        uItem = new ItemStack(Material.FLINT_AND_STEEL);

        itemMeta = uItem.getItemMeta();
        itemMeta.setCustomModelData(100);

        name = MiniMessage.miniMessage().deserialize(RegicideUI.l().c().getString("towns-button-name"));
        itemMeta.displayName(name);
        lore = new ArrayList<>();

        for (String s : RegicideUI.l().c().getStringList("towns-button-lore")) {
            Component c = MiniMessage.miniMessage().deserialize(s);
            lore.add(c);
        }
        itemMeta.lore(lore);

        uItem.setItemMeta(itemMeta);

        for (int i = 4; i <= 8; i++)
            addElement(new ButtonTowns(uItem, i));
        for (int i = 13; i <= 17; i++)
            addElement(new ButtonTowns(uItem, i));

        
        
        // Nations
        uItem = new ItemStack(Material.FLINT_AND_STEEL);

        itemMeta = uItem.getItemMeta();
        itemMeta.setCustomModelData(100);

        name = MiniMessage.miniMessage().deserialize(RegicideUI.l().c().getString("nations-button-name"));
        itemMeta.displayName(name);
        lore = new ArrayList<>();

        for (String s : RegicideUI.l().c().getStringList("nations-button-lore")) {
            Component c = MiniMessage.miniMessage().deserialize(s);
            lore.add(c);
        }
        itemMeta.lore(lore);

        uItem.setItemMeta(itemMeta);

        for (int i = 22; i <= 26; i++)
            addElement(new ButtonNations(uItem, i));
        for (int i = 31; i <= 35; i++)
            addElement(new ButtonNations(uItem, i));

        

        // Market
        uItem = new ItemStack(Material.FLINT_AND_STEEL);

        itemMeta = uItem.getItemMeta();
        itemMeta.setCustomModelData(100);

        name = MiniMessage.miniMessage().deserialize(RegicideUI.l().c().getString("market-button-name"));
        itemMeta.displayName(name);
        lore = new ArrayList<>();

        for (String s : RegicideUI.l().c().getStringList("market-button-lore")) {
            Component c = MiniMessage.miniMessage().deserialize(s);
            lore.add(c);
        }
        itemMeta.lore(lore);

        uItem.setItemMeta(itemMeta);

        for (int i = 40; i <= 44; i++)
            addElement(new ButtonMarket(uItem, i));
        for (int i = 49; i <= 53; i++)
            addElement(new ButtonMarket(uItem, i));
    }

    @Override
    public void onOpen(@NotNull InventoryOpenEvent e) {

    }

    @Override
    public void onClose(@NotNull InventoryCloseEvent e) {

    }
}

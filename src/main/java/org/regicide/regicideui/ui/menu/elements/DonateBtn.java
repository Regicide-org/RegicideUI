package org.regicide.regicideui.ui.menu.elements;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;

import java.util.ArrayList;
import java.util.List;

public final class DonateBtn extends AbstractItem {
    @Override
    public ItemProvider getItemProvider() {
        ItemStack i = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta m = i.getItemMeta();



        m.setCustomModelData(103);



        String titleText = RegicideUI.l().c().getString("menu-button-donate-name");
        Component title = MiniMessage.miniMessage().deserialize("<i:false><white>"+titleText+"</white></i>");
        m.displayName(title);



        List<String> loreText = RegicideUI.l().c().getStringList("menu-button-donate-lore");
        List<Component> lore = new ArrayList<>();
        for (String s : loreText)
            lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>"+s+"</white></i>"));
        m.lore(lore);



        i.setItemMeta(m);
        return new ItemBuilder(i);
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
    }
}
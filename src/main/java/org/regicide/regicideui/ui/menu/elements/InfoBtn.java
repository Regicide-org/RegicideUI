package org.regicide.regicideui.ui.menu.elements;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.ui.universal.InfoItem;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;

import java.util.ArrayList;
import java.util.List;

public final class InfoBtn extends AbstractItem {
    @Override
    public ItemProvider getItemProvider() {
        ItemStack i = InfoItem.getItem();
        ItemMeta m = i.getItemMeta();

        List<TextComponent> lore = new ArrayList<>();
        TextComponent s1 = Component.empty();
        TextComponent s2 = Component
                .text("В данном меню представлены\n").color(TextColor.color(0xFCFC00)).decoration(TextDecoration.ITALIC, false)
                .append(Component.text().content("подменю, такие как: профиль,\n"))
                .append(Component.text().content("города, нации, рынок и т.п.\n"))
                .append(Component.text().content("\n"))
                .append(Component.text().content("И обратите внимание на донат O_O"))
                .toBuilder().build();
        lore.add(s1);
        lore.add(s2);
        m.lore(lore);

        i.setItemMeta(m);
        return new ItemBuilder(i);
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {

    }
}

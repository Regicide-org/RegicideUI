package org.regicide.regicideui.ui.Menu.elements;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
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
        TextComponent name = Component.text("Донат")
                .decoration(TextDecoration.ITALIC, false)
                .color(TextColor.color(0xFFFFFF))
                .decorate(TextDecoration.BOLD)
                .toBuilder().build();
        m.displayName(name);



        List<TextComponent> lore = new ArrayList<>();
        TextComponent s1 = Component.empty();
        TextComponent s2 = Component.text("Аренда хостинга стоит денег, так\n").decoration(TextDecoration.ITALIC, false).color(TextColor.color(0xFCFC00))
                .append(Component.text("что да, помогите материально, пожалуйста!\n\n"))
                .append(Component.text("\u0500 ").color(TextColor.color(0xFFFFFF)))
                .append(Component.text().content(">").color(NamedTextColor.DARK_GRAY))
                .append(Component.text().content(" Клик ").color(TextColor.color(0xE9D282)))
                .append(Component.text().content("– получить ссылку на донат").color(TextColor.color(0xFCFC00)))
                .toBuilder().build();
        lore.add(s1);
        lore.add(s2);
        m.lore(lore);

        i.setItemMeta(m);
        return new ItemBuilder(i);
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        if (clickType.isLeftClick()) {
        }
    }
}
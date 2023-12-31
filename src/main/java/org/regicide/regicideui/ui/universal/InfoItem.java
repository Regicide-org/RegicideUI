package org.regicide.regicideui.ui.universal;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class InfoItem {
    public static ItemStack getItem() {
        ItemStack i = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta m = i.getItemMeta();



        m.setCustomModelData(102);
        TextComponent name = Component.text("Инфо")
                .decoration(TextDecoration.ITALIC, false)
                .color(TextColor.color(0xFFFFFF))
                .decorate(TextDecoration.BOLD)
                .toBuilder().build();
        m.displayName(name);

        i.setItemMeta(m);
        return i;
    }
}

package org.regicide.regicideui.ui.universal;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.regicide.regicideui.RegicideUI;

public final class InfoItem {
    public static ItemStack getItem() {
        ItemStack i = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta m = i.getItemMeta();



        m.setCustomModelData(99);

        String titleText = RegicideUI.l().c().getString("button-info-name");
        Component title = MiniMessage.miniMessage().deserialize("<i:false><white>"+titleText+"</white></i>");
        m.displayName(title);



        i.setItemMeta(m);
        return i;
    }
}

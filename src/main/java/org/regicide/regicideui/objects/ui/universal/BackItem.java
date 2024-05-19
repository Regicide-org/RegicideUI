package org.regicide.regicideui.objects.ui.universal;

import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.Config;
import xyz.xenondevs.invui.gui.PagedGui;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.controlitem.PageItem;

import java.util.ArrayList;
import java.util.List;

public class BackItem extends PageItem {
    public BackItem() {
        super(false);
    }

    @Override
    public ItemProvider getItemProvider(PagedGui<?> gui) {
        ItemStack i = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta m = i.getItemMeta();

        String nameText = "Предыдущая страница";
        Component name = MiniMessage.miniMessage().deserialize("<i:false><white>"+nameText+"</white></i>");
        m.displayName(name);

        List<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize(""));
        if (gui.hasPreviousPage()) {
            m.setCustomModelData(118);
            lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Ԁ<dark_gray> > <#E9D282>Клик <#FCFC00>– перейти на <yellow>" + gui.getCurrentPage() + "<#E9D282>/<yellow>" + gui.getPageAmount() + "</i>"));
        } else {
            m.setCustomModelData(122);
            lore.add(MiniMessage.miniMessage().deserialize("<i:false><#D82625>Страницы закончились!</i>"));
        }
        m.lore(lore);

        i.setItemMeta(m);
        return new ItemBuilder(i);
    }

    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        super.handleClick(clickType, player, event);

        Sound s = Sound.sound(
                new NamespacedKey(Config.instance().OPEN_MENU_PATH_SPACE, Config.instance().OPEN_MENU_PATH_NAME),
                Sound.Source.PLAYER,
                Config.instance().OPEN_MENU_VOLUME,
                Config.instance().OPEN_MENU_PITCH
        );
        player.playSound(s);
    }
}

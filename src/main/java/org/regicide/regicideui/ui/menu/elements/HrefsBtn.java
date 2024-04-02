package org.regicide.regicideui.ui.menu.elements;

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
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.ui.hrefs.HrefsGUI;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;
import xyz.xenondevs.invui.window.Window;
import xyz.xenondevs.invui.window.WindowManager;

import java.util.ArrayList;
import java.util.List;

public final class HrefsBtn extends AbstractItem {
    @Override
    public ItemProvider getItemProvider() {
        ItemStack i = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta m = i.getItemMeta();



        m.setCustomModelData(104);



        String titleText = RegicideUI.l().c().getString("menu-button-hrefs-name");
        Component title = MiniMessage.miniMessage().deserialize("<i:false><white>"+titleText+"</white></i>");
        m.displayName(title);



        List<String> loreText = RegicideUI.l().c().getStringList("menu-button-hrefs-lore");
        List<Component> lore = new ArrayList<>();
        for (String s : loreText)
            lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>"+s+"</white></i>"));
        m.lore(lore);



        i.setItemMeta(m);
        return new ItemBuilder(i);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent event) {
        if (clickType.isLeftClick()) {

            Window window = Window.merged()
                    .setViewer(player)
                    .setGui(new HrefsGUI(WindowManager.getInstance().getOpenWindow(player)).getGui())
                    .setTitle(RegicideUI.l().c().getString("hrefs-title"))
                    .build();
            window.open();

            net.kyori.adventure.sound.Sound s = net.kyori.adventure.sound.Sound.sound(
                    new NamespacedKey(RegicideUI.config().getOpenMenuPathSpace(), RegicideUI.config().getOpenMenuPathName()),
                    Sound.Source.PLAYER,
                    RegicideUI.config().getOpenMenuVolume(),
                    RegicideUI.config().getOpenMenuPitch()
            );
            player.playSound(s);
        }
    }
}

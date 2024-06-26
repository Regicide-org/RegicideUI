package org.regicide.regicideui.objects.ui.nations.collection;

import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Town;
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
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.nations.single.NationUI;
import org.regicide.regicideui.objects.ui.profile.single.Profile;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;
import xyz.xenondevs.invui.window.Window;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

public class NationBtn extends AbstractItem {
    private final ContainerGUI container;
    private final Nation nation;


    public NationBtn(@NotNull final ContainerGUI container, @NotNull final Nation nation) {
        this.container = container;
        this.nation = nation;
    }

    @Override
    public ItemProvider getItemProvider() {
        ItemStack i = new ItemStack(Material.FLINT_AND_STEEL);
        ItemMeta m = i.getItemMeta();

        m.setCustomModelData(109);

        String nameText = nation.getName();
        Component name = MiniMessage.miniMessage().deserialize("<i:false><white>"+nameText+"</white></i>");
        m.displayName(name);

        String loreKey = "ui.element.nationlist.button.nationicon.lore";
        List<Component> lore = new ArrayList<>();
        int n = 1;
        while (true) {
            try {
                String s = Localization.getRaw(loreKey + "." + n, container.getViewer().locale().toString());
                n++;
                lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>"+s+"</white></i>"));
            } catch (MissingResourceException e) {
                break;
            }
        }
        m.lore(lore);

        i.setItemMeta(m);
        return new ItemBuilder(i);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent inventoryClickEvent) {
        if (clickType.isLeftClick()) {

            Window window = Window.merged()
                    .setViewer(player)
                    .setTitle(Localization.getRaw("ui.element.nation.title", player.locale().toString()))
                    .setGui(new NationUI(player).getGui())
                    .build();
            window.open();

            Sound s = Sound.sound(
                    new NamespacedKey(Config.instance().OPEN_MENU_PATH_SPACE, Config.instance().OPEN_MENU_PATH_NAME),
                    Sound.Source.PLAYER,
                    Config.instance().OPEN_MENU_VOLUME,
                    Config.instance().OPEN_MENU_PITCH
            );
            player.playSound(s);
        }
    }
}

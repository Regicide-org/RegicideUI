package org.regicide.regicideui.objects.ui;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.Localization;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

public abstract class DefaultElementGUI extends AbstractItem {

    protected Material base = Material.FLINT_AND_STEEL;
    protected ContainerGUI container;
    protected String nameKey;
    protected String loreKey;
    int cmd;

    public DefaultElementGUI(@NotNull final ContainerGUI container, @NotNull final String nameKey, @NotNull final String loreKey, int cmd) {
        this.container = container;
        this.nameKey = nameKey;
        this.loreKey = loreKey;
        this.cmd = cmd;
    }

    public DefaultElementGUI(@NotNull final Material base, @NotNull final ContainerGUI container, @NotNull final String nameKey, @NotNull final String loreKey, int cmd) {
        this.base = base;
        this.container = container;
        this.nameKey = nameKey;
        this.loreKey = loreKey;
        this.cmd = cmd;
    }

    @Override
    public ItemProvider getItemProvider() {
        ItemStack i = new ItemStack(this.base);
        ItemMeta m = i.getItemMeta();

        m.setCustomModelData(this.cmd);

        String nameText = Localization.getRaw(this.nameKey, container.getViewer().locale().toString());
        Component name = MiniMessage.miniMessage().deserialize("<i:false><white>"+nameText+"</white></i>");
        m.displayName(name);

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
}

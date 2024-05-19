package org.regicide.regicideui.objects.ui.towns.collection;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.universal.BackItem;
import org.regicide.regicideui.objects.ui.universal.ForwardItem;
import org.regicide.regicideui.objects.ui.universal.BackBtn;
import org.regicide.regicideui.objects.ui.universal.ExitBtn;
import org.regicide.regicideui.objects.ui.universal.InfoBtn;
import xyz.xenondevs.invui.gui.PagedGui;
import xyz.xenondevs.invui.gui.structure.Markers;
import xyz.xenondevs.invui.item.Item;
import xyz.xenondevs.invui.item.impl.AbstractItem;
import xyz.xenondevs.invui.window.Window;

import java.util.ArrayList;
import java.util.List;

public final class CollectionTowns extends ContainerGUI {
    public CollectionTowns(@NotNull final Window prevWindow, @NotNull final Player player) {
        super(prevWindow, player);
    }

    public CollectionTowns(@NotNull final Player player) {
        super(player);
    }

    @Override
    public void setup() {
        List<Town> towns = TownyAPI.getInstance().getTowns();
        List<Item> elements = new ArrayList<>();
        towns.forEach(town -> elements.add(new TownBtn(this, town)));

        AbstractItem exitBackBtn;
        if (this.hasPrevWindow())
            exitBackBtn = new BackBtn(this.prevWindow, this, 98);
        else exitBackBtn = new ExitBtn(this, 101);

        // create the gui
        this.gui = PagedGui.items()
                .setStructure(
                        "e . . . . . . . i",
                        ". . . . . . . . .",
                        ". @ @ @ @ @ @ @ .",
                        "< @ @ @ @ @ @ @ >",
                        ". @ @ @ @ @ @ @ .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . T . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .addIngredient('e', exitBackBtn)
                .addIngredient('i', new InfoBtn(this, "ui.element.townlist.button.info.lore", 99))
                .addIngredient('<', new BackItem())
                .addIngredient('>', new ForwardItem())
                .addIngredient('T', new SelfTownBtn(this, this.viewer))
                .addIngredient('@', Markers.CONTENT_LIST_SLOT_HORIZONTAL)
                .setContent(elements)
                .build();
    }
}

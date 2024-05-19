package org.regicide.regicideui.objects.ui.nations.collection;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.profile.collection.PlayerHeadBtn;
import org.regicide.regicideui.objects.ui.towns.collection.TownBtn;
import org.regicide.regicideui.objects.ui.universal.*;
import xyz.xenondevs.invui.gui.PagedGui;
import xyz.xenondevs.invui.gui.structure.Markers;
import xyz.xenondevs.invui.item.Item;
import xyz.xenondevs.invui.item.impl.AbstractItem;
import xyz.xenondevs.invui.window.Window;

import java.util.ArrayList;
import java.util.List;

public final class CollectionNations extends ContainerGUI {
    public CollectionNations(@NotNull final Window prevWindow, @NotNull final Player player) {
        super(prevWindow, player);
    }

    public CollectionNations(@NotNull final Player player) {
        super(player);
    }

    @Override
    public void setup() {
        List<Nation> nations = TownyAPI.getInstance().getNations();
        List<Item> elements = new ArrayList<>();
        nations.forEach(nation -> elements.add(new NationBtn(this, nation)));

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
                        ". . N . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .addIngredient('e', exitBackBtn)
                .addIngredient('i', new InfoBtn(this, "ui.element.nationlist.button.info.lore", 99))
                .addIngredient('<', new BackItem())
                .addIngredient('>', new ForwardItem())
                .addIngredient('N', new SelfNationBtn(this, this.viewer))
                .addIngredient('@', Markers.CONTENT_LIST_SLOT_HORIZONTAL)
                .setContent(elements)
                .build();
    }
}

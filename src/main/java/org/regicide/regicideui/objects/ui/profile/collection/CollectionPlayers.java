package org.regicide.regicideui.objects.ui.profile.collection;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.universal.*;
import xyz.xenondevs.invui.gui.PagedGui;
import xyz.xenondevs.invui.gui.structure.Markers;
import xyz.xenondevs.invui.item.Item;
import xyz.xenondevs.invui.item.impl.AbstractItem;
import xyz.xenondevs.invui.window.Window;

import java.util.ArrayList;
import java.util.List;
public final class CollectionPlayers extends ContainerGUI {


    public CollectionPlayers(@NotNull final Window prevWindow, @NotNull final Player player) {
        super(prevWindow, player);
    }

    public CollectionPlayers(@NotNull final Player player) {
        super(player);
    }

    @Override
    public void setup() {
        List<Player> pList = new ArrayList<>(RegicideUI.instance().getServer().getOnlinePlayers());
        List<Item> elements = new ArrayList<>();
        pList.forEach(player -> elements.add(new PlayerHeadBtn(this, player)));

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
                        ". . P . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .addIngredient('e', exitBackBtn)
                .addIngredient('i', new InfoBtn(this, "ui.element.playerlist.button.info.lore", 99))
                .addIngredient('<', new BackItem())
                .addIngredient('>', new ForwardItem())
                .addIngredient('P', new SelfProfileBtn(this, getViewer()))
                .addIngredient('@', Markers.CONTENT_LIST_SLOT_HORIZONTAL)
                .setContent(elements)
                .build();
    }
}

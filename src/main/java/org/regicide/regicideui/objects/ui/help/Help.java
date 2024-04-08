package org.regicide.regicideui.objects.ui.help;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.universal.BackBtn;
import org.regicide.regicideui.objects.ui.universal.ExitBtn;
import org.regicide.regicideui.objects.ui.universal.InfoBtn;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.item.impl.AbstractItem;
import xyz.xenondevs.invui.window.Window;

public final class Help extends ContainerGUI {
    public Help(@NotNull Player viewer) {
        super(viewer);
    }

    public Help(@NotNull final Window prevWindow, @NotNull Player viewer) {
        super(prevWindow, viewer);
    }

    @Override
    public void setup() {

        AbstractItem exitBackBtn;
        if (this.hasPrevWindow())
            exitBackBtn = new BackBtn(this.prevWindow, this, 96);
        else exitBackBtn = new ExitBtn(this, 95);

        this.gui = Gui.normal()
                .setStructure(
                        "x . . . u . . . i",
                        ". 0 0 . . . 1 1 .",
                        ". 0 0 . . . 1 1 .",
                        ". 2 2 . . . 3 3 .",
                        ". 2 2 . . . 3 3 .",
                        ". . . . d . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .addIngredient('x', exitBackBtn)
                .addIngredient('i', new InfoBtn(this, "ui.element.wiki.button.info.lore", 97))
                .build();
    }
}

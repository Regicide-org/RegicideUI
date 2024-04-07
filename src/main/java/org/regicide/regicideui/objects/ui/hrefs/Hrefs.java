package org.regicide.regicideui.objects.ui.hrefs;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.universal.BackBtn;
import org.regicide.regicideui.objects.ui.universal.ExitBtn;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.item.impl.AbstractItem;
import xyz.xenondevs.invui.window.Window;

public class Hrefs extends ContainerGUI {

    public Hrefs(@NotNull Player viewer) {
        super(viewer);
    }

    public Hrefs(@NotNull final Window prevWindow, @NotNull Player viewer) {
        super(prevWindow, viewer);
    }

    @Override
    public void setup() {

        AbstractItem exitBackBtn;
        if (this.hasPrevWindow())
            exitBackBtn = new BackBtn(this.prevWindow, this);
        else exitBackBtn = new ExitBtn(this);

        this.gui = Gui.normal()
                .setStructure(
                        ". . . . . . . . .",
                        "x . . . . . . . i",
                        ". . # v # d # . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .addIngredient('x', exitBackBtn)
                .addIngredient('i', new InfoBtn(this))
                .addIngredient('v', new VkontakteBtn(this))
                .addIngredient('d', new DiscordBtn(this))
                .build();
    }
}

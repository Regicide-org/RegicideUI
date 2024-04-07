package org.regicide.regicideui.objects.ui.hrefs;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.window.Window;

public final class Hrefs extends ContainerGUI {

    public Hrefs(@NotNull Player viewer) {
        super(viewer);
    }

    public Hrefs(@NotNull final Window prevWindow, @NotNull Player viewer) {
        super(prevWindow, viewer);
    }

    @Override
    public void setup() {
        this.gui = Gui.normal()
                .setStructure(
                        ". . . . . . . . .",
                        "x . . . . . . . i",
                        ". . # v # d # . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .build();
    }
}

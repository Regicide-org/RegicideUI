package org.regicide.regicideui.objects.ui.help;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import xyz.xenondevs.invui.gui.Gui;
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
                .build();
    }
}

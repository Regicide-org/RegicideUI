package org.regicide.regicideui.objects.ui.profile.single;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.window.Window;

public final class Profile extends ContainerGUI {
    public Profile(@NotNull Player viewer) {
        super(viewer);
    }

    public Profile(@NotNull Window prevWindow, @NotNull Player viewer) {
        super(prevWindow, viewer);
    }

    @Override
    public void setup() {
        this.gui = Gui.normal()
                .setStructure(
                        ". . . . . . . . .",
                        "x . . . . . . . i",
                        ". H h o . . . . .",
                        ". h h . . t n b .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .build();
    }
}

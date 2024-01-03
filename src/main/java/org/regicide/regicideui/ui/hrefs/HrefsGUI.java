package org.regicide.regicideui.ui.hrefs;

import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.ui.RGUIContainer;
import org.regicide.regicideui.ui.hrefs.elements.DiscordBtn;
import org.regicide.regicideui.ui.hrefs.elements.InfoBtn;
import org.regicide.regicideui.ui.hrefs.elements.VkontakteBtn;
import org.regicide.regicideui.ui.universal.ExitBtn;
import xyz.xenondevs.invui.gui.Gui;

public final class HrefsGUI implements RGUIContainer {
    private final Gui gui;

    public HrefsGUI() {
            this.gui = Gui.normal()
                    .setStructure(
                            ". . . . . . . . .",
                            "x . . . . . . . i",
                            ". . # v # d # . .",
                            ". . . . . . . . .",
                            ". . . . . . . . .")
                    .addIngredient('x', new ExitBtn())
                    .addIngredient('i', new InfoBtn())
                    .addIngredient('v', new VkontakteBtn())
                    .addIngredient('d', new DiscordBtn())
                    .build();
    }
        @Override
        @NotNull
        public Gui getGui() {
        return gui;
    }
}

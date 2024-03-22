package org.regicide.regicideui.ui.hrefs;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.regicide.regicideui.ui.RGUIContainer;
import org.regicide.regicideui.ui.hrefs.elements.DiscordBtn;
import org.regicide.regicideui.ui.hrefs.elements.InfoBtn;
import org.regicide.regicideui.ui.hrefs.elements.VkontakteBtn;
import org.regicide.regicideui.ui.universal.BackBtn;
import org.regicide.regicideui.ui.universal.ExitBtn;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.window.Window;

public final class HrefsGUI implements RGUIContainer {
    private final Gui gui;
    private final Window prevWindow;

    public HrefsGUI(@Nullable final Window prevWindow) {
        this.prevWindow = prevWindow;
        if (prevWindow == null) {
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
        } else {
            this.gui = Gui.normal()
                    .setStructure(
                            ". . . . . . . . .",
                            "x . . . . . . . i",
                            ". . # v # d # . .",
                            ". . . . . . . . .",
                            ". . . . . . . . .")
                    .addIngredient('x', new BackBtn(prevWindow))
                    .addIngredient('i', new InfoBtn())
                    .addIngredient('v', new VkontakteBtn())
                    .addIngredient('d', new DiscordBtn())
                    .build();
        }
    }
        @Override
        @NotNull
        public Gui getGui() {
        return gui;
    }

    @Override
    public Window getPrevWindow() {
        return prevWindow;
    }
}

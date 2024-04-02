package org.regicide.regicideui.ui.hrefs;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.regicide.regicideui.ui.RGUIBackable;
import org.regicide.regicideui.ui.hrefs.elements.DiscordBtn;
import org.regicide.regicideui.ui.hrefs.elements.InfoBtn;
import org.regicide.regicideui.ui.hrefs.elements.VkontakteBtn;
import org.regicide.regicideui.ui.universal.BackBtn;
import org.regicide.regicideui.ui.universal.ExitBtn;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.window.Window;

public final class HrefsGUI extends RGUIBackable {
    private Gui gui;
    public HrefsGUI(@Nullable final Window prevWindow) {
        super(prevWindow);
    }

    @Override
    public void setupBackable() {
        this.gui = Gui.normal()
                .setStructure(
                        ". . . . . . . . .",
                        "x . . . . . . . i",
                        ". . # v # d # . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .addIngredient('x', new BackBtn(this.getPrevWindow()))
                .addIngredient('i', new InfoBtn())
                .addIngredient('v', new VkontakteBtn())
                .addIngredient('d', new DiscordBtn())
                .build();
    }

    @Override
    public void setupUnbackable() {
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

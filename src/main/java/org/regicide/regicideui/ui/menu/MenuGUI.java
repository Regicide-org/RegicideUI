package org.regicide.regicideui.ui.menu;

import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.ui.menu.elements.*;
import org.regicide.regicideui.ui.RGUIContainer;
import org.regicide.regicideui.ui.universal.ExitBtn;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.window.Window;

public final class MenuGUI implements RGUIContainer {

    private final Gui gui;

    public MenuGUI(@NotNull final Window prevWindow) {
        this.gui = Gui.normal()
                .setStructure(
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        "x . . . . . . . i",
                        ". . . . . . . . .",
                        "a . . p t n . . s",
                        ". . . e m d . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .addIngredient('x', new ExitBtn())
                .addIngredient('i', new InfoBtn())
                .addIngredient('a', new DynMapBtn())
                .addIngredient('s', new HrefsBtn())
                .addIngredient('p', new ProfileBtn())
                .addIngredient('t', new TownsBtn())
                .addIngredient('n', new NationsBtn())
                .addIngredient('e', new EncyclopediaBtn())
                .addIngredient('m', new MarketBtn())
                .addIngredient('d', new DonateBtn())
                .build();
    }

    public @NotNull Gui getGui() {
        return gui;
    }

    @Override
    public Window getPrevWindow() {
        return null;
    }
}

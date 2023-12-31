package org.regicide.regicideui.ui.Menu;

import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.ui.Menu.elements.*;
import org.regicide.regicideui.ui.RGUIContainer;
import org.regicide.regicideui.ui.universal.ExitBtn;
import xyz.xenondevs.invui.gui.Gui;

public final class MenuGUI implements RGUIContainer {

    private final Gui gui;

    public MenuGUI() {
        this.gui = Gui.normal() // Creates the GuiBuilder for a normal GUI
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
                .addIngredient('s', new DiscordBtn())
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
}

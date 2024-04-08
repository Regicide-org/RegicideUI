package org.regicide.regicideui.objects.ui.menu;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.objects.ui.ContainerGUI;
import org.regicide.regicideui.objects.ui.universal.ExitBtn;
import org.regicide.regicideui.objects.ui.universal.InfoBtn;
import xyz.xenondevs.invui.gui.Gui;

public class Menu extends ContainerGUI {
    public Menu(@NotNull Player viewer) {
        super(viewer);
    }

    @Override
    public void setup() {
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
                .addIngredient('x', new ExitBtn(this, 101))
                .addIngredient('i', new InfoBtn(this,"ui.element.menu.button.info.lore", 102))
                .addIngredient('a', new WebMapBtn(this))
                .addIngredient('s', new HrefsBtn(this))
                .addIngredient('p', new ProfileBtn(this))
                .addIngredient('t', new TownsBtn(this))
                .addIngredient('n', new NationsBtn(this))
                .addIngredient('e', new WikiBtn(this))
                .addIngredient('m', new MarketBtn(this))
                .addIngredient('d', new DonateBtn(this))
                .build();
    }
}
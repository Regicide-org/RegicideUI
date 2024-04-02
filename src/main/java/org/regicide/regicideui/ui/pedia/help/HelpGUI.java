package org.regicide.regicideui.ui.pedia.help;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.regicide.regicideui.ui.RGUIBackable;
import org.regicide.regicideui.ui.profile.elements.InfoBtn;
import org.regicide.regicideui.ui.universal.BackBtn;
import org.regicide.regicideui.ui.universal.ExitBtn;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.window.Window;

public final class HelpGUI extends RGUIBackable {

    private Gui gui;

    /**
     * @param prevWindow The previous {@link Window}.
     */
    public HelpGUI(@Nullable Window prevWindow) {
        super(prevWindow);
    }

    @Override
    public void setupBackable() {
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
                .addIngredient('x', new BackBtn(this.getPrevWindow()))
                .addIngredient('i', new InfoBtn())
                .addIngredient('0', new ItemStack(Material.FLINT_AND_STEEL))
                .addIngredient('1', new ItemStack(Material.EMERALD_BLOCK))
                .addIngredient('2', new ItemStack(Material.EMERALD_BLOCK))
                .addIngredient('3', new ItemStack(Material.EMERALD_BLOCK))
                .build();
    }

    @Override
    public void setupUnbackable() {
        this.gui = Gui.normal()
                .setStructure(
                        "x . . . u . . . i",
                        ". 0 0 . . . 1 1 .",
                        ". 0 0 . . . 1 1 .",
                        ". 1 1 . . . 0 0 .",
                        ". 1 1 . . . 0 0 .",
                        ". . . . d . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .addIngredient('x', new ExitBtn())
                .addIngredient('i', new InfoBtn())
                .addIngredient('0', new ItemStack(Material.FLINT_AND_STEEL))
                .addIngredient('0', new ItemStack(Material.EMERALD_BLOCK))
                .build();
    }

    @Override
    public @NotNull Gui getGui() {
        return this.gui;
    }
}

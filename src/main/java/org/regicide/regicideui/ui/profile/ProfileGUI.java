package org.regicide.regicideui.ui.profile;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.regicide.regicideui.ui.RGUIBackable;
import org.regicide.regicideui.ui.profile.elements.InfoBtn;
import org.regicide.regicideui.ui.universal.BackBtn;
import org.regicide.regicideui.ui.universal.ExitBtn;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.window.Window;

public final class ProfileGUI extends RGUIBackable {
    private Gui gui;
    private final CommandSender sender;
    private final Player targetPlayer;

    /**
     * @param prevWindow The previous {@link Window}.
     */
    public ProfileGUI(@Nullable Window prevWindow, @NotNull final CommandSender sender, @Nullable final Player targetPlayer) {
        super(prevWindow);

        this.sender = sender;
        this.targetPlayer = targetPlayer;
    }

    @Override
    public void setupBackable() {
        this.gui = Gui.normal()
                .setStructure(
                        ". . . . . . . . .",
                        "x . . . . . . . i",
                        ". 0 0 . . . . o .",
                        ". 0 0 . . t n b .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .addIngredient('x', new BackBtn(this.getPrevWindow()))
                .addIngredient('i', new InfoBtn())
                .addIngredient('0', new ItemStack(Material.FLINT_AND_STEEL))
                .build();
    }

    @Override
    public void setupUnbackable() {
        this.gui = Gui.normal()
                .setStructure(
                        ". . . . . . . . .",
                        "x . . . . . . . i",
                        ". 0 0 . . . . o .",
                        ". 0 0 . . t n b .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .",
                        ". . . . . . . . .")
                .addIngredient('x', new ExitBtn())
                .addIngredient('i', new InfoBtn())
                .addIngredient('0', new ItemStack(Material.FLINT_AND_STEEL))
                .build();
    }

    @Override
    public @NotNull Gui getGui() {
        return this.gui;
    }
}
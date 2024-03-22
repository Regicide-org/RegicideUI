package org.regicide.regicideui.ui;

import org.jetbrains.annotations.NotNull;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.window.Window;

public interface RGUIContainer {
    /**
     * @return The GUI of the menu.
     */
    @NotNull
    Gui getGui();

    Window getPrevWindow();
}

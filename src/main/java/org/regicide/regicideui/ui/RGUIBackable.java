package org.regicide.regicideui.ui;

import org.jetbrains.annotations.Nullable;
import xyz.xenondevs.invui.window.Window;

/**
 * The {@link RGUIContainer}, which can contain the previous {@link xyz.xenondevs.invui.gui.Gui}.
 */
public abstract class RGUIBackable implements RGUIContainer {
    private final Window prevWindow;

    /**
     * @param prevWindow The previous {@link Window}.
     */
    public RGUIBackable(@Nullable final Window prevWindow) {
        this.prevWindow = prevWindow;

        if (prevWindow != null)
            setupBackable();
        else setupUnbackable();
    }

    /**
     * @return The previous {@link Window} or null if there is no previous window.
     */
    public Window getPrevWindow() {
        return this.prevWindow;
    }

    /**
     * Installation logic GUI containing the previous menu.
     */
    public abstract void setupBackable();

    /**
     * Installation logic GUI that does not contain a return menu.
     */
    public abstract void setupUnbackable();
}

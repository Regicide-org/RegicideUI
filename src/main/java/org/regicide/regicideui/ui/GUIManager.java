package org.regicide.regicideui.ui;

import org.jetbrains.annotations.NotNull;
import org.regicide.regicideui.ui.Menu.MenuGUI;
import xyz.xenondevs.invui.gui.Gui;

import java.util.HashMap;
import java.util.Map;

public final class GUIManager {

    private static final Map<String, RGUIContainer> GUI_MAP = new HashMap<>();

    /**
     * Loads all plugin's GUI.
     */
    public static void load() {
        GUI_MAP.put("menu", new MenuGUI());
    }

    /**
     *
     * @param name The name of the GUI.
     * @return the GUI by name.
     */
    public static Gui getGui(@NotNull final String name) {
        return GUI_MAP.get(name).getGui();
    }
}

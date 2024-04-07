package org.regicide.regicideui.objects.ui;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.window.Window;

import java.util.Arrays;

/**
 * Container for GUI.
 */
public abstract class ContainerGUI {
    protected Window prevWindow;
    protected Gui gui;
    protected final Player viewer;
    protected final Object[] arguments;

    public ContainerGUI(@NotNull final Player viewer) {
        this.prevWindow = null;
        this.viewer = viewer;

        this.arguments = null;
        setup();
    }

    public ContainerGUI(@NotNull final Player viewer, @NotNull Object... arguments) {
        this.prevWindow = null;
        this.viewer = viewer;

        this.arguments = Arrays.stream(arguments).toArray();
        setup();
    }

    public ContainerGUI(@NotNull final Window prevWindow, @NotNull final Player viewer) {
        this.prevWindow = prevWindow;
        this.viewer = viewer;

        this.arguments = null;
        setup();
    }

    public ContainerGUI(@NotNull final Window prevWindow, @NotNull final Player viewer, @NotNull Object... arguments) {
        this.prevWindow = prevWindow;
        this.viewer = viewer;

        this.arguments = Arrays.stream(arguments).toArray();
        setup();
    }

    /**
     * Setup of the GUI.
     */
    public abstract void setup();

    /**
     * @return The GUI.
     */
    @NotNull
    public Gui getGui() {
        return gui;
    }

    /**
     * @return The viewer of the GUI.
     */
    @NotNull
    public Player getViewer() {
        return viewer;
    }

    /**
     * @return The arguments of the ContainerGUI or null if there are no arguments.
     */
    @Nullable
    public Object[] getArguments() {
        return arguments;
    }

    /**
     * @param n The number of the argument.
     * @return The argument.
     */
    @Nullable
    public Object getArguments(int n) {
        if (n > arguments.length || n < 0)
            return null;
        else return arguments[n];
    }

    /**
     * @return The previous window or null if there are no previous window.
     */
    public Window getPrevWindow() {
        return this.prevWindow;
    }

    /**
     * @return True if this GUI has previous Window or false if not.
     */
    public boolean hasPrevWindow() {
        return this.prevWindow != null;
    }
}

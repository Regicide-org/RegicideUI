package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.ui.pedia.help.HelpGUI;
import xyz.xenondevs.invui.window.Window;
import xyz.xenondevs.invui.window.WindowManager;

public final class HelpCMD {

    public static void register() {
        new CommandAPICommand("help")
                .withPermission("regicideui.command.help")
                .withAliases("encyclopedia", "wiki")

                .executesPlayer((pExecutor, args) -> {
                    Window window = Window.merged()
                            .setViewer(pExecutor)
                            .setGui(new HelpGUI(WindowManager.getInstance().getOpenWindow(pExecutor)).getGui())
                            .setTitle(RegicideUI.l().c().getString("help-title"))
                            .build();
                    window.open();
                })
                .executesConsole(sender -> {
                    RegicideUI.instance().getLogger().info("Not implemented for a console!");
                })
                .register();
    }
}

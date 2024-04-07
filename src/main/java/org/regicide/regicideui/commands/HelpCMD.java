package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.objects.ui.help.Help;
import xyz.xenondevs.invui.window.Window;

public final class HelpCMD {

    public static void register() {
        new CommandAPICommand("help")
                .withPermission("regicideui.command.help")
                .withAliases("encyclopedia", "wiki")

                .executesPlayer((pExecutor, args) -> {
                    Window window = Window.merged()
                            .setViewer(pExecutor)
                            .setGui(new Help(pExecutor).getGui())
                            .setTitle(Localization.get("ui.element.wiki.title", pExecutor.locale().toString()))
                            .build();
                    window.open();
                })
                .register();
    }
}

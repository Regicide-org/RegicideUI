package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.Argument;
import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.StringArgument;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.OfflinePlayer;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.PlayerNameStorage;
import org.regicide.regicideui.objects.ui.profile.Profile;
import xyz.xenondevs.invui.window.Window;

import java.util.ArrayList;
import java.util.List;

public final class ProfileCMD {

    public static void register() {

        List<Argument<?>> targetArgument = new ArrayList<>();
        targetArgument.add(new StringArgument("target").includeSuggestions(ArgumentSuggestions.strings(
                PlayerNameStorage.get()
        )));

        new CommandAPICommand("profile")
                .withOptionalArguments(targetArgument)
                .withPermission("regicideui.command.profile")
                .executesPlayer((pExecutor, args) -> {

                    String target = (String) args.get("target");

                    // Other profile
                    if (target != null) {
                        OfflinePlayer pTarget = RegicideUI.instance().getServer().getOfflinePlayerIfCached(target);

                        if (!(pExecutor.hasPermission("regicideui.command.profile.other"))) {

                            String msgText = Localization.get("message.error.don't_have_permission.to_perform_command", pExecutor.locale().toString());
                            Component msg = MiniMessage.miniMessage().deserialize("<i:false><white>"+msgText+"</white></i>");
                            pExecutor.sendMessage(msg);
                            return;
                        }

                        if (pTarget == null) {
                            String msgText = Localization.get("message.error.player_never_logged_on_this_server", pExecutor.locale().toString());
                            Component msg = MiniMessage.miniMessage().deserialize("<i:false><white>"+msgText+"</white></i>");
                            pExecutor.sendMessage(msg);

                            return;
                        }

                        Window window = Window.merged()
                                .setViewer(pExecutor)
                                .setTitle(Localization.get("ui.element.profile.title", pExecutor.locale().toString()))
                                .setGui(new Profile(pExecutor).getGui())
                                .build();
                        window.open();

                    } else {

                        Window window = Window.merged()
                                .setViewer(pExecutor)
                                .setTitle(Localization.get("ui.element.profile.title", pExecutor.locale().toString()))
                                .setGui(new Profile(pExecutor).getGui())
                                .build();
                        window.open();
                    }
                })
                .executesConsole((sender, args) -> {
                    String target = (String) args.get("target");
                    if (target == null)
                        RegicideUI.instance().getLogger().info("The console has no profile!");
                    else
                        // TODO
                    {
                        OfflinePlayer pTarget = RegicideUI.instance().getServer().getOfflinePlayerIfCached(target);

                        if (pTarget == null) {
                            sender.sendMessage("This player has never logged on the server!");
                            return;
                        }

                        RegicideUI.instance().getLogger().info("Вывод данных об игроке " + target);
                    }
                })
                .register();
    }
}
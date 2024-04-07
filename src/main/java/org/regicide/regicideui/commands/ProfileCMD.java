package org.regicide.regicideui.commands;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.StringArgument;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.OfflinePlayer;
import org.regicide.regicideui.Localization;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.objects.ui.profile.Profile;
import xyz.xenondevs.invui.window.Window;

public final class ProfileCMD {

    public static void register() {

        // TODO Вывод онлайн-игроков
        new CommandAPICommand("profile")
                .withOptionalArguments(new StringArgument("name"))
                .withPermission("regicideui.command.profile")
                .executesPlayer((pExecutor, args) -> {

                    String name = (String) args.get("name");

                    // Other profile
                    if (name != null) {
                        OfflinePlayer pTarget = RegicideUI.instance().getServer().getOfflinePlayerIfCached(name);

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
                    String name = (String) args.get("name");
                    if (name == null)
                        RegicideUI.instance().getLogger().info("The console has no profile!");
                    else
                        // TODO
                    {
                        OfflinePlayer pTarget = RegicideUI.instance().getServer().getOfflinePlayerIfCached(name);

                        if (pTarget == null) {
                            sender.sendMessage("This player has never logged on the server!");
                            return;
                        }

                        RegicideUI.instance().getLogger().info("Вывод данных об игроке " + name);
                    }
                })
                .register();
    }
}
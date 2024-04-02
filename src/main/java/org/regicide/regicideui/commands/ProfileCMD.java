package org.regicide.regicideui.commands;


import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.StringArgument;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.OfflinePlayer;
import org.regicide.regicideui.RegicideUI;
import org.regicide.regicideui.ui.profile.ProfileGUI;
import xyz.xenondevs.invui.window.Window;

public final class ProfileCMD {

    @SuppressWarnings("ConstantConditions")
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

                        if (pTarget == null) {
                            String msgText = RegicideUI.l().c().getString("message-player-never-logged-error");
                            Component msg = MiniMessage.miniMessage().deserialize("<i:false><white>"+msgText+"</white></i>");
                            pExecutor.sendMessage(msg);

                            return;
                        }

                        Window window = Window.merged()
                                .setViewer(pExecutor)
                                .setTitle(RegicideUI.l().c().getString("profile-title"))
                                .setGui(new ProfileGUI(null, pExecutor, pExecutor).getGui())
                                .build();
                        window.open();

                        // Self profile
                    } else {

                        if (!(pExecutor.hasPermission("regicideui.command.profile.other"))) {

                            String msgText = RegicideUI.l().c().getString("message-don't-have-permission-to-perform-command");
                            Component msg = MiniMessage.miniMessage().deserialize("<i:false><white>"+msgText+"</white></i>");
                            pExecutor.sendMessage(msg);
                            return;
                        }

                        Window window = Window.merged()
                                .setViewer(pExecutor)
                                .setTitle(RegicideUI.l().c().getString("profile-title"))
                                .setGui(new ProfileGUI(null, pExecutor, pExecutor).getGui())
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
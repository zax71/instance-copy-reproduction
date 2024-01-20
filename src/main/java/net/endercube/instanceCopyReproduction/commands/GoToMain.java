package net.endercube.instanceCopyReproduction.commands;

import net.endercube.instanceCopyReproduction.MainInstance;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.builder.Command;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.InstanceContainer;
import org.jetbrains.annotations.NotNull;

public class GoToMain extends Command {
    public GoToMain() {
        super("gotomain");

        setDefaultExecutor(((sender, context) -> {
            Player player = (Player) sender;

            player.setInstance(MainInstance.INSTANCE, new Pos(0, 100, 0));
            player.sendMessage("You are now in the main instance");
        }));
    }
}

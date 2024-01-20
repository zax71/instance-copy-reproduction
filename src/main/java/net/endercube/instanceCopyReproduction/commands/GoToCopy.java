package net.endercube.instanceCopyReproduction.commands;

import net.endercube.instanceCopyReproduction.MainInstance;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.builder.Command;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.InstanceContainer;

public class GoToCopy extends Command {
    public GoToCopy() {
        super("gotocopy");

        setDefaultExecutor(((sender, context) -> {
            Player player = (Player) sender;

            InstanceContainer copyInstance = MainInstance.POLAR_INSTANCE.copy();
            MinecraftServer.getInstanceManager().registerInstance(copyInstance);

            player.setInstance(copyInstance, new Pos(0, 100, 0));
            player.sendMessage("You are now in the copy");
        }));
    }
}

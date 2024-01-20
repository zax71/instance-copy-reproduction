package net.endercube.instanceCopyReproduction.commands;

import net.endercube.instanceCopyReproduction.Instances;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.builder.Command;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.tag.Tag;

public class GoToCopy extends Command {
    public GoToCopy() {
        super("gotocopy");

        setDefaultExecutor(((sender, context) -> {
            Player player = (Player) sender;

            player.setInstance(Instances.POLAR_INSTANCE);

            InstanceContainer instance = Instances.ACTIVE_INSTANCE.stream()
                    .filter((map) -> map.getTag(Tag.String("name")).equals("aMapName"))
                    .findFirst()
                    .orElse(null);

            InstanceContainer copyInstance = instance.copy();

            MinecraftServer.getInstanceManager().registerInstance(copyInstance);

            player.setInstance(copyInstance, new Pos(0, 100, 0));
            player.sendMessage("You are now in the copy");
        }));
    }
}

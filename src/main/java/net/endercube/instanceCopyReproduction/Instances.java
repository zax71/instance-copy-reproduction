package net.endercube.instanceCopyReproduction;

import net.endercube.instanceCopyReproduction.dimensions.FullbrightDimension;
import net.hollowcube.polar.PolarLoader;
import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.AnvilLoader;
import net.minestom.server.instance.InstanceContainer;
import net.minestom.server.tag.Tag;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Instances {

    public static ArrayList<InstanceContainer> ACTIVE_INSTANCE = new ArrayList<>();
    public static InstanceContainer POLAR_INSTANCE;


    static {

        InstanceContainer anvilInstanceContainer = MinecraftServer.getInstanceManager().createInstanceContainer(
                FullbrightDimension.INSTANCE,
                new AnvilLoader(Path.of("./instances/world"))
        );

        InstanceContainer polarInstanceContainer;
        try {
            // Create the polar instance
            polarInstanceContainer = MinecraftServer.getInstanceManager().createInstanceContainer();
            polarInstanceContainer.setChunkLoader(new PolarLoader(Path.of("./instances/polarWorld.polar")));
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }

        anvilInstanceContainer.setTag(Tag.String("name"), "aMapName");

        POLAR_INSTANCE = polarInstanceContainer;
        ACTIVE_INSTANCE.add(anvilInstanceContainer);
    }
}

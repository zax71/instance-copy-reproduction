package net.endercube.instanceCopyReproduction;

import net.hollowcube.polar.PolarLoader;
import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.AnvilLoader;
import net.minestom.server.instance.InstanceContainer;

import java.io.IOException;
import java.nio.file.Path;

public class MainInstance {
    public static InstanceContainer ANVIL_INSTANCE;
    public static InstanceContainer POLAR_INSTANCE;

    public static InstanceContainer ACTIVE_INSTANCE;

    static {
        // Create the anvil instance
        InstanceContainer anvilInstanceContainer = MinecraftServer.getInstanceManager().createInstanceContainer();
        anvilInstanceContainer.setChunkLoader(new AnvilLoader(Path.of("./instances/world")));
        ANVIL_INSTANCE = anvilInstanceContainer;

        try {
            // Create the polar instance
            InstanceContainer polarInstanceContainer = MinecraftServer.getInstanceManager().createInstanceContainer();
            polarInstanceContainer.setChunkLoader(new PolarLoader(Path.of("./instances/polarWorld.polar")));
            POLAR_INSTANCE = polarInstanceContainer;
        }
         catch (IOException e) {
            throw new RuntimeException(e);
        }

        ACTIVE_INSTANCE = POLAR_INSTANCE;
    }
}

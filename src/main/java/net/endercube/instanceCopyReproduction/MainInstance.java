package net.endercube.instanceCopyReproduction;

import net.minestom.server.MinecraftServer;
import net.minestom.server.instance.AnvilLoader;
import net.minestom.server.instance.InstanceContainer;

import java.nio.file.Path;

public class MainInstance {
    public static InstanceContainer INSTANCE;

    static {
        // Create the instance
        InstanceContainer instanceContainer = MinecraftServer.getInstanceManager().createInstanceContainer();
        instanceContainer.setChunkLoader(new AnvilLoader(Path.of("./world")));
        INSTANCE = instanceContainer;
    }
}

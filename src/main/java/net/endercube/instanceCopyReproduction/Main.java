package net.endercube.instanceCopyReproduction;

import net.endercube.instanceCopyReproduction.commands.GoToCopy;
import net.endercube.instanceCopyReproduction.commands.GoToMain;
import net.minestom.server.MinecraftServer;
import net.minestom.server.command.CommandManager;
import net.minestom.server.coordinate.Pos;
import net.minestom.server.entity.Player;
import net.minestom.server.event.GlobalEventHandler;
import net.minestom.server.event.player.AsyncPlayerConfigurationEvent;
import net.minestom.server.extras.MojangAuth;

public class Main {
    public static void main(String[] args) {
        // Initialization
        MinecraftServer minecraftServer = MinecraftServer.init();
        CommandManager commandManager = MinecraftServer.getCommandManager();

        // Add an event callback to specify the spawning instance (and the spawn position)
        GlobalEventHandler globalEventHandler = MinecraftServer.getGlobalEventHandler();
        globalEventHandler.addListener(AsyncPlayerConfigurationEvent.class, event -> {
            final Player player = event.getPlayer();
            event.setSpawningInstance(MainInstance.ACTIVE_INSTANCE);
            player.setRespawnPoint(new Pos(0, 100, 0));
        });

        MojangAuth.init();
        // Start the server on port 25565
        minecraftServer.start("0.0.0.0", 25565);

        // Register commands
        commandManager.register(new GoToCopy());
        commandManager.register(new GoToMain());
    }
}
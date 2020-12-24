package com.pepe.pprtp.peperandomteleport;

import com.pepe.pprtp.peperandomteleport.commands.rtpCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class PepeRandomTeleport extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[PEPE] PPRTP Enabled");
        getCommand("rtp").setExecutor(new rtpCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

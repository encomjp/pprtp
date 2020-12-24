package com.pepe.pprtp.peperandomteleport.commands;

import com.pepe.pprtp.peperandomteleport.PepeRandomTeleport;
import com.pepe.pprtp.peperandomteleport.events.timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.concurrent.ThreadLocalRandom;

public class rtpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            Boolean cooldown = player.hasPotionEffect(PotionEffectType.SLOW_FALLING);
            if (cooldown == true) {
                player.sendMessage(ChatColor.DARK_RED + "Teleport Cooldown, please try again in few seconds");
            } else{
                if (player.hasPermission("pprtp.rtp"))
                {
                    Location playerLoc = player.getLocation();
                    Location PlayerSpawnLoc = playerLoc.getWorld().getSpawnLocation();
                    int playerSpawnLocX = (int) PlayerSpawnLoc.getX();
                    int playerSpawnLocY = (int) PlayerSpawnLoc.getZ();
                    int randomNumX = ThreadLocalRandom.current().nextInt(playerSpawnLocX, playerSpawnLocX + 20000);
                    int randomNumZ = ThreadLocalRandom.current().nextInt(playerSpawnLocY, playerSpawnLocY + 20000);
                    player.teleport(player.getLocation().add(randomNumX, 75, randomNumZ));
                    player.setVelocity(player.getVelocity().setY((-.5)));
                    player.sendMessage(ChatColor.AQUA + "Parachuting System Enabled");
                    player.addPotionEffect(PotionEffectType.SLOW_FALLING.createEffect(900, 10));
                }
                    if (player.hasPotionEffect(PotionEffectType.SLOW_FALLING) == false)
                    {
                        player.sendMessage("Parachuting System Disabled!");
                    }
                }
        }


        return false;
    }
}

package me.Louis.TeleFood.listener;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Listeners implements Listener {
	
	@EventHandler
	public void teleportPlayer(PlayerItemConsumeEvent event) {
		Random rand =  new Random();
		double limit = 70.0;
		
		boolean validTp = false;
		Player p = event.getPlayer();
		Location currentLoc = p.getLocation();
		World w = p.getWorld();
		
		double xaxis = currentLoc.getX();
		double yaxis = currentLoc.getY();
		double zaxis = currentLoc.getZ();
		
		
		
		while (validTp != true){
			
			double double_random = rand.nextDouble(limit);
			Location newLoc = new Location(w, (xaxis + double_random), (yaxis + double_random), (zaxis + double_random));
			Block newBlock = newLoc.getBlock();
			Material newBlockMat = newBlock.getType();
						
			if (newBlockMat.isAir()) {
					Location cloneLoc = newLoc.clone();
					cloneLoc.subtract(0, 1, 0);
			        if (cloneLoc.getBlock().getType().isSolid()) {
			        	validTp = true;
						p.teleport(newLoc);
						p.sendMessage("You have been telported");
			        }
			}
		}
		validTp = false;
	}
	
	@EventHandler
	public void mobSpawn(PlayerTeleportEvent event) {
		EntityType[] hostileMobs = {EntityType.BLAZE,EntityType.CAVE_SPIDER,EntityType.CREEPER,EntityType.ELDER_GUARDIAN,EntityType.ENDER_DRAGON,EntityType.ENDERMAN,EntityType.EVOKER,EntityType.GHAST,EntityType.GUARDIAN,EntityType.HUSK,EntityType.ILLUSIONER,EntityType.MAGMA_CUBE,EntityType.SHULKER,EntityType.SILVERFISH,EntityType.SKELETON,EntityType.SLIME,EntityType.SPIDER,EntityType.VEX,EntityType.VINDICATOR,EntityType.WITCH,EntityType.WITHER,EntityType.WITHER_SKELETON,EntityType.ZOMBIE};
		Player p = event.getPlayer();
		Location currentLoc = p.getLocation();
		World w = p.getWorld();
		Random rand = new Random();
        int randomMobNo = rand.nextInt(22);
        try
        {
            Thread.sleep(100);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        w.spawnEntity(currentLoc, hostileMobs[randomMobNo]);
        p.sendMessage("Spawned a random mob");
				
	}
	

}

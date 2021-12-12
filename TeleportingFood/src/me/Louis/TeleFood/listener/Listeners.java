package me.Louis.TeleFood.listener;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class Listeners implements Listener {
	
	@EventHandler
	public void teleportPlayer(PlayerItemConsumeEvent event) {
		Random rand =  new Random();
		double limit = 50.0;
		
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
			        }
			}
		}
		
		
		validTp = false;
	}

}

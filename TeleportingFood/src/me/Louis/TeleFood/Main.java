package me.Louis.TeleFood;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.Louis.TeleFood.listener.Listeners;

public class Main extends JavaPlugin {
	private static Main instance;
	
	public static Main getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(new Listeners(), (Plugin) this);
	}
	
	public void onDisable() {
		instance = null;
	}
}

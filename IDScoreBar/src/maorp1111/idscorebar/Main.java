package maorp1111.idscorebar;

import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import maorp1111.idscorebar.commands.Commands;


public class Main extends JavaPlugin{
	
	public static List<String> onList;
	
	@Override
	public void onEnable() {
		getCommand("id").setExecutor(new Commands());
		getLogger().info("<IDScoreBar> have been enabled.");
		PluginManager pm = getServer().getPluginManager();
		Listener listener = new maorp1111.idscorebar.listeners.Listener(this);
		onList = getConfigPlayers();
		pm.registerEvents(listener, this);
	}
	
	
	public List<String> getConfigPlayers() {
		return this.getConfig().getStringList("on_list");
	}
	
	
	@Override
	public void onDisable() {
		this.getConfig().set("on_list", onList);
		saveConfig();
	}

}

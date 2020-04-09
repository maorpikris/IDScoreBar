package maorp1111.idscorebar;

import java.util.HashMap;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import maorp1111.idscorebar.commands.Commands;
import maorp1111.idscorebar.listeners.SBListener;
import maorp1111.idscorebar.utils.SBScoreBoard;


public class Main extends JavaPlugin{
	
	public static HashMap<String, SBScoreBoard> onList;
	public static ScoreboardManager sbm;
	
	@Override
	public void onEnable() {
		getCommand("id").setExecutor(new Commands());
		getLogger().info("<IDScoreBar> have been enabled.");
		PluginManager pm = getServer().getPluginManager();
		Listener listener = new SBListener();
		sbm = Bukkit.getScoreboardManager();
		pm.registerEvents(listener, this);
		onList = getConfigPlayers();
	}
	
	
	public HashMap<String, SBScoreBoard> getConfigPlayers() {
		HashMap<String, SBScoreBoard> onListBuild = new HashMap<String, SBScoreBoard>();
		for(String uuid : this.getConfig().getStringList("on_list")) {
			onListBuild.put(uuid, new SBScoreBoard());
		}
		return onListBuild;
	}
	
	
	@Override
	public void onDisable() {
		this.getConfig().set("on_list", onList.keySet());
		saveConfig();
	}

}

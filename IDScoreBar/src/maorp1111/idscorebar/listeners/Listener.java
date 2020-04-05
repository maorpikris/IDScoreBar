package maorp1111.idscorebar.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import maorp1111.idscorebar.Main;
import maorp1111.idscorebar.utils.Utils;
import net.md_5.bungee.api.ChatColor;


public class Listener implements org.bukkit.event.Listener {
	
	static ScoreboardManager sbm; 
	static Scoreboard sb;
	static Objective o;
	Score itemId;
	String lastScoreName;
	
	public Listener(Main p) {
	}
	
	@EventHandler
	public void onPlayerJoined(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		
		if(Utils.isOnList(p, Main.onList)) {
			setupScoreboard();
		}
		
	}
	
	public static void setupScoreboard() {
		sbm = Bukkit.getScoreboardManager();
		sb = sbm.getNewScoreboard();
		o = sb.registerNewObjective("color", "dummy");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§aID HELPER");
	}
	
	public static void removeScoreBoard(Player p) {
		p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onItemHeldChange(PlayerItemHeldEvent event){
		
        Player player = event.getPlayer(); 
        if(Utils.isOnList(player, Main.onList)) {
        	if(player.getInventory().getItem(event.getNewSlot()) == null) {
            	if(lastScoreName!= null) {
                	sb.resetScores(lastScoreName);
                }
                itemId = o.getScore("0");
                itemId.setScore(1);
                lastScoreName = "0";
                player.setScoreboard(sb);
            	return;
            }
            ItemStack stack = player.getInventory().getItem(event.getNewSlot());
            String data = stack.getData().toString();
    		String id = stack.getTypeId() + ":" + data.substring(data.indexOf("(") + 1, data.indexOf(")"));
            if(lastScoreName!= null) {
            	sb.resetScores(lastScoreName);
            }
            
            itemId = o.getScore(id);
            itemId.setScore(1);
            lastScoreName = id;
            player.setScoreboard(sb);
		}
        
    }

}

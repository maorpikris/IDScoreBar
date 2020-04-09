package maorp1111.idscorebar.listeners;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.ScoreboardManager;

import maorp1111.idscorebar.Main;
import maorp1111.idscorebar.utils.Utils;
import org.bukkit.event.Listener;


public class SBListener implements Listener {
	
	static ScoreboardManager sbm; 
	
	
	public SBListener() {
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onItemHeldChange(PlayerItemHeldEvent event){
		
        Player player = event.getPlayer(); 
        if(Utils.isOnList(player, Main.onList.keySet())) {
        	if(player.getInventory().getItem(event.getNewSlot()) == null) {
            	Main.onList.get(player.getUniqueId().toString()).updateO("0", player);
            	return;
            }
            ItemStack stack = player.getInventory().getItem(event.getNewSlot());
            String data = stack.getData().toString();
    		String id = stack.getTypeId() + ":" + data.substring(data.indexOf("(") + 1, data.indexOf(")"));
    		Main.onList.get(player.getUniqueId().toString()).updateO(id, player);
		}
        
    }

}

package maorp1111.idscorebar.utils;

import java.util.Set;

import org.bukkit.entity.Player;

public class Utils {
	
	public static boolean isOnList(Player p, Set<String> s) {
		return s.contains(p.getUniqueId().toString());
	}


}

package maorp1111.idscorebar.utils;

import java.util.List;

import org.bukkit.entity.Player;

public class Utils {
	
	public static boolean isOnList(Player p, List<String> l) {
		return l.contains(p.getUniqueId().toString());
	}

}

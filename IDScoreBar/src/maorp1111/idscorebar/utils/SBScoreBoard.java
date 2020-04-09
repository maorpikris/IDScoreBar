package maorp1111.idscorebar.utils;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import maorp1111.idscorebar.Main;

public class SBScoreBoard {
	private Scoreboard sb;
	private Objective o;
	private Score itemId;
	private String lastScoreName;
	
	public SBScoreBoard() {
		sb = Main.sbm.getNewScoreboard();
		o = sb.registerNewObjective("color", "dummy");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§aTheIDGuy");
	}
	
	public void updateO(String id, Player p) {
		if(id.equalsIgnoreCase("0")) {
			if(lastScoreName!= null) {
	        	sb.resetScores(lastScoreName);
	        }
			itemId = o.getScore(id);
	        itemId.setScore(1);
	        lastScoreName = id;
	        p.setScoreboard(sb);
	        return;
		}
		if(lastScoreName!= null) {
        	sb.resetScores(lastScoreName);
        }
		if(id.matches("(.*):0")) {
        	id = id.split(":")[0];
        }
        itemId = o.getScore(id);
        itemId.setScore(1);
        lastScoreName = id;
        p.setScoreboard(sb);
	}

	public Scoreboard getSb() {
		return sb;
	}

	public void setSb(Scoreboard sb, Player p) {
		this.sb = sb;
	}

	public Objective getO() {
		return o;
	}

	public void setO(Objective o) {
		this.o = o;
	}

	public Score getItemId() {
		return itemId;
	}

	public void setItemId(Score itemId) {
		this.itemId = itemId;
	}

	public String getLastScoreName() {
		return lastScoreName;
	}

	public void setLastScoreName(String lastScoreName) {
		this.lastScoreName = lastScoreName;
	}
	
	

}

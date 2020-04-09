package maorp1111.idscorebar.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import maorp1111.idscorebar.Main;
import maorp1111.idscorebar.utils.SBScoreBoard;
import maorp1111.idscorebar.utils.Utils;


public class Commands implements CommandExecutor{
	
	public String cmdTurnOnOff = "id";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase(cmdTurnOnOff)) {
				if(Utils.isOnList(p, Main.onList.keySet())) {
					Main.onList.remove(p.getUniqueId().toString());
					p.sendMessage("[TheIDGuy] §cOFF");
					p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
					return true;
				} else {
					Main.onList.put(p.getUniqueId().toString(), new SBScoreBoard());
					p.sendMessage("[TheIDGuy] §aON");
					return true;
				}
			}
			return false;
			
		} else {
			sender.sendMessage("Only players can execute this command.");
		}
		return false;
	}
	

}
 
package maorp1111.idscorebar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import maorp1111.idscorebar.Main;
import maorp1111.idscorebar.utils.Utils;
import net.minecraft.server.v1_12_R1.CommandExecute;

public class Commands implements CommandExecutor{
	
	public String cmdTurnOnOff = "id";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase(cmdTurnOnOff)) {
				if(Utils.isOnList(p, Main.onList)) {
					Main.onList.remove(p.getUniqueId().toString());
					p.sendMessage("[IDScoreBar] §cOFF");
					maorp1111.idscorebar.listeners.Listener.removeScoreBoard(p);
					return true;
				} else {
					Main.onList.add(p.getUniqueId().toString());
					p.sendMessage("[IDScoreBar] §aON");
					maorp1111.idscorebar.listeners.Listener.setupScoreboard();
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
 
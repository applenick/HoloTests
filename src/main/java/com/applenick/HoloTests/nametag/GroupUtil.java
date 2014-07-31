package com.applenick.HoloTests.nametag;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.applenick.HoloTests.HoloTest;

public class GroupUtil {
	
	public static void setupNameGroup(String teamName, String prefix) {
		ScoreboardManager manage = HoloTest.get().getServer().getScoreboardManager();
		Scoreboard groupTeam = manage.getNewScoreboard();
		setupGroup(groupTeam , teamName , prefix);
	}
	
	private static Team setupGroup(Scoreboard scoreboard, String teamName, String teamPrefix) {
		Team team = scoreboard.registerNewTeam(teamName);
		team.setPrefix(teamPrefix.toString());
		team.setSuffix(ChatColor.RESET.toString());
		return team;
	}
	
	public static void addToTeam(Player p){
	Team t = HoloTest.get().getServer().getScoreboardManager().getMainScoreboard().getTeam(HoloTest._appleGroup);
	t.addPlayer(p);
	}
	

}

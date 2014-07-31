package com.applenick.HoloTests.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.applenick.HoloTests.HoloTest;

public class GroupUtil {
	
	public static void setupNameGroup(String teamName, String prefix) {
		setupGroup(ScoreboardUtil.getScoreBoard() , teamName , prefix);
	}
	
	private static Team setupGroup(Scoreboard scoreboard, String teamName, String teamPrefix) {
		Team team = scoreboard.registerNewTeam(teamName);
		team.setPrefix(teamPrefix.toString());
		team.setSuffix(ChatColor.RESET.toString());
		return team;
	}
	
	public static void addToTeam(Player p){
		
		Team t = ScoreboardUtil.getScoreBoard().getTeam(HoloTest._appleGroup);
		
		t.addPlayer(p);
		
		t.setDisplayName("TEST");
	}
	

}

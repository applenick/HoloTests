package com.applenick.HoloTests.utils;

import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.applenick.HoloTests.HoloTest;

public class ScoreboardUtil {
	
	public static ScoreboardManager manager;
	public static Scoreboard mainBoard;
	
	public static void setupScoreboards(){
		manager = HoloTest.get().getServer().getScoreboardManager();
		mainBoard = manager.getNewScoreboard();
	}
		
	public static ScoreboardManager getManager(){
		return manager;
	}
	
	public static Scoreboard getScoreBoard(){
		return mainBoard;
	}

}

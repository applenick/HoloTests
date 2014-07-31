package com.applenick.HoloTests;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.applenick.HoloTests.utils.GroupUtil;
import com.applenick.HoloTests.utils.ScoreboardUtil;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();
		p.setScoreboard(ScoreboardUtil.getScoreBoard());
		GroupUtil.addToTeam(event.getPlayer());
	}

}

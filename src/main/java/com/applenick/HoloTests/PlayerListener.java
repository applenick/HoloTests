package com.applenick.HoloTests;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.applenick.HoloTests.nametag.GroupUtil;

public class PlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		GroupUtil.addToTeam(event.getPlayer());
	}

}

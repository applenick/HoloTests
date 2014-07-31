package com.applenick.HoloTests;

import org.bukkit.configuration.Configuration;

public class Config {
	
	public static Configuration getConfig(){
		return HoloTest.get().getConfig();
	}
	
	public static class Format{
		public static String getGroupName(){
			return getConfig().getString("group.name");
		}
	}
 
}

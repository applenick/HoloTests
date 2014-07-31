package com.applenick.HoloTests.utils;

import com.applenick.HoloTests.HoloTest;

public class Alog {
	
	public static void console(String msg){
		HoloTest.get().getServer().getConsoleSender().sendMessage(msg);
	}

}

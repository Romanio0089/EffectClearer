package com.romanio0089.effectclearer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyFirstListener implements Listener {

	public MyFirstListener(Main plugin) {
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		player.sendMessage("");
	
	}
	
}

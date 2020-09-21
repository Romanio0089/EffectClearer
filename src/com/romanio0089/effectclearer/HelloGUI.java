package com.kraken.helloworld2;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class HelloGUI {

	public static ItemSmith smithy = new ItemSmith();
	public static Inventory helloGUI = Bukkit.createInventory(null, 27, "Hello GUI");
	
	public HelloGUI() {
		
	}
	
	public static boolean openGUI(Player player) {
		
		ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1);
		
		helloGUI.setItem(0, filler);
		helloGUI.setItem(1, filler);
		helloGUI.setItem(2, filler);
		helloGUI.setItem(3, filler);
		helloGUI.setItem(4, filler);
		helloGUI.setItem(5, filler);
		helloGUI.setItem(6, filler);
		helloGUI.setItem(7, filler);
		helloGUI.setItem(8, filler);
		
		helloGUI.setItem(9, filler);
		helloGUI.setItem(10, filler);
		helloGUI.setItem(11, filler);
		helloGUI.setItem(12, smithy.buildWeapon("midas"));
		helloGUI.setItem(13, smithy.buildWeapon("excalibur"));
		helloGUI.setItem(14, smithy.buildWeapon("troll"));
		helloGUI.setItem(15, filler);
		helloGUI.setItem(16, filler);
		helloGUI.setItem(17, filler);
		
		helloGUI.setItem(18, filler);
		helloGUI.setItem(19, filler);
		helloGUI.setItem(20, filler);
		helloGUI.setItem(21, filler);
		helloGUI.setItem(22, filler);
		helloGUI.setItem(23, filler);
		helloGUI.setItem(24, filler);
		helloGUI.setItem(25, filler);
		helloGUI.setItem(26, filler);		
		
		player.openInventory(helloGUI);
		
		return true;
		
	}
	
}

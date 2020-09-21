package com.kraken.helloworld2;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MyFirstListener implements Listener {

	public MyFirstListener(Main plugin) {
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		player.sendMessage("Hola!");
		
		ItemStack item = new ItemSmith().buildWeapon("midas");
		
		player.getInventory().addItem(item);
		
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 600, 1));
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if ( !player.hasPermission("helloworld2.build") ) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onBlockDestroy(BlockBreakEvent event) {
		
		Player player = (Player) event.getPlayer();
		
		if ( !player.hasPermission("helloworld2.demolish") ) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getInventory();
		
		if ( inventory.getName().equals("Hello GUI") && event.getSlotType() != SlotType.OUTSIDE ) {
			
			ItemSmith smithy = new ItemSmith();
			
			ItemStack clicked = event.getCurrentItem();
			Material clickedType = clicked.getType();
			String clickedLore = new String();
			
			if ( clicked.hasItemMeta() ) {
				clickedLore = clicked.getItemMeta().getLore().toString();
			}
			
			
			if ( clickedType == Material.GOLD_SWORD && clickedLore.contains("The golden sword of King Midas!") ) {
				player.getInventory().addItem( smithy.buildWeapon("midas") );
			} else if ( clickedType == Material.IRON_SWORD && clickedLore.contains("The fantastic sword of King Arthur!") ) {
				player.getInventory().addItem( smithy.buildWeapon("excalibur") );
			} else if ( clickedType == Material.STONE_SWORD && clickedLore.contains("The powerful and heavy Troll King's sword!") ) {
				player.getInventory().addItem( smithy.buildWeapon("troll") );
			}
			
			event.setCancelled(true);
			player.closeInventory();
			
		}
		
	}
	
}








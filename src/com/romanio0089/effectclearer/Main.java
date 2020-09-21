package com.romanio0089.effectclearer;

import java.util.WeakHashMap;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	
	String color = "red";
	WeakHashMap<Location, String> selections = new WeakHashMap<Location, String>();

    @Override
    public void onEnable() {
    	
        getLogger().info("EffectClearer has been sucessfully enabled !");
        
        PluginManager pm = getServer().getPluginManager();
        MyFirstListener listener = new MyFirstListener(this);
        pm.registerEvents(listener, this);
        
        if ( getConfig().getString("color") == null ) {
        	getConfig().set("color", "red");
        	saveConfig();
        }
        
    }
	
    @Override
    public void onDisable() {
    	
        getLogger().info("EffectClearer has been sucessfully disabled !");
        
    }
    
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	Player player = (Player) sender;
    	
    	if (sender instanceof Player) {
    		
    		String lowerCmd = cmd.getName().toLowerCase();
    		Inventory inv = player.getInventory();
    		
    		switch (lowerCmd) {
    		
    			case "ce":
    			
    				for (PotionEffect effect : player.getActivePotionEffects())
    			        player.removePotionEffect(effect.getType());
    				
    				player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "EffectClearer" + ChatColor.GRAY + "] " + ChatColor.RESET + "Cleared all player effects !");
    				return true;
    				
    			case "effectclear":
        			
    				for (PotionEffect effect : player.getActivePotionEffects())
    			        player.removePotionEffect(effect.getType());
    				
    				player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "EffectClearer" + ChatColor.GRAY + "] " + ChatColor.RESET + "Cleared all player effects !");
    				return true;			
			
				case "effectc":
			
					for (PotionEffect effect : player.getActivePotionEffects())
						player.removePotionEffect(effect.getType());
			
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "EffectClearer" + ChatColor.GRAY + "] " + ChatColor.RESET + "Cleared all player effects !");
					return true;
					
				case "cleareffect":
					
					for (PotionEffect effect : player.getActivePotionEffects())
						player.removePotionEffect(effect.getType());
			
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "EffectClearer" + ChatColor.GRAY + "] " + ChatColor.RESET + "Cleared all player effects !");
					return true;
					
				case "ecr":
					
					for (PotionEffect effect : player.getActivePotionEffects())
						player.removePotionEffect(effect.getType());
			
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "EffectClearer" + ChatColor.GRAY + "] " + ChatColor.RESET + "Cleared all player effects !");
					return true;
					
				case "cleare":
					
					for (PotionEffect effect : player.getActivePotionEffects())
						player.removePotionEffect(effect.getType());
			
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "EffectClearer" + ChatColor.GRAY + "] " + ChatColor.RESET + "Cleared all player effects !");
					return true;
					
				case "eclear":
					
					for (PotionEffect effect : player.getActivePotionEffects())
						player.removePotionEffect(effect.getType());
			
					player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "EffectClearer" + ChatColor.GRAY + "] " + ChatColor.RESET + "Cleared all player effects !");
					return true;
    		
    	}
    	
	}
		return false;
    	
	}
}

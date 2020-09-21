package com.kraken.helloworld2;

import java.util.WeakHashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;

public class Main extends JavaPlugin {
	
	String color = "red";
	WeakHashMap<Location, String> selections = new WeakHashMap<Location, String>();

    @Override
    public void onEnable() {
    	
        getLogger().info("HelloWorld2 has been enabled.");
        
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
    	
        getLogger().info("HelloWorld2 has been disabled.");
        
    }
    
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	Player player = (Player) sender;
    	
    	if (sender instanceof Player) {
    		
    		String lowerCmd = cmd.getName().toLowerCase();
    		Inventory inv = player.getInventory();
    		
    		switch (lowerCmd) {
    		
    			case "gui":
    				
    				if ( player.hasPermission("helloworld2.gui") ) {
    					boolean success = HelloGUI.openGUI(player);
    					
    					if (!success) {
        					player.sendMessage(ChatColor.RED + "Could not open the GUI!");
        				}
    					
					} else {
						player.sendMessage("NO SWORD 4 U!");
					}
    				
    				return true;
    		
    			case "fcheck":
    		
    				MPlayer mp = MPlayer.get(player);
    				Faction faction = mp.getFaction();
    				
    				if ( !faction.getName().equals("§2Wilderness") ) {
    					player.sendMessage(ChatColor.GREEN + "You are indeed in a faction!");
    					return true;
    				} else {
    					player.sendMessage(ChatColor.RED + "You are factionless and aloooone!");
    					return true;
    				}
    				
    			case "tag":
    				
    				if (args.length == 0) {
    					player.sendMessage("Try adding a color after the tag command.");
    					return true;
    				} else {
    					switch (args[0].toLowerCase()) {
    						case "blue":
    							selections.put(player.getLocation().add(0, -1, 0), "blue");
    							return true;
    						case "red":
    							selections.put(player.getLocation().add(0, -1, 0), "red");
    							return true;
    						case "yellow":
    							selections.put(player.getLocation().add(0, -1, 0), "yellow");
    							return true;
    						default:
    							player.sendMessage("Color not recognized in tag command.");
    							return true;
    					}
    				}
    				
    			case "colorify":
    				
    				for ( Location loc : selections.keySet() ) {
    					
    					String color = selections.get(loc);
    					Block block = loc.getBlock();
    					
    					switch (color.toLowerCase()) {
    					
    					case "blue":
    						block.setType(Material.WOOL);
    						block.setData((byte) 11);
    						break;
    					case "red":
    						block.setType(Material.WOOL);
    						block.setData((byte) 14);
    						break;
    					case "yellow":
    						block.setType(Material.WOOL);
    						block.setData((byte) 4);
    						break;
    						
    					}
    					
    				}
    				
    				player.sendMessage("Your blocks have been colorified!");
    				return true;
    		
    			case "color":
    			
    				if (args.length == 1) {
    					
    					switch (args[0].toLowerCase()) {
    					
    						case "blue":
    							color = "blue";
    							getConfig().set("color", "blue");
    							saveConfig();
    							return true;
    						case "yellow":
    							color = "yellow";
    							getConfig().set("color", "yellow");
    							saveConfig();
    							return true;
    						case "red":
    							color = "red";
    							getConfig().set("color", "red");
    							saveConfig();
    							return true;
    						default:
    							player.sendMessage("I have no idea what color you chose. Try red, blue, or yellow!");
    							return true;
    					
    					}
    					
    				} else if (args.length == 0) {
    					
    					player.sendMessage("Your color is: " + getConfig().getString("color") + ".");
    					return true;
    					
    				} else {
    					
    					player.sendMessage("I have no idea what color you chose. Try red, blue, or yellow!");
						return true;
    					
    				}
    		
    			case "nv":
    			
    				player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 6000, 1));
    				return true;
    		
    			case "jockey":
    				
    				Location spawnLoc = player.getLocation().add(2,0,0);
    				World world = player.getWorld();
    				
    				Spider spider = (Spider) world.spawnEntity(spawnLoc, EntityType.SPIDER);
    				Skeleton skeleton = (Skeleton) world.spawnEntity(spawnLoc, EntityType.SKELETON);
    				spider.setPassenger(skeleton);
    				
    				return true;
    		
    			case "glow":
    				
    				Location blockLoc = player.getLocation().add(0, 2, 0);
    				
    				if ( blockLoc.getBlock().getType().equals(Material.AIR) ) {
    				
    					blockLoc.getBlock().setType(Material.GLOWSTONE);
    					return true;
    					
    				} else {
    					
    					player.sendMessage("You must have air above you to use this command!");
    					return true;
    					
    				}
    				
    			case "jungle":
    				
    				Location blockLoc2 = player.getLocation().add(2, 0, 0);
    				
    				if ( blockLoc2.getBlock().getType().equals(Material.AIR) ) {
    				
    					
    					Block jungleBlock = blockLoc2.getBlock();
    					jungleBlock.setType(Material.LOG);
    					jungleBlock.setData((byte) 3);
    					return true;
    					
    				} else {
    					
    					player.sendMessage("You must have air to your side to use this command!");
    					return true;
    					
    				}
    		
    			case "netherport":
    				
    				World nether = Bukkit.getServer().getWorld("world_nether");
    				Location loc = new Location(nether, 0, 0, 0);
    				
    				player.teleport(loc);
    				return true;
    		
    			case "givesword":
    				
    				int length = args.length;
    				
    				switch (length) {
    				
    					case 0:
    						
    						if ( player.hasPermission("helloworld2.sword") ) {
    							ItemStack item = new ItemSmith().buildWeapon("midas");
        						inv.addItem(item);
    						} else {
    							player.sendMessage("NO SWORD 4 U!");
    						}
    						return true;
    					default:
    						player.sendMessage("Your command was not recognized.");
    	    		    	return true;
    						
    				}
    				
    			default:
    				player.sendMessage("Your command was not recognized.");
    		    	return true;
    		
    		}
    		
    	}
    	
    	player.sendMessage("Your command was not recognized.");
    	return true;
    	
    }
    
}
package com.applenick.HoloTests;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.applenick.HoloTests.commands.HoloCommands;
import com.applenick.HoloTests.nametag.GroupUtil;
import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.CommandException;
import com.sk89q.minecraft.util.commands.CommandPermissionsException;
import com.sk89q.minecraft.util.commands.CommandUsageException;
import com.sk89q.minecraft.util.commands.CommandsManager;
import com.sk89q.minecraft.util.commands.MissingNestedCommandException;
import com.sk89q.minecraft.util.commands.WrappedCommandException;

public class HoloTest extends JavaPlugin {
	
	public static String _prefix = ChatColor.WHITE + "[" + ChatColor.RED + "Apple" + ChatColor.WHITE + "]";
	public static String _appleGroup = "apple";
	
	private static HoloTest holotest;
	public static HoloTest get(){
		return holotest;
	}
	
	public void onEnable(){
		holotest = this;
		
		GroupUtil.setupNameGroup(_appleGroup , _prefix);
		
		
		this.setupListener(new PlayerListener());

		setupCommands();
	}
	
	private void setupListener(Listener listener){
		this.getServer().getPluginManager().registerEvents(listener, this);
	}
		
	
	 private CommandsManager<CommandSender> commands;

	    private void setupCommands() {
	        this.commands = new CommandsManager<CommandSender>() {
	            @Override public boolean hasPermission(CommandSender sender, String perm) {
	                return sender instanceof ConsoleCommandSender || sender.hasPermission(perm);
	            }
	        };

	        CommandsManagerRegistration register = new CommandsManagerRegistration(this, this.commands);
	        register.register(HoloCommands.class);
	    }

	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	        try {
	            this.commands.execute(cmd.getName(), args, sender, sender);
	        } catch (CommandPermissionsException e) {
	            sender.sendMessage(ChatColor.RED + "You don't have permission.");
	        } catch (MissingNestedCommandException e) {
	            sender.sendMessage(ChatColor.RED + e.getUsage());
	        } catch (CommandUsageException e) {
	            sender.sendMessage(ChatColor.RED + e.getMessage());
	            sender.sendMessage(ChatColor.RED + e.getUsage());
	        } catch (WrappedCommandException e) {
	            if (e.getCause() instanceof NumberFormatException) {
	                sender.sendMessage(ChatColor.RED + "Number expected, string received instead.");
	            } else {
	                sender.sendMessage(ChatColor.RED + "An error has occurred. See console.");
	                e.printStackTrace();
	            }
	        } catch (CommandException e) {
	            sender.sendMessage(ChatColor.RED + e.getMessage());
	        }

	        return true;
	    }

}

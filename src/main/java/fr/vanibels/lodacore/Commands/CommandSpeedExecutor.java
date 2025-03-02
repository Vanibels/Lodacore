package fr.vanibels.lodacore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpeedExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (command.getName() == "speedon"){
            player.setFlySpeed(3);
            player.setWalkSpeed(3);
            player.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Vittesse de " + player.getName() + " mis sur 3");
        }
        if (command.getName() == "speedoff"){
            player.setFlySpeed(1);
            player.setWalkSpeed(1);
            player.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Vittesse de " + player.getName() + " mis sur 1");
        }
        return true;
    }
}

package fr.vanibels.lodacore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandJourExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        World world = player.getWorld();

        world.setTime(1000);
        player.sendMessage(ChatColor.BOLD + "" + ChatColor.GOLD + "Le jour a été mis sur " + world.getName());
        return true;
    }
}

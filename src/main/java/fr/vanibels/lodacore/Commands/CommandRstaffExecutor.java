package fr.vanibels.lodacore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRstaffExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("Connect toi");

        }else {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.GREEN + "Attends aprés je dev promis");
            // Location staffr = new Location( Bukkit.getWorld("world"),-152.51f, 53.50f, 245.42f, -2068.50f, 5.10f);
            // player.teleport(staffr);

        }

        return true;
    }
}

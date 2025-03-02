package fr.vanibels.lodacore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandRstaffExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("Connecte toi");

        }else {
            Player player = (Player) sender;
            player.teleport(new Location(Bukkit.getWorld("operator"),0.00,-60.00,0.00,362.70F,10.65F));
        }

        return true;
    }
}

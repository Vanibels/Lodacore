package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Utils.TeleportCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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
            Location staffr = new Location( Bukkit.getWorld("event"),114.500, -60, -43.500);
            TeleportCommand teleportCommand = new TeleportCommand();
            teleportCommand.teleportWithDelayAndCooldown(player,staffr);

        }

        return true;
    }
}

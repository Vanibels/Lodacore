package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Utils.TeleportCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAreneExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("Vient en jeu pour cette commande");
            return true;
        }

        Player player = (Player) sender;
        Location warzone = new Location(Bukkit.getWorld("warzone"), -534.500 ,53.00 ,-816.500 ,182.70f ,13.95f);
        player.sendMessage("Téléportation dans la zone de combats " + ChatColor.DARK_RED+"Attention!!!");
        TeleportCommand teleportCommand = new TeleportCommand();
        teleportCommand.teleportWithDelayAndCooldown(player,warzone);

        return true;
    }
}

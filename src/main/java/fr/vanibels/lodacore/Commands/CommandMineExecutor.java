package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Utils.TeleportCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMineExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String labels, String[] args) {

        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("Vient en jeu pour cette commande");
            return true;
        }

        Player player = (Player) sender;
        Location minage = new Location(Bukkit.getWorld("ressources"), -21.500, 184, -342.500,182.70f ,13.95f);
        player.sendMessage("Téléportation dans le monde minage " + ChatColor.DARK_RED+"Attention!!!");
        TeleportCommand teleportCommand = new TeleportCommand();
        teleportCommand.teleportWithDelayAndCooldown(player,minage);

        return true;
    }
}

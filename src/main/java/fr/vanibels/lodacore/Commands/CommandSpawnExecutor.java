package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Lodacore;
import fr.vanibels.lodacore.Managers.Task.TeleportTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawnExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;
        if (!(Lodacore.OnlinePlayer.contains(player))){
            player.sendMessage(ChatColor.RED + "Connecter vous puis faite /join");
            return true;
        }
       Location spawn = new Location(Bukkit.getWorld("lobby"), 292.00, 113.00 ,291.00 ,180F ,0F);;
       TeleportTask teleportTask = new TeleportTask(player,spawn);
       teleportTask.run();

        return true;
    }
}

package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Utils.TeleportCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static fr.vanibels.lodacore.Lodacore.instance;

public class CommandSpawnExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("Cette command n'est disponnible qu'en jeu");
        }else{
            Player player = (Player) sender;
            player.sendMessage(ChatColor.GREEN+"Teleportation");
            TeleportCommand teleportCommand = new TeleportCommand();
            teleportCommand.teleportWithDelayAndCooldown(player,instance.spawn);
        }

        return true;
    }
}

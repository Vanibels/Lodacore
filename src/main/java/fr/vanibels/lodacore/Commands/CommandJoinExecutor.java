package fr.vanibels.lodacore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static fr.vanibels.lodacore.Lodacore.OnlinePlayer;
import static fr.vanibels.lodacore.Lodacore.instance;

public class CommandJoinExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (OnlinePlayer.contains(player))return true;
        OnlinePlayer.add(player);
        Location spawn = new Location(Bukkit.getWorld("lobby"), 292.00, 113.00 ,291.00 ,180F ,0F);
        player.teleport(spawn);
        //player.setResourcePack("https://drive.google.com/uc?export=download&id=1jXYNhE2WCb-YsLUbyeKBSCERigE8azJn");

        return true;
    }
}

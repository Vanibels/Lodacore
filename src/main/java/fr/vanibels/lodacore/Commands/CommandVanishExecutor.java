package fr.vanibels.lodacore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static fr.vanibels.lodacore.Lodacore.instance;

public class CommandVanishExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)){
            Bukkit.getLogger().info("[STATUS ERROR]-Vous n'avez pas le status nécessaire pour executer cette commande");
            return false;
        }

        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();

        if (isVanish(uuid) == true){
            instance.vanishPlayers.remove(uuid);
            player.setDisplayName(player.getName());
            player.sendMessage(ChatColor.BOLD +""+ChatColor.GOLD + "Lodaban " +ChatColor.GREEN + " Vanish désactivé");
            player.setCollidable(false);
            player.setCanPickupItems(true);
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                onlinePlayer.showPlayer(instance, player);
            }
        }else {
            instance.vanishPlayers.add(uuid);
            player.sendMessage(ChatColor.BOLD +""+ChatColor.GOLD + "Lodaban " +ChatColor.GREEN + " Vanish activé");

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (!onlinePlayer.hasPermission("lodaria.mod.vanish.view")){
                    onlinePlayer.hidePlayer(instance,player);
                }
            }
            player.setCollidable(false);
            player.setCanPickupItems(true);
            player.setDisplayName(ChatColor.BOLD + "" + ChatColor.RED + "VANISH " + player.getName());
        }

        return true;
    }
    public static boolean isVanish(UUID uuid){
        return instance.vanishPlayers.contains(uuid) || instance.superVanishedPlayers.contains(uuid);
    }
}

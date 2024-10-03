package fr.vanibels.lodacore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("La console ne peut pas se rendre invisible.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("staffmod.vanish")) {
            player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }

        if (player.isInvisible()) {
            player.setInvisible(false);
            player.sendMessage(ChatColor.GREEN + "Vous êtes maintenant visible.");
        } else {
            player.setInvisible(true);
            player.sendMessage(ChatColor.RED + "Vous êtes maintenant invisible.");
        }

        return true;
    }
}

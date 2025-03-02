package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Managers.PlayerManagers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static fr.vanibels.lodacore.Lodacore.instance;

public class CommandBienvenueExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Vérifie que l'expéditeur est un joueur
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Cette commande ne peut être utilisée que par un joueur.");
            return true;
        }

        Player player = (Player) sender;

        // Vérifie qu'il y a des arguments
        if (args.length < 1) {
            player.sendMessage(ChatColor.RED + "Veuillez spécifier un joueur à qui souhaiter la bienvenue.");
            return false;
        }

        // Récupère le joueur cible
        Player target = Bukkit.getPlayer(args[0]); // Utiliser args[0] au lieu de args[1]

        // Vérifie si le joueur cible est en ligne
        if (args[0].equalsIgnoreCase("@a")) {
            for (Player targets : Bukkit.getOnlinePlayers()) {
                targets.sendMessage(ChatColor.LIGHT_PURPLE + "Bienvenue " + ChatColor.DARK_PURPLE + targets.getName() + ChatColor.GOLD + " sur Lodaria !");
                targets.sendMessage(ChatColor.LIGHT_PURPLE + "Fais /tuto si tu as besoin d'aide ou va sur le wiki : " + ChatColor.GOLD + " ");
                targets.sendMessage(ChatColor.LIGHT_PURPLE + "Contacte un guide, un modérateur ou un super modérateur si tu as besoin d'aide.");
                targets.sendMessage(ChatColor.LIGHT_PURPLE + "Contacte le support via le " + ChatColor.DARK_BLUE + "Discord avec le /discord.");
            }
        }

        if (target == null) {
            player.sendMessage(ChatColor.RED + "Le joueur spécifié n'est pas en ligne.");
            return true;
        }
        Bukkit.broadcastMessage(instance.prefix + ChatColor.DARK_PURPLE + player.getName() + ChatColor.LIGHT_PURPLE + " souhaite la bienvenue à " + target.getName());

        target.sendMessage(ChatColor.LIGHT_PURPLE + "Bienvenue " + ChatColor.DARK_PURPLE + target.getName() + ChatColor.GOLD + " sur Lodaria !");
        target.sendMessage(ChatColor.LIGHT_PURPLE + "Fais /tuto si tu as besoin d'aide ou va sur le wiki : " + ChatColor.GOLD + " ");
        target.sendMessage(ChatColor.LIGHT_PURPLE + "Contacte un guide, un modérateur ou un super modérateur si tu as besoin d'aide.");
        target.sendMessage(ChatColor.LIGHT_PURPLE + "Contacte le support via le " + ChatColor.DARK_BLUE + "Discord avec le /discord.");
        /*

        // Envoie le message de bienvenue au joueur cible
        Bukkit.broadcastMessage(instance.prefix + ChatColor.DARK_PURPLE + player.getName() + ChatColor.LIGHT_PURPLE + " souhaite la bienvenue à " + target.getName());

        target.sendMessage(ChatColor.LIGHT_PURPLE + "Bienvenue " + ChatColor.DARK_PURPLE + target.getName() + ChatColor.GOLD + " sur Lodaria !");
        target.sendMessage(ChatColor.LIGHT_PURPLE + "Fais /tuto si tu as besoin d'aide ou va sur le wiki : " + ChatColor.GOLD + "https://lodaria.net");
        target.sendMessage(ChatColor.LIGHT_PURPLE + "Contacte un guide, un modérateur ou un super modérateur si tu as besoin d'aide.");
        target.sendMessage(ChatColor.LIGHT_PURPLE + "Contacte le support via le " + ChatColor.DARK_BLUE + "Teamspeak ts.lodaria.net " + "ou via le Discord avec /discord.");*/

        return true;
    }
}

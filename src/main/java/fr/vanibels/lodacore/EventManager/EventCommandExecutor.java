package fr.vanibels.lodacore.EventManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static fr.vanibels.lodacore.Lodacore.instance;
import static org.bukkit.Instrument.CREEPER;

public class EventCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        Player onlinePlayers = (Player) Bukkit.getOnlinePlayers();
        if (!player.hasPermission("lodaria.events")) {
            player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }

        // Vérification de la sous-commande (vanish, ban, etc.)
        if (args.length == 0) {
            player.sendMessage(ChatColor.YELLOW + "/event on - Annoncer le début d'une session d'event dans quelques minutes");
            player.sendMessage(ChatColor.YELLOW + "/event off - Désactiver une session d'event");
            player.sendMessage(ChatColor.YELLOW + "/event broadcast - Annoncer un event");
            return true;
        }

        String subCommand = args[0].toLowerCase();
        switch (subCommand) {
            case "on":
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.sendTitle("§6Session d'event début dans quelques minutes", "", 10, 70, 20);
                }
                Bukkit.broadcastMessage("§6Session d'event débute dans quelques minutes");
                Bukkit.setMotd(instance.getConfig().getString("global.EventMotd"));
                break;

            case "off":
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.sendTitle("§6Session d'event terminé", "", 10, 70, 20);
                }
                Bukkit.broadcastMessage("§6Session d'event terminé");
                Bukkit.setMotd(instance.getConfig().getString("global.DefaultMotd"));
                break;

            case "broadcast":
                StringBuilder st = new StringBuilder();
                for (int i = 1; i < args.length; i++) {  // Commence à i=1 pour ignorer le subCommand "broadcast"
                    st.append(args[i]).append(" ");
                }
                String message = st.toString().trim(); // Retire l'espace final

                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.sendTitle("[§6Session d'event]", "§6" + message, 10, 70, 20);
                }
                Bukkit.broadcastMessage("§6Session d'event : " + message);
                break;

            default:
                player.sendMessage("Commande inconnue");
                break;
        }
        return true;

    }
}

package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Lodacore;
import fr.vanibels.lodacore.Utils.ServerState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static fr.vanibels.lodacore.Lodacore.instance;


public class CommandMaintExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Connecte toi puis reesaye");
            return true;
        }

        Player player = (Player) sender;

        // Commande pour activer/désactiver la maintenance
        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Utilisation: /maintenance <on/off>");
            return true;
        }

        switch (args[0].toLowerCase()){
            case "on":
                ServerState State = instance.getSSTATE();
                if (State == ServerState.MAINTENANCE){
                    player.sendMessage("Le serveur est déja en mode maintenance");
                    return true;
                }
                instance.setSSTATE(ServerState.MAINTENANCE);
                Bukkit.setWhitelistEnforced(true);
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    if (!onlinePlayer.hasPermission("lodaria.maintenance")) {
                        onlinePlayer.kickPlayer(ChatColor.RED + instance.getConfig().getString("maintenance.kickMessage"));
                    }
                }
                Bukkit.setWhitelist(true);
                instance.setIsMaintenance(true);
                Bukkit.setMotd(instance.getConfig().getString("maintenance.motd"));
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()){
                    onlinePlayer.sendTitle(ChatColor.GOLD + "Maintenance activer","");
                }
                Bukkit.getLogger().info("Maintenance du serveur activer");
                break;

            case "off":
                instance.setSSTATE(ServerState.OPEN);
                instance.setIsMaintenance(false);
                Bukkit.setWhitelist(false);
                Bukkit.setMotd("§l§4[LODARIA] §r§6PvP-Fac §1Vanilla 1.XXX §f- §lPréparez-vous pour la V2 \\!");
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()){
                    onlinePlayer.sendTitle(ChatColor.GOLD + "Maintenance désactiver","");
                }
                Bukkit.getLogger().info("Maintenance du serveur désactiver");
                break;

            default:
                sender.sendMessage(ChatColor.RED + "Commande inconnue");
                sender.sendMessage(ChatColor.RED + "Utilisation: /maintenance <on/off>");
                break;
        }


        return true;
    }



}

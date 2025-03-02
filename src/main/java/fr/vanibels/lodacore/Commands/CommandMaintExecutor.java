package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Lodacore;
import fr.vanibels.lodacore.Managers.Task.EndTimerTask;
import fr.vanibels.lodacore.Managers.Task.StartTimerTask;
import fr.vanibels.lodacore.Managers.Utils.ServerState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static fr.vanibels.lodacore.Lodacore.instance;

public class CommandMaintExecutor implements CommandExecutor {
    private static final int TIME = 600;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Connecte-toi puis réessaie.");
            return true;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Utilisation: /maintenance <on/off/start/end/status>");
            return true;
        }

        ServerState state = instance.getSSTATE();
        String subCommand = args[0].toLowerCase();

        switch (subCommand) {
            case "on":
                if (state == ServerState.MAINTENANCE) {
                    player.sendMessage(instance.prefix + "Le serveur est déjà en mode maintenance.");
                    return true;
                }
                if (state == ServerState.WAITING) {
                    player.sendMessage(instance.prefix + ChatColor.DARK_RED + " La procédure est en cours.");
                    return true;
                }
                setMaintenance(player);
                break;

            case "off":
            case "end":
                if (state == ServerState.WAITING) {
                    player.sendMessage(instance.prefix + ChatColor.DARK_RED + " La procédure est en cours.");
                    return true;
                }
                if (state != ServerState.MAINTENANCE) {
                    player.sendMessage(instance.prefix + ChatColor.DARK_RED + " Le serveur n'est pas en maintenance.");
                    return true;
                }
                if (subCommand.equals("off")) {
                    unsetMaintenance(player);
                } else {
                    startEndTimer(player);
                }
                break;

            case "start":
                if (state == ServerState.MAINTENANCE || state == ServerState.WAITING) {
                    player.sendMessage(instance.prefix + ChatColor.DARK_RED + " Le serveur est déjà en maintenance ou la procédure est en cours.");
                    return true;
                }
                startStartTimer(player);
                break;

            case "status":
                player.sendMessage(instance.prefix + ChatColor.GOLD + " État du serveur: " + instance.getSSTATE());
                break;

            default:
                sender.sendMessage(ChatColor.RED + "Commande inconnue.");
                sender.sendMessage(ChatColor.RED + "Utilisation: /maintenance <on/off/start/end/status>");
                break;
        }
        return true;
    }

    private void startStartTimer(Player player) {
        instance.setSSTATE(ServerState.WAITING);
        Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + " Maintenance dans " + ChatColor.RESET + "10 minutes.");
        new StartTimerTask(TIME, player).runTaskTimer(instance, 0, 20);
    }

    private void startEndTimer(Player player) {
        instance.setSSTATE(ServerState.WAITING);
        Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + " Fin maintenance dans " + ChatColor.RESET + "10 minutes.");
        new EndTimerTask(TIME, player).runTaskTimer(instance, 0, 20);
    }

    private void unsetMaintenance(Player executor) {
        instance.setSSTATE(ServerState.OPEN);
        instance.setIsMaintenance(false);
        Bukkit.setWhitelist(false);
        Bukkit.setMotd("§6§l⚔\uFE0F §e§l[Événement PvP : Siège de Château] §6§l⚔\uFE0F §7§lRejoignez la bataille ! §c§l10vs10 §f- §9§lArchers, Guerriers §fet §a§lÉclaireurs §f!");

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.sendTitle(ChatColor.GOLD + "Maintenance désactivée", "");
        }

        Bukkit.getLogger().info("Maintenance du serveur désactivée par " + executor.getDisplayName() + " --- " + executor.getName() + " --- " + executor.getUniqueId());
    }

    private void setMaintenance(Player executor) {
        instance.setSSTATE(ServerState.MAINTENANCE);
        instance.setIsMaintenance(true);
        Bukkit.setWhitelist(true);
        Bukkit.setWhitelistEnforced(true);
        Bukkit.setMotd("§c§lMaintenance en cours ! §eBientôt de retour!");

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayer.hasPermission("lodaria.maintenance")) {
                onlinePlayer.kickPlayer(instance.prefix + ChatColor.RED + " Serveur en maintenance, de retour sous peu ;)");
            }
        }

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.sendTitle(instance.prefix + ChatColor.GOLD + "Maintenance activée", "");
        }

        Bukkit.getLogger().info(instance.prefix + "Maintenance du serveur activée par " + executor.getDisplayName() + " --- " + executor.getName() + " --- " + executor.getUniqueId());
    }
}

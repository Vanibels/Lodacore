package fr.vanibels.lodacore.Commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Date;

import static fr.vanibels.lodacore.Lodacore.*;

public class StaffGUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!(sender instanceof Player)) {
            sender.sendMessage("La console ne peut pas utiliser cette commande.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("lodaria.staff")) {
            player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }

        // Vérification de la sous-commande (vanish, ban, etc.)
        if (args.length == 0) {
            player.sendMessage(ChatColor.YELLOW + "/staff gui - Ouvre l'interface GUI du staff");
            player.sendMessage(ChatColor.YELLOW + "/staff vanish - Activer/désactiver le vanish");
            player.sendMessage(ChatColor.YELLOW + "/staff ban <joueur> - Bannir un joueur");
            player.sendMessage(ChatColor.YELLOW + "/staff tempban <joueur> <durée> - Tempban d'un joueur");
            player.sendMessage(ChatColor.YELLOW + "/staff kick <joueur> - Kick un joueur");
            player.sendMessage(ChatColor.YELLOW + "/staff mute <joueur> - Mute un joueur");
            player.sendMessage(ChatColor.YELLOW + "/staff unban <joueur> - Unban un joueur");
            player.sendMessage(ChatColor.YELLOW + "/staff unmute <joueur> - Unmute un joueur");
            return true;
        }

        String subCommand = args[0].toLowerCase();

        switch (subCommand) {
            case "vanish":
                if (player.hasPermission("lodaria.vanish")) {
                    boolean isVanished = player.isInvisible();
                    if (isVanished) {
                        player.setInvisible(false);
                        player.sendMessage(ChatColor.GREEN + "Vanish désactivé.");
                    } else {
                        player.setInvisible(true);
                        player.sendMessage(ChatColor.GREEN + "Vanish activé.");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission de faire cela.");
                }
                break;

            case "ban":
                if (args.length < 2) {
                    player.sendMessage(ChatColor.RED + "Usage: /staff ban <joueur>");
                    return true;
                }

                Player targetBan = Bukkit.getPlayer(args[1]);
                if (targetBan != null) {
                    if (BannedPlayer.contains(targetBan)){
                        player.sendMessage(ChatColor.RED + targetBan.getDisplayName() + "à déja été bannie");
                        return true;
                    }
                    String banMessage = "Vous avez été banni par " + player.getName();
                    // Utilise le BanList de Bukkit pour bannir
                    Bukkit.getBanList(BanList.Type.NAME).addBan(targetBan.getName(), banMessage, null, player.getName());
                    targetBan.kickPlayer(banMessage);
                    BannedPlayer.add(targetBan);
                    Bukkit.broadcastMessage(ChatColor.RED + targetBan.getName() + " a été banni.");
                } else {
                    player.sendMessage(ChatColor.RED + "Joueur non trouvé.");
                }
                break;

            case "tempban":
                if (args.length < 3) {
                    player.sendMessage(ChatColor.RED + "Usage: /staff tempban <joueur> <durée en minutes>");
                    return true;
                }

                Player targetTempBan = Bukkit.getPlayer(args[1]);

                try {
                    int duration = Integer.parseInt(args[2]); // Durée en minutes
                    if (targetTempBan != null) {
                        if (TempBannedPlayer.contains(targetTempBan)){
                            player.sendMessage(ChatColor.RED + targetTempBan.getDisplayName() + "à déja été bannie");
                            return true;
                        }
                        String tempBanMessage = "Vous avez été temporairement banni par " + player.getName() + " pour " + duration + " minutes.";

                        // Calcul de la durée du ban en millisecondes
                        long banTime = duration * 60 * 1000L; // conversion en millisecondes
                        Date unbanDate = new Date(System.currentTimeMillis() + banTime);

                        // Bannir temporairement avec une date de fin
                        Bukkit.getBanList(BanList.Type.NAME).addBan(targetTempBan.getName(), tempBanMessage, unbanDate, player.getName());
                        targetTempBan.kickPlayer(tempBanMessage);
                        TempBannedPlayer.add(targetTempBan);
                        Bukkit.broadcastMessage(ChatColor.RED + targetTempBan.getName() + " a été temporairement banni pour " + duration + " minutes.");

                    } else {
                        player.sendMessage(ChatColor.RED + "Joueur non trouvé.");
                    }
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "La durée doit être un nombre valide.");
                }
                break;

            case "kick":
                if (args.length < 2) {
                    player.sendMessage(ChatColor.RED + "Usage: /staff kick <joueur>");
                    return true;
                }
                Player targetKick = Bukkit.getPlayer(args[1]);
                if (targetKick != null) {
                    targetKick.kickPlayer("Vous avez été expulsé par " + player.getName());
                    Bukkit.broadcastMessage(ChatColor.RED + targetKick.getName() + " a été expulsé.");
                } else {
                    player.sendMessage(ChatColor.RED + "Joueur non trouvé.");
                }
                break;
            case "mute":
                if (args.length < 2) {
                    player.sendMessage(ChatColor.RED + "Usage: /staff mute <joueur>");
                    return true;
                }

                Player targetMute = Bukkit.getPlayer(args[1]);
                if (targetMute != null) {
                    if (MutedPlayers.contains(targetMute)){
                        player.sendMessage(ChatColor.RED + targetMute.getDisplayName() + "à déja été mute");
                        return true;
                    }
                    MutedPlayers.add(targetMute.getName());
                    Bukkit.broadcastMessage(ChatColor.RED + targetMute.getName() + " a été réduit au silence.");
                } else {
                    player.sendMessage(ChatColor.RED + "Joueur non trouvé.");
                }
                break;

            case "tempmute":
                if (args.length < 3) {
                    player.sendMessage(ChatColor.RED + "Usage: /staff tempmute <joueur> <durée en minutes>");
                    return true;
                }

                Player targetTempMute = Bukkit.getPlayer(args[1]);
                try {
                    int muteDuration = Integer.parseInt(args[2]); // Durée en minutes

                    if (targetTempMute != null) {
                        if (TempMutedPlayers.contains(targetTempMute)){
                            player.sendMessage(ChatColor.RED + targetTempMute.getDisplayName() + "à déja été mute");
                            return true;
                        }
                        TempMutedPlayers.add(targetTempMute.getName());
                        Bukkit.broadcastMessage(ChatColor.RED + targetTempMute.getName() + " a été réduit au silence pour " + muteDuration + " minutes.");

                        // Planifier le unmute après le délai
                        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("Lodacore"), () -> {
                            TempMutedPlayers.remove(targetTempMute.getName());
                            Bukkit.broadcastMessage(ChatColor.GREEN + targetTempMute.getName() + " n'est plus réduit au silence.");
                        }, muteDuration * 1200L); // 1200 ticks = 1 minute
                    } else {
                        player.sendMessage(ChatColor.RED + "Joueur non trouvé.");
                    }
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "La durée doit être un nombre.");
                }
                break;
            case "unmute":
                if (args.length < 2) {
                    player.sendMessage(ChatColor.RED + "Usage: /staff unmute <joueur>");
                    return true;
                }

                String targetUnmuteName = args[1];

                if (MutedPlayers.contains(targetUnmuteName)) {
                    MutedPlayers.remove(targetUnmuteName);
                    Bukkit.broadcastMessage(ChatColor.GREEN + targetUnmuteName + " a été démuté.");
                } else if (TempMutedPlayers.contains(targetUnmuteName)) {
                    TempMutedPlayers.remove(targetUnmuteName);
                    Bukkit.broadcastMessage(ChatColor.GREEN + targetUnmuteName + " a été démuté.");
                } else {
                    player.sendMessage(ChatColor.RED + "Ce joueur n'est pas muet.");
                }
                break;


            case "unban":
                if (args.length < 2) {
                    player.sendMessage(ChatColor.RED + "Usage: /staff unban <joueur>");
                    return true;
                }
                // Logique pour unban
                break;case "banlist":
                player.sendMessage(ChatColor.RED + "Joueurs temporairement bannis :");

                // Récupère la liste des bannis
                for (BanEntry banEntry : Bukkit.getBanList(BanList.Type.NAME).getBanEntries()) {
                    String bannedPlayer = banEntry.getTarget(); // Nom du joueur banni
                    Date expiration = banEntry.getExpiration(); // Date de fin du ban, si c'est un tempban

                    if (expiration != null) {
                        player.sendMessage(ChatColor.YELLOW + bannedPlayer + ChatColor.GRAY + " - Expire le : " + ChatColor.AQUA + expiration.toString());
                    }
                }

                player.sendMessage(ChatColor.DARK_RED + "Joueurs bannis définitivement :");

                // Affiche les bannis sans expiration (bannissement permanent)
                for (BanEntry banEntry : Bukkit.getBanList(BanList.Type.NAME).getBanEntries()) {
                    String bannedPlayer = banEntry.getTarget();
                    if (banEntry.getExpiration() == null) {
                        player.sendMessage(ChatColor.RED + bannedPlayer);
                    }
                }
                break;


            default:
                player.sendMessage(ChatColor.RED + "Commande non reconnue.");
        }

        return true;
    }
}

package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Managers.PlayerManagers;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

import static fr.vanibels.lodacore.Lodacore.*;

public class StaffCommand implements CommandExecutor {
    private final Map<UUID, Long> lastKickTimes = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (!(sender instanceof Player)) {
            sender.sendMessage("La console ne peut pas utiliser cette commande.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("lodaria.mod") && !player.hasPermission("lodaria.admin")) {
            player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }

        // Vérification de la sous-commande
        if (args.length == 0) {
            player.sendMessage(ChatColor.YELLOW + "/ss gui - Ouvre l'interface GUI du staff");
            player.sendMessage(ChatColor.YELLOW + "/ss mod - Met en mode modération");
            player.sendMessage(ChatColor.YELLOW + "/ss ban <joueur> - Bannir un joueur");
            player.sendMessage(ChatColor.YELLOW + "/ss tempban <joueur> <durée> - Tempban d'un joueur");
            player.sendMessage(ChatColor.YELLOW + "/ss kick <joueur> - Kick un joueur");
            player.sendMessage(ChatColor.YELLOW + "/ss mute <joueur> <durée> - Mute un joueur temporairement");
            player.sendMessage(ChatColor.YELLOW + "/ss unban <joueur> - Unban un joueur");
            player.sendMessage(ChatColor.YELLOW + "/ss unmute <joueur> - Unmute un joueur");
            return true;
        }

        String subCommand = args[0].toLowerCase();

        switch (subCommand) {
            case "mod":
                if (player.hasPermission("lodaria.mod.supermod") || player.hasPermission("lodaria.admin")) {
                    if (instance.modList.contains(player.getUniqueId())) {
                        PlayerManagers pm = PlayerManagers.getFromPlayer(player);
                        instance.modList.remove(player.getUniqueId());
                        player.sendMessage(ChatColor.RED + "Mod modérateur désactivé.");
                        player.getInventory().clear();
                        pm.giveIventory();
                        pm.destroy();
                        player.setAllowFlight(false);
                        player.setFlying(false);
                    } else {
                        PlayerManagers pm = new PlayerManagers(player);
                        instance.modList.add(player.getUniqueId());
                        player.sendMessage(ChatColor.GREEN + "Mod modérateur activé.");
                        pm.init();
                        pm.saveIventory();
                        player.getInventory().clear();
                        pm.setup();
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission de faire cela.");
                }
                break;

            case "ban":
                // Vérification des permissions
                if (!player.hasPermission("lodaria.mod.rstaff") && !player.hasPermission("lodaria.mod.admin")) {
                    player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
                    return false;
                }

                // Vérification du format de la commande
                if (args.length < 3 || !args[0].equalsIgnoreCase("ban")) {
                    player.sendMessage(ChatColor.RED + "Utilisation incorrecte. Format: /ss ban [User] [raison]");
                    return false;
                }

                // Récupération du pseudo du joueur et de la raison
                String targetName = args[1];
                StringBuilder reasonBuilder = new StringBuilder();
                // Construction de la raison à partir des arguments restants
                for (int i = 2; i < args.length; i++) {
                    reasonBuilder.append(args[i]).append(" ");
                }

                String reason = reasonBuilder.toString().trim();

                // Vérification si le joueur cible est en ligne
                Player target = Bukkit.getPlayer(targetName);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Le joueur " + targetName + " n'est pas en ligne.");
                    return false;
                }
                if (target.hasPermission("lodaria.mod.bypass")){
                    player.sendMessage(ChatColor.DARK_RED + "Il semble de cette personne soit immuniser  contre ce genre de tour :)");
                    return true;
                }
                // Affichage du message de bannissement
                Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Ban permanent de " + ChatColor.WHITE + target.getName() + " pour " + ChatColor.DARK_RED + reason);

                banPlayer(target,-1,reason);

                break;


            case "tempban":
                /*
                 * Format command
                 * /ss tempban [User] [temps] [raison]
                 * s -- seconde | m -- mois | a -- année | d -- jour
                 */

                // Vérification des permissions
                if (!player.hasPermission("lodaria.mod.rstaff") &&
                        !player.hasPermission("lodaria.mod.admin") &&
                        !player.hasPermission("lodaria.mod.rgameplay") &&
                        !player.hasPermission("lodaria.mod.supermod")) {
                    player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
                    return false;
                }

                // Vérification du format de la commande
                if (args.length < 4) {
                    player.sendMessage(ChatColor.RED + "Utilisation incorrecte. Format: /ss tempban [User] [temps] [raison]");
                    return false;
                }

                // Récupération du pseudo du joueur
                String targetTempban = args[1];
                String timeInput = args[2];
                StringBuilder reasonTempBan = new StringBuilder();

                // Construction de la raison à partir des arguments restants
                for (int i = 3; i < args.length; i++) {
                    reasonTempBan.append(args[i]).append(" ");
                }

                String reasonBan = reasonTempBan.toString().trim();

                // Vérification si le joueur cible est en ligne
                Player targetBan = Bukkit.getPlayer(targetTempban);
                if (targetBan == null) {
                    player.sendMessage(ChatColor.RED + "Le joueur " + targetTempban + " n'est pas en ligne.");
                    return false;
                }

                // Conversion du temps en millisecondes
                long durationMillis = parseDuration(timeInput);
                if (durationMillis == -1) {
                    player.sendMessage(ChatColor.RED + "Le format du temps est incorrect. Utilisez : s (seconde), d (jour), m (mois), a (année)");
                    return false;
                }
                if (targetBan.hasPermission("lodaria.mod.bypass")){
                    player.sendMessage(ChatColor.DARK_RED + "Il semble de cette personne soit immuniser  contre ce genre de tour :)");
                    return true;
                }

                // Vérification des limites de bannissement en fonction des permissions
                if (player.hasPermission("lodaria.mod.supermod") && durationMillis > (3 * 30L * 24 * 60 * 60 * 1000)) {
                    player.sendMessage(ChatColor.RED + "Vous ne pouvez pas bannir pour plus de 3 mois.");
                    return false;
                }

                if (player.hasPermission("lodaria.mod.rgameplay") && durationMillis > (2 * 365L * 24 * 60 * 60 * 1000)) {
                    player.sendMessage(ChatColor.RED + "Vous ne pouvez pas bannir pour plus de 2 ans.");
                    return false;
                }

                // Différentes permissions pour des durées spécifiques
                if (player.hasPermission("lodaria.mod.rstaff") || player.hasPermission("lodaria.mod.admin")) {
                    // Bannissement sans limite
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Ban temporaire de " + ChatColor.WHITE + targetBan.getName() + " pour " + ChatColor.DARK_RED + reasonBan);
                    Bukkit.getPlayer(targetBan.getUniqueId()).kickPlayer(reasonBan);
                    banPlayer(targetBan,durationMillis, reasonBan);
                } else if (player.hasPermission("lodaria.mod.rgameplay")) {
                    // Ban maximum de 2 ans
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Ban temporaire de " + ChatColor.WHITE + targetBan.getName() + " pour " + ChatColor.DARK_RED + reasonBan + " pour une durée maximale de 2 ans.");
                    Bukkit.getPlayer(targetBan.getUniqueId()).kickPlayer(reasonBan);
                    banPlayer(targetBan,durationMillis, reasonBan);
                } else if (player.hasPermission("lodaria.mod.supermod")) {
                    // Ban maximum de 3 mois
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Ban temporaire de " + ChatColor.WHITE + targetBan.getName() + " pour " + ChatColor.DARK_RED + reasonBan + " pour une durée maximale de 3 mois.");
                    Bukkit.getPlayer(targetBan.getUniqueId()).kickPlayer(reasonBan);
                    banPlayer(targetBan,durationMillis, reasonBan);
                }

                break;

             case "unban":
                /*
                 * Format command
                 * /ss unban [User]
                 */

                // Vérification des permissions
                if (!player.hasPermission("lodaria.mod.rstaff") &&
                        !player.hasPermission("lodaria.mod.admin") &&
                        !player.hasPermission("lodaria.mod.rgameplay") &&
                        !player.hasPermission("lodaria.mod.supermod")) {
                    player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
                    return false;
                }

                // Vérification du format de la commande
                if (args.length < 2) {
                    player.sendMessage(ChatColor.RED + "Utilisation incorrecte. Format: /ss unban [User]");
                    return false;
                }

                // Récupération du pseudo du joueur
                String targetUnBan = args[1];

                // Récupération de l'objet Player si le joueur est en ligne
                Player targetPlayer = Bukkit.getPlayer(targetUnBan);

                // Si le joueur est hors ligne, récupérer l'objet OfflinePlayer
                if (targetPlayer == null) {
                    targetPlayer = (Player) Bukkit.getOfflinePlayer(targetPlayer.getUniqueId());

                }

                // Vérification si le joueur est banni
                BanList<Player> banList = Bukkit.getBanList(BanList.Type.PROFILE);
                BanEntry<Player> banEntry = banList.getBanEntry(targetPlayer);
                if (banEntry == null) {
                    player.sendMessage(ChatColor.RED + "Le joueur " + targetUnBan + " n'est pas banni.");
                    return false;
                }

                // Vérification des permissions et des durées de ban
                long banDuration = System.currentTimeMillis() - banEntry.getCreated().getTime();

                if (player.hasPermission("lodaria.mod.supermod") && banDuration > (3 * 30L * 24 * 60 * 60 * 1000)) {
                    player.sendMessage(ChatColor.RED + "Vous ne pouvez pas débannir un joueur banni depuis plus de 3 mois.");
                    return false;
                }

                if (player.hasPermission("lodaria.mod.rgameplay") && banDuration > (2 * 365L * 24 * 60 * 60 * 1000)) {
                    player.sendMessage(ChatColor.RED + "Vous ne pouvez pas débannir un joueur banni depuis plus de 2 ans.");
                    return false;
                }

                // Unban
                banList.pardon(targetPlayer);
                Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Unban de " + ChatColor.WHITE + targetUnBan);

                break;




            case "kick":
                /*
                 * Format command
                 * /ss kick [User] [raison]
                 */

                // Vérification du format de la commande
                if (args.length < 2) {
                    player.sendMessage(ChatColor.RED + "Utilisation incorrecte. Format: /ss kick [User] [raison]");
                    return false;
                }

                // Récupération du pseudo et de la raison du kick
                String targetKickName = args[1];
                String kickReason = String.join(" ", Arrays.copyOfRange(args, 2, args.length));

                // Récupération de l'objet Player si le joueur est en ligne
                Player targetKickPlayer = Bukkit.getPlayer(targetKickName);

                // Si le joueur est hors ligne
                if (targetKickPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Le joueur " + targetKickName + " n'est pas en ligne.");
                    return false;
                }
                if (targetKickPlayer.hasPermission("lodaria.mod.bypass")){
                    player.sendMessage(ChatColor.DARK_RED + "Il semble de cette personne soit immuniser  contre ce genre de tour :)");
                    return true;
                }

                // Vérification des permissions
                if (player.hasPermission("lodaria.mod.rstaff") || player.hasPermission("lodaria.mod.admin")) {
                    // Kick sans limite
                    targetKickPlayer.kickPlayer(ChatColor.RED + "Vous avez été kické par " + player.getName() + " pour : " + kickReason);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Kick de " + ChatColor.WHITE + targetKickName + " pour " + ChatColor.DARK_RED + kickReason);
                } else if (player.hasPermission("lodaria.mod.rgameplay")) {
                    // Kick sans limite
                    targetKickPlayer.kickPlayer(ChatColor.RED + "Vous avez été kické par " + player.getName() + " pour : " + kickReason);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Kick de " + ChatColor.WHITE + targetKickName + " pour " + ChatColor.DARK_RED + kickReason);
                } else if (player.hasPermission("lodaria.mod.supermod")) {
                    // Kick sans limite
                    targetKickPlayer.kickPlayer(ChatColor.RED + "Vous avez été kické par " + player.getName() + " pour : " + kickReason);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Kick de " + ChatColor.WHITE + targetKickName + " pour " + ChatColor.DARK_RED + kickReason);
                } else if (player.hasPermission("lodaria.mod.conf")) {
                    // Vérification du cooldown (10 minutes)
                    long cooldown = 10 * 60 * 1000; // 10 minutes en millisecondes
                    long lastKickTime = getLastKickTime(player); // Méthode à implémenter pour récupérer le dernier kick

                    if (System.currentTimeMillis() - lastKickTime < cooldown) {
                        player.sendMessage(ChatColor.RED + "Vous devez attendre avant de kick à nouveau.");
                        return false;
                    }

                    // Kick avec cooldown
                    targetKickPlayer.kickPlayer(ChatColor.RED + "Vous avez été kické par " + player.getName() + " pour : " + kickReason);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Kick de " + ChatColor.WHITE + targetKickName + " pour " + ChatColor.DARK_RED + kickReason);

                    // Mettre à jour le dernier temps de kick
                    updateLastKickTime(player); // Méthode à implémenter pour mettre à jour le dernier kick
                }
                break;

            case "mutecmds":
                /*
                 * Format command
                 * /ss mute [User] [temps] [raison]
                 * s -- seconde | m -- mois | a -- année | d -- jour
                 */

                // Vérification des permissions
                if (args.length < 4) {
                    player.sendMessage(ChatColor.RED + "Utilisation incorrecte. Format: /ss mute [User] [temps] [raison]");
                    return false;
                }

                String targetUser = args[1];
                String timeArg = args[2];
                String Mutereason = String.join(" ", Arrays.copyOfRange(args, 3, args.length));

                Player targetMute = Bukkit.getPlayer(targetUser);

                if (targetMute == null) {
                    player.sendMessage(ChatColor.RED + "Le joueur " + targetUser + " n'est pas en ligne.");
                    return false;
                }

                long muteDuration = parseDuration(timeArg);

                if (muteDuration <= 0) {
                    player.sendMessage(ChatColor.RED + "Temps invalide spécifié.");
                    return false;
                }
                if (targetMute.hasPermission("lodaria.mod.bypass")){
                    player.sendMessage(ChatColor.DARK_RED + "Il semble de cette personne soit immuniser  contre ce genre de tour :)");
                    return true;
                }

                // Gestion des permissions et des limitations
                if (player.hasPermission("lodaria.mod.rstaff") || player.hasPermission("lodaria.mod.admin")) {
                    // Peut mute sans limite
                    mutePlayer(targetMute, muteDuration);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Mute de " + ChatColor.WHITE + targetUser + " pour " + ChatColor.DARK_RED + Mutereason);
                } else if (player.hasPermission("lodaria.mod.rgameplay")) {
                    // Peut mute sans limite
                    mutePlayer(targetMute, muteDuration);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Mute de " + ChatColor.WHITE + targetUser + " pour " + ChatColor.DARK_RED + Mutereason);
                } else if (player.hasPermission("lodaria.mod.supermod")) {
                    if (muteDuration > (365 * 24 * 60 * 60 * 1000L)) { // Maximum 1 an
                        player.sendMessage(ChatColor.RED + "Vous ne pouvez pas muter un joueur pour plus d'un an.");
                        return false;
                    }
                    mutePlayer(targetMute, muteDuration);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Mute de " + ChatColor.WHITE + targetUser + " pour " + ChatColor.DARK_RED + Mutereason);
                } else if (player.hasPermission("lodaria.mod.conf")) {
                    if (muteDuration > (3 * 30 * 24 * 60 * 60 * 1000L)) { // Maximum 3 mois
                        player.sendMessage(ChatColor.RED + "Vous ne pouvez pas muter un joueur pour plus de 3 mois.");
                        return false;
                    }
                    mutePlayer(targetMute, muteDuration);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Mute de " + ChatColor.WHITE + targetUser + " pour " + ChatColor.DARK_RED + Mutereason);
                } else if (player.hasPermission("lodaria.mod.chat")) {
                    if (muteDuration > (30 * 24 * 60 * 60 * 1000L)) { // Maximum 1 mois
                        player.sendMessage(ChatColor.RED + "Vous ne pouvez pas muter un joueur pour plus d'un mois.");
                        return false;
                    }
                    mutePlayer(targetMute, muteDuration);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Mute de " + ChatColor.WHITE + targetUser + " pour " + ChatColor.DARK_RED + Mutereason);
                } else {
                    player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
                    return false;
                }
                break;
            case "mute":
                /*
                 * Format command
                 * /ss mute [User] [temps] [raison]
                 * s -- seconde | m -- mois | a -- année | d -- jour
                 */

                // Vérification des permissions
                if (args.length < 4) {
                    player.sendMessage(ChatColor.RED + "Utilisation incorrecte. Format: /ss mute [User] [temps] [raison]");
                    return false;
                }

                String targetCMDSUser = args[1];
                String timeCMDSArg = args[2];
                String MuteCMDSreason = String.join(" ", Arrays.copyOfRange(args, 3, args.length));

                Player targetCMDSMute = Bukkit.getPlayer(targetCMDSUser);

                if (targetCMDSMute == null) {
                    player.sendMessage(ChatColor.RED + "Le joueur " + targetCMDSUser + " n'est pas en ligne.");
                    return false;
                }

                long muteCMDSDuration = parseDuration(timeCMDSArg);

                if (muteCMDSDuration <= 0) {
                    player.sendMessage(ChatColor.RED + "Temps invalide spécifié.");
                    return false;
                }
                if (targetCMDSMute.hasPermission("lodaria.mod.bypass")){
                    player.sendMessage(ChatColor.DARK_RED + "Il semble de cette personne soit immuniser  contre ce genre de tour :)");
                    return true;
                }

                // Gestion des permissions et des limitations
                if (player.hasPermission("lodaria.mod.rstaff") || player.hasPermission("lodaria.mod.admin")) {
                    // Peut mute sans limite
                    mutePlayer(targetCMDSMute, muteCMDSDuration);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Mute de " + ChatColor.WHITE + targetCMDSUser + " pour " + ChatColor.DARK_RED + MuteCMDSreason);
                } else if (player.hasPermission("lodaria.mod.rgameplay")) {
                    // Peut mute sans limite
                    mutePlayer(targetCMDSMute, muteCMDSDuration);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Mute de " + ChatColor.WHITE + targetCMDSUser + " pour " + ChatColor.DARK_RED + MuteCMDSreason);
                } else if (player.hasPermission("lodaria.mod.supermod")) {
                    if (muteCMDSDuration > (365 * 24 * 60 * 60 * 1000L)) { // Maximum 1 an
                        player.sendMessage(ChatColor.RED + "Vous ne pouvez pas muter un joueur pour plus d'un an.");
                        return false;
                    }
                    mutePlayer(targetCMDSMute, muteCMDSDuration);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Mute de " + ChatColor.WHITE + targetCMDSUser + " pour " + ChatColor.DARK_RED + MuteCMDSreason);
                } else if (player.hasPermission("lodaria.mod.conf")) {
                    if (muteCMDSDuration > (3 * 30 * 24 * 60 * 60 * 1000L)) { // Maximum 3 mois
                        player.sendMessage(ChatColor.RED + "Vous ne pouvez pas muter un joueur pour plus de 3 mois.");
                        return false;
                    }
                    mutePlayer(targetCMDSMute, muteCMDSDuration);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Mute de " + ChatColor.WHITE + targetCMDSUser + " pour " + ChatColor.DARK_RED + MuteCMDSreason);
                } else if (player.hasPermission("lodaria.mod.chat")) {
                    if (muteCMDSDuration > (30 * 24 * 60 * 60 * 1000L)) { // Maximum 1 mois
                        player.sendMessage(ChatColor.RED + "Vous ne pouvez pas muter un joueur pour plus d'un mois.");
                        return false;
                    }
                    muteCMDSPlayer(targetCMDSMute, muteCMDSDuration);
                    Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Mute de " + ChatColor.WHITE + targetCMDSUser + " pour " + ChatColor.DARK_RED + MuteCMDSreason);
                } else {
                    player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
                    return false;
                }
                break;

            case "gui":
                openStaffGUI(player);
                break;

            case "unmute":
                /*
                 * Format command
                 * /ss unmute [User]
                 */

                // Vérification des permissions
                if (!player.hasPermission("lodaria.mod.rstaff") &&
                        !player.hasPermission("lodaria.mod.admin") &&
                        !player.hasPermission("lodaria.mod.rgameplay") &&
                        !player.hasPermission("lodaria.mod.supermod")) {
                    player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
                    return false;
                }

                // Vérification du format de la commande
                if (args.length < 2) {
                    player.sendMessage(ChatColor.RED + "Utilisation incorrecte. Format: /ss unmute [User]");
                    return false;
                }

                // Récupération du pseudo du joueur
                String targetUnmute = args[1];

                // Vérification si le joueur est dans la liste des muets
                if (!TempMutedPlayers.contains(targetUnmute)) {
                    player.sendMessage(ChatColor.RED + "Le joueur " + targetUnmute + " n'est pas muté.");
                    return false;
                }

                // Retrait du joueur de la liste des muets temporaires
                TempMutedPlayers.remove(targetUnmute);

                // Vérification si le joueur est en ligne
                Player targetMuted = Bukkit.getPlayer(targetUnmute);
                if (Bukkit.getOnlinePlayers().contains(targetMuted)) {
                    targetMuted.sendMessage(ChatColor.GREEN + "Vous avez été unmuté. Vous pouvez parler à nouveau !");
                }

                // Annonce de l'unmute à tous les joueurs
                Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + "Unmute de " + ChatColor.WHITE + targetUnmute);

                break;

            case "banlist":
                // Vérification des permissions
                if (!player.hasPermission("lodaria.mod.supermod")) {
                    player.sendMessage(ChatColor.RED + "Vous n'avez pas la permission d'utiliser cette commande.");
                    return false;
                }

                // Récupération de la liste des bannis
                BanList<Player> banListList = Bukkit.getBanList(BanList.Type.PROFILE);

                // Vérification si la liste est vide
                if (Bukkit.getBannedPlayers().isEmpty()) {
                    player.sendMessage(ChatColor.YELLOW + "Il n'y a actuellement aucun joueur banni.");
                    return true;
                }

                // Envoi de la liste des joueurs bannis au joueur
                player.sendMessage(ChatColor.GOLD + "Liste des joueurs bannis :");
                for (BanEntry<Player>  banEntryList : banListList.getEntries()) {
                    player.sendMessage(ChatColor.WHITE + "- " + banEntryList.getBanTarget() + " (banni par: " + banEntryList.getSource() + ")");
                }

                break;


            default:
                player.sendMessage(ChatColor.RED + "Commande non reconnue.");
        }



        return true;
    }

    private void muteCMDSPlayer(Player targetCMDSMute, long muteCMDSDuration) {
        CMDMutedPlayers.add(targetCMDSMute.getName());
    }

    private void mutePlayer(Player targetPlayer, long muteDuration) {
        // TempMute
        TempMutedPlayers.add(targetPlayer.getName());
        //Mute
        if (muteDuration == -1){
            MutedPlayers.add(targetPlayer.getName());
        }

    }

    private void openStaffGUI(Player player) {
        // Crée un inventaire de type coffre avec 9 emplacements (modifiable si plus de joueurs avec la permission)
        Inventory staffGUI = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Staff Connecté");

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            // Vérifie si le joueur a la permission lodaria.mod ou plus
            if (onlinePlayer.hasPermission("lodaria.mod")) {
                // Crée un item représentant le joueur
                ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
                ItemMeta meta = playerHead.getItemMeta();
                meta.setDisplayName(ChatColor.GREEN + onlinePlayer.getName());

                // Ajoute des informations sur la santé et l'expérience
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.YELLOW + "Santé: " + ChatColor.RED + onlinePlayer.getHealth() + "/" + onlinePlayer.getMaxHealth());
                lore.add(ChatColor.YELLOW + "Niveau d'expérience: " + ChatColor.AQUA + onlinePlayer.getLevel());
                meta.setLore(lore);

                playerHead.setItemMeta(meta);

                // Ajoute l'item à l'inventaire
                staffGUI.addItem(playerHead);
            }
        }

        // Ouvre l'inventaire pour le joueur
        player.openInventory(staffGUI);
    }

    /**
     * Formate la durée de temps en une chaîne lisible.
     */

    private long parseDuration(String timeInput) {
        try {
            char unit = timeInput.charAt(timeInput.length() - 1);
            long timeValue = Long.parseLong(timeInput.substring(0, timeInput.length() - 1));

            switch (unit) {
                case 's': // secondes
                    return timeValue * 1000;
                case 'd': // jours
                    return timeValue * 24 * 60 * 60 * 1000;
                case 'm': // mois
                    return timeValue * 30L * 24 * 60 * 60 * 1000;
                case 'a': // années
                    return timeValue * 365L * 24 * 60 * 60 * 1000;
                default:
                    return -1; // Format incorrect
            }
        } catch (NumberFormatException e) {
            return -1; // Format incorrect
        }
    }

    // Stockage des derniers temps de kick pour chaque joueur


    // Méthode pour récupérer le dernier temps de kick d'un joueur
    private long getLastKickTime(Player player) {
        return lastKickTimes.getOrDefault(player.getUniqueId(), 0L);
    }

    // Méthode pour mettre à jour le dernier temps de kick d'un joueur
    private void updateLastKickTime(Player player) {
        lastKickTimes.put(player.getUniqueId(), System.currentTimeMillis());
    }


    private String formatTime(long duration) {
        long seconds = duration / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        if (days > 0) {
            return days + " jours";
        } else if (hours > 0) {
            return hours + " heures";
        } else if (minutes > 0) {
            return minutes + " minutes";
        } else {
            return seconds + " secondes";
        }
    }

    private void banPlayer(Player targetPlayer, long duration, String banReasen) {
        BanList<Player> banList = Bukkit.getBanList(BanList.Type.PROFILE);

        // Calcul de la date de fin de ban
        long endTime = System.currentTimeMillis() + duration;
        Date endDate = new Date(endTime);

        // Ajouter l'entrée de bannissement
        banList.addBan(targetPlayer, banReasen, endDate,null);

        if (duration == -1){
            // banList.addBan(targetPlayer,banReasen, null);
        }

        // Déconnecter le joueur s'il est en ligne
        if (targetPlayer.isOnline()) {
           String reasen = ChatColor.DARK_RED + banReasen;

            targetPlayer.kickPlayer("Vous avez été temporairement banni: "+ reasen);
        }
    }
}

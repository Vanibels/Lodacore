package fr.vanibels.lodacore.cloud;

import fr.vanibels.lodacore.Managers.DBConnection;
import fr.vanibels.lodacore.Managers.DBManagers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CloudExecutor<PlayerInfo> implements CommandExecutor {

    private UUID uuid;
    private String username;
    private String grade;
    private String lastConnexion;
    private String lastDeconnexion;


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // Vérifie que l'expéditeur de la commande est un joueur
        if (!(sender instanceof Player)) {
            sender.sendMessage("Cette commande ne peut être exécutée que par un joueur.");
            return false;
        }

        Player player = (Player) sender;

        // Vérifie que le joueur possède la permission nécessaire
        if (!player.hasPermission("lodaria.cloud.info")) {
            player.sendMessage("Vous n'avez pas la permission pour utiliser cette commande.");
            return false;
        }

        // Vérifie qu'il y a des arguments
        if (args.length < 1) {
            player.sendMessage("Usage : /ecloud help");
            return false;
        }

        // Utilise un switch pour les différents arguments possibles
        switch (args[0].toLowerCase()) {
            case "info":
                // Vérifie qu'il y a un second argument pour spécifier le joueur cible
                if (args.length == 2) {
                    String targetPlayer = args[1];
                    // Logique pour afficher les informations du joueur cible
                    player.sendMessage("Affichage des informations pour : " + targetPlayer);
                    try {
                        getPlayerInfoByName(targetPlayer);

                        player.sendMessage(ChatColor.BLUE +"---------------------------------------------------");
                        if (Bukkit.getOnlinePlayers().contains(targetPlayer)){player.sendMessage(ChatColor.GOLD +"Statue " + ChatColor.GREEN + "Connecté");}else {player.sendMessage(ChatColor.GOLD +"Statue " + ChatColor.RED + "Déconnecté");}
                        player.sendMessage(ChatColor.GOLD +"Nom " + ChatColor.WHITE + username);
                        player.sendMessage(ChatColor.GOLD +"UUID " + ChatColor.WHITE + uuid);
                        player.sendMessage(ChatColor.GOLD +"grade " + ChatColor.WHITE + grade);
                        player.sendMessage(ChatColor.GOLD +"Dernier connexion " + ChatColor.WHITE + lastConnexion);
                        player.sendMessage(ChatColor.GOLD +"Dernier deconnexion " + ChatColor.WHITE + lastDeconnexion);
                        player.sendMessage(ChatColor.GOLD +"Faction " + ChatColor.WHITE + "Comming ....");
                        player.sendMessage(ChatColor.GOLD +"Historique des sanction " + ChatColor.WHITE + "Comming ....");
                        player.sendMessage(ChatColor.BLUE +"---------------------------------------------------");

                    } catch (SQLException e) {
                        player.sendMessage("Une eurreur est survenue ! contact vanibles");
                        throw new RuntimeException(e);
                    }
                } else {
                    player.sendMessage("Usage : /ecloud info [player]");
                }
                break;

            default:
                // Si l'argument ne correspond à aucune commande
                player.sendMessage("Commande inconnue. Usage : /ecloud info [player]");
                break;
        }

        return true;
    }
    public void getPlayerInfoByName(String playerName) throws SQLException {
        // Récupère la connexion principale via DBManagers
        final DBManagers dbManagers = new DBManagers();
        final DBConnection dbConnection = dbManagers.getMainConnection();
        final String sql = "SELECT uuid, playerUserName, Grade, LastConnexion, LastDeconnexion FROM player WHERE playerUserName = ?";
        Connection connection = dbConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        // Définit le nom du joueur dans la requête préparée
        statement.setString(1, playerName);

        // Exécute la requête et récupère les résultats
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            uuid = UUID.fromString(resultSet.getString("uuid"));
            grade = resultSet.getString("Grade");
            lastConnexion = resultSet.getString("LastConnexion");
            lastDeconnexion = resultSet.getString("LastDeconnexion");
            username = playerName;
            // Retourne un objet PlayerInfo avec les informations récupérées
            return ;
        }
    }
}

package fr.vanibels.lodacore.Events;

import fr.vanibels.lodacore.Managers.DBConnection;
import fr.vanibels.lodacore.Managers.PlayerManagers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.*;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

import static fr.vanibels.lodacore.Lodacore.*;

public class PlayerConnectionEvent implements Listener {
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e){
        Player player = e.getPlayer();
        String playerName = e.getPlayer().getName();
        final UUID uuid = e.getPlayer().getUniqueId();

        /*final DBConnection ss = instance.getDbManagers().getMainConnection();

        try {
            final Connection connection = ss.getConnection();

            final PreparedStatement ppst = connection.prepareStatement("SELECT uuid , sanction FROM player WHERE uuid = ?");

            ppst.setString(1, uuid.toString());

            final ResultSet rs = ppst.executeQuery();

            if (!rs.next()){
                CreateUserProfil(connection,player,uuid);
            }


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        */
        OnlinePlayer.add(e.getPlayer());
        if (!instance.modList.isEmpty()){
            for (int i = 0; i < instance.modList.size(); i++) {
                Player moderator = Bukkit.getPlayer(instance.modList.get(i));
                assert moderator != null;
                player.hidePlayer(instance, moderator);
            }
        }
        player.setGameMode(GameMode.SURVIVAL);
        String message = (ChatColor.WHITE + "["+ ChatColor.GREEN + "+"+ChatColor.WHITE+ "] " + playerName);
        player.sendMessage(ChatColor.GRAY + "-------------------------------------------");
        player.sendMessage(ChatColor.BLUE + "Bienvenue sur Lodaria");
        player.sendMessage(ChatColor.BLUE + "Connecter entant que " + playerName);
        player.sendMessage(ChatColor.BLUE + "Viens sur discord: /discord ");
        player.sendMessage(ChatColor.BLUE + "/spawn pour aller au spawn: ");
        player.sendMessage(ChatColor.GRAY + "-------------------------------------------");
        e.setJoinMessage(message);
        // mettre le ressource pack du serveur
        // player.setResourcePack("https://www.curseforge.com/minecraft/texture-packs/better-details-texture-models-pack");
        player.sendTitle(ChatColor.GOLD +"Lodaria", ChatColor.GREEN +"1.21");
    }
    @EventHandler
    public void PlayerLogoutEvent(PlayerQuitEvent e){
        Player player = e.getPlayer();

        /*try {
            UpdateUserProfilDeconnexion(instance.getDbManagers().getMainConnection().getConnection(), e.getPlayer().getUniqueId());
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }*/
        OnlinePlayer.remove(e.getPlayer());
        if (instance.modList.contains(player.getUniqueId())) {
            PlayerManagers pm = PlayerManagers.getFromPlayer(player);
            instance.modList.remove(player.getUniqueId());
            player.sendMessage(ChatColor.RED + "Mod modérateur désactivé.");
            player.getInventory().clear();
            pm.giveIventory();
            pm.destroy();
            player.setAllowFlight(false);
            player.setFlying(false);
        }
        if (instance.vList.contains(e.getPlayer())) instance.vList.remove(e.getPlayer());
        String playerName = e.getPlayer().getName();
        e.setQuitMessage(ChatColor.WHITE + "["+ ChatColor.RED+ "-"+ChatColor.WHITE+ "] " + playerName);
    }

    @EventHandler
    public void PlayerLoginEvent(PlayerLoginEvent e){
       if (isMaintenance){
           if (!e.getPlayer().hasPermission("lodaria.maintenance")){
               // Message de kick personnalisé récupéré depuis le config.yml
               String kickMessage = instance.getConfig().getString("maintenance.kickMessage");
               // Empêcher la connexion du joueur avec un message personnalisé
               assert kickMessage != null;
               e.disallow(PlayerLoginEvent.Result.KICK_OTHER, kickMessage);
           }
       }
    }/*
    public void CreateUserProfil(Connection connection, Player player, UUID uuid){
        try {
            final PreparedStatement ppst = connection.prepareStatement("INSERT INTO player VALUES ?, ?, ?, ?, ?");
            final long time = System.currentTimeMillis();
            ppst.setString(1,uuid.toString());
            ppst.setString(2, player.getName());
            ppst.setString(3,"Roturier");
            ppst.setTimestamp(4,new Timestamp(time));
            ppst.setTimestamp(5,new Timestamp(time));
            ppst.executeUpdate();
            Logger.getLogger("Minecraft").info("Création du profil de " + player.getName()+ " UUID " + uuid.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void UpdateUserProfilDeconnexion(Connection connection, UUID uuid){
        try {
            final PreparedStatement ppst = connection.prepareStatement("UPDATE player SET LastDeconnexion = ? WHERE uuid = ?");
            final long time = System.currentTimeMillis();

            ppst.setTimestamp(1,new Timestamp(time));
            ppst.setString(2,uuid.toString());
            ppst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

}

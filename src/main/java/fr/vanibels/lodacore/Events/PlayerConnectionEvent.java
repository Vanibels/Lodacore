package fr.vanibels.lodacore.Events;

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

import java.util.Objects;

import static fr.vanibels.lodacore.Lodacore.*;

public class PlayerConnectionEvent implements Listener {
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e){
        OnlinePlayer.add(e.getPlayer());
        Player player = e.getPlayer();
        String playerName = e.getPlayer().getName();



        player.setGameMode(GameMode.SURVIVAL);
        player.teleport(instance.spawn);
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
        player.sendTitle(ChatColor.RED +"Lodaria", ChatColor.GREEN +"1.21");
    }
    @EventHandler
    public void PlayerLogoutEvent(PlayerQuitEvent e){
        OnlinePlayer.remove(e.getPlayer());
        if (instance.modList.contains(e.getPlayer())) {
            instance.modList.remove(e.getPlayer());
            Player player = e.getPlayer();

            PlayerManagers pm = new PlayerManagers(player);
            pm.destroy();
            pm.giveIventory();
        }
        if (instance.vList.contains(e.getPlayer())) instance.vList.remove(e.getPlayer());
        Player player = e.getPlayer();
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
    }

    @EventHandler
    public void onWorld(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        // player.getInventory().clear();

    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Entity entity= e.getEntity();
        if (!(entity instanceof Player)){
            return;
        }
        e.setKeepInventory(true);
        e.setNewLevel(0);
        e.setNewExp(0);
        e.setDeathMessage(null);
        Location spawn = instance.spawn;
        entity.teleport(spawn);


    }

}

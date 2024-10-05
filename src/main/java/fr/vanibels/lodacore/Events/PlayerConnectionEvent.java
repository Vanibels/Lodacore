package fr.vanibels.lodacore.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

import static fr.vanibels.lodacore.Lodacore.*;

public class PlayerConnectionEvent implements Listener {
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e){
        OnlinePlayer.add(e.getPlayer());
    }
    @EventHandler
    public void PlayerLogoutEvent(PlayerQuitEvent e){
        OnlinePlayer.remove(e.getPlayer());
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

}

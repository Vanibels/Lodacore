package fr.vanibels.lodacore.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static fr.vanibels.lodacore.Lodacore.OnlinePlayer;

public class PlayerConnectionEvent implements Listener {
    @EventHandler
    public void PlayerLoginEvent(PlayerJoinEvent e){
        OnlinePlayer.add(e.getPlayer());
    }
    @EventHandler
    public void PlayerLogoutEvent(PlayerQuitEvent e){
        OnlinePlayer.remove(e.getPlayer());
    }

    /*@EventHandler
    public void ServerRestartEvent()
    */
}

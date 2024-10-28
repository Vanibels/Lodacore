package fr.vanibels.lodacore.Events;

import fr.vanibels.lodacore.Managers.PlayerManagers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static fr.vanibels.lodacore.Lodacore.instance;

public class ModQuitEvent implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();

        if (instance.modList.contains(player.getUniqueId())){
            instance.modList.add(player.getUniqueId());
            player.setAllowFlight(true);
            player.setFlying(true);
            PlayerManagers pm = PlayerManagers.getFromPlayer(player);
            player.getInventory().clear();
            pm.giveIventory();
            pm.destroy();
        }
    }
}

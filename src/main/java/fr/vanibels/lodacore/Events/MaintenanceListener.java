package fr.vanibels.lodacore.Events;

import fr.vanibels.lodacore.Lodacore;
import fr.vanibels.lodacore.Commands.CommandMaintExecutor;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class MaintenanceListener implements Listener {
    private final Lodacore plugin;

    public MaintenanceListener(Lodacore plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        if (plugin.isMaintenanceMode()) {
            String playerName = event.getPlayer().getName();
            if (!plugin.getAllowedPlayers().contains(playerName)) {
                event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, ChatColor.RED + "Le serveur est en mode maintenance.");
            }
        }
    }
}

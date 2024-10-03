package fr.vanibels.lodacore.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import static fr.vanibels.lodacore.Lodacore.*;

public class
ModChatListener implements Listener {
    @EventHandler
    public void ModChatEvent(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String message = event.getMessage();

        if (!player.hasPermission("lodaria.modMessage")) return;
        if (!message.startsWith("$")) return;

        event.setCancelled(true);

        String ModMessage = ChatColor.DARK_GRAY+ "["+ ChatColor.DARK_RED+"STAFF CHAT"+ ChatColor.DARK_GRAY+"] " +ChatColor.GOLD+ player.getDisplayName() + "-" + ChatColor.WHITE + message.replace('$',' ');

        // Parcours tous les joueurs en ligne
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("lodaria.modMessage")){
                onlinePlayer.sendMessage(ModMessage);
            }
        }
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (MutedPlayers.contains(player.getName()) || TempMutedPlayers.contains(player.getName())) {
            player.sendMessage(ChatColor.RED + "Vous êtes réduit au silence et ne pouvez pas parler.");
            event.setCancelled(true); // Empêche le message d'être envoyé
        }
    }
}

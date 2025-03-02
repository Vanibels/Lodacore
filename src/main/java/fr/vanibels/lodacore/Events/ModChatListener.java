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

        String ModMessage = ChatColor.DARK_GRAY+ "["+ ChatColor.DARK_RED+"SUPER STAFF CHAT"+ ChatColor.DARK_GRAY+"] " +ChatColor.GOLD+ player.getDisplayName() + "-" + ChatColor.WHITE + message.replace('$',' ');

        // Parcours tous les joueurs en ligne
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.hasPermission("lodaria.modMessage")){
                onlinePlayer.sendMessage(ModMessage);
            }
        }
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (event.getMessage().startsWith("/"))return;
        if (MutedPlayers.contains(player.getName()) || TempMutedPlayers.contains(player.getName())) {
            player.sendMessage(ChatColor.RED + "Vous êtes réduit au silence et ne pouvez pas parler.");
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (player.hasPermission("lodaria.modMessage")){
                    onlinePlayer.sendMessage(ChatColor.GRAY + "Muted player message --- " + player.getName() + " " + event.getMessage());
                }
            }
            event.setCancelled(true); // Empêche le message d'être envoyé
        }

        if (CMDMutedPlayers.contains(player.getName())){
            player.sendMessage(ChatColor.RED + "Vous ne pouvez utiliser que les commandes de base pendant la duré de votre sanction");
            String message = event.getMessage();
            if (message.startsWith("/spawn") || message.startsWith("/helpop") || message.startsWith("/warp") || message.startsWith("/f") || message.startsWith("/r") || message.startsWith("/menu") || message.startsWith("/arene") || message.startsWith("/wz") || message.startsWith("/warzone") || message.startsWith("/ar") || message.startsWith("/tuto")|| message.startsWith("/site")|| message.startsWith("/ts")|| message.startsWith("/discord")|| message.startsWith("/boutique")) return;

            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                if (player.hasPermission("lodaria.modMessage")){
                    onlinePlayer.sendMessage(ChatColor.GRAY + "Muted player message --- " + player.getName() + " " +  event.getMessage());
                }
            }
            event.setCancelled(true); // Empêche le message d'être envoyé
        }

    }
}

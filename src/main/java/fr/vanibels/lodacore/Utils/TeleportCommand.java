package fr.vanibels.lodacore.Utils;

import fr.vanibels.lodacore.Lodacore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class TeleportCommand {

    private final HashMap<UUID, Long> cooldowns = new HashMap<>();
    private final long cooldownTime = 15 * 1000; // 15 seconds in milliseconds
    private final int teleportDelaySeconds = 5; // 5 seconds delay before teleport

    public void teleportWithDelayAndCooldown(Player player, Location targetLocation) {
        UUID playerId = player.getUniqueId();

        if (player.hasPermission("lodaria.user.teleport.bypass")){
            player.teleport(targetLocation);
            player.sendMessage(ChatColor.GREEN + "Vous êtes maintenant à votre destination !");
            return;
        }

        long currentTime = System.currentTimeMillis();

        // Vérifie si le cooldown est actif
        if (cooldowns.containsKey(playerId) && currentTime - cooldowns.get(playerId) < cooldownTime) {
            long remainingTime = (cooldownTime - (currentTime - cooldowns.get(playerId))) / 1000;
            player.sendMessage(ChatColor.RED + "Vous devez attendre encore " + remainingTime + " secondes avant de vous téléporter.");
            return;
        }

        // Applique le cooldown
        cooldowns.put(playerId, currentTime);
        // Compte à rebours et téléportation
        new BukkitRunnable() {
            int countdown = teleportDelaySeconds;

            @Override
            public void run() {
                if (countdown > 0) {
                    player.sendMessage(ChatColor.YELLOW + "Il reste " + countdown + " secondes avant la téléportation...");
                    countdown--;
                } else {
                    player.teleport(targetLocation);
                    player.sendMessage(ChatColor.GREEN + "Vous êtes maintenant à votre destination !");
                    cancel(); // Annule la tâche après la téléportation
                }
            }
        }.runTaskTimer(Lodacore.instance, 0, 20); // Exécute la tâche toutes les secondes (20 ticks)
    }
}

package fr.vanibels.lodacore.Managers.Task;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TeleportTask extends BukkitRunnable {
    private final Player player;
    private final Location targetLocation;
    private final Location initialLocation;
    private int timer = 5;

    public TeleportTask(Player player, Location targetLocation) {
        this.player = player;
        this.targetLocation = targetLocation;
        this.initialLocation = player.getLocation().clone(); // Stocke la position initiale
    }

    @Override
    public void run() {
        // Si le joueur a la permission de bypass, téléportation instantanée
        if (player.hasPermission("lodaria.user.teleport.bypass")) {
            player.teleport(targetLocation);
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Téléportation" + ChatColor.DARK_GRAY + "] " + ChatColor.GREEN + "Téléportation instantanée !");
            cancel();
            return;
        }

        // Vérifie si le joueur a bougé
        if (hasPlayerMoved()) {
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Téléportation" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + "Téléportation annulée, vous avez bougé !");
            cancel();
            return;
        }

        // Si le timer atteint 0, on téléporte le joueur
        if (timer <= 0) {
            player.teleport(targetLocation);
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Téléportation" + ChatColor.DARK_GRAY + "] " + ChatColor.GREEN + "Téléportation effectuée !");
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f); // Ajout d’un son
            cancel();
            return;
        }

        // Affichage du message de compte à rebours avec son
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Téléportation" + ChatColor.DARK_GRAY + "] " + ChatColor.YELLOW + "Téléportation dans " + ChatColor.GOLD + timer + ChatColor.YELLOW + " secondes...");
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 1.0f); // Son indicatif
        timer--;
    }

    // Vérifie si le joueur a bougé en ignorant les variations mineures en hauteur
    private boolean hasPlayerMoved() {
        Location currentLocation = player.getLocation();
        return !initialLocation.getWorld().equals(currentLocation.getWorld()) ||
                initialLocation.getX() != currentLocation.getX() ||
                initialLocation.getZ() != currentLocation.getZ();
    }
}

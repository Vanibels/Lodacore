package fr.vanibels.lodacore.Managers;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class TeleportTask extends BukkitRunnable {
    private final Player player;
    private final Location location;
    private int timer = 5; // No need for static here

    public TeleportTask(Player player, Location location){
        this.player = player;
        this.location = location;
    }

    @Override
    public void run() {

        Location currentLocation = player.getLocation();

        if (player.hasPermission("lodaria.user.teleport.bypass")) {
            player.teleport(location);
            return;
        }

        if (timer <= 0) {
            cancel();
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Teleportation" + ChatColor.DARK_GRAY + "]" +ChatColor.GREEN + " Teleportation imminante");
            return;
        }

        if (!currentLocation.equals(player.getLocation())) { // Better way to compare locations
            player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Teleportation" + ChatColor.DARK_GRAY + "]" +ChatColor.GREEN + " Teleportation impossible");
            cancel();
        } else {
            player.teleport(location);
            cancel();
        }

        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_AQUA + "Teleportation" + ChatColor.DARK_GRAY + "]" + ChatColor.YELLOW + " Teleportation dans " + timer + " secondes");
        timer--;
    }
}

package fr.vanibels.lodacore.Managers.Task;

import fr.vanibels.lodacore.Lodacore;
import fr.vanibels.lodacore.Managers.Utils.ServerState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static fr.vanibels.lodacore.Lodacore.instance;

public class StartTimerTask extends BukkitRunnable {
    private final Player Executor;
    private int Timer;

    public StartTimerTask(int Timer, Player Executor) {
        this.Timer = Timer;
        this.Executor = Executor;
    }

    @Override
    public void run() {
        if (Timer <= 0) {
            Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + " Activation de la maintenance");
            SetMaint(Executor);
            cancel();
            return;
        }

        // Annonces aux moments clés
        if (Timer == 5 * 60) announceMaintenance(5, "minute");
        if (Timer == 3 * 60) announceMaintenance(3, "minute");
        if (Timer == 120) announceMaintenance(2, "minute");
        if (Timer == 60) announceMaintenance(1, "minute");
        if (Timer == 30) announceMaintenance(30, "secondes");
        if (Timer <= 10 && Timer >= 1) announceMaintenance(Timer, "secondes");

        Executor.sendMessage(instance.prefix + ChatColor.DARK_GRAY + " [" + ChatColor.DARK_AQUA + "DEBUGGER" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_PURPLE + Timer);
        Timer--;
    }

    private void announceMaintenance(int time, String unit) {
        Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + " Maintenance dans " + ChatColor.RESET + time + " " + unit);
    }

    private void SetMaint(Player executor) {
        ServerState state = instance.getSSTATE();

        if (state == ServerState.MAINTENANCE) {
            executor.sendMessage(ChatColor.RED + "Le serveur est déjà en mode maintenance.");
            return;
        }

        if (state == ServerState.WAITING) {
            executor.sendMessage(ChatColor.DARK_RED + "La procédure est en cours.");
            return;
        }

        instance.setSSTATE(ServerState.MAINTENANCE);
        Bukkit.setWhitelistEnforced(true);

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!onlinePlayer.hasPermission("lodaria.maintenance")) {
                onlinePlayer.kickPlayer(ChatColor.RED + "Serveur en maintenance de retour sous peu ;)");
            }
        }

        Bukkit.setWhitelist(true);
        instance.setIsMaintenance(true);
        Bukkit.setMotd("§c§lMaintenance en cours ! §eBientôt de retour!");

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.sendTitle(ChatColor.GOLD + "Maintenance activée", "");
        }

        Bukkit.getLogger().info("Maintenance du serveur activée par " + executor.getDisplayName() + " --- " + executor.getName() + " --- " + executor.getUniqueId());
    }
}

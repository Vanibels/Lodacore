package fr.vanibels.lodacore.Managers.Task;

import fr.vanibels.lodacore.Managers.Utils.ServerState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static fr.vanibels.lodacore.Lodacore.instance;

public class EndTimerTask extends BukkitRunnable {
    private int Timer;
    private final Player Executor;

    public EndTimerTask(int Timer, Player Executor) {
        this.Timer = Timer;
        this.Executor = Executor;
    }

    @Override
    public void run() {
        if (Timer <= 0) {
            Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + " Ouverture");
            UnSetMaint(Executor);
            instance.setSSTATE(ServerState.OPEN);
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
        Bukkit.broadcastMessage(instance.prefix + ChatColor.GOLD + " Fin maintenance dans " + ChatColor.RESET + time + " " + unit);
    }

    private void UnSetMaint(Player executor) {
        ServerState EState = instance.getSSTATE();

        if (EState == ServerState.WAITING) {
            executor.sendMessage(ChatColor.DARK_RED + " La procédure est en cours.");
            return;
        }

        if (EState != ServerState.MAINTENANCE) {
            executor.sendMessage(ChatColor.DARK_RED + " Le serveur n'est pas en maintenance.");
            return;
        }

        instance.setSSTATE(ServerState.OPEN);
        instance.setIsMaintenance(false);
        Bukkit.setWhitelist(false);
        Bukkit.setMotd("§6§l⚔\uFE0F §e§l[Événement PvP \\: Siège de Château] §6§l⚔\uFE0F   §7§lRejoignez la bataille \\! §c§l10vs10 §f- §9§lArchers, Guerriers §fet §a§lÉclaireurs §f\\!");

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.sendTitle(ChatColor.GOLD + "Maintenance désactivée", "");
        }

        Bukkit.getLogger().info("Maintenance du serveur désactivée par " + executor.getDisplayName() + " --- " + executor.getName() + " --- " + executor.getUniqueId());
    }
}

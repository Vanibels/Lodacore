package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Lodacore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CommandMaintExecutor implements CommandExecutor {
    private final Lodacore plugin;
    private boolean maintenanceMode = false;
    private File maintenanceFile;
    private YamlConfiguration maintenanceConfig;

    public CommandMaintExecutor(Lodacore plugin) {
        this.plugin = plugin;
        this.maintenanceFile = new File(plugin.getDataFolder(), "maintenance.json");

        if (!maintenanceFile.exists()) {
            try {
                maintenanceFile.createNewFile();
                this.maintenanceConfig = YamlConfiguration.loadConfiguration(maintenanceFile);
                maintenanceConfig.set("allowedPlayers", List.of());
                saveConfig();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.maintenanceConfig = YamlConfiguration.loadConfiguration(maintenanceFile);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Seuls les joueurs peuvent utiliser cette commande.");
            return true;
        }

        Player player = (Player) sender;

        // Commande pour activer/désactiver la maintenance
        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Utilisation: /maintenance <on/off> ou /maintenance add/remove <joueur>");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "on":
                activateMaintenance(player);
                break;

            case "off":
                deactivateMaintenance(player);
                break;

            case "add":
                if (args.length < 2) {
                    player.sendMessage(ChatColor.RED + "Usage: /maintenance add <joueur>");
                } else {
                    addPlayerToWhitelist(args[1], player);
                }
                break;

            case "remove":
                if (args.length < 2) {
                    player.sendMessage(ChatColor.RED + "Usage: /maintenance remove <joueur>");
                } else {
                    removePlayerFromWhitelist(args[1], player);
                }
                break;

            default:
                player.sendMessage(ChatColor.RED + "Utilisation incorrecte.");
        }
        return true;
    }

    private void activateMaintenance(Player player) {
        if (maintenanceMode) {
            player.sendMessage(ChatColor.RED + "Le mode maintenance est déjà activé.");
            return;
        }

        maintenanceMode = true;
        Bukkit.setWhitelist(true); // Activer la whitelist

        // Expulser tous les joueurs qui ne sont pas autorisés
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (!isPlayerWhitelisted(onlinePlayer.getName())) {
                onlinePlayer.kickPlayer(ChatColor.RED + "Le serveur est en mode maintenance. Rejoignez-nous plus tard.");
            }
        }

        Bukkit.broadcastMessage(ChatColor.RED + "Mode maintenance activé.");
        player.sendMessage(ChatColor.GREEN + "Mode maintenance activé.");
    }

    private void deactivateMaintenance(Player player) {
        if (!maintenanceMode) {
            player.sendMessage(ChatColor.RED + "Le mode maintenance est déjà désactivé.");
            return;
        }

        maintenanceMode = false;
        Bukkit.setWhitelist(false); // Désactiver la whitelist
        Bukkit.broadcastMessage(ChatColor.GREEN + "Mode maintenance désactivé.");
        player.sendMessage(ChatColor.GREEN + "Mode maintenance désactivé.");
    }

    private void addPlayerToWhitelist(String playerName, Player sender) {
        List<String> allowedPlayers = maintenanceConfig.getStringList("allowedPlayers");

        if (!allowedPlayers.contains(playerName)) {
            allowedPlayers.add(playerName);
            maintenanceConfig.set("allowedPlayers", allowedPlayers);
            saveConfig();

            sender.sendMessage(ChatColor.GREEN + playerName + " a été ajouté à la liste blanche de la maintenance.");
        } else {
            sender.sendMessage(ChatColor.RED + playerName + " est déjà dans la liste blanche.");
        }
    }

    private void removePlayerFromWhitelist(String playerName, Player sender) {
        List<String> allowedPlayers = maintenanceConfig.getStringList("allowedPlayers");

        if (allowedPlayers.contains(playerName)) {
            allowedPlayers.remove(playerName);
            maintenanceConfig.set("allowedPlayers", allowedPlayers);
            saveConfig();

            sender.sendMessage(ChatColor.GREEN + playerName + " a été retiré de la liste blanche de la maintenance.");
        } else {
            sender.sendMessage(ChatColor.RED + playerName + " n'est pas dans la liste blanche.");
        }
    }

    private boolean isPlayerWhitelisted(String playerName) {
        List<String> allowedPlayers = maintenanceConfig.getStringList("allowedPlayers");
        return allowedPlayers.contains(playerName);
    }

    private void saveConfig() {
        try {
            maintenanceConfig.save(maintenanceFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

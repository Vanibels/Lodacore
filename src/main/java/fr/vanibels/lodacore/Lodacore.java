package fr.vanibels.lodacore;

import fr.vanibels.lodacore.Commands.CommandListExecutor;
import fr.vanibels.lodacore.Commands.CommandMaintExecutor;
import fr.vanibels.lodacore.Commands.StaffGUICommand;
import fr.vanibels.lodacore.Commands.VanishCommand;
import fr.vanibels.lodacore.Events.MaintenanceListener;
import fr.vanibels.lodacore.Events.ModChatListener;
import fr.vanibels.lodacore.Events.PlayerConnectionEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class Lodacore extends JavaPlugin {
    private static LuckPerms luckPerms;

    public static List<Player> OnlinePlayer = new ArrayList<>();
    public static List<Player> BannedPlayer = new ArrayList<>();
    public static ArrayList<Player> TempBannedPlayer = new ArrayList<>();
    public static List<String> MutedPlayers = new ArrayList<>();
    public static List<String> TempMutedPlayers = new ArrayList<>();


    PluginManager pm = Bukkit.getPluginManager();
    private boolean maintenanceMode = false;
    private File maintenanceFile;
    private YamlConfiguration maintenanceConfig;
    @Override
    public void onEnable() {
        // Chargement ou création du fichier de configuration de la maintenance
        maintenanceFile = new File(getDataFolder(), "maintenance.json");
        if (!maintenanceFile.exists()) {
            try {
                maintenanceFile.createNewFile();
                maintenanceConfig = YamlConfiguration.loadConfiguration(maintenanceFile);
                maintenanceConfig.set("allowedPlayers", List.of());
                saveConfig();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            maintenanceConfig = YamlConfiguration.loadConfiguration(maintenanceFile);
        }

        // Init events
        pm.registerEvents(new ModChatListener(), this);
        pm.registerEvents(new PlayerConnectionEvent(), this);

        // Init Commands
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("staff").setExecutor(new StaffGUICommand(luckPerms));
        getCommand("list").setExecutor(new CommandListExecutor(luckPerms));
        getCommand("maintenance").setExecutor(new CommandMaintExecutor(this));
        pm.registerEvents(new MaintenanceListener(this), this);

        //
        getLogger().info("Lodaria Plugin activé !");
        // Initialisation du plugin
    }
    public static LuckPerms getLuckPerms() {
        return luckPerms;
    }

    @Override
    public void onDisable() {
        getLogger().info("Lodaria Plugin désactivé !");
        // Nettoyage avant la désactivation
    }


    public boolean isMaintenanceMode() {
        return maintenanceMode;
    }

    public void setMaintenanceMode(boolean maintenanceMode) {
        this.maintenanceMode = maintenanceMode;
    }

    public List<String> getAllowedPlayers() {
        return maintenanceConfig.getStringList("allowedPlayers");
    }

    public void saveConfig() {
        try {
            maintenanceConfig.save(maintenanceFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

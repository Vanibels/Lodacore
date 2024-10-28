package fr.vanibels.lodacore;

import fr.vanibels.lodacore.Commands.*;
import fr.vanibels.lodacore.Events.*;
import fr.vanibels.lodacore.KitManager.command.*;
import fr.vanibels.lodacore.KitManager.listener.*;
import fr.vanibels.lodacore.Managers.Database;
import fr.vanibels.lodacore.Managers.DatabaseManager;
import fr.vanibels.lodacore.Managers.PlayerManagers;
import fr.vanibels.lodacore.Utils.ServerState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class Lodacore extends JavaPlugin {

    public static List<Player> OnlinePlayer = new ArrayList<>();
    public static List<Player> BannedPlayer = new ArrayList<>();
    public static ArrayList<Player> TempBannedPlayer = new ArrayList<>();
    public static List<String> MutedPlayers = new ArrayList<>();
    public static List<String> TempMutedPlayers = new ArrayList<>();
    public static Lodacore instance;
    public static ServerState SSTATE = ServerState.OPEN;
    public static boolean isMaintenance = false;
    public ArrayList<UUID> modList = new ArrayList<>();
    public ArrayList<UUID> vList = new ArrayList<>();
    public ArrayList<UUID> freezList = new ArrayList<>();
    public boolean isVanish;
    public HashMap<UUID, PlayerManagers> players = new HashMap<UUID, fr.vanibels.lodacore.Managers.PlayerManagers>();
    public Location spawn = new Location(Bukkit.getWorld("world"),-306.500 ,71 ,103.500, 0F, 0F);
    public String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD +"LODARIA"+ ChatColor.DARK_GRAY + "]" + ChatColor.WHITE + " ";
    private DatabaseManager databaseManager;
    public Database database;
    PluginManager pm = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        SSTATE = ServerState.OPEN;
        instance= this;
        saveDefaultConfig();
        databaseManager = new DatabaseManager();
        try {
            databaseManager.connect();
            databaseManager.setupDatabase(); // Appel pour créer les tables si elles n'existent pas
        } catch (SQLException e) {
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
        }

        String url = getConfig().getString("database.url");
        String username = getConfig().getString("database.username");
        String password = getConfig().getString("database.password");

        database = new Database(url, username, password);
        try {
            database.connect();
            database.createTables();
        } catch (SQLException e) {
            e.printStackTrace();
            getLogger().severe("Impossible de se connecter à la base de données.");
        }

        // Init events
        Event();

        // Init Commands
        Command();
        //
        getLogger().info("Lodaria Plugin activé !");
        // Initialisation du plugin
    }

    @Override
    public void onDisable() {
        getLogger().info("Lodaria Plugin désactiation !");
        setSSTATE(ServerState.OPEN);
        databaseManager.disconnect();

        try {
            if (database != null) {
                database.disconnect();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Nettoyage avant la désactivation
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public Database getDatabase() {
        return database;
    }

    public void setSSTATE(ServerState state){
        SSTATE = state;
    }
    public ServerState getSSTATE(){
        return SSTATE;
    }

    public boolean getIsMaintenance(){
        return isMaintenance;
    }
    public void setIsMaintenance(boolean b){
        isMaintenance = b;
    }
    private void Event(){
        pm.registerEvents(new ModChatListener(), this);
        pm.registerEvents(new PlayerConnectionEvent(), this);
        pm.registerEvents(new ChevalierToolsListener(), this);
        pm.registerEvents(new DebugerToolsListener(), this);
        pm.registerEvents(new DieuToolsListener(), this);
        pm.registerEvents(new SeigneurToolsListener(), this);
        pm.registerEvents(new SurvivantToolsListener(), this);
        pm.registerEvents(new ModToolsListener(), this);
        pm.registerEvents(new ModQuitEvent(),this);
        pm.registerEvents(new ModeratorInteracEvent(),this);
        pm.registerEvents(new ModCancel(),this);
    }
    private void Command(){
        getCommand("sanction").setExecutor(new StaffCommand());
        getCommand("maintenance").setExecutor(new CommandMaintExecutor());
        getCommand("core").setExecutor(new CoreCommandExecutor());
        getCommand("sur").setExecutor(new SurExecutor());
        getCommand("che").setExecutor(new CheExecutor());
        getCommand("sei").setExecutor(new SeiExecutor());
        getCommand("dieu").setExecutor(new DieuExecutor());
        getCommand("debug").setExecutor(new DebugExecutor());
        getCommand("mod").setExecutor(new ModExecutor());
        getCommand("tuto").setExecutor(new CommandTutoExecutor());
        // getCommand("chat").setExecutor(new CommandChatExecutor());
        getCommand("testASOM").setExecutor(new CommandTestExecutor());
        getCommand("spawn").setExecutor(new CommandSpawnExecutor());
        getCommand("rstaff").setExecutor(new CommandRstaffExecutor());
        getCommand("arene").setExecutor(new CommandAreneExecutor());
        getCommand("s").setExecutor(new CommandShopExecutor());
        getCommand("discord").setExecutor(new CommandDiscordExecutor());
        getCommand("vote").setExecutor(new CommandVoteExecutor());
        getCommand("boutique").setExecutor(new CommandBoutiqueExecutor());
        getCommand("menu").setExecutor(new CommandMenuExecutor());
        getCommand("site").setExecutor(new CommandSiteExecutor());
        getCommand("bienvenue").setExecutor(new CommandBienvenueExecutor());
    }

}

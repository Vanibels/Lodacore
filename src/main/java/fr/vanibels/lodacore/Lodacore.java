package fr.vanibels.lodacore;

import fr.vanibels.lodacore.Commands.*;
import fr.vanibels.lodacore.Events.ModChatListener;
import fr.vanibels.lodacore.Events.PlayerConnectionEvent;
import fr.vanibels.lodacore.KitManager.command.*;
import fr.vanibels.lodacore.KitManager.listener.*;
import fr.vanibels.lodacore.Utils.ServerState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Lodacore extends JavaPlugin {

    public static List<Player> OnlinePlayer = new ArrayList<>();
    public static List<Player> BannedPlayer = new ArrayList<>();
    public static ArrayList<Player> TempBannedPlayer = new ArrayList<>();
    public static List<String> MutedPlayers = new ArrayList<>();
    public static List<String> TempMutedPlayers = new ArrayList<>();
    public static Lodacore instance;
    public static ServerState SSTATE = ServerState.OPEN;
    public static boolean isMaintenance = false;
    PluginManager pm = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        SSTATE = ServerState.OPEN;
        instance= this;
        saveDefaultConfig();
        // Init events
        pm.registerEvents(new ModChatListener(), this);
        pm.registerEvents(new PlayerConnectionEvent(), this);
        pm.registerEvents(new ChevalierToolsListener(), this);
        pm.registerEvents(new DebugerToolsListener(), this);
        pm.registerEvents(new DieuToolsListener(), this);
        pm.registerEvents(new SeigneurToolsListener(), this);
        pm.registerEvents(new SurvivantToolsListener(), this);
        pm.registerEvents(new ModToolsListener(), this);

        // Init Commands
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("staff").setExecutor(new StaffGUICommand());
        getCommand("maintenance").setExecutor(new CommandMaintExecutor());
        getCommand("core").setExecutor(new CoreCommandExecutor());
        getCommand("sur").setExecutor(new SurExecutor());
        getCommand("che").setExecutor(new CheExecutor());
        getCommand("sei").setExecutor(new SeiExecutor());
        getCommand("dieu").setExecutor(new DieuExecutor());
        getCommand("debug").setExecutor(new DebugExecutor());
        getCommand("mod").setExecutor(new ModExecutor());

        //
        getLogger().info("Lodaria Plugin activé !");
        // Initialisation du plugin
    }

    @Override
    public void onDisable() {
        getLogger().info("Lodaria Plugin désactivé !");
        // Nettoyage avant la désactivation
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


}

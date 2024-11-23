package fr.vanibels.lodacore;

import fr.vanibels.lodacore.Commands.*;
import fr.vanibels.lodacore.Events.*;
import fr.vanibels.lodacore.KitManager.command.*;
import fr.vanibels.lodacore.KitManager.listener.KitListener;
import fr.vanibels.lodacore.Managers.DBManagers;
import fr.vanibels.lodacore.Managers.PlayerManagers;
import fr.vanibels.lodacore.Utils.ServerState;
import fr.vanibels.lodacore.cloud.CloudExecutor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class Lodacore extends JavaPlugin {

    public static List<Player> OnlinePlayer = new ArrayList<>();
    public static List<String> MutedPlayers = new ArrayList<>();
    public static List<String> CMDMutedPlayers = new ArrayList<>();
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
    public String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD +"Lodaria"+ ChatColor.DARK_GRAY + "]" + ChatColor.WHITE + " ";
    PluginManager pm = Bukkit.getPluginManager();
    //private DBManagers dbManagers;
    @Override
    public void onEnable() {

        SSTATE = ServerState.OPEN;
        instance= this;
        saveDefaultConfig();
        // Load databasse
        // dbManagers = new DBManagers();
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
        // dbManagers.close();
        getLogger().info("Lodaria Plugin désactiation !");
    }

    public void setSSTATE(ServerState state){
        SSTATE = state;
    }
    public ServerState getSSTATE(){
        return SSTATE;
    }

    /*public DBManagers getDbManagers() {
        return dbManagers;
    }*/

    public boolean getIsMaintenance(){
        return isMaintenance;
    }
    public void setIsMaintenance(boolean b){
        isMaintenance = b;
    }
    private void Event(){
        pm.registerEvents(new ModChatListener(), this);
        pm.registerEvents(new PlayerConnectionEvent(), this);
        pm.registerEvents(new KitListener(), this);
        pm.registerEvents(new ModQuitEvent(),this);
        pm.registerEvents(new ModeratorInteracEvent(),this);
        pm.registerEvents(new ModCancel(),this);
    }
    private void Command(){
        // getCommand("ecloud").setExecutor(new CloudExecutor());
        getCommand("sanction").setExecutor(new StaffCommand());
        getCommand("maintenance").setExecutor(new CommandMaintExecutor());
        getCommand("core").setExecutor(new CoreCommandExecutor());
        getCommand("lkit").setExecutor(new KitExecutor());
        getCommand("tuto").setExecutor(new CommandTutoExecutor());
        // getCommand("chat").setExecutor(new CommandChatExecutor());
        getCommand("testASOM").setExecutor(new CommandTestExecutor());
        getCommand("spawn").setExecutor(new CommandSpawnExecutor());
        getCommand("mine").setExecutor(new CommandMineExecutor());
        getCommand("rstaff").setExecutor(new CommandRstaffExecutor());
        getCommand("arene").setExecutor(new CommandAreneExecutor());
        getCommand("s").setExecutor(new CommandShopExecutor());
        getCommand("discord").setExecutor(new CommandDiscordExecutor());
        getCommand("vote").setExecutor(new CommandVoteExecutor());
        getCommand("boutique").setExecutor(new CommandBoutiqueExecutor());
        getCommand("site").setExecutor(new CommandSiteExecutor());
        getCommand("bienvenue").setExecutor(new CommandBienvenueExecutor());
    }

}

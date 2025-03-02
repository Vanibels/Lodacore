package fr.vanibels.lodacore;

import fr.vanibels.lodacore.Commands.*;
import fr.vanibels.lodacore.Events.*;
import fr.vanibels.lodacore.KitManager.command.*;
import fr.vanibels.lodacore.KitManager.listener.KitListener;
import fr.vanibels.lodacore.Managers.PlayerManagers;
import fr.vanibels.lodacore.Managers.Utils.ServerState;
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
    public ArrayList<UUID> vanishPlayers = new ArrayList<>();
    public ArrayList<UUID> frozenPlayers = new ArrayList<>();
    public ArrayList<UUID> vanishedPlayers = new ArrayList<>();
    public ArrayList<UUID> superVanishedPlayers = new ArrayList<>();
    public HashMap<UUID, PlayerManagers> players = new HashMap<UUID, fr.vanibels.lodacore.Managers.PlayerManagers>();
    public Location spawn = new Location(Bukkit.getWorld("lobby"), 0.53, 57.00, 0.48, 0F, 0F);
    public String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD +"Lodaria"+ ChatColor.DARK_GRAY + "]" + " [" + ChatColor.DARK_AQUA + "CORE" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET;
    PluginManager pm = Bukkit.getPluginManager();
    //private DBManagers dbManagers;
    @Override
    public void onEnable() {
        SSTATE = ServerState.MAINTENANCE;
        instance= this;
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
        getCommand("sanction").setExecutor(new StaffCommand());
        getCommand("maintenance").setExecutor(new CommandMaintExecutor());
        getCommand("core").setExecutor(new CoreCommandExecutor());
        getCommand("lkit").setExecutor(new KitExecutor());
        getCommand("tuto").setExecutor(new CommandTutoExecutor());
        getCommand("testASOM").setExecutor(new CommandTestExecutor());
        getCommand("rstaff").setExecutor(new CommandRstaffExecutor());
        getCommand("discord").setExecutor(new CommandDiscordExecutor());
        getCommand("jour").setExecutor(new CommandJourExecutor());
        getCommand("nuit").setExecutor(new CommandNuitExecutor());
        getCommand("site").setExecutor(new CommandSiteExecutor());
        getCommand("bienvenue").setExecutor(new CommandBienvenueExecutor());
        getCommand("join").setExecutor(new CommandJoinExecutor());
        getCommand("spawn").setExecutor(new CommandSpawnExecutor());
        getCommand("sun").setExecutor(new CommandSunExecutor());
        getCommand("rain").setExecutor(new CommandRainExecutor());
        getCommand("speedon").setExecutor(new CommandSpeedExecutor());
        getCommand("speedoff").setExecutor(new CommandSpeedExecutor());
        getCommand("vanish").setExecutor(new CommandVanishExecutor());
        getCommand("vanish").setExecutor(new CommandSuperVanishExecutor());
    }

}

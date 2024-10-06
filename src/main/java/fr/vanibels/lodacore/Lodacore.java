package fr.vanibels.lodacore;

import fr.vanibels.lodacore.Commands.*;
import fr.vanibels.lodacore.Events.ModChatListener;
import fr.vanibels.lodacore.Events.PlayerConnectionEvent;
import fr.vanibels.lodacore.Utils.ServerState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.luckperms.api.LuckPerms;

import java.util.ArrayList;
import java.util.List;

public final class Lodacore extends JavaPlugin {
    private static LuckPerms luckPerms;

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

        // Init Commands
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("staff").setExecutor(new StaffGUICommand());
        getCommand("maintenance").setExecutor(new CommandMaintExecutor());
        getCommand("core").setExecutor(new CoreCommandExecutor());

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

    public ServerState setSSTATE(ServerState state){
        return SSTATE = state;
    }
    public ServerState getSSTATE(){
        return SSTATE;
    }

    public boolean getIsMaintenance(){
        return isMaintenance;
    }
    public boolean setIsMaintenance(boolean b){
        return isMaintenance = b;
    }


}

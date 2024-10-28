package fr.vanibels.lodacore.LodaFaction.Commands.SubCommands;

import fr.vanibels.lodacore.LodaFaction.Managers.FactionDAO;
import fr.vanibels.lodacore.Lodacore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import fr.vanibels.lodacore.LodaFaction.Managers.Faction;

public class CreateFactionExecutor {
    public static void FactionCreate(Player player, Lodacore ins,String title, String description){
        Faction faction = new Faction(title,player.getUniqueId(),description);

        faction.addMember(player.getUniqueId(),"Roi");

        FactionDAO.saveFaction(faction);

        player.sendMessage("Faction" + title + "crée");

        Bukkit.broadcastMessage(ChatColor.DARK_RED + "[" + ChatColor.GREEN +"Faction" + ChatColor.DARK_RED + "]"+ ChatColor.YELLOW +"/- " +player.getName()+"Viens de crée la "+ChatColor.GOLD +title);
    }
}

package fr.vanibels.lodacore.KitManager.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public class KitExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage("Nop connecte toi!");
            return false;
        }
        KitManagers KM = new KitManagers();
        Player player = (Player) sender;
        if (args.length == 0){
            player.sendMessage(ChatColor.DARK_RED + "Commande incorrect");
            player.sendMessage(ChatColor.YELLOW + "/kit roturier");
            player.sendMessage(ChatColor.YELLOW + "/kit baron");
            player.sendMessage(ChatColor.YELLOW + "/kit vicomte");
            player.sendMessage(ChatColor.YELLOW + "/kit comte");
            player.sendMessage(ChatColor.YELLOW + "/kit marquis");
            player.sendMessage(ChatColor.YELLOW + "/kit duc");
            player.sendMessage(ChatColor.YELLOW + "/kit rois");
            player.sendMessage(ChatColor.YELLOW + "/kit empereur");
        }

        String subCommand = args[0].toLowerCase();

        switch (subCommand) {
            case "roturier":
                KM.RoturierKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "baron":
                KM.BaronKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "vicomte":
                KM.VicomteKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "comte":
                KM.ComteKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "marquis":
                KM.MarquisKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "duc":
                KM.DucKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "rois":
                KM.RoisKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "empereur":
                KM.EmpereurKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "moderator":
                KM.ModerateurKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "debug":
                KM.DebugKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "survivant","sur":
                KM.SurvivantKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "chevalier","che":
                KM.ChevalierKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "seigneur","sei":
                KM.SeigneurKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "dieu":
                KM.DieuKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "coins","lodacoins":
                KM.lodacoins(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "raida","raidA":
                KM.RaidAttaqueKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "raidd", "raidD":
                KM.RaidDefenseKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "raidw","raidW":
                KM.RaidWeaponKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            case "all":
                KM.lodacoins(player);
                KM.RoturierKit(player);
                KM.BaronKit(player);
                KM.VicomteKit(player);
                KM.ComteKit(player);
                KM.MarquisKit(player);
                KM.DucKit(player);
                KM.RoisKit(player);
                KM.EmpereurKit(player);
                KM.ModerateurKit(player);
                KM.DebugKit(player);
                KM.SurvivantKit(player);
                KM.ChevalierKit(player);
                KM.SeigneurKit(player);
                KM.DieuKit(player);
                KM.RaidWeaponKit(player);
                KM.RaidAttaqueKit(player);
                KM.RaidDefenseKit(player);
                player.sendMessage(ChatColor.YELLOW + "Obtention du/des kits");
                break;
            default:
                player.sendMessage(ChatColor.DARK_RED + "Argument incorrect");
                break;

        }

        return true;
    }
}

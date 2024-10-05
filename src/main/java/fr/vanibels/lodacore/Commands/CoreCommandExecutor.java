package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Lodacore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CoreCommandExecutor implements CommandExecutor {

    public static Lodacore ins = Lodacore.instance;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 0) return false;

        if (args.length == 1){
            switch (args[0].toLowerCase()){
                case "reload":
                    sender.sendMessage(ChatColor.YELLOW + "Reload du plugin");
                    ins.reloadConfig();
                    sender.sendMessage(ChatColor.GOLD + "Reload terminé");
                    break;
                case "version":
                    sender.sendMessage(ChatColor.GREEN +  ins.getConfig().getString("global.name") + " " +  ins.getConfig().getString("global.version") + "Core version " + ins.getConfig().getInt("global.coreVersion"));
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "Command inconnue");

            }
            return true;
        }

        return false;
    }
}

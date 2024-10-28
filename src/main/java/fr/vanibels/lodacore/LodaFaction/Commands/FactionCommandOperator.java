package fr.vanibels.lodacore.LodaFaction.Commands;

import fr.vanibels.lodacore.LodaFaction.Commands.SubCommands.CreateFactionExecutor;
import fr.vanibels.lodacore.Lodacore;
import net.luckperms.api.platform.Platform;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import fr.vanibels.lodacore.LodaFaction.Managers.Faction;
import org.bukkit.entity.Player;

public class FactionCommandOperator implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("Seul un joueur de plus non operateur/ou en modération peut executer ces commandes");
            return false;
        }
        Player player = (Player) sender;
        if (args.length == 0){
            return false;
        }

        String subCommand = args[0].toLowerCase();

        switch (subCommand) {
            case "create":
                if (args.length < 2){
                    player.sendMessage(ChatColor.RED + "/f create [Nom] [Description]");
                }
                // Transformation
                String title = args[1];
                StringBuilder sb = new StringBuilder();
                for (int i = 2; i < args.length; i++) {
                    sb.append(i);
                }
                String description = sb.toString();

                //Vérification
                // Création
                CreateFactionExecutor.FactionCreate(player, Lodacore.instance, args[1],description );
                break;
        }

        return true;
    }
}

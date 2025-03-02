package fr.vanibels.lodacore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandDiscordExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_GRAY + "-------------------------------------");
        sender.sendMessage(ChatColor.BOLD + "" + ChatColor.YELLOW +"【"+ ChatColor.DARK_BLUE + "Discord officiel de Lodaria" + ChatColor.YELLOW +"】");
        sender.sendMessage(ChatColor.BOLD + "" + ChatColor.GRAY + "https://discord.gg/yHFVTS5G3a");
        sender.sendMessage(ChatColor.BOLD + "" + ChatColor.DARK_GRAY + "-------------------------------------");
        return true;
    }
}

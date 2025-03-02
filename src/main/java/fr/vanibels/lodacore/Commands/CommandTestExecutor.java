package fr.vanibels.lodacore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandTestExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage("Ready - Vanibels -* Lodaria");
        }else {
            sender.sendMessage("Ready - copyright Vanibels -* Lodaria");
            Player player = (Player) sender;
            ItemStack devSword = new ItemStack(Material.NETHERITE_SWORD);


            ItemMeta devM = (ItemMeta) devSword.getItemMeta();

            devM.setDisplayName(ChatColor.RED+"DEV SWORD");
            devM.addEnchant(Enchantment.DAMAGE_ALL,255,true);
            devSword.setItemMeta(devM);
            player.getInventory().addItem(devSword);
            player.updateInventory();

        }

        return true;
    }
}

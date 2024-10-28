package fr.vanibels.lodacore.KitManager.listener;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ModToolsListener implements Listener {
    @EventHandler
    public void onModInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        ItemStack it = e.getItem();
        Action ac = e.getAction();
        if (it == null)return;

        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Giver LV0 ---Moderator kit")){
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK){
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.YELLOW + "Giver lv0","Moderator");

                //A0001
                ItemStack item1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(ChatColor.YELLOW + "§4Bye");
                itemMeta1.setLore(Arrays.asList("§eForgé par §cVanibels"));
                itemMeta1.addEnchant(Enchantment.KNOCKBACK,20,true);
                itemMeta1.setUnbreakable(true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0006
                ItemStack item6 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(ChatColor.YELLOW + "Casque du §4Moderateur");
                itemMeta6.setLore(Arrays.asList("§eForgé par §cVanibels"));
                itemMeta6.setUnbreakable(true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta itemMeta7 = item7.getItemMeta();
                itemMeta7.setDisplayName(ChatColor.YELLOW + "Plastron du §4Moderateur");
                itemMeta7.setLore(Arrays.asList("§eForgé par §cVanibels"));
                itemMeta7.setUnbreakable(true);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.NETHERITE_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(ChatColor.YELLOW + "Jambiere du §4Moderateur");
                itemMeta8.setLore(Arrays.asList("§eForgé par §cVanibels"));
                itemMeta8.setUnbreakable(true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta itemMeta9 = item9.getItemMeta();
                itemMeta9.setDisplayName(ChatColor.YELLOW + "Botte du §4Moderateur");
                itemMeta9.setLore(Arrays.asList("§eForgé par §cVanibels"));
                itemMeta9.setUnbreakable(true);
                item9.setItemMeta(itemMeta9);

                player.getInventory().clear();
                player.updateInventory();
                player.getInventory().addItem(item9);
                player.getInventory().addItem(item8);
                player.getInventory().addItem(item7);
                player.getInventory().addItem(item6);
                player.getInventory().addItem(item1);

            }
        }

    }
}

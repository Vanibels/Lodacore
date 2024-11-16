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
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;

public class KitListener implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack it = e.getItem();
        Action ac = e.getAction();
        if (it == null) return;
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Giver LV1 --- SURVIVANT")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");

                //A0001
                ItemStack item1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Dague du survivant");
                itemMeta1.setLore(Arrays.asList("Ancien dag des heros", "Cette lame est emoussee"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 1, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0002
                ItemStack item2 = new ItemStack(Material.WOODEN_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hoe LV1");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //A0003
                ItemStack item3 = new ItemStack(Material.WOODEN_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pelle LV1");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //A0004
                ItemStack item4 = new ItemStack(Material.WOODEN_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pioche LV1");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //A0005
                ItemStack item5 = new ItemStack(Material.WOODEN_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hache LV1");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                //A0006
                ItemStack item6 = new ItemStack(Material.LEATHER_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Casque du survivant");
                itemMeta6.setLore(Arrays.asList("Pas du tout solide"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 1, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta itemMeta7 = item7.getItemMeta();
                itemMeta7.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Chemise du survivant");
                itemMeta7.setLore(Arrays.asList("Chemise sale", "Cette chemise fait vomir"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 1, true);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.LEATHER_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Cullot de survie");
                itemMeta8.setLore(Arrays.asList("Culotte de wish", "Cette culotte me rappelle un heros"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 1, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.LEATHER_BOOTS);
                ItemMeta itemMeta9 = item9.getItemMeta();
                itemMeta9.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Botte du survivant");
                itemMeta9.setLore(Arrays.asList("Botte tropicale", "Cette botte est sale"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 1, true);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);


            }
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(org.bukkit.ChatColor.DARK_RED + "Giver LV2 --- CHEVALIER")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(org.bukkit.ChatColor.RED + "Giver lv2", "");


                //B0001
                ItemStack item1 = new ItemStack(Material.IRON_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.RED + "Lame sacree");
                itemMeta1.setLore(Arrays.asList("Lame de temps Ancient", "Cette lame tranche beaucoup"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 2, true);
                itemMeta1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //B0002
                ItemStack item2 = new ItemStack(Material.STONE_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(org.bukkit.ChatColor.RED + "Hoe LV2");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 2, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 2, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //B0003
                ItemStack item3 = new ItemStack(Material.STONE_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(org.bukkit.ChatColor.RED + "Pelle LV2");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 2, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 2, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //B0004
                ItemStack item4 = new ItemStack(Material.IRON_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(org.bukkit.ChatColor.RED + "Pioche LV2");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 2, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 2, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //B0005
                ItemStack item5 = new ItemStack(Material.STONE_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(org.bukkit.ChatColor.RED + "Hache LV2");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 2, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 2, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                //B0006
                ItemStack item6 = new ItemStack(Material.IRON_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(org.bukkit.ChatColor.RED + "Casque des heros");
                itemMeta6.setLore(Arrays.asList("Casque des plut grand chevalier"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 2, true);
                itemMeta6.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //B0007
                ItemStack item7 = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta itemMeta7 = item7.getItemMeta();
                itemMeta7.setDisplayName(org.bukkit.ChatColor.RED + "Plastron des heros");
                itemMeta7.setLore(Arrays.asList("Plastron du roi Arture", "Cet plastron fut connus", "comme plastron royal"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 2, true);
                itemMeta7.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //B0008
                ItemStack item8 = new ItemStack(Material.IRON_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(org.bukkit.ChatColor.RED + "culote de superman");
                itemMeta8.setLore(Arrays.asList("Une copie tres rare"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 2, true);
                itemMeta8.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //B0009
                ItemStack item9 = new ItemStack(Material.IRON_BOOTS);
                ItemMeta itemMeta9 = item9.getItemMeta();
                itemMeta9.setDisplayName(org.bukkit.ChatColor.RED + "Botte de merlin");
                itemMeta9.setLore(Arrays.asList("Botte d'enchanteur", "Cette botte appartenais a merlin"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 2, true);
                itemMeta9.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);


            }
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Giver LV3 --- SEIGNEUR")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.GREEN + "Giver lv3", "");

                //A0001
                ItemStack item1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(ChatColor.GREEN + "Lame du conquerant");
                itemMeta1.setLore(Arrays.asList("Lame tueuse de dragon"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 3, true);
                itemMeta1.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
                itemMeta1.addEnchant(Enchantment.KNOCKBACK, 1, true);
                itemMeta1.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0002
                ItemStack item2 = new ItemStack(Material.DIAMOND_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(ChatColor.GREEN + "Hoe LV3");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 3, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //A0003
                ItemStack item3 = new ItemStack(Material.DIAMOND_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(ChatColor.GREEN + "Pelle LV3");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 3, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //A0004
                ItemStack item4 = new ItemStack(Material.DIAMOND_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(ChatColor.GREEN + "Pioche LV3");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 3, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //A0005
                ItemStack item5 = new ItemStack(Material.DIAMOND_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(ChatColor.GREEN + "Hache LV3");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 3, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                //A0006
                ItemStack item6 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(ChatColor.GREEN + "couronne des roi");
                itemMeta6.setLore(Arrays.asList("Porter par le roi Artur"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 3, true);
                itemMeta6.addEnchant(Enchantment.THORNS, 1, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta itemMeta7 = item7.getItemMeta();
                itemMeta7.setDisplayName(ChatColor.GREEN + "Cape des roi");
                itemMeta7.setLore(Arrays.asList("Cape des plus grand roi"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 3, true);
                itemMeta7.addEnchant(Enchantment.THORNS, 1, true);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(ChatColor.GREEN + "Cuissard");
                itemMeta8.setLore(Arrays.asList("ce cuissard fut porter", "pendant la conquete de la chine"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 3, true);
                itemMeta8.addEnchant(Enchantment.THORNS, 1, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta itemMeta9 = item9.getItemMeta();
                itemMeta9.setDisplayName(ChatColor.GREEN + "Botte de louis 14");
                itemMeta9.setLore(Arrays.asList("Botte du roi Louis 14"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 3, true);
                itemMeta9.addEnchant(Enchantment.THORNS, 1, true);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);


            }
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Giver LV4 --- DIEU")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.YELLOW + "Giver lv4", "");

                //A0001
                ItemStack item1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(ChatColor.YELLOW + "Lame divine");
                itemMeta1.setLore(Arrays.asList("Lame tueuse de demon"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 4, true);
                itemMeta1.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                itemMeta1.addEnchant(Enchantment.KNOCKBACK, 2, true);
                itemMeta1.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0002
                ItemStack item2 = new ItemStack(Material.DIAMOND_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(ChatColor.YELLOW + "Hoe LV4");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 4, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //A0003
                ItemStack item3 = new ItemStack(Material.DIAMOND_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(ChatColor.YELLOW + "Pelle LV4");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 4, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //A0004
                ItemStack item4 = new ItemStack(Material.DIAMOND_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(ChatColor.YELLOW + "Pioche LV4");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 4, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //A0005
                ItemStack item5 = new ItemStack(Material.DIAMOND_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(ChatColor.YELLOW + "Hache LV4");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 4, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                //A0006
                ItemStack item6 = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(ChatColor.YELLOW + "couronne de petale");
                itemMeta6.setLore(Arrays.asList("Cree par Apollon"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 4, true);
                itemMeta6.addEnchant(Enchantment.THORNS, 2, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta itemMeta7 = item7.getItemMeta();
                itemMeta7.setDisplayName(ChatColor.YELLOW + "Cape de Zeuse");
                itemMeta7.setLore(Arrays.asList("Cape du plus grand dieu"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 4, true);
                itemMeta7.addEnchant(Enchantment.THORNS, 2, true);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.NETHERITE_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(ChatColor.YELLOW + "Cullot de Zeuse");
                itemMeta8.setLore(Arrays.asList("cette cullote fut porter par Zeuse"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 4, true);
                itemMeta8.addEnchant(Enchantment.THORNS, 2, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta itemMeta9 = item9.getItemMeta();
                itemMeta9.setDisplayName(ChatColor.YELLOW + "Talaria");
                itemMeta9.setLore(Arrays.asList("Botte du messager des dieu"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 4, true);
                itemMeta9.addEnchant(Enchantment.THORNS, 2, true);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);

            }
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_RED + "Giver LV0 ---Moderator kit")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.YELLOW + "Giver lv0", "Moderator");

                //A0001
                ItemStack item1 = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(ChatColor.YELLOW + "§4Bye");
                itemMeta1.setLore(Arrays.asList("§eForgé par §cVanibels"));
                itemMeta1.addEnchant(Enchantment.KNOCKBACK, 20, true);
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
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(org.bukkit.ChatColor.DARK_PURPLE + "Giver LV0 --- Dev debuger")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(org.bukkit.ChatColor.DARK_PURPLE + "Giver lv0", "Tools debuger");


                //D0001
                ItemStack item1 = new ItemStack(Material.DEBUG_STICK);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.DARK_PURPLE + "Debuger");
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);


            }
        }

        // grade kit's

        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Kit Roturier")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");

                /*/A0001
                ItemStack item1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Dague du survivant");
                itemMeta1.setLore(Arrays.asList("Ancien dag des heros", "Cette lame est emoussee"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 1, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0002
                ItemStack item2 = new ItemStack(Material.WOODEN_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hoe LV1");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //A0003
                ItemStack item3 = new ItemStack(Material.WOODEN_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pelle LV1");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //A0004
                ItemStack item4 = new ItemStack(Material.WOODEN_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pioche LV1");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //A0005
                ItemStack item5 = new ItemStack(Material.WOODEN_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hache LV1");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                *///A0006
                ItemStack item6 = new ItemStack(Material.IRON_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(org.bukkit.ChatColor.GRAY + "Casque des roturiers");
                itemMeta6.setLore(Arrays.asList("Fait office de parapluie de fortune"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 1, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta itemMeta7 = (LeatherArmorMeta) item7.getItemMeta();
                itemMeta7.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Tunique de villageois");
                itemMeta7.setLore(Arrays.asList("Chemise sale", "Sert dans les champs"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 1, true);
                Color itemColor =hexToColor("9D9D97");
                itemMeta7.setColor(itemColor);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Cullot des paysans");
                itemMeta8.setLore(Arrays.asList("Culotte crasseuse", "Cette culotte est taché de bout"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 1, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta itemMeta9 = (LeatherArmorMeta) item9.getItemMeta();
                itemMeta9.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Botte du survivant");
                itemMeta9.setLore(Arrays.asList("Botte tropicale", "Cette botte est sale"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta9.setColor(itemColor);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);


            }
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Kit Baron")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");

                /*/A0001
                ItemStack item1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Dague du survivant");
                itemMeta1.setLore(Arrays.asList("Ancien dag des heros", "Cette lame est emoussee"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 1, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0002
                ItemStack item2 = new ItemStack(Material.WOODEN_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hoe LV1");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //A0003
                ItemStack item3 = new ItemStack(Material.WOODEN_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pelle LV1");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //A0004
                ItemStack item4 = new ItemStack(Material.WOODEN_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pioche LV1");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //A0005
                ItemStack item5 = new ItemStack(Material.WOODEN_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hache LV1");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                *///A0006
                ItemStack item6 = new ItemStack(Material.IRON_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(org.bukkit.ChatColor.GRAY + "Casque des roturiers");
                itemMeta6.setLore(Arrays.asList("Fait office de parapluie de fortune"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 1, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta itemMeta7 = (LeatherArmorMeta) item7.getItemMeta();
                itemMeta7.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Tunique de villageois");
                itemMeta7.setLore(Arrays.asList("Chemise sale", "Sert dans les champs"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 1, true);
                Color itemColor =hexToColor("9D9D97");
                itemMeta7.setColor(itemColor);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Cullot des paysans");
                itemMeta8.setLore(Arrays.asList("Culotte crasseuse", "Cette culotte est taché de bout"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 1, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta itemMeta9 = (LeatherArmorMeta) item9.getItemMeta();
                itemMeta9.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Botte du survivant");
                itemMeta9.setLore(Arrays.asList("Botte tropicale", "Cette botte est sale"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta9.setColor(itemColor);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);


            }
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Kit Vicomte")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");

                /*/A0001
                ItemStack item1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Dague du survivant");
                itemMeta1.setLore(Arrays.asList("Ancien dag des heros", "Cette lame est emoussee"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 1, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0002
                ItemStack item2 = new ItemStack(Material.WOODEN_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hoe LV1");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //A0003
                ItemStack item3 = new ItemStack(Material.WOODEN_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pelle LV1");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //A0004
                ItemStack item4 = new ItemStack(Material.WOODEN_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pioche LV1");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //A0005
                ItemStack item5 = new ItemStack(Material.WOODEN_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hache LV1");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                *///A0006
                ItemStack item6 = new ItemStack(Material.IRON_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(org.bukkit.ChatColor.GRAY + "Casque des roturiers");
                itemMeta6.setLore(Arrays.asList("Fait office de parapluie de fortune"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 1, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta itemMeta7 = (LeatherArmorMeta) item7.getItemMeta();
                itemMeta7.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Tunique de villageois");
                itemMeta7.setLore(Arrays.asList("Chemise sale", "Sert dans les champs"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 1, true);
                Color itemColor =hexToColor("9D9D97");
                itemMeta7.setColor(itemColor);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Cullot des paysans");
                itemMeta8.setLore(Arrays.asList("Culotte crasseuse", "Cette culotte est taché de bout"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 1, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta itemMeta9 = (LeatherArmorMeta) item9.getItemMeta();
                itemMeta9.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Botte du survivant");
                itemMeta9.setLore(Arrays.asList("Botte tropicale", "Cette botte est sale"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta9.setColor(itemColor);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);


            }
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Kit Comte")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");

                /*/A0001
                ItemStack item1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Dague du survivant");
                itemMeta1.setLore(Arrays.asList("Ancien dag des heros", "Cette lame est emoussee"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 1, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0002
                ItemStack item2 = new ItemStack(Material.WOODEN_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hoe LV1");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //A0003
                ItemStack item3 = new ItemStack(Material.WOODEN_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pelle LV1");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //A0004
                ItemStack item4 = new ItemStack(Material.WOODEN_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pioche LV1");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //A0005
                ItemStack item5 = new ItemStack(Material.WOODEN_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hache LV1");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                *///A0006
                ItemStack item6 = new ItemStack(Material.IRON_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(org.bukkit.ChatColor.GRAY + "Casque des roturiers");
                itemMeta6.setLore(Arrays.asList("Fait office de parapluie de fortune"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 1, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta itemMeta7 = (LeatherArmorMeta) item7.getItemMeta();
                itemMeta7.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Tunique de villageois");
                itemMeta7.setLore(Arrays.asList("Chemise sale", "Sert dans les champs"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 1, true);
                Color itemColor =hexToColor("9D9D97");
                itemMeta7.setColor(itemColor);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Cullot des paysans");
                itemMeta8.setLore(Arrays.asList("Culotte crasseuse", "Cette culotte est taché de bout"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 1, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta itemMeta9 = (LeatherArmorMeta) item9.getItemMeta();
                itemMeta9.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Botte du survivant");
                itemMeta9.setLore(Arrays.asList("Botte tropicale", "Cette botte est sale"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta9.setColor(itemColor);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);


            }
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Marquis")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");

                /*/A0001
                ItemStack item1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Dague du survivant");
                itemMeta1.setLore(Arrays.asList("Ancien dag des heros", "Cette lame est emoussee"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 1, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0002
                ItemStack item2 = new ItemStack(Material.WOODEN_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hoe LV1");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //A0003
                ItemStack item3 = new ItemStack(Material.WOODEN_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pelle LV1");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //A0004
                ItemStack item4 = new ItemStack(Material.WOODEN_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pioche LV1");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //A0005
                ItemStack item5 = new ItemStack(Material.WOODEN_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hache LV1");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                *///A0006
                ItemStack item6 = new ItemStack(Material.IRON_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(org.bukkit.ChatColor.GRAY + "Casque des roturiers");
                itemMeta6.setLore(Arrays.asList("Fait office de parapluie de fortune"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 1, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta itemMeta7 = (LeatherArmorMeta) item7.getItemMeta();
                itemMeta7.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Tunique de villageois");
                itemMeta7.setLore(Arrays.asList("Chemise sale", "Sert dans les champs"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 1, true);
                Color itemColor =hexToColor("9D9D97");
                itemMeta7.setColor(itemColor);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Cullot des paysans");
                itemMeta8.setLore(Arrays.asList("Culotte crasseuse", "Cette culotte est taché de bout"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 1, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta itemMeta9 = (LeatherArmorMeta) item9.getItemMeta();
                itemMeta9.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Botte du survivant");
                itemMeta9.setLore(Arrays.asList("Botte tropicale", "Cette botte est sale"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta9.setColor(itemColor);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);


            }
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Kit Duc")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");

                /*/A0001
                ItemStack item1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Dague du survivant");
                itemMeta1.setLore(Arrays.asList("Ancien dag des heros", "Cette lame est emoussee"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 1, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0002
                ItemStack item2 = new ItemStack(Material.WOODEN_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hoe LV1");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //A0003
                ItemStack item3 = new ItemStack(Material.WOODEN_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pelle LV1");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //A0004
                ItemStack item4 = new ItemStack(Material.WOODEN_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pioche LV1");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //A0005
                ItemStack item5 = new ItemStack(Material.WOODEN_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hache LV1");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                *///A0006
                ItemStack item6 = new ItemStack(Material.IRON_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(org.bukkit.ChatColor.GRAY + "Casque des roturiers");
                itemMeta6.setLore(Arrays.asList("Fait office de parapluie de fortune"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 1, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta itemMeta7 = (LeatherArmorMeta) item7.getItemMeta();
                itemMeta7.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Tunique de villageois");
                itemMeta7.setLore(Arrays.asList("Chemise sale", "Sert dans les champs"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 1, true);
                Color itemColor =hexToColor("9D9D97");
                itemMeta7.setColor(itemColor);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Cullot des paysans");
                itemMeta8.setLore(Arrays.asList("Culotte crasseuse", "Cette culotte est taché de bout"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 1, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta itemMeta9 = (LeatherArmorMeta) item9.getItemMeta();
                itemMeta9.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Botte du survivant");
                itemMeta9.setLore(Arrays.asList("Botte tropicale", "Cette botte est sale"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta9.setColor(itemColor);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);


            }
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Kit Rois")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");

                /*/A0001
                ItemStack item1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Dague du survivant");
                itemMeta1.setLore(Arrays.asList("Ancien dag des heros", "Cette lame est emoussee"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 1, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0002
                ItemStack item2 = new ItemStack(Material.WOODEN_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hoe LV1");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //A0003
                ItemStack item3 = new ItemStack(Material.WOODEN_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pelle LV1");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //A0004
                ItemStack item4 = new ItemStack(Material.WOODEN_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pioche LV1");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //A0005
                ItemStack item5 = new ItemStack(Material.WOODEN_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hache LV1");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                *///A0006
                ItemStack item6 = new ItemStack(Material.IRON_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(org.bukkit.ChatColor.GRAY + "Casque des roturiers");
                itemMeta6.setLore(Arrays.asList("Fait office de parapluie de fortune"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 1, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta itemMeta7 = (LeatherArmorMeta) item7.getItemMeta();
                itemMeta7.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Tunique de villageois");
                itemMeta7.setLore(Arrays.asList("Chemise sale", "Sert dans les champs"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 1, true);
                Color itemColor =hexToColor("9D9D97");
                itemMeta7.setColor(itemColor);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Cullot des paysans");
                itemMeta8.setLore(Arrays.asList("Culotte crasseuse", "Cette culotte est taché de bout"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 1, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta itemMeta9 = (LeatherArmorMeta) item9.getItemMeta();
                itemMeta9.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Botte du survivant");
                itemMeta9.setLore(Arrays.asList("Botte tropicale", "Cette botte est sale"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta9.setColor(itemColor);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);


            }
        }
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Kit Empereur")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");

                /*/A0001
                ItemStack item1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Dague du survivant");
                itemMeta1.setLore(Arrays.asList("Ancien dag des heros", "Cette lame est emoussee"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 1, true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().addItem(item1);

                //A0002
                ItemStack item2 = new ItemStack(Material.WOODEN_HOE);
                ItemMeta itemMeta2 = item2.getItemMeta();
                itemMeta2.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hoe LV1");
                itemMeta2.setLore(Arrays.asList("Incassable cette Hoe", "Peut etre echangee"));
                itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta2.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta2.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta2.setUnbreakable(true);
                item2.setItemMeta(itemMeta2);

                player.getInventory().addItem(item2);


                //A0003
                ItemStack item3 = new ItemStack(Material.WOODEN_SHOVEL);
                ItemMeta itemMeta3 = item3.getItemMeta();
                itemMeta3.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pelle LV1");
                itemMeta3.setLore(Arrays.asList("Incassable cette pelle", "Peut etre echangee"));
                itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta3.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta3.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                itemMeta3.setUnbreakable(true);
                item3.setItemMeta(itemMeta3);

                player.getInventory().addItem(item3);

                //A0004
                ItemStack item4 = new ItemStack(Material.WOODEN_PICKAXE);
                ItemMeta itemMeta4 = item4.getItemMeta();
                itemMeta4.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Pioche LV1");
                itemMeta4.setLore(Arrays.asList("Incassable cette pioche", "Peut etre echangee"));
                itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES); // Facultatif : pour masquer les attributs de l'item
                itemMeta4.setUnbreakable(true);
                itemMeta4.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta4.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item4.setItemMeta(itemMeta4);

                player.getInventory().addItem(item4);

                //A0005
                ItemStack item5 = new ItemStack(Material.WOODEN_AXE);
                ItemMeta itemMeta5 = item5.getItemMeta();
                itemMeta5.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Hache LV1");
                itemMeta5.setLore(Arrays.asList("Incassable cette hache", "Peut etre echangee"));
                itemMeta5.setUnbreakable(true);
                itemMeta5.addEnchant(Enchantment.DIG_SPEED, 1, true);
                itemMeta5.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, true);
                item5.setItemMeta(itemMeta5);

                player.getInventory().addItem(item5);

                *///A0006
                ItemStack item6 = new ItemStack(Material.IRON_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(org.bukkit.ChatColor.GRAY + "Casque des roturiers");
                itemMeta6.setLore(Arrays.asList("Fait office de parapluie de fortune"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 1, true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().addItem(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta itemMeta7 = (LeatherArmorMeta) item7.getItemMeta();
                itemMeta7.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Tunique de villageois");
                itemMeta7.setLore(Arrays.asList("Chemise sale", "Sert dans les champs"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 1, true);
                Color itemColor =hexToColor("9D9D97");
                itemMeta7.setColor(itemColor);
                item7.setItemMeta(itemMeta7);

                player.getInventory().addItem(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Cullot des paysans");
                itemMeta8.setLore(Arrays.asList("Culotte crasseuse", "Cette culotte est taché de bout"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 1, true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().addItem(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta itemMeta9 = (LeatherArmorMeta) item9.getItemMeta();
                itemMeta9.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Botte du survivant");
                itemMeta9.setLore(Arrays.asList("Botte tropicale", "Cette botte est sale"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta9.setColor(itemColor);
                item9.setItemMeta(itemMeta9);

                player.getInventory().addItem(item9);


            }
        }
    }
    public static Color hexToColor(String hexCode) {
        // Vérifie si le code commence par '#' et a une longueur de 7 caractères
        if (hexCode == null || !hexCode.startsWith("#") || hexCode.length() != 7) {
            throw new IllegalArgumentException("Le code hexadécimal doit être au format #RRGGBB !");
        }

        try {
            // Extrait les composantes RVB du code hexadécimal
            int red = Integer.parseInt(hexCode.substring(1, 3), 16); // Rouge
            int green = Integer.parseInt(hexCode.substring(3, 5), 16); // Vert
            int blue = Integer.parseInt(hexCode.substring(5, 7), 16); // Bleu

            // Retourne un objet Color avec les composantes RVB
            return Color.fromRGB(red, green, blue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Le code hexadécimal contient des caractères non valides !");
        }
    }
}

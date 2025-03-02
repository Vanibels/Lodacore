package fr.vanibels.lodacore.KitManager.listener;

import fr.vanibels.lodacore.Managers.Utils.ItemBuilder;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.List;

public class KitListener implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack it = e.getItem();
        Action ac = e.getAction();
        if (it == null) return;
        // Evenement survivor kit's
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
        // Evenement knight kit's
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
        // Evenement lord kit's
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
        // Evenement god kit's
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
        // Try moderator kit's
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
        // Debug kit
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

        // Kit Roturier
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Kit Roturier")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");
                // Bois
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
                Color itemColor = hexToColor("9D9D97");
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
        // Kit Baron
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_AQUA + "Kit Baron")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");
                // Pierre
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
                Color itemColor = hexToColor("9D9D97");
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
        // Kit Vicomte
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
                Color itemColor = hexToColor("9D9D97");
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
        // Kit comte
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Kit Comte")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");
                // Fer
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
                Color itemColor = hexToColor("9D9D97");
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
        // Kit marquis
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "Kit Marquis")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");
                // Fer
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
                Color itemColor = hexToColor("9D9D97");
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
        // Kit duc
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Kit Duc")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");
                // Diamant
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
                Color itemColor = hexToColor("9D9D97");
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
        // Kit rois
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Kit Rois")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");
                // Or
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
                Color itemColor = hexToColor("9D9D97");
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
        // Kit empereur
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Kit Empereur")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                player.sendTitle(ChatColor.LIGHT_PURPLE + "Giver lv1", "");
                // Netherite
                //A0001
                ItemStack item1 = new ItemStack(Material.NETHERITE_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.BLUE + "Lame Divine");
                itemMeta1.setLore(Arrays.asList("Epe sacrée forgé par le forgeron des dieux", "Et donner au humains par une déesse"));
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
                Color itemColor = hexToColor("9D9D97");
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
        // Event castel raid
        if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Kit Defenseur")) {
            if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                player.getInventory().clear();
                player.updateInventory();
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                //A0001
                ItemStack item1 = new ItemStack(Material.STONE_SWORD);
                ItemMeta itemMeta1 = item1.getItemMeta();
                itemMeta1.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Dague des defenseurs");
                itemMeta1.setLore(Arrays.asList(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================"));
                itemMeta1.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta1.setUnbreakable(true);
                item1.setItemMeta(itemMeta1);

                player.getInventory().setItem(0, item1);

                //A0006
                ItemStack item6 = new ItemStack(Material.IRON_HELMET);
                ItemMeta itemMeta6 = item6.getItemMeta();
                itemMeta6.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Casque des defenseurs");
                itemMeta6.setLore(Arrays.asList(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================"));
                itemMeta6.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta6.setUnbreakable(true);
                item6.setItemMeta(itemMeta6);

                player.getInventory().setHelmet(item6);

                //A0007
                ItemStack item7 = new ItemStack(Material.LEATHER_CHESTPLATE);
                ItemMeta itemMeta7 = item7.getItemMeta();
                itemMeta7.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Chemise des defenseurs");
                itemMeta7.setLore(Arrays.asList(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================"));
                itemMeta7.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta7.setUnbreakable(true);
                item7.setItemMeta(itemMeta7);

                player.getInventory().setChestplate(item7);

                //A0008
                ItemStack item8 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
                ItemMeta itemMeta8 = item8.getItemMeta();
                itemMeta8.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Cullot des defenseurs");
                itemMeta8.setLore(Arrays.asList(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================"));
                itemMeta8.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta8.setUnbreakable(true);
                item8.setItemMeta(itemMeta8);

                player.getInventory().setLeggings(item8);

                //A0009
                ItemStack item9 = new ItemStack(Material.GOLDEN_BOOTS);
                ItemMeta itemMeta9 = item9.getItemMeta();
                itemMeta9.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Botte du defenseur");
                itemMeta9.setLore(Arrays.asList(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================"));
                itemMeta9.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta9.setUnbreakable(true);
                item9.setItemMeta(itemMeta9);

                player.getInventory().setBoots(item9);

                ItemStack Fireball = new ItemBuilder(Material.FIRE_CHARGE).setAmount(15).addEnchant(Enchantment.ARROW_DAMAGE, 2).setName(ChatColor.RED + "Boule de feu").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                ItemStack Bow = new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_INFINITE, 1).setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").setName(ChatColor.RED + "Arc").UnBreak().toItemStack();
                ItemStack Crossbow = new ItemBuilder(Material.CROSSBOW).addEnchant(Enchantment.IMPALING, 1).setName(ChatColor.RED + "Fusil").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                ItemStack Grapp = new ItemBuilder(Material.FISHING_ROD).addEnchant(Enchantment.LOYALTY, 10).setName(ChatColor.RED + "Grappin").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                ItemStack Arrow = new ItemBuilder(Material.ARROW).addEnchant(Enchantment.ARROW_DAMAGE, 1).setName(ChatColor.RED + "Flêche").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                ItemStack Balle = new ItemBuilder(Material.FIREWORK_ROCKET).setAmount(15).addEnchant(Enchantment.ARROW_DAMAGE, 1).setName(ChatColor.RED + "Balle").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                ItemStack Bouffe = new ItemBuilder(Material.GOLDEN_CARROT).setAmount(64).addEnchant(Enchantment.LUCK, 1).setName(ChatColor.RED + "Bouffe").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                player.getInventory().setItemInOffHand(Balle);
                player.getInventory().setItem(1, Fireball);
                player.getInventory().setItem(2, Bouffe);
                player.getInventory().setItem(6, Grapp);
                player.getInventory().setItem(7, Crossbow);
                player.getInventory().setItem(8, Bow);
                player.getInventory().setItem(17, Arrow);

                player.updateInventory();

            }
        }
            if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Kit Attaquant")) {
                if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                    player.getInventory().clear();
                    player.updateInventory();
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);

                    //A0001
                    ItemStack item1 = new ItemStack(Material.STONE_SWORD);
                    ItemMeta itemMeta1 = item1.getItemMeta();
                    itemMeta1.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Dague des Attaquants");
                    itemMeta1.setLore(Arrays.asList(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================"));
                    itemMeta1.addEnchant(Enchantment.DURABILITY, 1, true);
                    itemMeta1.setUnbreakable(true);
                    item1.setItemMeta(itemMeta1);

                    player.getInventory().setItem(0, item1);

                    //A0006
                    ItemStack item6 = new ItemStack(Material.IRON_HELMET);
                    ItemMeta itemMeta6 = item6.getItemMeta();
                    itemMeta6.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Casque des Attaquants");
                    itemMeta6.setLore(Arrays.asList(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================"));
                    itemMeta6.addEnchant(Enchantment.DURABILITY, 1, true);
                    itemMeta6.setUnbreakable(true);
                    item6.setItemMeta(itemMeta6);

                    player.getInventory().setHelmet(item6);

                    //A0007
                    ItemStack item7 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                    ItemMeta itemMeta7 = item7.getItemMeta();
                    itemMeta7.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Chemise des Attaquants");
                    itemMeta7.setLore(Arrays.asList(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================"));
                    itemMeta7.addEnchant(Enchantment.DURABILITY, 1, true);
                    itemMeta7.setUnbreakable(true);
                    item7.setItemMeta(itemMeta7);

                    player.getInventory().setChestplate(item7);

                    //A0008
                    ItemStack item8 = new ItemStack(Material.LEATHER_LEGGINGS);
                    ItemMeta itemMeta8 = item8.getItemMeta();
                    itemMeta8.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Cullot des Attaquants");
                    itemMeta8.setLore(Arrays.asList(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================"));
                    itemMeta8.addEnchant(Enchantment.DURABILITY, 1, true);
                    itemMeta8.setUnbreakable(true);
                    item8.setItemMeta(itemMeta8);

                    player.getInventory().setLeggings(item8);

                    //A0009
                    ItemStack item9 = new ItemStack(Material.GOLDEN_BOOTS);
                    ItemMeta itemMeta9 = item9.getItemMeta();
                    itemMeta9.setDisplayName(org.bukkit.ChatColor.LIGHT_PURPLE + "Botte des Attaquants");
                    itemMeta9.setLore(Arrays.asList(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================"));
                    itemMeta9.addEnchant(Enchantment.DURABILITY, 1, true);
                    itemMeta9.setUnbreakable(true);
                    item9.setItemMeta(itemMeta9);

                    player.getInventory().setBoots(item9);

                    ItemStack Fireball = new ItemBuilder(Material.FIRE_CHARGE).setAmount(15).addEnchant(Enchantment.ARROW_DAMAGE, 2).setName(ChatColor.RED + "Boule de feu").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    ItemStack Bow = new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_INFINITE, 1).setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").setName(ChatColor.RED + "Arc").UnBreak().toItemStack();
                    ItemStack Crossbow = new ItemBuilder(Material.CROSSBOW).addEnchant(Enchantment.IMPALING, 1).setName(ChatColor.RED + "Fusil").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    ItemStack Grapp = new ItemBuilder(Material.FISHING_ROD).addEnchant(Enchantment.LOYALTY, 10).setName(ChatColor.RED + "Grappin").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    ItemStack Arrow = new ItemBuilder(Material.ARROW).addEnchant(Enchantment.ARROW_DAMAGE, 1).setName(ChatColor.RED + "Flêche").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    ItemStack Balle = new ItemBuilder(Material.FIREWORK_ROCKET).setAmount(15).addEnchant(Enchantment.ARROW_DAMAGE, 1).setName(ChatColor.RED + "Balle").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    ItemStack Bouffe = new ItemBuilder(Material.GOLDEN_CARROT).setAmount(64).addEnchant(Enchantment.LUCK, 1).setName(ChatColor.RED + "Bouffe").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    player.getInventory().setItemInOffHand(Balle);
                    player.getInventory().setItem(1, Fireball);
                    player.getInventory().setItem(2, Bouffe);
                    player.getInventory().setItem(6, Grapp);
                    player.getInventory().setItem(7, Crossbow);
                    player.getInventory().setItem(8, Bow);
                    player.getInventory().setItem(17, Arrow);

                    player.updateInventory();


                }
            }
            if (it.getType() == Material.NETHER_STAR && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Arme event raid")) {
                if (ac == Action.LEFT_CLICK_AIR || ac == Action.LEFT_CLICK_BLOCK) {
                    player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                    /*
                     * ChatColor.RED + "================",ChatColor.YELLOW + " ◈ Item Event ◈ ",ChatColor.RED + "================"
                     * Fire ball arc arbaléte trident hache en pierre
                     */
                    ItemStack Fireball = new ItemBuilder(Material.FIRE_CHARGE).addEnchant(Enchantment.ARROW_DAMAGE, 2).setName(ChatColor.RED + "Boule de feu").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    ItemStack Bow = new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_INFINITE, 1).setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").setName(ChatColor.RED + "Arc").UnBreak().toItemStack();
                    ItemStack Crossbow = new ItemBuilder(Material.CROSSBOW).addEnchant(Enchantment.IMPALING, 1).setName(ChatColor.RED + "Fusil").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    ItemStack Trident = new ItemBuilder(Material.TRIDENT).addEnchant(Enchantment.LOYALTY, 4).setName(ChatColor.RED + "Trident").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    ItemStack Grapp = new ItemBuilder(Material.FISHING_ROD).addEnchant(Enchantment.LOYALTY, 10).setName(ChatColor.RED + "Grappin").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    ItemStack Arrow = new ItemBuilder(Material.ARROW).addEnchant(Enchantment.ARROW_DAMAGE, 1).setName(ChatColor.RED + "Flêche").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    ItemStack Balle = new ItemBuilder(Material.FIREWORK_ROCKET).addEnchant(Enchantment.ARROW_DAMAGE, 1).setName(ChatColor.RED + "Balle").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();
                    ItemStack Bouffe = new ItemBuilder(Material.GOLDEN_CARROT).addEnchant(Enchantment.LUCK, 1).setName(ChatColor.RED + "Bouffe").setLore(ChatColor.RED + "================", ChatColor.YELLOW + " ◈ Item Event ◈ ", ChatColor.RED + "================").UnBreak().toItemStack();

                    player.getInventory().addItem(Fireball);
                    player.getInventory().addItem(Bow);
                    player.getInventory().addItem(Crossbow);
                    player.getInventory().addItem(Trident);
                    player.getInventory().addItem(Grapp);
                    player.getInventory().addItem(Arrow);
                    player.getInventory().addItem(Balle);
                    player.getInventory().addItem(Bouffe);
                }
            }


        }

        // Liste des blocs destructibles
        private final List<Material> destructibleBlocks = Arrays.asList(
                Material.SPRUCE_FENCE, Material.IRON_BARS
        );

        @EventHandler
        public void onFireballLaunch (PlayerInteractEvent event){
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();

            // Vérifie si l'item est bien une boule de feu et a le bon nom
            if (item.getType() == Material.FIRE_CHARGE && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.RED + "Boule de feu")) {

                    // Retire l'objet après l'utilisation
                    if (item.getAmount() > 1) {
                        item.setAmount(item.getAmount() - 1);
                    } else {
                        player.getInventory().removeItem(item);
                    }

                    // Crée une boule de feu personnalisée
                    Fireball fireball = player.launchProjectile(Fireball.class);
                    fireball.setVelocity(player.getLocation().getDirection().multiply(2)); // Accélération x2
                    fireball.setIsIncendiary(false); // Ne met pas le feu
                    fireball.setYield(0); // Désactive l'explosion classique

                    event.setCancelled(true); // Annule l'interaction mais après le lancement
                }
            }
        }

        @EventHandler
        public void onFireballHit (ProjectileHitEvent event){
            if (event.getEntity() instanceof Fireball) {
                Fireball fireball = (Fireball) event.getEntity();
                Entity hitEntity = event.getHitEntity();
                Location explosionLocation = fireball.getLocation();

                // Détruit uniquement les blocs spécifiques
                breakSpecificBlocks(explosionLocation, 3); // Rayon de 3 blocs

                // Effet d'explosion sans endommager d'autres blocs
                fireball.getWorld().playSound(explosionLocation, Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);
                fireball.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, explosionLocation, 5);

                // Repousse les entités touchées
                if (hitEntity != null) {
                    Vector knockback = hitEntity.getLocation().toVector().subtract(fireball.getLocation().toVector()).normalize().multiply(1.5);
                    hitEntity.setVelocity(knockback);
                    hitEntity.playEffect(EntityEffect.HURT);
                }

                fireball.remove();
            }
        }

        // Méthode pour casser uniquement les blocs autorisés dans un rayon donné
        private void breakSpecificBlocks (Location center,int radius){
            World world = center.getWorld();
            if (world == null) return;

            for (int x = -radius; x <= radius; x++) {
                for (int y = -radius; y <= radius; y++) {
                    for (int z = -radius; z <= radius; z++) {
                        Block block = world.getBlockAt(center.clone().add(x, y, z));

                        if (destructibleBlocks.contains(block.getType())) {
                            block.breakNaturally(); // Casse le bloc normalement
                        }
                    }
                }
            }
        }
        @EventHandler
        public void onPlayerUseFishingRod (PlayerFishEvent event){
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();

            // Vérifie si c'est une canne à pêche avec le nom "Grappling Hook"
            if (item.getType() == Material.FISHING_ROD && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.RED + "Grappin")) {

                    // Vérifie si l'événement est le lancement ou l'attrapage du grappin
                    if (event.getState() == PlayerFishEvent.State.REEL_IN || event.getState() == PlayerFishEvent.State.IN_GROUND) {
                        Projectile hook = event.getHook();
                        Location hookLocation = hook.getLocation();
                        Location playerLocation = player.getLocation();

                        // Calcule la direction du grappin
                        Vector pullDirection = hookLocation.toVector().subtract(playerLocation.toVector()).normalize().multiply(1.5);

                        // Applique une vitesse au joueur
                        player.setVelocity(pullDirection);

                        // Effet sonore pour le fun
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1f, 1f);

                        // Particules lors du grappinage
                        player.getWorld().spawnParticle(Particle.CLOUD, player.getLocation(), 10);

                        // Empêche le grappin de ramener des items ou des entités
                        event.setCancelled(true);
                    }
                }
            }
        }

        @EventHandler
        public void onCrossbowShoot (EntityShootBowEvent event){
            if (event.getBow() != null && event.getBow().getType() == Material.CROSSBOW) {
                if (event.getProjectile() instanceof Firework) {
                    Firework firework = (Firework) event.getProjectile();
                    FireworkMeta meta = firework.getFireworkMeta();

                    // Ajoute une explosion si elle n'existe pas
                    if (meta.getEffects().isEmpty()) {
                        FireworkEffect effect = FireworkEffect.builder()
                                .with(FireworkEffect.Type.BALL_LARGE)
                                .withColor(Color.RED)
                                .withFade(Color.YELLOW)
                                .withFlicker()
                                .build();
                        meta.addEffect(effect);
                        firework.setFireworkMeta(meta);
                    }
                }
            }
        }


        public static Color hexToColor (String hexCode){
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



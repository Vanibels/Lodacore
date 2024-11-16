package fr.vanibels.lodacore.KitManager.command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class KitManagers {

    // Kit Grade joueur
    public void RoturierKit(Player player){
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GRAY + "Kit Roturier");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Click Droit", "Pour obtenir les items",ChatColor.RED + "◈ Item special ◈" ));
        itemMeta.addEnchant(Enchantment.LUCK, 1, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    public void BaronKit(Player player){
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_AQUA + "Kit Baron");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Click Droit", "Pour obtenir les items",ChatColor.RED + "◈ Item special ◈" ));
        itemMeta.addEnchant(Enchantment.LUCK, 2, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    public void VicomteKit(Player player){
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Kit Vicomte");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Click Droit", "Pour obtenir les items",ChatColor.RED + "◈ Item special ◈" ));
        itemMeta.addEnchant(Enchantment.LUCK, 3, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    public void ComteKit(Player player){
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.AQUA + "Kit Comte");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Click Droit", "Pour obtenir les items",ChatColor.RED + "◈ Item special ◈" ));
        itemMeta.addEnchant(Enchantment.LUCK, 4, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    public void MarquisKit(Player player){
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Kit Marquis");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Click Droit", "Pour obtenir les items",ChatColor.RED + "◈ Item special ◈" ));
        itemMeta.addEnchant(Enchantment.LUCK, 5, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    public void DucKit(Player player){
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "Kit Duc");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Click Droit", "Pour obtenir les items",ChatColor.RED + "◈ Item special ◈" ));
        itemMeta.addEnchant(Enchantment.LUCK, 6, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    public void RoisKit(Player player){
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GOLD + "Kit Rois");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Click Droit", "Pour obtenir les items",ChatColor.RED + "◈ Item special ◈"));
        itemMeta.addEnchant(Enchantment.LUCK, 7, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    public void EmpereurKit(Player player){
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW + "Kit Empereur");
        itemMeta.setLore(Arrays.asList(ChatColor.GOLD + "Click Droit", "Pour obtenir les items",ChatColor.YELLOW + "◈ Item special ◈"));
        itemMeta.addEnchant(Enchantment.LUCK, 8, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }

    // kit Responsable Gameplay & modérateur
    public void ModerateurKit(Player player){
        // Ascatools.E0000.giveStart(player);
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_RED + "Giver LV0 ---Moderator kit");
        itemMeta.setLore(Arrays.asList(ChatColor.DARK_RED + "Click Droit",ChatColor.DARK_RED + "Pour obtenir les items",ChatColor.DARK_RED +"Attention au clear de l'inventaire"));
        player.sendTitle(ChatColor.DARK_RED +"Click Droit Pour obtenir les items",ChatColor.DARK_RED +"Attention au clear de l'inventaire");
        itemMeta.addEnchant(Enchantment.LUCK, 10, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    public void DebugKit(Player player){
        // Ascatools.E0000.giveStart(player);
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_PURPLE + "Giver LV0 --- Dev debuger");
        itemMeta.setLore(Arrays.asList("$4Click Droit", "Pour obtenir les items"));
        itemMeta.addEnchant(Enchantment.LUCK, 10, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    // kit evenement
    public void SurvivantKit(Player player){
        // Ascatools.A0000.giveStart(player);
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Giver LV1 --- SURVIVANT");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Click Droit",ChatColor.YELLOW + "Pour obtenir les items",ChatColor.YELLOW +"◈ Item Event ◈"));
        itemMeta.addEnchant(Enchantment.LUCK, 1, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    public void ChevalierKit(Player player){
        // Ascatools.A0000.giveStart(player);
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_RED + "Giver LV2 --- CHEVALIER");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Click Droit",ChatColor.YELLOW + "Pour obtenir les items",ChatColor.YELLOW +"◈ Item Event ◈"));
        itemMeta.addEnchant(Enchantment.LUCK, 2, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    public void SeigneurKit(Player player){

        // Ascatools.A0000.giveStart(player);
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Giver LV3 --- SEIGNEUR");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW + "Click Droit",ChatColor.YELLOW + "Pour obtenir les items",ChatColor.YELLOW +"◈ Item Event ◈"));
        itemMeta.addEnchant(Enchantment.LUCK, 3, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }
    public void DieuKit(Player player){
        // Ascatools.A0000.giveStart(player);
        ItemStack item = new ItemStack(Material.NETHER_STAR);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.YELLOW + "Giver LV4 --- DIEU");
        itemMeta.setLore(Arrays.asList(ChatColor.YELLOW +  "Click Droit",ChatColor.YELLOW + "Pour obtenir les items",ChatColor.YELLOW +"◈ Item Event ◈"));
        itemMeta.addEnchant(Enchantment.LUCK, 4, true);
        item.setItemMeta(itemMeta);
        player.getInventory().addItem(item);
    }

}
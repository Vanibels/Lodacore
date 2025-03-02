package fr.vanibels.lodacore.Commands;

import fr.vanibels.lodacore.Lodacore;
import fr.vanibels.lodacore.Managers.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static fr.vanibels.lodacore.Lodacore.instance;

public class CoreCommandExecutor implements CommandExecutor {

    public static Lodacore ins = instance;
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
                case "ei","edititem","eitem":
                    if (!(sender instanceof Player)) return false;
                    
                    Player player = (Player) sender;
                    
                    if (player.getInventory().getItemInMainHand().getType() == Material.AIR){
                        player.sendMessage(instance.prefix + ChatColor.RED + " Prennez l'item dans votre main principal.");
                        return false;
                    }
                    
                    ItemEditor(player);
                    break;
                default:
                    sender.sendMessage(ChatColor.RED + "Command inconnue");

            }
            return true;
        }

        return false;
    }

    private void ItemEditor(Player player) {
        if (player.getInventory().getItemInMainHand().getItemMeta().getLore().contains(ChatColor.YELLOW +"◈ Item Event ◈")){
            player.sendMessage(ChatColor.RED + "Ce item a déja été modifié, veuiller en prendre un autre :/");
            return;
        }
        // Initialisation des variables
        String editor = ChatColor.GOLD + "Editeur";
        Inventory inv = Bukkit.createInventory(null,54,editor);
        ItemStack main = getItem(player);
        ItemStack save = new ItemBuilder(Material.ENCHANTED_BOOK).setName(ChatColor.GREEN + "Enregistrer").setLore("Click pour enregistrer","").toItemStack();
        ItemStack cancel = new ItemBuilder(Material.BARRIER).setName(ChatColor.RED + "Annuler").setLore("Click pour annuler les modifications").toItemStack();
        ItemStack name = new ItemBuilder(Material.NAME_TAG).setName(ChatColor.GREEN + "Nom").setLore("Click pour changer le nom de l'item").toItemStack();
        ItemStack model = new ItemBuilder(Material.ANVIL).setName(ChatColor.GREEN + "Model").setLore("Click pour changer","Le custom model data de l'item").toItemStack();
        ItemStack add = new ItemBuilder(Material.BOOKSHELF).setName(ChatColor.BLUE + "Description").setLore("Rajouter une ligne").toItemStack();
        ItemStack line1 = new ItemBuilder(Material.PAPER).setName(ChatColor.BLUE + "Ajouter une ligne").setLore("Ajouter une ligne de description max-7").toItemStack();
        ItemStack line2 = new ItemBuilder(Material.PAPER,2).setName(ChatColor.BLUE + "Description").setLore("Premier click pour ajouter la ligne","Second click pour modifier la description").toItemStack();
        ItemStack line3 = new ItemBuilder(Material.PAPER,3).setName(ChatColor.BLUE + "Description").setLore("Premier click pour ajouter la ligne","Second click pour modifier la description").toItemStack();
        ItemStack line4 = new ItemBuilder(Material.PAPER,4).setName(ChatColor.BLUE + "Description").setLore("Premier click pour ajouter la ligne","Second click pour modifier la description").toItemStack();
        ItemStack line5 = new ItemBuilder(Material.PAPER,5).setName(ChatColor.BLUE + "Description").setLore("Premier click pour ajouter la ligne","Second click pour modifier la description").toItemStack();
        ItemStack line6 = new ItemBuilder(Material.PAPER,6).setName(ChatColor.BLUE + "Description").setLore("Premier click pour ajouter la ligne","Second click pour modifier la description").toItemStack();
        ItemStack line7 = new ItemBuilder(Material.PAPER,7).setName(ChatColor.BLUE + "Description").setLore("Premier click pour ajouter la ligne","Second click pour modifier la description").toItemStack();
        // Mise en place des items
        inv.setItem(0,save);
        inv.setItem(8,cancel);
        inv.setItem(11,name);
        inv.setItem(13,main);
        inv.setItem(15,model);
        inv.setItem(31,add);
        inv.setItem(37,line1);
        inv.setItem(38,line2);
        inv.setItem(39,line3);
        inv.setItem(40,line4);
        inv.setItem(41,line5);
        inv.setItem(42,line6);
        inv.setItem(43,line7);
        // Logique des items


        // Lancement de la frame
        player.openInventory(inv);
    }

    public static ItemStack getItem(Player player){
        return player.getInventory().getItemInMainHand();
    }
}

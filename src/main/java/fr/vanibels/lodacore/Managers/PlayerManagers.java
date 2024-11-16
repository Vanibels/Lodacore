package fr.vanibels.lodacore.Managers;

import fr.vanibels.lodacore.Utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static fr.vanibels.lodacore.Lodacore.instance;

public class PlayerManagers {
    private Player player;
    private ItemStack[] items = new ItemStack[40];
    public static boolean isModerator(Player player){
        return instance.modList.contains(player.getUniqueId());
    }
    public static boolean isVanished(Player player){
        return instance.vList.contains(player.getUniqueId());

    }
    public static void setVanished(Player player, boolean vanish) {
        if (vanish) {
            instance.vList.add(player.getUniqueId());
        } else {
            instance.vList.remove(player.getUniqueId());
        }
    }
    public static boolean isFreezed(Player player){
        return instance.freezList.contains(player.getUniqueId());

    }

    public PlayerManagers(Player player){
        this.player = player;

    }

    public void init(){
        instance.players.put(player.getUniqueId(), this);
    }
    public void setup(){
        ItemStack invSee = new ItemBuilder(Material.PAPER).setName(ChatColor.GREEN +"Voir inventaire").setLore("Click droit sur un joueur").toItemStack();
        ItemStack vanish = new ItemBuilder(Material.BLAZE_POWDER).setName(ChatColor.YELLOW +"Vanish").setLore("Click droit pour passer en vanish").toItemStack();
        ItemStack freeze = new ItemBuilder(Material.PACKED_ICE).setName(ChatColor.BLUE +"Freeze").setLore("Click droit sur un joueur").toItemStack();
        ItemStack rbTp = new ItemBuilder(Material.ENDER_EYE).setName(ChatColor.DARK_GREEN +"Aller a un joueur").setLore("Click droit pour","aller a un joueur").toItemStack();
        ItemStack kbTester = new ItemBuilder(Material.STICK).setName(ChatColor.DARK_GRAY +"KB").setLore("Click guache test les kb").addUnsafeEnchantment(Enchantment.KNOCKBACK, 5).toItemStack();
        ItemStack playerKiller = new ItemBuilder(Material.DIAMOND_SWORD).setName(ChatColor.RED +"Killer").setLore("Click droit sur un joueur/entité","pour le tuer").toItemStack();
        ItemStack DebugStick = new ItemBuilder(Material.DEBUG_STICK).setName(ChatColor.DARK_PURPLE + "Debugger").setLore("Execute la commande /co i").toItemStack();
        ItemStack Reports = new ItemBuilder(Material.CHEST).setName(ChatColor.GOLD + "Reports").setLore("Execute la commande /reports").toItemStack();

        player.getInventory().setItem(0,invSee);
        player.getInventory().setItem(1,vanish);
        player.getInventory().setItem(2,freeze);
        player.getInventory().setItem(3,rbTp);
        player.getInventory().setItem(4,kbTester);
        player.getInventory().setItem(5,playerKiller);
        player.getInventory().setItem(6,DebugStick);
        player.getInventory().setItem(7,Reports);
        player.sendMessage(ChatColor.GREEN+"Outils de moderation activé");
        player.setAllowFlight(true);
        player.setFlying(true);
        player.setGameMode(GameMode.CREATIVE);
        player.setCollidable(false);
        player.sendTitle(ChatColor.RED + "Mode moderation",ChatColor.GREEN + "Activé");


    }
    public void destroy(){
        instance.players.remove(player.getUniqueId());
    }
    public static PlayerManagers getFromPlayer(Player player){

        return instance.players.get(player.getUniqueId());
    }

    public ItemStack[] getItems() {
        return items;
    }

    public void saveIventory(){
        for (int i =0; i < 36; i++){
            ItemStack item= player.getInventory().getItem(i);
            if (item != null){
                items[i] = item;
            }
        }

    }
    public void giveIventory(){
        player.getInventory().clear();
        for (int i =0; i < 36; i++){
            ItemStack item= getItems()[i];
            if (item != null){
                player.getInventory().setItem(i, item);
            }

        }


    }
}

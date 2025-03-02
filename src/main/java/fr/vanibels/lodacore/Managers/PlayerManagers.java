package fr.vanibels.lodacore.Managers;

import fr.vanibels.lodacore.Managers.Utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.metadata.FixedMetadataValue;

import static fr.vanibels.lodacore.Lodacore.instance;

public class PlayerManagers {
    private Player player;
    private ItemStack[] items = new ItemStack[40];
    public static boolean isModerator(Player player){
        return instance.modList.contains(player.getUniqueId());
    }
    public static boolean isVanished(Player player){
        return instance.vanishPlayers.contains(player.getUniqueId());

    }
    public static void setVanished(Player player, boolean vanish) {
        if (vanish) {
            instance.vanishPlayers.add(player.getUniqueId());
        } else {
            instance.vanishPlayers.remove(player.getUniqueId());
        }
    }
    public static boolean isFreezed(Player player){
        return instance.frozenPlayers.contains(player.getUniqueId());

    }

    public PlayerManagers(Player player){
        this.player = player;

    }

    public void init(){
        instance.players.put(player.getUniqueId(), this);
    }
    public void setup(Player player) {
        // Outils de modération
        ItemStack rbTp = new ItemBuilder(Material.ENDER_EYE)
                .setName(ChatColor.DARK_GREEN + "Aller à un joueur")
                .setLore("Click droit pour", "aller à un joueur")
                .toItemStack();

        ItemStack kbTester = new ItemBuilder(Material.STICK)
                .setName(ChatColor.DARK_GRAY + "KB Tester")
                .setLore("Click gauche pour tester les KB")
                .addUnsafeEnchantment(Enchantment.KNOCKBACK, 5)
                .toItemStack();

        ItemStack debugStick = new ItemBuilder(Material.DEBUG_STICK)
                .setName(ChatColor.DARK_PURPLE + "Debugger")
                .setLore("Exécute la commande /co i")
                .toItemStack();

        ItemStack reports = new ItemBuilder(Material.CHEST)
                .setName(ChatColor.GOLD + "Reports")
                .setLore("Exécute la commande /reports")
                .toItemStack();

        ItemStack worldEdit = new ItemBuilder(Material.WOODEN_AXE)
                .setName(ChatColor.GOLD + "Edit")
                .setLore("FAWE axe")
                .toItemStack();

        // Nouveaux outils utiles pour les OPs
        ItemStack vanishTool = new ItemBuilder(Material.BLAZE_ROD)
                .setName(ChatColor.LIGHT_PURPLE + "Vanish Tool")
                .setLore("Click droit pour activer/désactiver le vanish")
                .toItemStack();

        ItemStack freezeTool = new ItemBuilder(Material.ICE)
                .setName(ChatColor.AQUA + "Freeze Tool")
                .setLore("Click droit sur un joueur pour le figer")
                .toItemStack();

        ItemStack invseeTool = new ItemBuilder(Material.BOOK)
                .setName(ChatColor.BLUE + "Voir l’inventaire")
                .setLore("Click droit sur un joueur pour voir son inventaire")
                .toItemStack();

        // Remplissage de l'inventaire
        player.getInventory().clear();
        player.getInventory().setItem(0, rbTp);
        player.getInventory().setItem(1, kbTester);
        player.getInventory().setItem(2, debugStick);
        player.getInventory().setItem(3, reports);
        player.getInventory().setItem(4, worldEdit);
        player.getInventory().setItem(5, vanishTool);
        player.getInventory().setItem(6, freezeTool);
        player.getInventory().setItem(7, invseeTool);

        // Mode modération activé
        player.sendMessage(ChatColor.GREEN + "Outils de modération activés !");
        player.setAllowFlight(true);
        player.setFlying(true);
        player.setGameMode(GameMode.CREATIVE);
        player.setCollidable(false);
        player.sendTitle(ChatColor.RED + "Mode modération", ChatColor.GREEN + "Activé");

        // Permet de casser des blocs en mode créatif
        player.setMetadata("canBreakBlocks", new FixedMetadataValue(instance, true));
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

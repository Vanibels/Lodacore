package fr.vanibels.lodacore.Commands;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CommandListExecutor implements CommandExecutor {
    private final LuckPerms luckPerms;

    public CommandListExecutor(LuckPerms luckPerms) {
        this.luckPerms = luckPerms;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("La console ne peut pas utiliser cette commande.");
            return true;
        }

        Player player = (Player) sender;

        // Créer un inventaire dynamique basé sur le nombre de joueurs connectés
        int size = ((Bukkit.getOnlinePlayers().size() / 9) + 1) * 9;  // Ajuster la taille à la prochaine multiple de 9
        Inventory playerListInventory = Bukkit.createInventory(null, size, ChatColor.YELLOW + "Joueurs connectés");

        // Parcourir les joueurs connectés
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            // Créer un ItemStack pour chaque joueur
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);  // Tête du joueur
            ItemMeta meta = playerHead.getItemMeta();

            assert meta != null;
            meta.setDisplayName(ChatColor.GOLD + onlinePlayer.getDisplayName());

            // Récupérer le grade via LuckPerms
            User user = luckPerms.getUserManager().getUser(onlinePlayer.getUniqueId());
            String grade = (user != null) ? user.getPrimaryGroup() : "Inconnu";

            // Ajouter des informations dans le lore
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.AQUA + "Grade: " + ChatColor.GREEN + grade);
            lore.add(ChatColor.GRAY + "Santé: " + onlinePlayer.getHealth());
            lore.add(ChatColor.GRAY + "UUID: " + onlinePlayer.getUniqueId());

            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            // Ajouter l'item dans l'inventaire
            playerListInventory.addItem(playerHead);
        }

        // Ouvrir l'inventaire pour le joueur
        player.openInventory(playerListInventory);

        return true;
    }
}

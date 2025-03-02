package fr.vanibels.lodacore.Events;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static fr.vanibels.lodacore.Lodacore.instance;

public class ModeratorInteracEvent implements Listener {
    @EventHandler
    public void ModInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item == null || item.getType() == Material.AIR) return;
        if (!instance.modList.contains(player.getUniqueId())) return;

        switch (item.getType()) {
            case ENDER_EYE:
                List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
                list.remove(player);
                if (list.isEmpty()) {
                    player.sendMessage(ChatColor.RED + "Aucun autre joueur connecté.");
                    return;
                }
                Player target = list.get(new Random().nextInt(list.size()));
                player.teleport(target.getLocation());
                player.sendMessage(ChatColor.GREEN + "Téléportation à " + ChatColor.AQUA + target.getName());
                break;

            case CHEST:
                player.performCommand("reports");
                break;

            case DEBUG_STICK:
                player.performCommand("co i");
                break;

            case BLAZE_ROD: // Vanish Tool
                if (instance.vanishPlayers.contains(player.getUniqueId())) {
                    instance.vanishPlayers.remove(player.getUniqueId());
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        onlinePlayer.showPlayer(instance, player);
                    }
                    player.sendMessage(ChatColor.YELLOW + "Vanish désactivé !");
                } else {
                    instance.vanishPlayers.add(player.getUniqueId());
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        if (!onlinePlayer.hasPermission("lodaria.moderation")) {
                            onlinePlayer.hidePlayer(instance, player);
                        }
                    }
                    player.sendMessage(ChatColor.GREEN + "Vanish activé !");
                }
                break;

            case ICE: // Freeze Tool
                Player targetFreeze = getTargetPlayer(player);
                if (targetFreeze != null) {
                    if (instance.frozenPlayers.contains(targetFreeze.getUniqueId())) {
                        instance.frozenPlayers.remove(targetFreeze.getUniqueId());
                        targetFreeze.sendMessage(ChatColor.RED + "Vous êtes dégelé !");
                        player.sendMessage(ChatColor.GREEN + targetFreeze.getName() + " est dégelé !");
                    } else {
                        instance.frozenPlayers.add(targetFreeze.getUniqueId());
                        targetFreeze.sendMessage(ChatColor.RED + "Vous êtes gelé !");
                        player.sendMessage(ChatColor.GREEN + targetFreeze.getName() + " est gelé !");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Aucun joueur visé.");
                }
                break;

            case BOOK: // Voir l'inventaire (Invsee)
                Player targetInvsee = getTargetPlayer(player);
                if (targetInvsee != null) {
                    player.openInventory(targetInvsee.getInventory());
                    player.sendMessage(ChatColor.GREEN + "Ouverture de l'inventaire de " + targetInvsee.getName());
                } else {
                    player.sendMessage(ChatColor.RED + "Aucun joueur visé.");
                }
                break;

            default:
                break;
        }
    }

    // Fonction pour récupérer le joueur ciblé
    private Player getTargetPlayer(Player player) {
        List<Entity> nearbyEntities = player.getNearbyEntities(5, 5, 5);
        for (Entity entity : nearbyEntities) {
            if (entity instanceof Player) {
                return (Player) entity;
            }
        }
        return null;
    }

    // Gestion du freeze dans un autre event pour empêcher les déplacements
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (instance.frozenPlayers.contains(player.getUniqueId())) {
            event.setTo(event.getFrom()); // Annule le mouvement
            player.sendMessage(ChatColor.RED + "Vous êtes gelé !");
        }
    }


    @EventHandler
    public void CoreInteractorEditorEvenet(InventoryInteractEvent e){
        Player player = (Player) e.getWhoClicked();
        ItemStack it = e.getWhoClicked().getItemInUse();
        Inventory inv = e.getInventory();

        if ( !(inv.getType().name().equals(ChatColor.GOLD + "Editeur"))) return;

        switch (it.getType()){
            case ENCHANTED_BOOK:
                inv.clear();
                e.setCancelled(true);
                break;
            case BARRIER:
                //it.getItemMeta();
                e.setCancelled(true);
                break;
            case NAME_TAG:
                e.setCancelled(true);
                break;
            case ANVIL:
                e.setCancelled(true);
                break;
            case PAPER:
                e.setCancelled(true);
                break;
            case BOOKSHELF:
                e.setCancelled(true);
                break;
            default: e.setCancelled(true);
        }

    }

}
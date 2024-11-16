package fr.vanibels.lodacore.Events;


import fr.vanibels.lodacore.Commands.StaffCommand;
import fr.vanibels.lodacore.Managers.PlayerManagers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static fr.vanibels.lodacore.Lodacore.MutedPlayers;
import static fr.vanibels.lodacore.Lodacore.instance;

public class ModeratorInteracEvent implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        // Si le joueur est gelé, on bloque son mouvement
        if (PlayerManagers.isFreezed(player)) {
            event.setCancelled(true);
            MutedPlayers.add(event.getPlayer().toString());
        }
    }
    @EventHandler
    public void ModInterac(PlayerInteractEntityEvent e){
        Player player = e.getPlayer();
        if (!PlayerManagers.isModerator(player)) return;
        if (!(e.getRightClicked() instanceof Player)) return;
        Player target = (Player) e.getRightClicked();
        e.setCancelled(true);

        switch (player.getInventory().getItemInMainHand().getType()){

            case PAPER:
                Inventory inv = Bukkit.createInventory(null,5 *9, ChatColor.BLUE + "Inventaire " + target.getName());

                for (int i =0; i<36;i++){
                    if (target.getInventory().getItem(i) != null){
                        inv.setItem(i,target.getInventory().getItem(i));
                    }
                }
                inv.setItem(36, target.getInventory().getHelmet());
                inv.setItem(37, target.getInventory().getChestplate());
                inv.setItem(38, target.getInventory().getLeggings());
                inv.setItem(39, target.getInventory().getBoots());

                player.openInventory(inv);

                break;
            case  DIAMOND_SWORD:
                if (!(e.getRightClicked() instanceof LivingEntity)) return;
                LivingEntity entity = (LivingEntity) e.getRightClicked();
                entity.setHealth(0);
                break;
            case PACKED_ICE:
                if (PlayerManagers.isFreezed(target)) {
                    // Si le joueur est déjà gelé, on le dégèle
                    instance.freezList.remove(target.getUniqueId());
                    MutedPlayers.remove(target.getUniqueId().toString());
                    target.sendMessage(ChatColor.GREEN + "Vous avez été dégelé.");
                    return;
                }
                // Si le joueur n'est pas gelé, on l'ajoute à la liste des joueurs gelés
                instance.freezList.add(target.getUniqueId());
                target.sendMessage(ChatColor.RED + "Vous avez été gelé !");
                target.sendMessage(ChatColor.RED + "Passez sur TeamSpeak : ts.lodaria.net ou sur le Discord : /discord !");
                target.sendTitle(ChatColor.RED + "Vous avez été gelé !", ChatColor.YELLOW + "Passez sur TeamSpeak : ts.lodaria.net ou Discord : /discord !");
                break;



            default: break;
        }
    }
    @EventHandler
    public void ModInteract(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if (!PlayerManagers.isModerator(player)) return;
        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        switch (player.getInventory().getItemInMainHand().getType()){
            case ENDER_EYE:
                List<Player> list = new ArrayList<>(Bukkit.getOnlinePlayers());
                list.remove(player);
                if (list.size() == 0){
                    player.sendMessage("Aucun autre joueur connecte");
                    return;
                }
                Player target = list.get(new Random().nextInt(list.size()));
                player.teleport(target.getLocation());
                player.sendMessage("Teleportation a " + target.getName());


                break;
            case BLAZE_POWDER:
                if (PlayerManagers.isVanished(player)) {
                    // Si le joueur est déjà en vanish, on le rend visible pour tous les autres joueurs
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        players.showPlayer(instance, player);
                    }
                    // Change l'état du vanish à false
                    PlayerManagers.setVanished(player, false);
                    player.sendMessage(ChatColor.GREEN + "Vous êtes maintenant visible.");
                    return;
                }
                // Si le joueur n'est pas en vanish, on le rend invisible pour tous les autres joueurs
                for (Player players : Bukkit.getOnlinePlayers()) {
                    players.hidePlayer(instance, player);
                }
                // Change l'état du vanish à true
                PlayerManagers.setVanished(player, true);
                player.sendMessage(ChatColor.RED + "Vous êtes maintenant en vanish.");
                break;
            case CHEST:
                player.performCommand("reports");
                break;
            case DEBUG_STICK:
                player.performCommand("co i");
                break;
            default: break;
        }

    }
}
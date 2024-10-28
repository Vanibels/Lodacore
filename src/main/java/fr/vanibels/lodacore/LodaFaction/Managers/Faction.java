package fr.vanibels.lodacore.LodaFaction.Managers;
import java.util.*;

public class Faction {
    private int id;
    private int power;
    private int powerMax;
    private String name;
    private UUID leaderUUID;
    private String description;
    private int level;
    private int xp;
    private int bankBalance;
    private List<UUID> members;
    private Map<UUID, String> roles;
    private Set<String> claims;
    private List<Faction> alliances;
    private int[] home; // Coordonnées du point de retour : [x, y, z]

    // Hiérarchie des rôles
    private final List<String> roleHierarchy = Arrays.asList("Villageois", "Officier", "Noble", "Vassal", "Roi");

    // Constructeur de la faction
    public Faction(String name, UUID leaderUUID, String description) {
        this.name = name;
        this.leaderUUID = leaderUUID;
        this.description = description;
        this.level = 1;
        this.xp = 0;
        this.bankBalance = 0;
        this.power = 20;
        this.powerMax = 50;
        this.members = new ArrayList<>();
        this.roles = new HashMap<>();
        this.claims = new HashSet<>();
        this.alliances = new ArrayList<>();
        this.home = new int[] {0, 64, 0}; // Coordonnées par défaut

        // Ajouter le leader en tant que "Roi"
        addMember(leaderUUID, "Roi");

        // Créer la table factions si elle n'existe pas, et ajouter cette faction à la base de données
        FactionDAO.createTableIfNotExists();
        FactionDAO.saveFaction(this);
    }

    // Méthodes de gestion des membres et rôles
    public void addMember(UUID playerUUID, String role) {
        members.add(playerUUID);
        roles.put(playerUUID, role);
        FactionDAO.updateFaction(this);
    }

    public void removeMember(UUID playerUUID) {
        members.remove(playerUUID);
        roles.remove(playerUUID);
        FactionDAO.updateFaction(this);
    }

    // Gestion de l'expérience et du niveau
    public void addXp(int amount) {
        xp += amount;
        checkLevelUp();
        FactionDAO.updateFaction(this);
    }

    private void checkLevelUp() {
        if (level < 10 && xp >= level * 20) {
            level++;
            powerMax = powerMax + 1;
            xp = 0;
        } else if (level >= 10 && level < 100 && xp >= 100) {
            level++;
            powerMax = powerMax + 5;
            xp = 0;
        } else if (level >= 100 && level < 200 && xp >= 1000) {
            level++;
            powerMax = powerMax + 15;
            xp = 0;
        }
    }

    // Gestion du point de retour (f home)
    public void setHome(int x, int y, int z) {
        home = new int[] {x, y, z};
        FactionDAO.updateFaction(this);
    }

    public int[] getHome() {
        return home;
    }

    // Getters
    public String getName() { return name; }
    public UUID getLeaderUUID() { return leaderUUID; }
    public String getDescription() { return description; }
    public int getLevel() { return level; }
    public int getXp() { return xp; }
    public int getBankBalance() { return bankBalance; }
    public int getPower() {
        return power;
    }
    public int getPowerMax() {
        return powerMax;
    }

    // Autres méthodes pour gérer les alliances, les claims, la banque, etc.
}

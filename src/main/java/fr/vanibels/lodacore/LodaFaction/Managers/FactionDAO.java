package fr.vanibels.lodacore.LodaFaction.Managers;
import java.sql.*;
import java.util.UUID;

public class FactionDAO {
    private static final String DB_URL = "jdbc:sqlite:factions.db";

    // Méthode pour créer la table factions si elle n'existe pas
    public static void createTableIfNotExists() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS factions (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "leaderUUID TEXT NOT NULL," +
                    "description TEXT," +
                    "level INTEGER," +
                    "xp INTEGER," +
                    "bankBalance INTEGER," +
                    "homeX INTEGER," +
                    "homeY INTEGER," +
                    "homeZ INTEGER)"+
                    "power INTEGER," +
                    "powerMax INTEGER,";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour sauvegarder une faction dans la base de données
    public static void saveFaction(Faction faction) {
        String sql = "INSERT INTO factions (name, leaderUUID, description, level, xp, bankBalance, homeX, homeY, homeZ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, faction.getName());
            pstmt.setString(2, faction.getLeaderUUID().toString());
            pstmt.setString(3, faction.getDescription());
            pstmt.setInt(4, faction.getLevel());
            pstmt.setInt(5, faction.getXp());
            pstmt.setInt(6, faction.getBankBalance());
            pstmt.setInt(7, faction.getHome()[0]);
            pstmt.setInt(8, faction.getHome()[1]);
            pstmt.setInt(9, faction.getHome()[2]);
            pstmt.setInt(10, faction.getPower());
            pstmt.setInt(10, faction.getPowerMax());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour mettre à jour une faction dans la base de données
    public static void updateFaction(Faction faction) {
        String sql = "UPDATE factions SET level = ?, xp = ?, bankBalance = ?, homeX = ?, homeY = ?, homeZ = ? WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, faction.getLevel());
            pstmt.setInt(2, faction.getXp());
            pstmt.setInt(3, faction.getBankBalance());
            pstmt.setInt(4, faction.getHome()[0]);
            pstmt.setInt(5, faction.getHome()[1]);
            pstmt.setInt(6, faction.getHome()[2]);
            pstmt.setString(7, faction.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer une faction
    public static void deleteFaction(String factionName) {
        String sql = "DELETE FROM factions WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, factionName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



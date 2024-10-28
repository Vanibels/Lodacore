package fr.vanibels.lodacore.Managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private Connection connection;
    private String url;
    private String username;
    private String password;

    public Database(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Connexion à la base de données
    public void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connexion réussie à la base de données !");
        }
    }

    // Déconnexion de la base de données
    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Créer les tables si elles n'existent pas
    public void createTables() throws SQLException {
        String createFactionTable = "CREATE TABLE IF NOT EXISTS factions (" +
                "faction_id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(100) NOT NULL," +
                "description TEXT," +
                "leader_uuid VARCHAR(36)," +
                "level INT DEFAULT 1," +
                "xp INT DEFAULT 0," +
                "bank_balance INT DEFAULT 0" +
                ");";

        String createMembersTable = "CREATE TABLE IF NOT EXISTS faction_members (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "faction_id INT," +
                "member_uuid VARCHAR(36)," +
                "role VARCHAR(20)," +
                "FOREIGN KEY (faction_id) REFERENCES factions(faction_id)" +
                ");";

        try (PreparedStatement statement1 = connection.prepareStatement(createFactionTable);
             PreparedStatement statement2 = connection.prepareStatement(createMembersTable)) {
            statement1.executeUpdate();
            statement2.executeUpdate();
            System.out.println("Tables créées (si elles n'existaient pas déjà).");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

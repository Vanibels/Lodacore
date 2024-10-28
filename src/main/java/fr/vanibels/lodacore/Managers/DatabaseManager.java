package fr.vanibels.lodacore.Managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private Connection connection;

    // Connexion à la base de données
    public void connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/lodaria_factions";
        String user = "root";
        String password = "your_password";
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to database!");
    }

    // Récupérer la connexion
    public Connection getConnection() {
        return connection;
    }

    // Déconnexion de la base de données
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected from database!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Méthode pour créer les tables si elles n'existent pas
    public void setupDatabase() {
        try (Statement statement = connection.createStatement()) {
            // Création de la table factions
            String createFactionsTable = "CREATE TABLE IF NOT EXISTS factions (" +
                    "faction_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(50) UNIQUE NOT NULL," +
                    "description TEXT," +
                    "leader_uuid CHAR(36)," +
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                    ");";
            statement.executeUpdate(createFactionsTable);

            // Création de la table members
            String createMembersTable = "CREATE TABLE IF NOT EXISTS members (" +
                    "player_uuid CHAR(36) NOT NULL," +
                    "faction_id INT," +
                    "role ENUM('LEADER', 'OFFICER', 'MEMBER') DEFAULT 'MEMBER'," +
                    "joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    "FOREIGN KEY (faction_id) REFERENCES factions(faction_id) ON DELETE CASCADE," +
                    "PRIMARY KEY (player_uuid, faction_id)" +
                    ");";
            statement.executeUpdate(createMembersTable);

            // Création de la table alliances
            String createAlliancesTable = "CREATE TABLE IF NOT EXISTS alliances (" +
                    "faction_id INT," +
                    "ally_faction_id INT," +
                    "PRIMARY KEY (faction_id, ally_faction_id)," +
                    "FOREIGN KEY (faction_id) REFERENCES factions(faction_id) ON DELETE CASCADE," +
                    "FOREIGN KEY (ally_faction_id) REFERENCES factions(faction_id) ON DELETE CASCADE" +
                    ");";
            statement.executeUpdate(createAlliancesTable);

            // Création de la table enemies
            String createEnemiesTable = "CREATE TABLE IF NOT EXISTS enemies (" +
                    "faction_id INT," +
                    "enemy_faction_id INT," +
                    "PRIMARY KEY (faction_id, enemy_faction_id)," +
                    "FOREIGN KEY (faction_id) REFERENCES factions(faction_id) ON DELETE CASCADE," +
                    "FOREIGN KEY (enemy_faction_id) REFERENCES factions(faction_id) ON DELETE CASCADE" +
                    ");";
            statement.executeUpdate(createEnemiesTable);

            System.out.println("Database setup complete. All tables are ready.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


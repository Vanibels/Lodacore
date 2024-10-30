package fr.vanibels.lodacore.Managers;

import java.sql.SQLException;

import static fr.vanibels.lodacore.Lodacore.instance;

public class DBManagers {
    private DBConnection MainConnection;

    public DBManagers(){
        this.MainConnection = new DBConnection(new DBCredential(instance.getConfig().getString("database.host"),instance.getConfig().getString("database.user"),instance.getConfig().getString("database.password"),instance.getConfig().getString("database.DBName"),instance.getConfig().getString("database.port")));
    }

    public void close(){
        try {
            this.MainConnection.Close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DBConnection getMainConnection() {
        return MainConnection;
    }
}

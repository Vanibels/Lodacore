package fr.vanibels.lodacore.Managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnection {
    private DBCredential dbCredential;

    private Connection connection;

    public DBConnection(DBCredential dbCredential) {
        this.dbCredential = dbCredential;

        this.Connect();
    }

    private void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.dbCredential.toURI(),this.dbCredential.getUser(),this.dbCredential.getPass());

            Logger.getLogger("Minecraft").info("Connexion à la base de donné réussi");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void Close() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()){
            this.connection.close();
        }
    }
    public Connection getConnection() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()){
            return this.connection;
        }
        else {
            Connect();
            return this.connection;
        }
    }

}

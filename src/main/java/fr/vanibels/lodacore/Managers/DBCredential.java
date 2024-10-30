package fr.vanibels.lodacore.Managers;

public class DBCredential {

    private String Host;
    private String User;
    private String Pass;
    private String DBName;
    private String Port;

    public DBCredential(String host, String user, String pass, String dbName, String port){
        Host = host;
        User = user;
        Pass = pass;
        DBName = dbName;
        Port = port;
    }

    public String toURI(){
       final StringBuilder sb = new StringBuilder();
       sb.append("jdbc:mysql://")
               .append(Host)
               .append(":")
               .append(Port)
               .append("/")
               .append(DBName);

       return sb.toString();
    }

    public String getUser() {
        return User;
    }

    public String getPass() {
        return Pass;
    }
}
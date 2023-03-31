import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class mySQLWriter {
    private static String url = "jdbc:mariadb://localhost:3306/tv3";
    private static String user_database = "root";
    private static String password_database = "Anto2554!";
    private static Connection connection;
    private static Statement statement = null;

    public Connection mySQLConnection() {
        try {
            System.out.println("All good");
            connection = DriverManager.getConnection(url, user_database, password_database);
            statement = connection.createStatement();
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            return null;
        }
    }

    public void dataLoader(String inputString){
        try {
            //statement.execute("INSERT INTO `"+ type +"` VALUES ("+ inputString + ");");
            statement.execute(inputString);
            System.out.println("Loader is good");
        } catch (SQLException e) {
            System.out.println("Loader has failed");
        }
    }


    public static void main(String[] args){
        Loaders loader = new Loaders();
        mySQLWriter writer = new mySQLWriter();
        writer.mySQLConnection();
        try {
            //System.out.println(loader.loadJournalist("src/main/resources/Journalists.csv"));
            writer.dataLoader(loader.loadJournalist("src/main/resources/Journalists.csv"));
            writer.dataLoader(loader.loadEdition("src/main/resources/Editions.csv"));
            writer.dataLoader(loader.loadPhone("src/main/resources/PhoneNumbers.csv"));
            writer.dataLoader(loader.loadEmail("src/main/resources/Emails.csv"));

            writer.dataLoader(loader.loadTopic("src/main/resources/Topic.csv"));
            writer.dataLoader(loader.loadRoles("src/main/resources/Roles.csv"));
            writer.dataLoader(loader.loadItem("src/main/resources/item.csv"));
            writer.dataLoader(loader.loadFootage("src/main/resources/footageCSV.csv"));
            writer.dataLoader(loader.loadFootage("src/main/resources/uploads.csv"));
            //writer.dataLoader(loader.loadJournalistFromUploads("src/main/resources/uploads.csv"));
            //This class was adding all the journalists from the file but that doesnt really work because there
            //are duplicates and then we have to take that into account

        }
        catch(IOException e){
            System.out.println("errors is made: " + e);
        }
    }
}

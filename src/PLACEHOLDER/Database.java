package PLACEHOLDER;
import java.sql.*;

public class Database {

    private static Connection connection;
    private static Statement statement;

    private Database() {}

    public static void establishConnection() {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@92.247.131.11:41521:xe","hkostadinov_rents","rrents123");
            statement = connection.createStatement();

        } catch(Exception e) {System.out.println(e);}

    }

    public static void addNewUser(String username, String password, String email) {
        String values = "USERS_SEQ.NEXTVAL, '" + username + "', '" + password + "', '" + email + "'";
        String query = "INSERT INTO Users VALUES (" + values + ")";
        System.out.println(query);
        try {
            statement.executeQuery(query);
        } catch(Exception e) {System.out.println(e);}
    }

}

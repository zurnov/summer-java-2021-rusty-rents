package PLACEHOLDER;
import java.sql.*;

public class Database {

    private static Connection connection;
    private static Statement statement;

    private static String values, query;

    private Database() {}

    public static void establishConnection() {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@92.247.131.11:41521:xe","hkostadinov_rents","rrents123");
            statement = connection.createStatement();

        } catch(Exception e) {System.out.println(e);}

    }

    public static void storeLogin(String username, String password) {

        String subquery = "(SELECT User_Id FROM Users WHERE User_Name = '" + username + "')";

        values = "LOGINS_SEQ.NEXTVAL, " + subquery + ", '" + password + "'";
        query = "INSERT INTO No_Hackers_Pls VALUES (" + values + ")";

        System.out.println(query);
        try {
            statement.executeQuery(query);
            statement.executeQuery("COMMIT");
        } catch(Exception e) {System.out.println(e);}

    }

    public static void addNewUser(String username, String password, String email) {

        values = "USERS_SEQ.NEXTVAL, '" + username + "', '" + email + "'";
        query = "INSERT INTO Users VALUES (" + values + ")";

        System.out.println(query);
        try {
            statement.executeQuery(query);
            statement.executeQuery("COMMIT");
        } catch(Exception e) {System.out.println(e);}

        storeLogin(username, password);

    }

    public static boolean isValidLogin(String username, String password) {

        query = "SELECT User_Id FROM Users WHERE USER_NAME = '" + username + "'";

        try {
            int userId = -1;
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                userId = rs.getInt(1);
            }
            else {
                System.out.println("No such username exists.");
                return false;
            }

            query = "SELECT Pass_Code FROM No_Hackers_Pls WHERE User_Id = " + userId;
            rs = statement.executeQuery(query);
            rs.next();
            String fetchedPass = rs.getString(1);
            if (!password.equals(fetchedPass)) {
                System.out.println("Invalid password for this user.");
                return false;
            }

            return true;

        } catch(Exception e) {System.out.println(e);}

        return false;

    }

}

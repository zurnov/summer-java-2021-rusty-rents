package Database;
import java.sql.*;

public class Database {

    private static int currentUserId;

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

    public static void storeNewLogin(int userId, String password) {

        //String subquery = "(SELECT User_Id FROM Users WHERE User_Name = '" + username + "')";

        values = "LOGINS_SEQ.NEXTVAL, " + userId + ", '" + password + "'";
        query = "INSERT INTO No_Hackers_Pls VALUES (" + values + ")";

        System.out.println("Database.storeNewLogin : Query to insert new login given userId and password:");
        System.out.println(query);

        try {

            statement.executeQuery(query);
            statement.executeQuery("COMMIT");

        } catch(Exception e) {System.out.println(e);}

    }

    public static void addNewUser(String username, String password, String email) {

        int newUserId = -1;

        try {

            ResultSet rs = statement.executeQuery("SELECT USERS_SEQ.NEXTVAL FROM Dual");
            rs.next();
            newUserId = rs.getInt(1);

            values = newUserId + ", '" + username + "', '" + email + "'";
            query = "INSERT INTO Users VALUES (" + values + ")";

            System.out.println("Database.addNewUser : Query to insert new user with retrieved user ID from USERS_SEQ, username and email:");
            System.out.println(query);

            statement.executeQuery(query);
            statement.executeQuery("COMMIT");


        } catch(Exception e) {System.out.println(e);}

        storeNewLogin(newUserId, password);

    }

    public static void addNewLandlord(String username, String password, String email) {

        addNewUser(username, password, email);

        try {

            ResultSet rs = statement.executeQuery("SELECT User_Id FROM Users WHERE User_Name = '" + username + "'");
            rs.next();
            int userId = rs.getInt(1);

            values = "LANDLORDS_SEQ.NEXTVAL, '" + userId + "'";
            query = "INSERT INTO Landlords(Landlord_Id, User_Id) VALUES (" + values + ")";

            System.out.println("Database.addNewLandlord : Query to insert new landlord with given user ID:");
            System.out.println(query);

            statement.executeQuery(query);
            statement.executeQuery("COMMIT");

        } catch(Exception e) {System.out.println(e);}

    }

    public static boolean isValidLogin(String username, String password) {

        query = "SELECT User_Id FROM Users WHERE USER_NAME = '" + username + "'";

        System.out.println("Database.isValidLogin: Query for selecting the id of given username:");
        System.out.println(query);

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

            System.out.println("Database.isValidLogin: Query to select password of given username:");
            System.out.println(query);

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

    public static int getUserId(String username) {

        query = "SELECT User_Id FROM Users WHERE User_Name = '" + username + "'";

        System.out.println("Database.getUserId : Query to select user ID from given username:");
        System.out.println(query);

        try {

            ResultSet rs = statement.executeQuery(query);
            rs.next();
            return rs.getInt(1);

        } catch(Exception e) {System.out.println(e);}

        return -1;

    }

    public static boolean checkEmailMatch(String email) {

        query = "SELECT Email_Address FROM Users WHERE User_Id = " + currentUserId;

        System.out.println("Database.checkEmailMatch : Query to select user email given user ID:");
        System.out.println(query);

        try {

            ResultSet rs = statement.executeQuery(query);
            rs.next();

            if (rs.getString(1).equalsIgnoreCase(email))
                return true;

            return false;

        } catch(Exception e) {System.out.println(e);}

        return false;

    }

    public static void changeEmail(String newEmail) {

        query = "UPDATE Users SET Email_Address = '" + newEmail + "' WHERE User_Id = " + currentUserId;

        System.out.println("Database.changeEmail : Query to update email address of user with given ID:");
        System.out.println(query);

        try {

            statement.executeQuery(query);
            statement.executeQuery("COMMIT");

        } catch(Exception e) {System.out.println(e);}

    }

    public static boolean checkPasswordMatch(String password) {

        query = "SELECT Pass_Code FROM No_Hackers_Pls WHERE User_Id = " + currentUserId;

        System.out.println("Database.checkPasswordMatch : Query to select user passcode given user ID:");
        System.out.println(query);

        try {

            ResultSet rs = statement.executeQuery(query);
            rs.next();

            if (rs.getString(1).equalsIgnoreCase(password))
                return true;

            return false;

        } catch(Exception e) {System.out.println(e);}

        return false;

    }

    public static void changePassword(String newPassword) {

        query = "UPDATE No_Hackers_Pls SET Pass_Code = '" + newPassword + "' WHERE User_Id = " + currentUserId;

        System.out.println("Database.changePassword : Query to update passcode of user with given ID:");
        System.out.println(query);

        try {

            statement.executeQuery(query);
            statement.executeQuery("COMMIT");


        } catch(Exception e) {System.out.println(e);}

    }

    public static void setCurrentUserId(int user) {
        currentUserId = user;
    }

    public static int getCurrentUserId() {
        return currentUserId;
    }

    public static ResultSet getCities() {

        query = "SELECT City_Name FROM Cities";

        ResultSet rs = null;

        try {

            rs = statement.executeQuery(query);

        } catch (Exception e) {System.out.println(e);}

        return rs;

    }

    public static ResultSet getProperties() {

        String qSelect = "SELECT L.Listing_Title, C.City_Name, P.Property_Type, L.Listing_Price_Bgn";
        String qFrom = "FROM Listings L JOIN Properties P ON P.Property_Id = L.Property_Id JOIN Cities C ON C.City_Id = P.City_Id";
        query = qSelect + " " + qFrom;

        ResultSet rs = null;

        try {

            rs = statement.executeQuery(query);

        } catch (Exception e) {System.out.println(e);}

        return rs;

    }

    public static ResultSet getFilteredProperties(String city, String type, String price) {

        String qSelect = "SELECT L.Listing_Title, C.City_Name, P.Property_Type, L.Listing_Price_Bgn";
        String qFrom = "FROM Listings L JOIN Properties P ON P.Property_Id = L.Property_Id JOIN Cities C ON C.City_Id = P.City_Id";

        query = qSelect + " " + qFrom;

        String qWhere = new String();

        // 1. ! ! !
        if (!city.isEmpty() && !type.isEmpty() && !price.isEmpty())
            qWhere = "WHERE C.City_Name = '" + city + "' AND P.Property_Type = '" + type + "' AND L.Listing_Price_Bgn <= '" + price + "'";
        // 2. ! ! e
        if (!city.isEmpty() && !type.isEmpty() && price.isEmpty())
            qWhere = "WHERE C.City_Name = '" + city + "' AND P.Property_Type = '" + type + "'";
        // 3. ! e !
        if (!city.isEmpty() && type.isEmpty() && !price.isEmpty())
            qWhere = "WHERE C.City_Name = '" + city + "' AND L.Listing_Price_Bgn <= '" + price + "'";
        // 4. ! e e
        if (!city.isEmpty() && type.isEmpty() && price.isEmpty())
            qWhere = "WHERE C.City_Name = '" + city + "'";
        // 5. e ! !
        if (city.isEmpty() && !type.isEmpty() && !price.isEmpty())
            qWhere = "WHERE P.Property_Type = '" + type + "' AND L.Listing_Price_Bgn <= '" + price + "'";
        // 6. e ! e
        if (city.isEmpty() && !type.isEmpty() && price.isEmpty())
            qWhere = "WHERE P.Property_Type = '" + type + "'";
        // 7. e e !
        if (city.isEmpty() && type.isEmpty() && !price.isEmpty())
            qWhere = "WHERE L.Listing_Price_Bgn <= '" + price + "'";
        // 8. e e e - return all listings
        if (city.isEmpty() && type.isEmpty() && price.isEmpty())
            return getProperties();

        query += " " + qWhere;

        //System.out.println(query);

        ResultSet rs = null;

        try {

            rs = statement.executeQuery(query);

        } catch (Exception e) {System.out.println(e);}

        return rs;

    }

}

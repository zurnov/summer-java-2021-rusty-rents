import Database.*;
import Listings.*;
import LogIn.LogIn;
import Account.MyProfile;
import Options.*;
import Register.*;


public class Main {

    public static void main(String[] args) {
        Database.establishConnection();
        new LogIn();
        new ViewListings();
    }
}

import Database.*;
import Listings.*;
import LogIn.*;
import Account.*;
import Options.*;
import Register.*;


public class Main {

    public static void main(String[] args) {
        Database.establishConnection();
        //new LogIn();
       // new ViewListings();
        new ListingDetails();
    }
}

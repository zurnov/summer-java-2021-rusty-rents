import Database.*;
import Listings.*;
import LogIn.*;
import Account.*;
import Options.*;
import Register.*;
import MainMenu.*;


public class Main {

    public static void main(String[] args) {
        Database.establishConnection();
       // new ViewListings();
       new ListingDetails();
    }
}

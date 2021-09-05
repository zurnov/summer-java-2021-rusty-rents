import Database.*;
import Listings.*;
import LogIn.*;
import Account.*;
import Options.*;
import Register.*;
import MainMenu.*;

import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        Database.establishConnection();
        new LogIn();
        //new Register();
        //new MyProfile();
        //new MyListings();
        new ViewListings();
        //new ListingDetails(null);
        //new ChangeEmail();
        //new ChangePassword();
        //new Options();

    }
}

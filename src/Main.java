import Database.*;
import Listings.*;
import LogIn.LogIn;
import Account.MyProfile;
import Options.*;
import Register.*;

import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        Database.establishConnection();
        new LogIn();
        //new MyProfile();
        //new MyListings();
        new ViewListings();
        //new ChangeEmail();
        //new ChangePassword();
        //new Options();

    }
}

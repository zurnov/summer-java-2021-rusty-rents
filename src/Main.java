import AppartmentActions.BuyAppartment;
import AppartmentActions.SellAppartment;
import Database.*;
import LogIn.LogIn;
import Options.ChangeEmail;
import Register.*;


public class Main {

    public static void main(String[] args) {
        Database.establishConnection();
        new LogIn();
        new ChangeEmail();
    }
}

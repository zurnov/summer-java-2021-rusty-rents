import Account.LandLordAccount;
import Account.RenterAccount;
import AppartmentActions.BuyAppartment;
import AppartmentActions.SellAppartment;
import Database.Database;
import LogIn.LogIn;
import MainMenu.LandLordMainMenu;

public class Main {

    public static void main(String[] args) {
        Database.establishConnection();
      new LogIn();
    }
}

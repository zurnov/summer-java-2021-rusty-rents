import AppartmentActions.BuyAppartment;
import AppartmentActions.SellAppartment;
import Database.Database;
import LogIn.LogIn;

public class Main {

    public static void main(String[] args) {
        Database.establishConnection();
      new LogIn();
    }
}

import Database.*;
import LogIn.LogIn;
import Options.ChangeEmail;
import Options.ChangePassword;
import Register.*;


public class Main {

    public static void main(String[] args) {
        Database.establishConnection();
        new LogIn();
    }
}

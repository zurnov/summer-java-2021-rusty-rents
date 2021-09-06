import Database.*;
import LogIn.*;

public class Main {

    public static void main(String[] args) {
        Database.establishConnection();
        new LogIn();
    }
}

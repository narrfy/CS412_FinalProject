import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Controller {

    private final ViewHome viewHome;
    private final ViewLeaderboard viewLeaderboard;
    //private final ViewCreateAcc viewCreateAcc;
    //private final ViewLogin viewLogin;


    public Controller(ViewHome view) {
        this.viewHome = view;

        this.viewLeaderboard = new ViewLeaderboard();
        //this.viewLogin = new ViewLogin();
        //this.viewCreateAcc = new ViewCreateAcc();
    }


    public void start() {
        // 1 (Try with resource)
        try(Socket socket = new Socket("localhost", 5000)) {
            // viewHome.initaltizeGUI();
            // viewCreateAcc.initaltizeGUI();
            // viewLogin.initaltizeGUI();
            viewLeaderboard.initaltizeGUI();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Connect all the buttons, store player information, send information to server



}

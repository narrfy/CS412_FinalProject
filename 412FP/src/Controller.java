import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Controller {

    private final ViewHome viewHome;
    private final ViewLeaderboard viewLeaderboard;
    private final ViewCreateAcc viewCreateAcc;
    private final ViewLogin viewLogin;


    public Controller(ViewHome view) {
        this.viewHome = view;

        this.viewLeaderboard = new ViewLeaderboard();
        this.viewLogin = new ViewLogin();
        this.viewCreateAcc = new ViewCreateAcc();

        // Home
        viewHome.addActionListenerLeaderboardButton(new actionListenerLeaderboardViewButton());
        viewHome.addActionListenerLogButton(new actionListenerLoginViewButton());
        viewHome.addActionListenerHeadsButton(new actionListenerHeadsButton());
        viewHome.addActionListenerTailsButton(new actionListenerTailsButton());
        viewHome.addActionListenerCreateBetButton(new actionListenerCreateBetButton());

        // Leaderboard
        viewLeaderboard.addActionListenerHomeButton(new actionListenerLeaderboardHomeViewButton());

        // Login
        viewLogin.addActionListenerHomeButton(new actionListenerLoginHomeViewButton());
        viewLogin.addActionListenerLoginButton(new actionListenerLoginButton());
        viewLogin.addActionListenerCreateAccButton(new actionListenerLoginCreateAccViewButton());


        // Create Acc
        viewCreateAcc.addActionListenerHomeButton(new actionListenerCreateAccHomeViewButton());
        viewCreateAcc.addActionListenerCreateAccButton(new actionListenerCreateAccButton());
    }


    public void start() {
        // 1 (Try with resource)
        try(Socket socket = new Socket("localhost", 5000)) {
            viewHome.initaltizeGUI();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Connect all the buttons, store player information, send information to server
    // Home
    private class actionListenerLeaderboardViewButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewLeaderboard.initaltizeGUI();
            viewHome.visible(false);
        }
    }

    private class actionListenerLoginViewButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewLogin.initaltizeGUI();
            viewHome.visible(false);
        }
    }

    private class actionListenerHeadsButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Heads");
        }
    }

    private class actionListenerTailsButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Tails");
        }
    }

    private class actionListenerCreateBetButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Create Bet");
        }
    }


    // Leaderboard
    private class actionListenerLeaderboardHomeViewButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewLeaderboard.visible();
            viewHome.visible(true);
        }
    }


    // Login
    private class actionListenerLoginHomeViewButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewLogin.visible();
            viewHome.visible(true);
        }
    }


    private class actionListenerLoginCreateAccViewButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewLogin.visible();
            viewCreateAcc.initaltizeGUI();
        }
    }

    private class actionListenerLoginButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Create Bet");
        }
    }



    // Create Acc

    private class actionListenerCreateAccHomeViewButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewCreateAcc.visible();
            viewHome.visible(true);
        }
    }

    private class actionListenerCreateAccButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Create Bet");
        }
    }




}

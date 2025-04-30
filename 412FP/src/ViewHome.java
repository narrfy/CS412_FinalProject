import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewHome {

    private JFrame jframe;

    // Top
    private JPanel jpanelTop;
    private JButton leaderboardButton;
    private JButton logButton;

    // Middle
    private JPanel jpanelMiddle;
    private JButton headsButton;
    private JButton tailsButton;
    private JLabel coinLabel; // Placeholder for a picture if we get to it

    // Bottom
    private JPanel jpanelBottom;
    private JTextField betAmountTextField;
    private JLabel betAmountLabel;
    private JButton betCreationButton;

    public ViewHome() {
        jframe = new JFrame();

        // Top
        jpanelTop = new JPanel();
        leaderboardButton = new JButton("LEADERBOARD");
        logButton = new JButton("Login");

        // Middle
        jpanelMiddle = new JPanel();
        headsButton = new JButton("Heads");
        tailsButton = new JButton("Tails");
        coinLabel = new JLabel("HEADS");

        // Bottom - Maybe remove one of the buttons (that way head/tails will just place the bet) - also add a label to show what is at stake
        jpanelBottom = new JPanel();
        betAmountTextField = new JTextField();
        betAmountTextField.setColumns(10);
        betAmountLabel = new JLabel("Current: ");
        betCreationButton = new JButton("New Bet");

    }

    public void initaltizeGUI(){
        jframe.setSize(400, 300);

        // Top
        jpanelTop.add(leaderboardButton, BorderLayout.EAST);
        jpanelTop.add(logButton, BorderLayout.WEST);

        // Middle
        jpanelMiddle.add(coinLabel, BorderLayout.NORTH);
        jpanelMiddle.add(headsButton, BorderLayout.EAST);
        jpanelMiddle.add(tailsButton, BorderLayout.WEST);

        // Bottom
        jpanelBottom.add(betAmountTextField, BorderLayout.EAST);
        jpanelBottom.add(betAmountLabel, BorderLayout.CENTER);
        jpanelBottom.add(betCreationButton, BorderLayout.WEST);

        // Frame Setup
        jframe.add(jpanelTop, BorderLayout.NORTH);
        jframe.add(jpanelMiddle, BorderLayout.CENTER);
        jframe.add(jpanelBottom, BorderLayout.SOUTH);
        jframe.setVisible(true);
    }

    public void addActionListenerLeaderboardButton(ActionListener al){ leaderboardButton.addActionListener(al); }
    public void addActionListenerLogButton(ActionListener al){ logButton.addActionListener(al); }
    public void addActionListenerHeadsButton(ActionListener al){ headsButton.addActionListener(al); }
    public void addActionListenerTailsButton(ActionListener al){ tailsButton.addActionListener(al); }
    public void addActionListenerCreateBetButton(ActionListener al){ betCreationButton.addActionListener(al); }

    public String getPlayerNewBetAmount(){ return betAmountTextField.getText(); }

    public void setLogButtonText(String value){ logButton.setText(value); }

    public void visible(boolean visible) {
        jframe.setVisible(visible);
    }

}

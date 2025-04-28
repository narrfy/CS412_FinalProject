import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class ViewLeaderboard {

    private JFrame jframe;

    // Top
    private JPanel jpanelTop;
    private JButton homeButton;
    private JLabel leaderboardLabel;

    // Middle
    private JPanel jpanelMiddle;
    private JList leaderboardList;

    // Bottom

    public ViewLeaderboard() {
        jframe = new JFrame();

        // Top
        jpanelTop = new JPanel();
        homeButton = new JButton("HOME");
        leaderboardLabel = new JLabel("TOP PLAYERS");

        // Middle
        jpanelMiddle = new JPanel();
        leaderboardList = new JList();

    }

    public void initaltizeGUI(){
        jframe.setSize(400, 300);

        // Top
        jpanelTop.add(homeButton, BorderLayout.NORTH);
        jpanelTop.add(leaderboardLabel, BorderLayout.SOUTH);

        // Middle
        jpanelMiddle.add(leaderboardList);

        // Frame Setup
        jframe.add(jpanelTop, BorderLayout.NORTH);
        jframe.add(jpanelMiddle, BorderLayout.CENTER);
        jframe.setVisible(true);
    }

    public void addActionListenerHomeButton(ActionListener al){ homeButton.addActionListener(al); }

    public void setJListData(Map<String, Float> data){
        // Set the data of the top 3 players into the JList
    }

}

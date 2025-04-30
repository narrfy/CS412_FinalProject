import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewLogin {

    private JFrame jframe;

    // Top
    private JPanel jpanelTop;
    private JButton homeButton;
    private JButton createAccButton;

    // Middle
    private JPanel jpanelMiddle;
    private JLabel usernameLabel;
    private JTextField usernameTextField;

    // Bottom
    private JPanel jpanelBottom;
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private JButton loginButton;

    public ViewLogin() {
        jframe = new JFrame();

        // Top
        jpanelTop = new JPanel();
        homeButton = new JButton("HOME");
        loginButton = new JButton("LOGIN");
        createAccButton = new JButton("Create Account");

        // Middle
        jpanelMiddle = new JPanel();
        usernameLabel = new JLabel("Username:");
        usernameTextField = new JTextField();
        usernameTextField.setColumns(20);

        // Bottom
        jpanelBottom = new JPanel();
        passwordLabel = new JLabel("Password:");
        passwordTextField = new JTextField();
        passwordTextField.setColumns(20);

    }

    public void initaltizeGUI(){
        jframe.setSize(400, 300);

        // Top
        jpanelTop.add(homeButton, BorderLayout.EAST);
        jpanelTop.add(createAccButton, BorderLayout.CENTER);
        jpanelTop.add(loginButton, BorderLayout.WEST);

        // Middle
        jpanelMiddle.add(usernameLabel, BorderLayout.NORTH);
        jpanelMiddle.add(usernameTextField, BorderLayout.EAST);

        // Bottom
        jpanelBottom.add(passwordLabel, BorderLayout.EAST);
        jpanelBottom.add(passwordTextField, BorderLayout.CENTER);

        // Frame Setup
        jframe.add(jpanelTop, BorderLayout.NORTH);
        jframe.add(jpanelMiddle, BorderLayout.CENTER);
        jframe.add(jpanelBottom, BorderLayout.SOUTH);
        jframe.setVisible(true);
    }

    public void addActionListenerHomeButton(ActionListener al){ homeButton.addActionListener(al); }
    public void addActionListenerCreateAccButton(ActionListener al){ createAccButton.addActionListener(al); }
    public void addActionListenerLoginButton(ActionListener al){ loginButton.addActionListener(al); }

    public String getPlayerCreatedUsername(){ return usernameTextField.getText(); }
    public String getPlayerCreatedPassword(){ return passwordTextField.getText(); }

    public void visible(){
        jframe.dispose();
    }

}

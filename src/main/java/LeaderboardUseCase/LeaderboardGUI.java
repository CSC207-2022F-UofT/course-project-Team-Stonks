package LeaderboardUseCase;

import javax.swing.*;
import entities.User;
import java.util.ArrayList;

public class LeaderboardGUI {

    JFrame frame = new JFrame("Storage");
    private JPanel panel1;
    JList<User> list = new JList<>();
    DefaultListModel<User> model = new DefaultListModel<>();

    JLabel label = new JLabel();
    JPanel panel = new JPanel();


    public LeaderboardGUI() {

        list.setModel(model);
        ArrayList<User> topUsers = (ArrayList<User>) LeaderboardUseCaseInteractor.updateLeaderboard().getTopUsers();
        for(User u : topUsers) {
            model.addElement(u);
        }

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LeaderboardGUI::new);
    }

}
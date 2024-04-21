import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    JFrame frame;

    JPanel mainPanel;
    JPanel buttonPanel;
    JPanel statsPanel;
    JPanel resultsPanel;

    JButton quitButton;
    JButton rockButton;
    JButton paperButton;
    JButton scissorsButton;

    ImageIcon rockIcon;
    ImageIcon paperIcon;
    ImageIcon scissorsIcon;
fdssasdf
    JLabel player2WinsLabel;
    JLabel tieLabel;

    JTextField player1WinsField;
    JTextField player2WinsField;
    JTextField tieField;

    JTextArea results;

    JScrollPane scrollPane;

    String computer = "";

    public int player1Win = 0;
    public int player2Win = 0;
    public int tie = 0;
    public int gamesPlayed = 0;
    public RockPaperScissorsFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setTitle("Rock Paper Scissors");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createButtonPanel();
        createStatsPanel();
        createResultsPanel();

        mainPanel.add(statsPanel, BorderLayout.NORTH);
        mainPanel.add(resultsPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
        setVisible(true);
    }

    private void createStatsPanel() {
        statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(2, 3, 25, 25));
        statsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));

        player1WinsLabel = new JLabel("Player 1 Wins", SwingConstants.CENTER);
        player1WinsLabel.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        player2WinsLabel = new JLabel("Player 2 Wins", SwingConstants.CENTER);
        player2WinsLabel.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        tieLabel = new JLabel("Number of Ties", SwingConstants.CENTER);
        tieLabel.setFont(new Font("Sans Serif", Font.PLAIN, 24));

    }
}

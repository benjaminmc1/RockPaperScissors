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

    JLabel player1WinsLabel;
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
        player1WinsField = new JTextField("0");
        player1WinsField.setHorizontalAlignment(JTextField.CENTER);
        player1WinsField.setFont(new Font("Times New Roman", Font.BOLD, 18));
        player2WinsField = new JTextField("0");
        player2WinsField.setHorizontalAlignment(JTextField.CENTER);
        player2WinsField.setFont(new Font("Times New Roman", Font.BOLD, 18));
        tieField = new JTextField("0");
        tieField.setHorizontalAlignment(JTextField.CENTER);
        tieField.setFont(new Font("Times New Roman", Font.BOLD, 18));

        player1WinsField.setEditable(false);
        player2WinsField.setEditable(false);
        tieField.setEditable(false);

        statsPanel.add(player1WinsLabel);
        statsPanel.add(player1WinsField);
        statsPanel.add(player2WinsLabel);
        statsPanel.add(player2WinsField);
        statsPanel.add(tieLabel);
        statsPanel.add(tieField);
    }

    public void createResultsPanel() {
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new GridLayout(1, 1));
        resultsPanel.setBorder(new TitledBorder(new EtchedBorder(), "Results"));
        resultsPanel.setSize(600, 600);

        results = new JTextArea();

        scrollPane = new JScrollPane(results, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setSize(350, 500);

        resultsPanel.add(scrollPane);
    }

    private void createButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout());
        buttonPanel.setBorder(new TitledBorder(new EtchedBorder(), "Button Panel"));

        rockIcon = new ImageIcon(new ImageIcon("src/rock.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        paperIcon = new ImageIcon(new ImageIcon("src/paper.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        scissorsIcon = new ImageIcon(new ImageIcon("src/scissors.jpg").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));

        quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent e) -> {System.exit(0);});

        rockButton = new JButton(rockIcon);
        rockButton.addActionListener((ActionEvent e) -> {getMove("Rock");});

        paperButton = new JButton(paperIcon);
        paperButton.addActionListener((ActionEvent e) -> {getMove("Paper");});

        scissorsButton = new JButton(scissorsIcon);
        scissorsButton.addActionListener((ActionEvent e) -> {getMove("Scissors");});

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        buttonPanel.add(quitButton);
    }
    
    private void getMove(String playerMove) {
        Random r = new Random();
        int i = 0;
        ArrayList<String> move = new ArrayList<>();
        move.add("Rock");
        move.add("Paper");
        move.add("Scissors");

        i = r.nextInt(3);

        computer = move.get(i);

        result(playerMove, computer);
    }

    private void result(String playerMove, String computer) {
        gamesPlayed++;
        int result = 0;
        ArrayList<String> win = new ArrayList<>();
        win.add("Tie!");
        win.add("Player 1 Wins!");
        win.add("Player 2 Wins!");

        if(playerMove == "Rock" && computer == "Rock") {
            result = 0;
        } else if(playerMove == "Rock" && computer == "Paper") {
            result = 2;
        } else if(playerMove == "Rock" && computer == "Scissors") {
            result = 1;
        } else if(playerMove == "Paper" && computer == "Rock") {
            result = 1;
        } else if(playerMove == "Paper" && computer == "Paper") {
            result = 0;
        } else if(playerMove == "Paper" && computer == "Scissors") {
            result = 2;
        } else if(playerMove == "Scissors" && computer == "Rock") {
            result = 2;
        } else if(playerMove == "Scissors" && computer == "Paper") {
            result = 1;
        } else if(playerMove == "Scissors" && computer == "Scissors") {
            result = 0;
        }

        results.append("Game #" + gamesPlayed + "\t Player 1 Move: " + playerMove + "\t Player 2 Move: " + computer + "\t Result: " + win.get(result) + "\n");
        updateCounter(result);
    }

    private void updateCounter(int r) {
        switch (r) {
            case 0:
                tie += 1;
                tieField.setText(Integer.toString(tie));
                break;
            case 1:
                player1Win += 1;
                player1WinsField.setText(Integer.toString(player1Win));
                break;
            case 2:
                player2Win += 1;
                player2WinsField.setText(Integer.toString(player2Win));
                break;
        }
    }
}

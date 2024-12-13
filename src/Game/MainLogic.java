package Game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainLogic extends JFrame {
    private JTextField userInput, playerNameInput;
    private JLabel resultLabel, randomNumbersLabel, livesLabel, pointsLabel;
    private JButton guessButton, historyButton, aboutButton, exitButton;
    private ArrayList<String> history;
    private int lives = 10;
    private int points = 0;
    private Image background;

    private float opacity = 0.5f;

    public MainLogic() {

        setTitle("Rain's Lotto Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        history = new ArrayList<>();

        background = new ImageIcon("C:/Users/Administrator/IdeaProjects/Project/src/Game/OMG-I-Won-The-Lottery.jpg").getImage();

        // Title
        JLabel title = createLabel("Rain's Lotto Game", 100, 10, 200, 30);
        Font f = new Font("Old English Text MT", Font.BOLD, 22);
        title.setForeground(Color.RED);
        title.setFont(f);
        add(title);

        // Player name input
        JLabel nameLabel = createLabel("Enter Player Name:", 30, 50, 150, 25);
        add(nameLabel);

        playerNameInput = new JTextField();
        playerNameInput.setBounds(180, 50, 150, 25);
        add(playerNameInput);

        // Label for number input
        JLabel numberLabel = createLabel("Enter a number (1-50):", 30, 90, 150, 25);
        add(numberLabel);

        userInput = new JTextField();
        userInput.setBounds(180, 90, 50, 25);
        add(userInput);

        // Random numbers label
        randomNumbersLabel = createLabel("Results: ?", 30, 130, 300, 25);
        add(randomNumbersLabel);

        // Result label
        resultLabel = createLabel("", 30, 160, 300, 25);
        add(resultLabel);

        // Lives and points label
        livesLabel = createLabel("Lives: " + lives, 30, 190, 150, 25);
        add(livesLabel);

        pointsLabel = createLabel("Points: " + points, 200, 190, 150, 25);
        add(pointsLabel);

        // Guess button
        guessButton = new JButton("Guess");
        guessButton.setBounds(250, 90, 100, 25);
        guessButton.addActionListener(e -> handleGuess());
        add(guessButton);

        // History button
        historyButton = new JButton("History");
        historyButton.setBounds(30, 300, 100, 25);
        historyButton.addActionListener(e -> new HistoryFrame(history));
        add(historyButton);

        // About button
        aboutButton = new JButton("About Us");
        aboutButton.setBounds(140, 300, 100, 25);
        aboutButton.addActionListener(e -> new AboutFrame());
        add(aboutButton);

        // Exit button
        exitButton = new JButton("Exit");
        exitButton.setBounds(250, 300, 100, 25);
        exitButton.addActionListener(e -> System.exit(0));
        add(exitButton);
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
        g2d.setComposite(alphaComposite);

        g2d.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        super.paintComponents(g);
    }

    private void handleGuess() {
        String input = userInput.getText();
        String playerName = playerNameInput.getText();

        if (playerName.isEmpty()) {
            resultLabel.setText("Please enter your name!");
            return;
        }

        try {
            int userNumber = Integer.parseInt(input);
            if (userNumber < 1 || userNumber > 50) {
                resultLabel.setText("Enter a number between 1 and 50!");
                return;
            }

            int[] randomNumbers = Main.generateRandomNumbers();
            boolean isMatch = Main.checkMatch(userNumber, randomNumbers);

            randomNumbersLabel.setText("Results: " + Main.numbersToString(randomNumbers));

            if (isMatch) {
                points += 10;
                resultLabel.setText("Congratulations! You guessed correctly!");
            } else {
                lives -= 1;
                resultLabel.setText("No Match, Try Again!");
            }

            livesLabel.setText("Lives: " + lives);
            pointsLabel.setText("Points: " + points);

            if (lives == 0) {
                String gameOverMessage = playerName + " finished the game with " + points + " points.";
                history.add("Name: " + playerName + ", Points: " + points);

                JOptionPane.showMessageDialog(this, "Game Over! " + gameOverMessage);
                resetGame();
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid Input! Enter a number.");
        }
    }

    private JLabel createLabel(String text, int x, int y, int width, int height) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setBounds(x, y, width, height);
        return label;
    }

    private void resetGame() {
        lives = 10;
        points = 0;
        livesLabel.setText("Lives: " + lives);
        pointsLabel.setText("Points: " + points);
        resultLabel.setText("");
        randomNumbersLabel.setText("Results: ?");
        userInput.setText("");
        playerNameInput.setText("");
    }


}

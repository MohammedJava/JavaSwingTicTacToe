import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener; // seems to be missing.


public class JavaSwingTicTacToe {
    //boolean roles as global static variables
    //need to be static to be instantiated only once at the start of the class
    static boolean player1 = true;
    static boolean player2 = false;
    static int buttonsDisabled = 0;
    static int scoreX = 0;
    static int scoreY = 0;

    //buttons with position_rowColumn
    static JButton restartButton = new JButton("Restart Game");
    static JLabel score = new JLabel("Score: ");

    //Array of JButtons
    static JButton[] buttons = new JButton[9];

    public static void main(String[] args) {
        //Create window and title
        JFrame window = new JFrame("TicTacToe Game");
        //window size and visibility
        window.setSize(640, 480);
        window.setVisible(true);


        //Action listener for buttons X/O
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //If player1 is playing, else player2 is playing
                if (player1) {
                    //get button and set to X
                    ((JButton) e.getSource()).setText("X");
                    //disable button
                    ((JButton) e.getSource()).setEnabled(false);
                    //switch roles
                    player1 = false;
                    player2 = true;
                    buttonsDisabled++;
                    checkForWin();
                }
                else {
                    //get the button and set text to O
                    ((JButton) e.getSource()).setText("O");
                    //disable button
                    ((JButton) e.getSource()).setEnabled(false);
                    //switch roles
                    player1 = true;
                    player2 = false;
                    buttonsDisabled++;
                    checkForWin();
                }
            }
        };

        //action listener for restart button
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });


        //Array for all buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            //Add action listener for each button
            buttons[i].addActionListener(listener);
        }

        //Add content created to pane
        Container pane = window.getContentPane();
        pane.setLayout(new GridLayout(4, 3));
        pane.add(score);
        pane.add(new JLabel());
        pane.add(restartButton);


        //counter for buttons
        int counter = 0;
        while (counter < 9) {
            //add buttons to pane
            pane.add(buttons[counter]);
            counter++;
        }


    }

    public static void checkForWin() {

        //Check for same row if equal values
        boolean row1 = buttons[0].getText().equals(buttons[1].getText()) && buttons[0].getText().equals(buttons[2].getText())
                && !(buttons[0].getText().equals(""));
        boolean row2 = buttons[3].getText().equals(buttons[4].getText()) && buttons[3].getText().equals(buttons[5].getText())
                && !(buttons[3].getText().equals(""));
        boolean row3 = buttons[6].getText().equals(buttons[7].getText()) && buttons[6].getText().equals(buttons[8].getText())
                && !(buttons[6].getText().equals(""));

        //check for each row which sign is present

        //For X player
        if (row1 && buttons[0].getText().equals("X")) {
            String scoreOfX = Integer.toString((++scoreX));
            String scoreOfY = Integer.toString((scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }

        //For O player
        else if (row1) {
            System.out.println("Happen1");
            String scoreOfX = Integer.toString((scoreX));
            String scoreOfY = Integer.toString((++scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }
        if (row2 && buttons[3].getText().equals("X")) {
            String scoreOfX = Integer.toString((++scoreX));
            String scoreOfY = Integer.toString((scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }
        else if (row2) {
            String scoreOfX = Integer.toString((scoreX));
            String scoreOfY = Integer.toString((++scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }
        if (row3 && buttons[6].getText().equals("X")) {
            String scoreOfX = Integer.toString((++scoreX));
            String scoreOfY = Integer.toString((scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }
        else if (row3) {
            String scoreOfX = Integer.toString((scoreX));
            String scoreOfY = Integer.toString((++scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }


        //Check for same column
        boolean column1 = buttons[0].getText().equals(buttons[3].getText()) && buttons[0].getText().equals(buttons[6].getText())
                && !(buttons[0].getText().equals(""));
        boolean column2 = buttons[1].getText().equals(buttons[4].getText()) && buttons[1].getText().equals(buttons[7].getText())
                && !(buttons[1].getText().equals(""));
        boolean column3 = buttons[2].getText().equals(buttons[5].getText()) && buttons[2].getText().equals(buttons[8].getText())
                && !(buttons[2].getText().equals(""));

        //For X player
        if (column1 && buttons[0].getText().equals("X")) {
            String scoreOfX = Integer.toString((++scoreX));
            String scoreOfY = Integer.toString((scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }

        //For O player
        else if (column1) {
            String scoreOfX = Integer.toString((scoreX));
            String scoreOfY = Integer.toString((++scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }
        if (column2 && buttons[1].getText().equals("X")) {
            String scoreOfX = Integer.toString((++scoreX));
            String scoreOfY = Integer.toString((scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }
        else if (column2) {
            String scoreOfX = Integer.toString((scoreX));
            String scoreOfY = Integer.toString((++scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }
        if (column3 && buttons[2].getText().equals("X")) {
            String scoreOfX = Integer.toString((++scoreX));
            String scoreOfY = Integer.toString((scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }
        else if (column3) {
            String scoreOfX = Integer.toString((scoreX));
            String scoreOfY = Integer.toString((++scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }

        //Check for same diagonals
        boolean diagonal1 = buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText())
                && !(buttons[0].getText().equals(""));
        boolean diagonal2 = buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText())
                && !(buttons[2].getText().equals(""));

        //For X player
        if (diagonal1 && buttons[0].getText().equals("X")) {
            String scoreOfX = Integer.toString((++scoreX));
            String scoreOfY = Integer.toString((scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }

        //For O player
        else if (diagonal1) {
            String scoreOfX = Integer.toString((scoreX));
            String scoreOfY = Integer.toString((++scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }
        if (diagonal2 && buttons[2].getText().equals("X")) {
            String scoreOfX = Integer.toString((++scoreX));
            String scoreOfY = Integer.toString((scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }
        else if (diagonal2) {
            String scoreOfX = Integer.toString((scoreX));
            String scoreOfY = Integer.toString((++scoreY));
            score.setText("Score: X: " + scoreOfX + " O: " + scoreOfY);
            //end game if victory
            endGame();
        }

    }


    public static void endGame() {
        //Array for all buttons
        for (int i = 0; i < 9; i++) {
            //Add action listener for each button
            buttons[i].setEnabled(false);
        }
    }

    public static void restart() {
        //Array for all buttons
        for (int i = 0; i < 9; i++) {
            //Add action listener for each button
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
    }
}

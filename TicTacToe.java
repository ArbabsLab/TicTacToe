import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.EventQueue;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;


public class TicTacToe {
    //initialize an array of buttons in a 5x5 arrangement
    JButton[][] buttons = new JButton[5][5];
    //Variable detecting which player's turn it is, info to collect, and score to update
    int playerID = 0;

    //Variables representing the player's scores
    int scorePlayer0 = 0;
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;

    //Declares player score labels
    JLabel player0Label;
    JLabel player1Label;
    JLabel player2Label;

    //Declares a delay timer to prevent instant clearing of board after win
    Timer delayTimer;

    //Function converting the playerID into a turn count
    public int turn(int count){
        return count % 3;
    }

    //Function which checks to see if the player that just placed their symbol has just won the game or not
    public boolean checkWin() {
    // Check rows to see if there is a win
    for (int i = 0; i < 5; i++) {
        if ((!buttons[i][0].getText().isEmpty() &&
            buttons[i][0].getText().equals(buttons[i][1].getText()) &&
            buttons[i][0].getText().equals(buttons[i][2].getText()))
            ||
            (!buttons[i][1].getText().isEmpty() &&
            buttons[i][1].getText().equals(buttons[i][2].getText()) &&
            buttons[i][1].getText().equals(buttons[i][3].getText()))
            ||
            (!buttons[i][2].getText().isEmpty() &&
            buttons[i][2].getText().equals(buttons[i][3].getText()) &&
            buttons[i][2].getText().equals(buttons[i][4].getText()))
            ) 
            {return true;}
    }

    // Check columns to see if there is a win
    for (int j = 0; j < 5; j++) {
        if ((!buttons[0][j].getText().isEmpty() &&
            buttons[0][j].getText().equals(buttons[1][j].getText()) &&
            buttons[0][j].getText().equals(buttons[2][j].getText()))
            ||
            (!buttons[1][j].getText().isEmpty() &&
            buttons[1][j].getText().equals(buttons[2][j].getText()) &&
            buttons[1][j].getText().equals(buttons[3][j].getText()))
            ||
            (!buttons[2][j].getText().isEmpty() &&
            buttons[2][j].getText().equals(buttons[3][j].getText()) &&
            buttons[2][j].getText().equals(buttons[4][j].getText()))
            )
            {return true;}
        }
    

    // Check diagonals to see if there is a win
    if (    (!buttons[0][0].getText().isEmpty() &&
            buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[0][0].getText().equals(buttons[2][2].getText()))
            ||
            (!buttons[1][1].getText().isEmpty() &&
            buttons[1][1].getText().equals(buttons[2][2].getText()) &&
            buttons[1][1].getText().equals(buttons[3][3].getText()))
            ||
            (!buttons[2][2].getText().isEmpty() &&
            buttons[2][2].getText().equals(buttons[3][3].getText()) &&
            buttons[2][2].getText().equals(buttons[4][4].getText()))
            ||
            (!buttons[0][1].getText().isEmpty() &&
            buttons[0][1].getText().equals(buttons[1][2].getText()) &&
            buttons[0][1].getText().equals(buttons[2][3].getText()))
            ||
            (!buttons[1][0].getText().isEmpty() &&
            buttons[1][0].getText().equals(buttons[2][1].getText()) &&
            buttons[1][0].getText().equals(buttons[3][2].getText()))
            ||
            (!buttons[1][2].getText().isEmpty() &&
            buttons[1][2].getText().equals(buttons[2][3].getText()) &&
            buttons[1][2].getText().equals(buttons[3][4].getText()))
            ||
            (!buttons[2][1].getText().isEmpty() &&
            buttons[2][1].getText().equals(buttons[4][3].getText()) &&
            buttons[2][1].getText().equals(buttons[3][2].getText()))
            ||
            (!buttons[0][2].getText().isEmpty() &&
            buttons[0][2].getText().equals(buttons[1][3].getText()) &&
            buttons[0][2].getText().equals(buttons[2][4].getText()))
            ||
            (!buttons[2][0].getText().isEmpty() &&
            buttons[2][0].getText().equals(buttons[4][2].getText()) &&
            buttons[2][0].getText().equals(buttons[3][1].getText()))
            ) 
            {return true;}

    if (    (!buttons[4][0].getText().isEmpty() &&
            buttons[4][0].getText().equals(buttons[1][1].getText()) &&
            buttons[4][0].getText().equals(buttons[2][2].getText()))
            ||
            (!buttons[3][1].getText().isEmpty() &&
            buttons[3][1].getText().equals(buttons[2][2].getText()) &&
            buttons[3][1].getText().equals(buttons[1][3].getText()))
            ||
            (!buttons[2][2].getText().isEmpty() &&
            buttons[2][2].getText().equals(buttons[1][3].getText()) &&
            buttons[2][2].getText().equals(buttons[0][4].getText()))
            ||
            (!buttons[3][0].getText().isEmpty() &&
            buttons[3][0].getText().equals(buttons[2][1].getText()) &&
            buttons[3][0].getText().equals(buttons[1][2].getText()))
            ||
            (!buttons[2][1].getText().isEmpty() &&
            buttons[2][1].getText().equals(buttons[1][2].getText()) &&
            buttons[2][1].getText().equals(buttons[0][3].getText()))
            ||
            (!buttons[3][2].getText().isEmpty() &&
            buttons[3][2].getText().equals(buttons[2][3].getText()) &&
            buttons[3][2].getText().equals(buttons[1][4].getText()))
            ||
            (!buttons[4][1].getText().isEmpty() &&
            buttons[4][1].getText().equals(buttons[2][3].getText()) &&
            buttons[4][1].getText().equals(buttons[3][2].getText()))
            ||
            (!buttons[4][2].getText().isEmpty() &&
            buttons[4][2].getText().equals(buttons[3][3].getText()) &&
            buttons[4][2].getText().equals(buttons[2][4].getText()))
            ||
            (!buttons[2][0].getText().isEmpty() &&
            buttons[2][0].getText().equals(buttons[1][1].getText()) &&
            buttons[2][0].getText().equals(buttons[0][2].getText()))
            ) 
            {return true;}

    return false;
    }

    //Function to update the score on the GUI
    public void updateScoreLabels() {
    // Update the JLabels displaying the scores
    player0Label.setText("Player O:     " + scorePlayer0);
    player1Label.setText("Player X:     " + scorePlayer1);
    player2Label.setText("Player Y:     " + scorePlayer2);
    }

    //Function to update the score of the winner of each round
    public int scoreUpdate(int winnerID){
        winnerID = turn(winnerID);
        switch(winnerID){
            case 0:
                scorePlayer0++;
                break;
            case 1:
                scorePlayer1++;
                break;
            default:
                scorePlayer2++;
                break;
        }
        updateScoreLabels();
        return 0;
    }

    //function to clear board
    public void clearBoard(){
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setText("");
            }
        }
        
        };

   public TicTacToe(){
        
        //initializes the empty TicTacToe board and all the containers that will be displayed
        JFrame board = new JFrame();
        JPanel gameContainer = new JPanel();
        JPanel scoreContainer = new JPanel();
        JPanel resetContainer = new JPanel();

        //initializes each grid in the board as a button
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j] = new JButton();
            }
        }
        
        //sets rules for delay timer after a win
        delayTimer = new Timer(1000, e -> {
            clearBoard();
            delayTimer.stop(); // Stop the timer after clearing the board
            playerID = 0; // Reset player turn after the delay
        });

        //Actionlistener which places the correct symbols depending on whose turn it is
         ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clickedButton = (JButton) e.getSource();
                if(clickedButton.getText().isEmpty()){

                    //Checks which player's turn it is and puts their appropriate symbol on the button
                    if(turn(playerID) == 0){
                    clickedButton.setText("O");
                    }
                    else if (turn(playerID) == 1){
                    clickedButton.setText("X");
                    }
                    else {
                    clickedButton.setText("Y");
                    
                    }
                    
                    //Checks to see if the player that just went won the game so it can clear the board and update the score, or else it just goes to the next players turn
                    if(checkWin()){
                        scoreUpdate(playerID);
                        clickedButton.setForeground(Color.GREEN);
                        delayTimer.start(); // starts delay timer so the win can be seen for a second before the board is cleared
                    }
                    else{playerID++;}
                }
            }
        };

        //Adds actionlistener to all the buttons
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
            buttons[i][j].addActionListener(actionListener);
            }
        }

        //Formats the gameContainer to add the buttons
        gameContainer.setLayout(new GridLayout(5, 5));
        gameContainer.setPreferredSize(new Dimension(250, 250));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                buttons[i][j].setPreferredSize(new Dimension(50, 50));
                gameContainer.add(buttons[i][j]);
            }
        }


        //Format score container to have player names
       scoreContainer.setLayout(new GridLayout(3, 1, 0, 50));
       scoreContainer.setPreferredSize(new Dimension(100, 250));

        player0Label = new JLabel("Player O:    " + scorePlayer0);
        player1Label = new JLabel("Player X:    " + scorePlayer1);
        player2Label = new JLabel("Player Y:    " + scorePlayer2);

        scoreContainer.add(player0Label);
        scoreContainer.add(player1Label);
        scoreContainer.add(player2Label);

        //Format resetContainer to display reset button
        resetContainer.setLayout(new FlowLayout());
        resetContainer.setPreferredSize(new Dimension(300, 100));
        JButton resetButton = new JButton("Reset Score");
        JButton clearBoardButton = new JButton("Clear Board");
        resetButton.setPreferredSize(new Dimension(125, 75));
        clearBoardButton.setPreferredSize(new Dimension(125, 75));
        
        //Actionlistener specifically for the reset button to reset the score and clear the board
        resetButton.addActionListener(new ActionListener() {
         @Override
        public void actionPerformed(ActionEvent abe) {
            scorePlayer0 = 0;
            scorePlayer1 = 0;
            scorePlayer2 = 0;
            updateScoreLabels();
            clearBoard();
        }
        });

        clearBoardButton.addActionListener(new ActionListener() {
         @Override
        public void actionPerformed(ActionEvent abce) {
            clearBoard();
        }
        });

        resetContainer.add(clearBoardButton);
        resetContainer.add(resetButton);
        
        //Format the empty board with all the information panels
        board.setLayout(new FlowLayout());
        board.add(gameContainer);
        board.add(scoreContainer);
        board.add(resetContainer);
      


        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setTitle("TicTacToe");
        //board.setSize(500, 500);
        board.setMinimumSize(new Dimension(400, 400));
        board.setMaximumSize(new Dimension(500, 450));
        board.setVisible(true);
        
        
       
        
   }
   
    public static void main(String[] args){
        //new TicTacToe();

        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TicTacToe();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }





}

package tictactoegame.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import tictactoegame.GameSystem;

public class GUI extends GameSystem{
    final private int side = 150;

    //Set font
    public static Font buttonFont = new Font("Fantasy", Font.BOLD, 100);
    public static Font labelFont = new Font("Fantasy", Font.BOLD, 25);
    
        
    //Setup the frame
    public static JFrame frame = new JFrame();
    
    //Setup Panel
    public static JPanel panel = new JPanel();
        
    //Setup Label
    public static JLabel gameMaster = new JLabel("X's turn");
        
    //Setup buttons
    public static JButton b1 = new JButton();
    public static JButton b2 = new JButton();
    public static JButton b3 = new JButton();
    public static JButton b4 = new JButton();
    public static JButton b5 = new JButton();
    public static JButton b6 = new JButton();
    public static JButton b7 = new JButton();
    public static JButton b8 = new JButton();
    public static JButton b9 = new JButton();
    public static JButton flushButton = new JButton("Restart"); 
    private JButton quit = new JButton("Quit");
    private JButton returnToMain = new JButton("Return to Main Menu");
    
    public static JButton[] buttons = {flushButton, b1, b2, b3, b4, b5, b6, b7, b8, b9};
    
    public GUI(boolean start){
        if(start){
            this.guiSetup();
            if(turn == computerTurn)
                aiPlay();
        }
    }

    public GUI() {
    }
    
    private void guiSetup(){
        //JFrame settings
        frame.setSize(450, 550);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);
        panel.setLayout(null);
        
        //Button settings
        b1.setBounds(0, 0, side, side);
        b2.setBounds(side, 0, side, side);
        b3.setBounds(side*2, 0, side, side);
        b4.setBounds(0, side, side, side);
        b5.setBounds(side, side, side, side);
        b6.setBounds(side*2, side, side, side);
        b7.setBounds(0, side*2, side, side);
        b8.setBounds(side, side*2, side, side);
        b9.setBounds(side*2, side*2, side, side);
        
        
        for(int i = 1; i<10; i++){
            gameButtonConfiguration(buttons[i], i);
            panel.add(buttons[i]);
        }
        
        //flushGrid Button settings
        flushButton.setBounds(350, 450, 100, 50);
        flushButton.setBorderPainted(false);
        flushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flushGrid();
                for(int i = 1; i<10; i++){
                    buttons[i].setText("");
                }
                gameMaster.setText("X's turn");
                if(isAgainstComputer && computerTurn)
                    aiPlay();
            }
        });
        panel.add(flushButton);
        
        //Quit Button Settings
        quit.setBounds(350, 500, 100, 50);
        quit.setBorderPainted(false);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        panel.add(quit);
        
        returnToMain.setBounds(0, 500, 300, 50);
        returnToMain.setBorderPainted(false);
        returnToMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flushGrid();
                for(int i = 1; i<10; i++){
                    buttons[i].setText("");
                }
                isAgainstComputer = false;
                frame.dispose();
                new MainMenu();
            }
        });
        panel.add(returnToMain);
        
        //gameMaster Settings
        gameMaster.setFont(labelFont);
        gameMaster.setBounds(10, side*3, 300, 50);
        
        panel.add(gameMaster);
    }
    
    private static void gameButtonConfiguration(JButton b, int coordinate){
        b.setBackground(Color.WHITE);
        b.setFont(buttonFont);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventOnClickGameButton(b, coordinate);
            }
        });
    }
    
    public static void eventOnClickGameButton(JButton b, int coordinate){
        if(turn == true && 0 == grid[coordinate]){
            specificAct(b, "X", "O's turn", coordinate, 1, false);
        }
        else if(turn == false && 0 == grid[coordinate]){
            specificAct(b, "O", "X's turn", coordinate, -1, true);
        }
    }
    
    private static void specificAct(JButton b, String bText, String gmText, 
            int coordinate, int gridState, boolean switchTo){
        b.setText(bText);
        grid[coordinate] = gridState;
        turn = switchTo;
        gameMaster.setText(gmText);
        gamePatternUpdate(b);
        checkForVictory();
        if(!endGame)
            GameSystem.aiPlay();
    }
            
    private static void checkForVictory(){
        byte v = isVictory();
        victorySettings();
        switch (v) {
            case 1:
                gameMaster.setText("X won! GG");
                break;
            case 2:
                gameMaster.setText("O won! GG");
                break;
            case 0:
                if(tie){
                    gameMaster.setText("Tie");
                }   
                break;
            default:
                break;
        }
        
        if(endGame){
            for(int i=1; i<=9; i++){
                grid[i] = 5;
            }
        }
    }
    
    //To Verify
    private static void gamePatternUpdate(JButton b){
        int i = 0;
        for (JButton button : buttons) {
            if(b.equals(button)){
                gamePattern += i;
                break;
            }
            i++;
        }
    }
}

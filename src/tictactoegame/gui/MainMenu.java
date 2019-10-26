package tictactoegame.gui; 
 
import java.awt.Color; 
import java.awt.Font; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.*; 
import tictactoegame.GameSystem;

public class MainMenu extends GameSystem implements ActionListener{ 
    public static final int SIDE = 200; 
     
    Font labelFont = new Font("Fantasy", Font.BOLD, 25); 
    Font menuButtonFont = new Font("Fantasy", Font.BOLD, 20); 
    
    JLabel question = new JLabel( 
            "How many players are you?", SwingConstants.CENTER); 
     
    JButton _1Player = new JButton("1 Player"); 
    JButton _2Player = new JButton("2 Players"); 
    JButton quitB = new JButton("x");
    
    JFrame frame = new JFrame("Tic Tac Toe"); 
     
    JPanel panel = new JPanel(); 
     
    public MainMenu(){ 
        this.menuSetup();
    } 
    
    private void menuSetup(){
        //Frame settings 
        frame.setResizable(false); 
        frame.setSize(400, 300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.add(panel); 
        frame.setVisible(true); 
         
        //Panel Settings 
        panel.setLayout(null);         
        panel.add(question); 
        panel.add(_1Player); 
        panel.add(_2Player); 
        panel.add(quitB);
         
        //Buttons Settings 
        buttonSettings(_1Player, 0); 
        buttonSettings(_2Player, SIDE); 
        quitButtonSettings();
 
        //Label Settings 
        question.setFont(labelFont); 
        question.setBounds(0, 0, 2*SIDE, 100); 
    }
    
    private void buttonSettings(JButton b, int x){ 
        b.setBounds(x, 100, SIDE, SIDE); 
        b.setFont(menuButtonFont); 
        b.setBackground(Color.WHITE); 
        b.addActionListener((ActionListener) this); 
    } 
    
    private void quitButtonSettings(){
        this.quitB.setBounds(460, 0, 40, 30);
        this.quitB.setFont(new Font("Fantasy", Font.BOLD, 11));
        this.quitB.setBackground(Color.red);
        this.quitB.setForeground(Color.white);
        this.quitB.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                frame.dispose();
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String action = ae.getActionCommand();
        if(action.equals("1 Player")){
            question.setText("Choose a character"); 
            _1Player.setText("X"); 
            _2Player.setText("O"); 
            isAgainstComputer = true; 
        }
        else if (action.equals("2 Players")) {
            frame.dispose(); 
            new GUI(true); 
        }
        else if (action.equals("X")) {
            computerTurn = false;
            frame.dispose(); 
            new GUI(true);
        }
        else if (action.equals("O")) {
            computerTurn = true;
            frame.dispose(); 
            new GUI(true);
        }
    }
}
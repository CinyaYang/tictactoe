import javax.swing.*;
import java.awt.*;
//import javax.swing.JOptionPane;
import java.awt.event.ActionListener;


public class View extends JFrame{
  //Create the login Panel
  JPanel login;
  JLabel username ;
  JTextField name;
  JButton start;
  JLabel show_name;
  JPanel game;
  JButton buttons[][];
  String user_name;
  ImageIcon X;
  ImageIcon O;
  
  View(){
    super("TicTacToe");
    setSize(400,400);
    
    setResizable(false);//people can't resize the frame
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    login = new JPanel();
    
    username = new JLabel("Player name: ");
    username.setVisible(true);
    username.setBounds(58,97,120,23);
    login.add(username);
    
    name = new JTextField();
    name.setVisible(true);
    name.setBounds(58,146,112,23);
    login.add(name);
    user_name = name.getText();
    //String user_name = "v ";
    
    
    name.setColumns(10);
    
    start = new JButton("Game Start!");
    ////start.addActionListener(new StartListener());
    start.setVisible(true);
    start.setBounds(171,197,89,23);
    login.add(start);
    //String user_name = "hello";
    
    show_name = new JLabel();
    show_name.setText("Good Luck! "+user_name);
    //final show_name;
    show_name.setVisible(false);
    //name.setBounds(58,146,112,23);
    login.add(show_name);
    login.setVisible(true);
    //
    
    //Create the panel for the game
    buttons = new JButton[3][3];
    //buttons.addActionListener(new ButtonsListener());
    start.setVisible(true);
    game = new JPanel();
    
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        buttons[i][j] = new JButton();
        game.add(buttons[i][j]);
      }
    }
    
    game.setLayout(new GridLayout(3,3));
    
 
    
    
    game.setVisible(false);
    //add(login,BorderLayout.NORTH);
    add(game,BorderLayout.CENTER);
    add(login,BorderLayout.EAST);
    //pack();
    
    //
    
    
    //Create the panel for the ENDING of the game
    //JPanel end = new JPanel();
    //JLabel end_l = new JLabel(ending);
    //end.add(end_l);
    //end.setVisible(false);
    //add(login,BorderLayout.NORTH);
    
    
    add(game,BorderLayout.CENTER);
    add(login,BorderLayout.NORTH);
    //add(end,BorderLayout.WEST);
    
    setVisible(true);
    //
    
    
    //Define the ImageIcon variable 
    X = new ImageIcon("C:\\Users\\cinya\\X.png"); // load the image to a imageIcon
    Image image_X = X.getImage(); // transform it 
    Image newimg_X = image_X.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    X = new ImageIcon(newimg_X);  // transform it back
    
    O = new ImageIcon("C:\\Users\\cinya\\O.jpg"); // load the image to a imageIcon
    Image image_O = O.getImage(); // transform it 
    Image newimg_O = image_O.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    O = new ImageIcon(newimg_O);  // transform it back
    //buttons[1][1].setIcon(O);
    //buttons[1][1].setVisible(false);
    
    
    

    validate();
    setVisible(true);   
  }
  
  
  void addStartListener(ActionListener listenForStartButton){
    start.addActionListener(listenForStartButton);
  }
  
  void addGameListener(ActionListener listenForGameButtons){
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        buttons[i][j].addActionListener(listenForGameButtons);
      }
    }
  }
  
  void displayErrorMessage(String errorMessage){
    JOptionPane.showMessageDialog(this,errorMessage);
  }
  
}
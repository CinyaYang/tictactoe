import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.Random;


public class TicTacToe extends JFrame{
  private static JLabel username ;
  private static JTextField name;
  private static JButton start;
  private static JLabel show_name;
  private static JPanel game;
  private static JButton buttons[][];
  private static char[][] table = new char[3][3];
  private static boolean test_space = false;
  private static boolean test_win = false;
  private static String ending = " ";
  private static ImageIcon X;
  private static ImageIcon O;
  
  
  
  
  
  
  public static void main(String[] args) {
    new TicTacToe();
  }
  private TicTacToe(){
    super("TicTacToe");
    setSize(400,400);
    
    setResizable(false);//people can't resize the frame
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Create the login Panel
    JPanel login = new JPanel();
    
    username = new JLabel("Player name: ");
    username.setVisible(true);
    username.setBounds(58,97,120,23);
    login.add(username);
    
    name = new JTextField();
    name.setVisible(true);
    name.setBounds(58,146,112,23);
    login.add(name);
    //String user_name = "v ";
    
    
    name.setColumns(10);
    
    start = new JButton("Game Start!");
    start.addActionListener(new StartListener());
    start.setVisible(true);
    start.setBounds(171,197,89,23);
    login.add(start);
    String user_name = "hello";
    
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
    
    game.setLayout(new GridLayout(3,3));
    
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        buttons[i][j] = new JButton();
        table[i][j] = '@';
        game.add(buttons[i][j]);
        buttons[i][j].addActionListener(new ButtonsListener());
      }
    }
    
    game.setVisible(false);
    //add(login,BorderLayout.NORTH);
    add(game,BorderLayout.CENTER);
    add(login,BorderLayout.EAST);
    //pack();
    
    //
    
    
    //Create the panel for the ENDING of the game
    JPanel end = new JPanel();
    JLabel end_l = new JLabel(ending);
    end.add(end_l);
    end.setVisible(false);
    //add(login,BorderLayout.NORTH);
    
    
    add(game,BorderLayout.CENTER);
    add(login,BorderLayout.NORTH);
    add(end,BorderLayout.WEST);
    
    setVisible(true);
    //
    
    
    //Define the ImageIcon variable 
    ImageIcon X = new ImageIcon("C:\\Users\\cinya\\X.png"); // load the image to a imageIcon
    Image image_X = X.getImage(); // transform it 
    Image newimg_X = image_X.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    X = new ImageIcon(newimg_X);  // transform it back
    
    ImageIcon O = new ImageIcon("C:\\Users\\cinya\\O.jpg"); // load the image to a imageIcon
    Image image_O = O.getImage(); // transform it 
    Image newimg_O = image_O.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    O = new ImageIcon(newimg_O);  // transform it back
    //buttons[1][1].setIcon(O);
    //buttons[1][1].setVisible(false);
    
    
    
    
    
    
//    buttons.addActionListener(new ActionListener(){
//      @Override
//      public void actionPerformed(ActionEvent event){
//        
//      }
//    });
    
    
    
    // buttons[6].setIcon(X);
    
    validate();
    setVisible(true);
    
    
    
    
    
  }
  
  private static class StartListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) 
    {
//        listPanel.setVisible(!listPanel.isVisible());
//        comboPanel.setVisible(!comboPanel.isVisible());
      String user_name = name.getText();
      username.setVisible(false);
      name.setVisible(false);
      start.setVisible(false);
      //show_name.setVisible(true);
      //JLabel show_name = new JLabel("Good Luck! "+user_name);
      //final show_name;
      
      show_name.setText("Good Luck! " + user_name + " ~ You would use O");
      System.out.println(user_name);
      show_name.setVisible(true);
      //name.setBounds(58,146,112,23);
      //login.add(show_name);
      game.setVisible(true);
      
    }
  }
  
  
  private static class ButtonsListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
      Object source = e.getSource();
      Random rand = new Random();
      int i_r;
      int j_r;
      char final_value = '.' ;
      
      
      //do{
        
        
        for(int i=0; i<3; i++){
          for(int j=0; j<3; j++){
            if (source==buttons[i][j]){
              //buttons[1][1].setIcon(O);
              //System.out.println("O");
              final_value = check_record(table, 'O', i, j);
            }
          }
        }
        
        //if(final_value=='O'||final_value=='F'){
          //break;
        //}
        
        do{
          i_r = rand.nextInt(3);
          j_r = rand.nextInt(3);
        }while(table[i_r][j_r] !='@'&&!(final_value=='O'||final_value=='F'));
        
        System.out.println(i_r+" "+j_r); 
//        
      
      //System.out.println(final_value);
    //}while(test_win==false);
      
      if(final_value=='F'||final_value=='X'||final_value=='O'){
        for(int i=0; i<3; i++){
          for(int j=0; j<3; j++){                                  //??method
            buttons[i][j].setEnabled(false);
          }
        }
        //game.setVisible(false);
        //login.setVisible(false);
        //end.setVisible(true);
      }else{
        final_value = check_record(table, 'X', i_r, j_r);
        if(final_value=='F'||final_value=='X'||final_value=='O'){
          for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){                                  //??method
              buttons[i][j].setEnabled(false);
            }
          }
        } 
      }
      
      if(final_value=='F'){
        
        show_name.setText("Table is full! Game out!");
        ending = "Table is full! Game out!";
      }else if(final_value=='O'){ //user
        
        show_name.setText("You Win!");
        ending = "You Win!";
      }else if(final_value=='X'){  //computer
        
        show_name.setText("You Lose!");
        ending = "You Lose!";
      }
      
      
      
      
     
      
    }
    
    
    
//    private static char input_output (char[][] table, char player){
//      char result = '@' ;
//      if(player=='O'){
//        
//        for(int i=0; i<3; i++){
//          for(int j=0; j<3; j++){
//            if (source==buttons[i][j]){
//              
//              result = check_record(table, 'O', i, j);
//            }
//          }
//        }
//        
//        result = check_record(table, 'O', r_1, c_1);
//        
//        if(result== 'O'||result=='F'){
//          return result;
//        }
//      }else if(player=='X'){
//        System.out.println("Second Player enter row(1~3): ");
//        int r_2 = reader.nextInt()-1;
//        System.out.println("Second Player enter column(1~3): ");
//        int c_2 = reader.nextInt()-1;
//        reader.close();
//        result = check_record(table, 'X', r_2, c_2);
//        
//        if(result== 'X' ||result== 'F' ){
//          return result;
//        }
//      }
//      
//      return result;
//    }
    
    //private static char check_record(char[][] table, char value, int row, int column){
    
    private static char check_record(char[][] table, char value, int row, int column){
      
      
      
      if(value=='O'){
        table[row][column] = 'O';
        buttons[row][column].setText("O");
        buttons[row][column].setIcon(O);
        System.out.println("O");
      }else if (value=='X'){
        table[row][column] = 'X';
        buttons[row][column].setText("X");
        buttons[row][column].setIcon(X);
      }
        
        
      
      
      //table[i_r][j_r] = 'X';
      //buttons[i_r][j_r].setIcon(X);
        
      //buttons[i_r][j_r].setEnabled(false);  
      buttons[row][column].setEnabled(false);
      
     // }
//        else{
//          System.out.println("Wrong position!");
//          System.out.println("Please enter your position again!");
//          input_output(table,value);
//          return 'W'; //wrong position
//        }
      
      test_space = false;
      for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
          if(table[i][j]=='@'){                    //now check for the space
            test_space = true;
          }
        }
      }
      
      if(test_space==false){
        return 'F';
      }
      
      System.out.println("Tic Tac Toe Table~");
      
      System.out.println(table[0][0]+" "+table[0][1]+" "+table[0][2]);
      System.out.println(table[1][0]+" "+table[1][1]+" "+table[1][2]);
      System.out.println(table[2][0]+" "+table[2][1]+" "+table[2][2]);
      
      test_win = false;    // now check for winning
      for(int i = 0; i<3; i++){
        if((table[i][1]==table[i][0]&&table[i][1]==table[i][2]&&table[i][1]!='@')||(table[0][i]==table[1][i]&&table[1][i]==table[2][i]&&table[1][i]!='@')){
          test_win = true;
        }
      }
      
      if(table[1][1]!='@'){
        if((table[0][0]==table[1][1]&&table[1][1]==table[2][2])||(table[0][2]==table[1][1]&&table[1][1]==table[2][0])){
          test_win = true;
        }
      }
      
      System.out.println(test_win);
      System.out.println(test_space);
      
      if (test_win==true){
        if(value=='O'){
          
        System.out.println("O"); 
          return 'O';
        }else{
          return 'X';
        }
        
      }
      
      
      
      return 0;
    }
    
    
    
  }
  
}

//Only final?????????????????

//start.addActionListener(new ActionListener(){
//      @Override
//      public void actionPerformed(ActionEvent event)
//      {
////        listPanel.setVisible(!listPanel.isVisible());
////        comboPanel.setVisible(!comboPanel.isVisible());
//        //user_name = name.getText();
//        username.setVisible(false);
//        name.setVisible(false);
//        start.setVisible(false);
//        //show_name.setVisible(true);
//        //JLabel show_name = new JLabel("Good Luck! "+user_name);
//        //final show_name;
//        
//        show_name.setText("Good Luck!" + user_name);
//        show_name.setVisible(true);
//        //name.setBounds(58,146,112,23);
//        //login.add(show_name);
//        game.setVisible(true);
//      }
//    });

/////////////////////////////////////////////////////////////////////////

//MAKE THE button "start" invisible
//start.setVisible(false);

//import javax.swing.ImageIcon;
//setResizable(false);//people can't resize the frame

// //This will center the JFrame in the middle of the screen
    //setLocationRelativeTo(null);
    
    
    //jp.setLayout(null);
//    jb11.setBounds(0,0,120,120);
//    jb12.setBounds(120,0,120,120);
//    jb13.setBounds(240,0,120,120);
//    jb21.setBounds(0,120,120,120);
//    jb22.setBounds(120,120,120,120);
//    jb23.setBounds(240,120,120,120);
//    jb31.setBounds(0,240,120,120);
//    jb32.setBounds(120,240,120,120);
//    jb33.setBounds(240,240,120,120);
    
    
    //final BufferedImage img=new ImgUtils().scaleImage(200,200,"C:\\Users\\cinya\\X.png");
//create label with image as background
    //JLabel label=new JLabel(new ImageIcon((Image)img));


   //buttons[] = new JButton();
//  JButton jb12 = new JButton();
//  JButton jb13 = new JButton();
//  JButton jb21 = new JButton();
//  JButton jb22 = new JButton();
//  JButton jb23 = new JButton();
//  JButton jb31 = new JButton();
//  JButton jb32 = new JButton();
//  JButton jb33 = new JButton();


//    jp.add(jb11);
//    jp.add(jb12);
//    jp.add(jb13);
//    jp.add(jb21);
//    jp.add(jb22);
//    jp.add(jb23);
//    jp.add(jb31);
//    jp.add(jb32);
//    jp.add(jb33);

//setLayout(null);
    //setDefaultCloseOperation(3);

//    JFrame guiFrame = new JFrame();
// 
// //make sure the program exits when the frame closes
    
    //setTitle("TicTacToe GUI");
    
    //setSize(500,500);
//import javax.swing.*;
//import java.awt.*;
//import javax.swing.JOptionPane;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class Controller{
  private View theView;
  private Play theModel;
  
  public Controller(View theView, Play theModel){
    this.theView = theView;
    this.theModel = theModel;
    this.theView.addStartListener(new StartListener()); 
    this.theView.addGameListener(new ButtonsListener());
    //this.theModel.ini_table();
  }
  
  
  class StartListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) 
    {
//        listPanel.setVisible(!listPanel.isVisible());
//        comboPanel.setVisible(!comboPanel.isVisible());
      
      theView.username.setVisible(false);
      theView.name.setVisible(false);
      theView.start.setVisible(false);
      //show_name.setVisible(true);
      //JLabel show_name = new JLabel("Good Luck! "+user_name);
      //final show_name;
      
      theView.show_name.setText("Good Luck! " + theView.user_name + " ~ You would use O");
      System.out.println(theView.user_name);
      theView.show_name.setVisible(true);
      //name.setBounds(58,146,112,23);
      //login.add(show_name);
      theView.game.setVisible(true);
      //theModel.ini_table(); ?????????
    }
  }
  
  
  class ButtonsListener implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
      Object source = e.getSource();
      
      char final_value = '.' ;
      
      
      //do{
      
      
      for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
          if (source==theView.buttons[i][j]){
            //theView.buttons[i][j].setIcon(theView.O);
            theModel.check_record('O', i, j);
            final_value = theModel.getStatus();
            //theView.buttons[i][j].setEnabled(false);
          }
        }
      }
      
      int[] position = new int[2];
      position = theModel.randomComputer(final_value);
      //theView.buttons[position[0]][position[1]].setText("X"); ??????
      theView.buttons[position[0]][position[1]].setEnabled(false);
      //final_value = check_record('X', position[0], position[1]);
      
      
      
//        
      
      //System.out.println(final_value);
      //}while(test_win==false);
      
      if(final_value=='F'||final_value=='X'||final_value=='O'){
        for(int i=0; i<3; i++){
          for(int j=0; j<3; j++){                                  //??method
            theView.buttons[i][j].setEnabled(false);
          }
        }
        //game.setVisible(false);
        //login.setVisible(false);
        //end.setVisible(true);
      }else{
        theModel.check_record('X', position[0], position[1]);
        final_value = theModel.getStatus();
        if(final_value=='F'||final_value=='X'||final_value=='O'){
          for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){                                  //??method
              theView.buttons[i][j].setEnabled(false);
            }
          }
        } 
      }
      
      if(final_value=='X'){//computer
        theView.show_name.setText("You Lose!");
        //ending = "You Lose!";
        
      }else if(final_value=='O'){ //user
        
        theView.show_name.setText("You Win!");
        //ending = "You Win!";
      }else if(final_value=='F'){  //grid filled
        theView.show_name.setText("Table is full! Game out!");
        //ending = "Table is full! Game out!";
      }
      
      
    }
  }
}
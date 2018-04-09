import java.util.Random;

public class Play{
  
  private static char status;
  private static char[][] table = new char[3][3];
  private static boolean test_space;
  private static boolean test_win;
 
  public void ini_table(){
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        table[i][j] = '@';
      }
    }
  }
  
  
  public static void getInfo(char value, int row, int column){
    if(value=='O'){
      table[row][column] = 'O';
      //buttons[row][column].setIcon(O);
    }else if (value=='X'){
      table[row][column] = 'X';
      //buttons[row][column].setText("X");
      //buttons[row][column].setIcon(X);
      
    }
  }
  
  public int[] randomComputer(char final_value){
    int[] position = new int[2];
    Random rand = new Random();
    do{
          position[0] = rand.nextInt(3);
          position[1] = rand.nextInt(3);
    }while(table[position[0]][position[1]] !='@'&&!(final_value=='O'||final_value=='F'));
    
    return position;    
  }
  
//  public int[] computerAI(char final_value){
//    int[] position = new int[2];
//    Random rand = new Random();
//    do{
//          position[0] = rand.nextInt(3);
//          position[1] = rand.nextInt(3);
//    }while(table[position[0]][position[1]] !='@'&&!(final_value=='O'||final_value=='F'));
//    
//    return position;    
//  }
  
  
  
  public void check_record(char value, int row, int column){
    
    if(value=='O'){
        table[row][column] = 'O';
      }else if (value=='X'){
        table[row][column] = 'X';
      }
      

      
      test_space = false;
      for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
          if(table[i][j]=='@'){                    //now check for the space
            test_space = true;
          }
        }
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
          
          status =  'O';
        }else{
          status =  'X';
        }
        
      }
      
      if(test_space==false){
        status =  'F';
      }
    }
    
  public char getStatus(){
    return status;
  }
    
}
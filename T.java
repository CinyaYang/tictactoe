import java.util.Scanner;

public class T {
    static char[][] table = new char[3][3];
    static boolean test_1 = true;//correct value
    static boolean test_2 = false;//space
    static boolean test_3 = false;//winner
    
    public static char input_output (char[][] table, char player){
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        char result = '@' ;
        if(player=='O'){
          System.out.println("First Player enter row(1~3): ");
          int r_1 = reader.nextInt()-1;
          System.out.println("First Player enter column(1~3): ");
          int c_1 = reader.nextInt()-1;
          reader.close(); 
         
          result = check_record(table, 'O', r_1, c_1);
          
          if(result== 'O'||result=='F'){
            return result;
          }
        }else if(player=='X'){
          System.out.println("Second Player enter row(1~3): ");
          int r_2 = reader.nextInt()-1;
          System.out.println("Second Player enter column(1~3): ");
          int c_2 = reader.nextInt()-1;
          reader.close();
          result = check_record(table, 'X', r_2, c_2);
          
          if(result== 'X' ||result== 'F' ){
            return result;
          }
        }
        
        return result;
    }
    
    
    public static char check_record(char[][] table, char value, int row, int column){
        
        if(table[row][column] == '@') {
            table[row][column]=value;
        }else{
          System.out.println("Wrong position!");
          System.out.println("Please enter your position again!");
          input_output(table,value);
          return 'W'; //wrong position
        }
        
        test_2 = false;//now check for the space
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(table[i][j]=='@'){
                    test_2 = true;
                }
            }
        }
        
        if(test_2==false){
            return 'F';
        }
        
        System.out.println("Tic Tac Toe Table~");
        System.out.println(table[0][0]+" "+table[0][1]+" "+table[0][2]);
        System.out.println(table[1][0]+" "+table[1][1]+" "+table[1][2]);
        System.out.println(table[2][0]+" "+table[2][1]+" "+table[2][2]);
        
        test_3 = false;    // now check for winning
        for(int i = 0; i<3; i++){
            if((table[i][1]==table[i][0]&&table[i][1]==table[i][2]&&table[i][1]!='@')||(table[0][i]==table[1][i]&&table[1][i]==table[2][i]&&table[1][i]!='@')){
                test_3 = true;
            }
        }
        
        if(table[1][1]!='@'){
          if((table[0][0]==table[1][1]&&table[1][1]==table[2][2])||(table[0][2]==table[1][1]&&table[1][1]==table[2][0])){
            test_3 = true;
          }
        }
        
        
        if (test_3==true){
          //System.out.println(value); 
            if(value=='O'){
                return 'O';
            }else{
                return 'X';
            }
           
        }
        
        return 0;
    }
    
    
    
    
    public static void main(String args[]) {
        
        char final_value ;
        
        
        System.out.println("Welcome to play Tic Tac Toe~");
        System.out.println("Lets Begin~");
        
        
        System.out.println("Tic Tac Toe Table~");
        
        for(int i=0; i<3; i++){
          for(int j=0; j<3; j++){
            table[i][j] = '@';
          }
        }
        
        System.out.println(table[0][0]+" "+table[0][1]+" "+table[0][2]);
        System.out.println(table[1][0]+" "+table[1][1]+" "+table[1][2]);
        System.out.println(table[2][0]+" "+table[2][1]+" "+table[2][2]);
        
        
        do{
            final_value = input_output(table,'O');
            
            if(final_value=='O'||final_value=='F'){
            break;
            }
            
            final_value = input_output(table,'X');
        }while(test_3==false);
        
        
        
        if(final_value=='F'){
            System.out.println("Table is full!");
            System.out.println("Game out!");
        }else if(final_value=='O'){
            System.out.println("The first Player is the Winner!");
        }else if(final_value=='X'){
            System.out.println("The Second Player is the Winner!");
        }
        
    }
    
    
}

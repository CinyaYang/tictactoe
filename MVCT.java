public class MVCT{
  public static void main(String[] args){
    View theView = new View();
    Play theModel = new Play();
    Controller theController = new Controller(theView, theModel);
    theModel.ini_table();
    theView.setVisible(true);
  }
}
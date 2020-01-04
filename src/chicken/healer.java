package chicken;

public class Healer extends Chicken{
  private int hp_increase = 0;
  public Healer(String Input_name, String Input_gender, String Input_type){
    super(Input_name, Input_gender, Input_type);
    hp = 60;
    happiness = 90;
  }


  //工作
  //改變data
  public int work(){
    //存活與否
    if(condition == 1){
      hp = hp - 30;
      happiness = happiness - 50;
      decide();
      return 0;//為符合父程式格式
    }
    else{
      return 0;//為符合父程式格式
    }
  }

  //治療
  public void heal(Chicken A){
    //存活與否
    if(condition == 1){
      hp_increase = hp/2;
      if(A.condition == 1){
        A.hp = A.hp + hp_increase;   
      }
    }
  }

  //顯示訊息
  public void getMessage(){
     super.getMessage();
     System.out.println(" ");
  }
}
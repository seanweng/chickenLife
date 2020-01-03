package chicken;

public class Cook extends Chicken{
  public Cook(String Input_name, String Input_gender, String Input_type){
    super(Input_name, Input_gender, Input_type);
    hp = 70;
    happiness = 95;
  }

  //工作
  //改變data
  public int work(int food){
    //存活與否
    if(condition == 1){
      food = food + (hp*3 + happiness*5)/4;
      hp = hp - 25;
      happiness = happiness - 20;
      decide();
      return food;
    }

    else{
      return food;
    }
  }


  //回傳食物增加量
  public int work(){
    int food = 0;

    //存活與否
    if(condition == 1){
      food = (hp*3 + happiness*5)/4;
      return food;
    }

    else{
      return food;
    }
  }


  //顯示訊息
  public void getMessage(){
     super.get_Message();
     System.out.println(" ");
  }
}
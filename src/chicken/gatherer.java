package chicken;

public class gatherer extends chicken{
  private int endurance = 0;

  public gatherer(String Input_name, String Input_gender, String Input_type){
    super(Input_name, Input_gender, Input_type);
    hp = 90;
    happiness = 85;
    set_endurance(hp);
  }


  //工作
  //改變data
  public int work(int ingredient){
    //存活與否
    if(condition == 1){
      ingredient = ingredient + work();
      hp = hp - 30;
      happiness = happiness - 25;
      decide();
      return ingredient;
    }

    else{
      return ingredient;
    }
  }

  //回傳食材增加量
  public int work(){
    int increase_ingredient = 0;

    //存活與否	
    if(condition == 1){
      set_endurance((hp - 30));
      increase_ingredient = (hp*4 + happiness*2)/3;
      if(increase_ingredient <= endurance){
        return increase_ingredient;
      }
      else{
        return endurance;
      }
    }

    else{
      return increase_ingredient;
    }
  }

  //取負重力值
  public int set_endurance(int now_hp){
    endurance = now_hp*3/2;
    if(endurance<=0){
      endurance = 0;
    }
    return endurance;
  }

  //顯示訊息
  public void get_Message(){
     super.get_Message();
     System.out.println("  負重力:" + set_endurance(hp));
     System.out.println(" ");
  }

}
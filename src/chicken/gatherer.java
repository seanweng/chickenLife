package chicken;

public class Gatherer extends Chicken{
  private int endurance = 0;

  public Gatherer(String Input_name, String Input_gender, String Input_type){
    super(Input_name, Input_gender, Input_type);
    hp = 90;
    happiness = 85;
    set_endurance(hp);
  }


  //�u�@
  //����data
  public int work(int ingredient){
    //�s���P�_
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

  //�^�ǭ����W�[�q
  public int work(){
    int increase_ingredient = 0;

    //�s���P�_	
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

  //���t���O��
  public int setEndurance(int now_hp){
    endurance = now_hp*3/2;
    if(endurance<=0){
      endurance = 0;
    }
    return endurance;
  }

  //��ܰT��
  public void getMessage(){
     super.get_Message();
     System.out.println("  �t���O:" + set_endurance(hp));
     System.out.println(" ");
  }

}
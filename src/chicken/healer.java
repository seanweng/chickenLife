package chicken;

public class healer extends chicken{
  private int hp_increase = 0;
  public healer(String Input_name, String Input_gender, String Input_type){
    super(Input_name, Input_gender, Input_type);
    hp = 60;
    happiness = 90;
  }


  //�u�@
  //����data
  public int work(){
    //�s���P�_
    if(condition == 1){
      hp = hp - 30;
      happiness = happiness - 50;
      decide();
      return 0;//���ŦX���{���榡
    }
    else{
      return 0;//���ŦX���{���榡
    }
  }

  //�v��
  public void heal(chicken A){
    //�s���P�_
    if(condition == 1){
      hp_increase = hp/2;
      if(A.condition == 1){
        A.hp = A.hp + hp_increase;   
      }
    }
  }

  //��ܰT��
  public void get_Message(){
     super.get_Message();
     System.out.println(" ");
  }
}
package chicken;

public class cook extends chicken
{
  public cook(String Input_name, String Input_sex, String Input_type)
  {
    super(Input_name, Input_sex, Input_type);
    hp = 70;
    happiness = 95;
  }

  //�u�@
  //����data
  public int work(int food)
  {
    //�s���P�_
    if(condition == 1)
    {
      food = food + (hp*3 + happiness*5)/4;
      hp = hp - 25;
      happiness = happiness - 20;
      decide();
      return food;
    }

    else
    {
      return food;
    }
  }


  //�^�ǭ����W�[�q
  public int work()
  {
    int food = 0;

    //�s���P�_
    if(condition == 1)
    {
      food = (hp*3 + happiness*5)/4;
      return food;
    }

    else
    {
      return food;
    }
  }


  //��ܰT��
  public void get_Message()
  {
     super.get_Message();
     System.out.println(" ");
  }




}
package chicken;

public class chicken
{
  protected String name;
  protected String sex;
  protected String type; // "cook" or "gatherer" or "healer"
  protected int condition; //�s��:1  ���`:0
  protected int hp;
  protected int happiness;



  //constructor
  public chicken(String Input_name, String Input_sex, String Input_type)
  {
    name = Input_name;
    sex = Input_sex;
    type = Input_type;
    condition = 1;
  }


  //���o�m�W
  public String get_name()
  {
    return name;
  }


  //���o�ʧO
  public String get_sex()
  {
    return sex;
  }


  //���o���O
  public String get_type()
  {
    return type;
  }


  //���o���A
  public int get_condition()
  {
    return condition;
  }


  //���o��O
  public int get_hp()
  {
    return hp;
  }


  //���o�ּ֭�
  public int get_happiness()
  {
    return happiness;
  }



  //����
  public int feed()
  {
    //�s���P�_
    if(condition == 1)
    {
      if(sex.equals("male"))
      {
        hp = hp + 70;
        decide();
        return 30;
      }

      else
      {
        hp = hp + 70;
        decide();
        return 20;
      }
    }

    else
    {
      return 0;
    }
  }
  //�^�ǭ����ݨD�q
  public int feed_require()
  {
    if(sex.equals("male"))
    {
      return 30;
    }

    else
    {
      return 20;
    }

  }



  //���R
  public void danceWith()
  {
    //�s���P�_
    if(condition == 1)
    {
      hp = hp - 20;
      happiness = happiness + 30;
      decide();
    }

  }


  //���\
  public int picnic()
  {
    //�s���P�_
    if(condition == 1)
    {
      if(sex.equals("male"))
      {
        hp = hp + 30;
        happiness = happiness + 20;
        decide();
        return 50;
      }

      else
      {
        hp = hp + 30;
        happiness = happiness + 20;
        decide();
        return 40;
      }
    }

    else
    {
      return 0;
    }
  }
  //�^�ǭ����ݨD�q
  public int picnic_require()
  {
    if(sex.equals("male"))
    {
      return 50;
    }

    else
    {
      return 40;
    }

  }




  //���[
  public void fight(chicken Input_object)
  {
    //�s���P�_
    if(condition == 1)
    {
      if(hp > Input_object.hp)
      {
        System.out.println(" ��"+ name + "�ӧQ!!!");
        System.out.println("");
        happiness = happiness + 30;
        hp = hp - 15;

        Input_object.happiness = Input_object.happiness - 15;
        Input_object.hp = Input_object.hp - 15;
        decide();
        Input_object.decide();
      }

      else if(hp == Input_object.hp)
      {
        if(sex.equals(Input_object.sex))
        {
          hp = hp - 15;
          System.out.println(" �����襭��!!!");
          System.out.println("");
        }

        else
        {
          if(sex.equals("female"))
          {
            System.out.println(" ��"+ name + "�ӧQ!!!");
            System.out.println("");
            happiness = happiness + 30;
            hp = hp - 15;

            Input_object.happiness = Input_object.happiness - 15;
            Input_object.hp = Input_object.hp - 15;

          }

          else
          {
            System.out.println(" ��"+ Input_object.name + "�ӧQ!!!");
            System.out.println("");
            Input_object.happiness = Input_object.happiness + 30;
            Input_object.hp = Input_object.hp - 15;

            happiness = happiness - 15;
            hp = hp - 15;
          }
        }
        decide();
        Input_object.decide();
      }

      else if(hp < Input_object.hp)
      {
        System.out.println(" ��"+ Input_object.name + "�ӧQ!!!");
            System.out.println("");
        Input_object.happiness = Input_object.happiness + 30;
        Input_object.hp = Input_object.hp - 15;

        happiness = happiness - 15;
        hp = hp - 15;

        decide();
        Input_object.decide();
      }
    }
  }

  //�u�@
    //����data
  public int work(int ingredient_Or_food)
  {
    return 0;
  }

    //�^�ǭ����W�[�q
  public int work()
  {
    return 0;
  }



  //�M�w�ƭ�
  protected void decide()
  {
    //hp���̤j�Ȥγ̤p��
    if(hp > 100)
    {
      hp = 100;
    }
    else if(hp < 0)
    {
      hp = 0;
    }


    //happiness���̤j�Ȥγ̤p��
    if(happiness > 100)
    {
      happiness = 100;
    }
    else if(happiness < 0)
    {
      happiness = 0;
    }


    //���`�P�_
    if(hp == 0 || happiness == 0)
    {
      condition = 0;
    }
  }


  //�ˬd�m�W
  public int check_name(String Input_name)
  {
    if(Input_name.equals(name))
    {
      return 1;
    }
    else
    {
      return 0;
    }
  }


  //��ܰT��
  public void get_Message()
  {
    System.out.println("  �W�r:" + name);
    System.out.println("  �ʧO:" + sex);
    System.out.println("  ����:" + type);
    if(condition == 1)
    {
      System.out.println("  ���A:�s��");
    }
    else
    {
      System.out.println("  ���A:���`");
    }
    System.out.println("  ��O:" + hp);
    System.out.println("  �ּ֭�:" + happiness);
  }

  //�ͳJ
  public int layEgg()
  {
    if(sex.equals("female"))
    {
      hp = hp - 70;
      happiness = happiness - 50;
      decide();
      return 1;
    }
    else
    {
      System.out.println(name +"�������A�L�k�ͳJ!!!");
      return 0;
    }
  }

  //�D��
  public static void mate(chicken A,chicken B)
  {
    A.hp = A.hp - 50;
    B.hp = B.hp - 50;

    A.happiness = 100;
    B.happiness = 100;

    A.decide();
    B.decide();
  }

  //�v��
  public void heal(chicken A)
  {
  }

  //�]�wint data
  public void set_all_int(int Input_condition, int Input_hp, int Input_happiness)
  {
    condition = Input_condition;
    hp = Input_hp;
    happiness = Input_happiness;
  }


}
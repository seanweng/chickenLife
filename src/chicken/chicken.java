package chicken;

public class Chicken{
  protected String name;
  protected String gender;
  protected String type; // "cook" or "gatherer" or "healer"
  protected int condition; //�s��:1  ���`:0
  protected int hp;
  protected int happiness;



  //constructor
  public Chicken(String Input_name, String Input_gender, String Input_type){
    name = Input_name;
    gender = Input_gender;
    type = Input_type;
    condition = 1;
  }


  //���o�m�W
  public String getName(){
    return name;
  }


  //���o�ʧO
  public String getGender(){
    return gender;
  }


  //���o���O
  public String getType(){
    return type;
  }


  //���o���A
  public int getCondition(){
    return condition;
  }


  //���o��O
  public int getHp(){
    return hp;
  }


  //���o�ּ֭�
  public int getHappiness(){
    return happiness;
  }


  //����
  public int feed(){
    //�s���P�_
    if(condition == 1){
      if(gender.equals("male")){
        hp = hp + 70;
        decide();
        return 30;
      }

      else{
        hp = hp + 70;
        decide();
        return 20;
      }
    }

    else{
      return 0;
    }
  }
  //�^�ǭ����ݨD�q
  public int feedRequire(){
    if(gender.equals("male")){
      return 30;
    }

    else{
      return 20;
    }

  }

  //���R
  public void danceWith(){
    //�s���P�_
    if(condition == 1){
      hp = hp - 20;
      happiness = happiness + 30;
      decide();
    }
  }


  //���\
  public int picnic(){
    //�s���P�_
    if(condition == 1){
      if(gender.equals("male")){
        hp = hp + 30;
        happiness = happiness + 20;
        decide();
        return 50;
      }

      else{
        hp = hp + 30;
        happiness = happiness + 20;
        decide();
        return 40;
      }
    }

    else{
      return 0;
    }
  }
  //�^�ǭ����ݨD�q
  public int picnicRequire(){
    if(gender.equals("male")){
      return 50;
    }
    else{
      return 40;
    }
  }

  //���[
  public void fight(chicken Input_object){
    //�s���P�_
    if(condition == 1){
      if(hp > Input_object.hp){
        System.out.println(" ��"+ name + "�ӧQ!!!");
        System.out.println("");
        happiness = happiness + 30;
        hp = hp - 15;

        Input_object.happiness = Input_object.happiness - 15;
        Input_object.hp = Input_object.hp - 15;
        decide();
        Input_object.decide();
      }

      else if(hp == Input_object.hp){
        if(gender.equals(Input_object.gender)){
          hp = hp - 15;
          System.out.println(" �����襭��!!!");
          System.out.println("");
        }

        else{
          if(gender.equals("female")){
            System.out.println(" ��"+ name + "�ӧQ!!!");
            System.out.println("");
            happiness = happiness + 30;
            hp = hp - 15;

            Input_object.happiness = Input_object.happiness - 15;
            Input_object.hp = Input_object.hp - 15;

          }

          else{
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

      else if(hp < Input_object.hp){
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
  public int work(int ingredient_Or_food){
    return 0;
  }

    //�^�ǭ����W�[�q
  public int work(){
    return 0;
  }



  //�M�w�ƭ�
  protected void decide(){
    //hp���̤j�Ȥγ̤p��
    if(hp > 100){
      hp = 100;
    }
    else if(hp < 0){
      hp = 0;
    }


    //happiness���̤j�Ȥγ̤p��
    if(happiness > 100){
      happiness = 100;
    }
    else if(happiness < 0){
      happiness = 0;
    }

    //���`�P�_
    if(hp == 0 || happiness == 0){
      condition = 0;
    }
  }


  //�ˬd�m�W
  public int checkName(String Input_name){
    if(Input_name.equals(name)){
      return 1;
    }
    else{
      return 0;
    }
  }


  //��ܰT��
  public void getMessage(){
    System.out.println("  �W�r:" + name);
    System.out.println("  �ʧO:" + gender);
    System.out.println("  ����:" + type);
    if(condition == 1){
      System.out.println("  ���A:�s��");
    }
    else{
      System.out.println("  ���A:���`");
    }
    System.out.println("  ��O:" + hp);
    System.out.println("  �ּ֭�:" + happiness);
  }

  //�ͳJ
  public int layEgg(){
    if(gender.equals("female")){
      hp = hp - 70;
      happiness = happiness - 50;
      decide();
      return 1;
    }
    else{
      System.out.println(name +"�������A�L�k�ͳJ!!!");
      return 0;
    }
  }

  //�D��
  public static void mate(chicken A,chicken B){
    A.hp = A.hp - 50;
    B.hp = B.hp - 50;

    A.happiness = 100;
    B.happiness = 100;

    A.decide();
    B.decide();
  }

  //�v��
  public void heal(chicken A){
  }

  //�]�wint data
  public void set_all_int(int Input_condition, int Input_hp, int Input_happiness){
    condition = Input_condition;
    hp = Input_hp;
    happiness = Input_happiness;
  }
}
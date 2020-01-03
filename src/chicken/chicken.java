package chicken;

public class Chicken{
  protected String name;
  protected String gender;
  protected String type; // "cook" or "gatherer" or "healer"
  protected int condition; //存活:1  死亡:0
  protected int hp;
  protected int happiness;



  //constructor
  public Chicken(String Input_name, String Input_gender, String Input_type){
    name = Input_name;
    gender = Input_gender;
    type = Input_type;
    condition = 1;
  }


  //取得姓名
  public String getName(){
    return name;
  }


  //取得性別
  public String getGender(){
    return gender;
  }


  //取得類別
  public String getType(){
    return type;
  }


  //取得狀態
  public int getCondition(){
    return condition;
  }


  //取得體力
  public int getHp(){
    return hp;
  }


  //取得快樂值
  public int getHappiness(){
    return happiness;
  }


  //餵食
  public int feed(){
    //存活與否
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
  //回傳食物需求量
  public int feedRequire(){
    if(gender.equals("male")){
      return 30;
    }

    else{
      return 20;
    }

  }

  //跳舞
  public void danceWith(){
    //存活與否
    if(condition == 1){
      hp = hp - 20;
      happiness = happiness + 30;
      decide();
    }
  }


  //野餐
  public int picnic(){
    //存活與否
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
  //回傳食物需求量
  public int picnicRequire(){
    if(gender.equals("male")){
      return 50;
    }
    else{
      return 40;
    }
  }

  //打架
  public void fight(chicken Input_object){
    //存活與否
    if(condition == 1){
      if(hp > Input_object.hp){
        System.out.println(" ★"+ name + "勝利!!!");
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
          System.out.println(" ★雙方平手!!!");
          System.out.println("");
        }

        else{
          if(gender.equals("female")){
            System.out.println(" ★"+ name + "勝利!!!");
            System.out.println("");
            happiness = happiness + 30;
            hp = hp - 15;

            Input_object.happiness = Input_object.happiness - 15;
            Input_object.hp = Input_object.hp - 15;

          }

          else{
            System.out.println(" ★"+ Input_object.name + "勝利!!!");
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
        System.out.println(" ★"+ Input_object.name + "勝利!!!");
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

  //工作
    //改變data
  public int work(int ingredient_Or_food){
    return 0;
  }

    //回傳食物增加量
  public int work(){
    return 0;
  }



  //決定數值
  protected void decide(){
    //hp的最大值及最小值
    if(hp > 100){
      hp = 100;
    }
    else if(hp < 0){
      hp = 0;
    }


    //happiness的最大值及最小值
    if(happiness > 100){
      happiness = 100;
    }
    else if(happiness < 0){
      happiness = 0;
    }

    //死亡與否
    if(hp == 0 || happiness == 0){
      condition = 0;
    }
  }


  //檢查姓名
  public int checkName(String Input_name){
    if(Input_name.equals(name)){
      return 1;
    }
    else{
      return 0;
    }
  }


  //顯示訊息
  public void getMessage(){
    System.out.println("  名字:" + name);
    System.out.println("  性別:" + gender);
    System.out.println("  類型:" + type);
    if(condition == 1){
      System.out.println("  狀態:存活");
    }
    else{
      System.out.println("  狀態:死亡");
    }
    System.out.println("  體力:" + hp);
    System.out.println("  快樂值:" + happiness);
  }

  //生蛋
  public int layEgg(){
    if(gender.equals("female")){
      hp = hp - 70;
      happiness = happiness - 50;
      decide();
      return 1;
    }
    else{
      System.out.println(name +"為公雞，無法生蛋!!!");
      return 0;
    }
  }

  //求偶
  public static void mate(chicken A,chicken B){
    A.hp = A.hp - 50;
    B.hp = B.hp - 50;

    A.happiness = 100;
    B.happiness = 100;

    A.decide();
    B.decide();
  }

  //治療
  public void heal(chicken A){
  }

  //設定int data
  public void set_all_int(int Input_condition, int Input_hp, int Input_happiness){
    condition = Input_condition;
    hp = Input_hp;
    happiness = Input_happiness;
  }
}
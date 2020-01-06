import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import chicken.*;

public class ChickenCoop{

  private ArrayList<Chicken> chicken = new ArrayList<Chicken>();;
  private int chickenNum = 0;
  private int ingredient = 100;
  private int food = 80;
  private int egg = 0;


  //搜尋小雞
  public Chicken findChicken(String Intput_name){
    boolean findOrNot = false;
    for(int i = 0; i < chickenNum; i++){
      if(Intput_name.equals(chicken.get(i).getName()){
        findOrNot = true;
        return chicken.get(i);
      }
    }
    return null;
  }

  //檢察小雞是否死亡
  public boolean isAlive(Chicken Intput_chicken){
    if(Intput_chicken.getCondition() == 0){
      return false;
    }
    else{
      return true;
    }
  }

  //產生新小雞
  public void hatch(String Intput_name,String Intput_gender,String Intput_type){
    switch(Intput_type){
      case "cook":
       chicken.add(new Cook(Intput_name, Intput_gender, Intput_type));
       break;

      case "gatherer":
       chicken.add(new Gatherer(Intput_name, Intput_gender, Intput_type));
       break;

      case "healer":
       chicken.add(new Healer(Intput_name, Intput_gender, Intput_type));
       break;
    }
    System.out.println(" ★一隻小雞誕生了");
    chicken.get(chickenNum).getMessage();
    chickenNum++;
  }


  //餵食
  public void feed(Chicken Intput_chicken){
    if(Intput_chicken.feedRequire() <= food){
      food = food - Intput_chicken.feed();
      System.out.println("  食材存量:" + ingredient);
      System.out.println("  食物存量:" + food);
      Intput_chicken.getMessage();
    }
    else{
        System.out.println("  食物存量不足");
    }
  }


  //跳舞
  public void danceWith(Chicken Intput_chicken){
    Intput_chicken.danceWith();
    Intput_chicken.getMessage();
  }


  //野餐
  public void picnic(Chicken Intput_chicken){
    if(Intput_chicken.picnicRequire() < food){
      food = food - Intput_chicken.picnic();
      System.out.println("  食材存量:" + ingredient);
      System.out.println("  食物存量:" + food);
      Intput_chicken.getMessage();
    }
    else{
      System.out.println("  食物存量不足");
    }
  }

  //打架
  public void fight(Chicken Intput_chicken_1,Chicken Intput_chicken_2){
    Intput_chicken_1.fight(Intput_chicken_2);
    Intput_chicken_1.getMessage();
    Intput_chicken_2.getMessage();
  }

  //求偶
  public void mate(Chicken Intput_chicken_1,Chicken Intput_chicken_2){
    Chicken.mate(Intput_chicken_1,Intput_chicken_2);
    Intput_chicken_1.getMessage();
    Intput_chicken_2.getMessage();
  }


  //生蛋
  public void layEgg(Chicken Intput_chicken){
    //是否為母雞
    if(Intput_chicken.getGender().equals("male")){
      System.out.println("  "+ Intput_chicken.getName() +"為公雞，無法生蛋!!!");
    }
    else{
      System.out.println("  獲得了一顆蛋!");
      egg = egg + Intput_chicken.layEgg();
      Intput_chicken.getMessage();
    }
  }


  //工作
  public void work(Chicken Intput_chicken){
      switch(Intput_chicken.getType()){
        case "gatherer":
          System.out.println("  食材增加:"+ Intput_chicken.work());
          ingredient = Intput_chicken.work(ingredient);
          System.out.println("  食材存量:" + ingredient);
          System.out.println("  食物存量:" + food);
          System.out.println("");
          Intput_chicken.getMessage();
          break;

        case "cook":
          if(ingredient > 60){
            ingredient = ingredient - 60;
            System.out.println("  食物增加:"+ Intput_chicken.work());
            food = Intput_chicken.work(food);
            System.out.println("  食材存量:" + ingredient);
            System.out.println("  食物存量:" + food);
            System.out.println("");
            Intput_chicken.getMessage();
          }
          else{
            System.out.println("  食材存量不足");      
          }
          break;

        case "healer":
          for(int i = 0; i < chickenNum; i++){
            if(i == Label){
              continue;
            }
            Intput_chicken.heal(chicken.get(i));
          }
          Intput_chicken.work();
          Intput_chicken.getMessage();
          break;
      }
    }
  }


  //查詢
  public void query(){
    System.out.println("  食材存量:" + ingredient);
    System.out.println("  食物存量:" + food);
    System.out.println("");
    System.out.println("  雞蛋數量:" + egg);
    System.out.println("");
    for(int i = 0; i <= (chickenNum-1); i++){
      chicken.get(i).getMessage();
      System.out.println("");
    }
  }


  //查詢分數
  public void checkScore(){
    int now_point = 0;
    int now_totalpoint = 0;

    now_totalpoint = egg*300;

    for(int i = 0; i < chickenNum; i++){
      if(chicken.get(i).getHp() == 100 && chicken.get(i).getHappiness() == 100){
        now_point = 1000;
      }

      else if(chicken.get(i).getHp() >= 51 && chicken.get(i).getHappiness() > 0){
        now_point = 500;
      }

      else if(chicken.get(i).getHp() > 0 && chicken.get(i).getHappiness() > 0){
        now_point = 100;
      }

      else if(chicken.get(i).getHp() == 0 && chicken.get(i).getHappiness() == 0){
        now_point = -500;
      }
      else{
        now_point = 0;
      }

      now_totalpoint = now_totalpoint + now_point;
    }

    System.out.println("  您目前的分數是:"+ now_totalpoint +"分");
  }


  //呼叫指令集
  public void help(){
    System.out.println(" 《指令集》");
    System.out.println("  1.產生新小雞:     hatch [名字] [性別] [類別] ");
    System.out.println("  2.餵食:           feed [雞的名字]");
    System.out.println("  3.跳舞:           danceWith [雞的名字]");
    System.out.println("  4.野餐:           picnic [雞的名字]");    
    System.out.println("  5.打架:           fight [名字 A] [名字 B]");
    System.out.println("  6.工作:           work [雞的名字]");
    System.out.println("  7.求偶:           mate [名字 A] [名字 B]");
    System.out.println("  8.生蛋:           layEgg [雞的名字]");
    System.out.println("  9.查詢:           query");
    System.out.println("  10.查詢分數:      checkScore");
    System.out.println("  11.呼叫指令集:    help");
    System.out.println("  12.存檔:          save [檔名] ");
    System.out.println("  13.讀檔:          load [檔名] ");
    System.out.println("  14.結束:          exit");
  }

  //存檔
  public void save(String filename){
    try{
      filename = filename+ ".txt";
      File file = new File(filename);
      FileWriter file_writer = new FileWriter(file);
      BufferedWriter writer = new BufferedWriter(file_writer);

      writer.write(Integer.toString(chickenNum));
      writer.newLine();

      writer.write(Integer.toString(ingredient));
      writer.newLine();

      writer.write(Integer.toString(food));
      writer.newLine();

      writer.write(Integer.toString(egg));
      writer.newLine();

      for(int i = 0; i < chickenNum; i++){            
        writer.write(chicken.get(i).getName());
        writer.newLine();
        writer.write(chicken.get(i).getGender());
        writer.newLine();
        writer.write(chicken.get(i).getType());
        writer.newLine();
        writer.write(Integer.toString(chicken.get(i).getCondition()));
        writer.newLine();
        writer.write(Integer.toString(chicken.get(i).getHp()));
        writer.newLine();
        writer.write(Integer.toString(chicken.get(i).getHappiness()));
        writer.newLine();
      }
      writer.close();
      System.out.println("  存檔成功");
    }
    catch(IOException ex){
      System.out.println("  存檔失敗");
    }

  }

  //讀檔
  public void load(String filename){
    //清空Arraylist
    if(chickenNum != 0){
      for(int i = (chickenNum-1); i >= 0; i--){ 
        chicken.remove(i);
      }
    }

    try{
      String getName = null;
      String getGender = null;
      String getType = null;
      int getCondition = 0;
      int getHp = 0;
      int getHappiness = 0;

      filename = filename + ".txt";
      File file = new File(filename);
      FileReader file_reader = new FileReader(file);
      BufferedReader reader = new BufferedReader(file_reader);

      chickenNum = Integer.parseInt(reader.readLine());

      ingredient = Integer.parseInt(reader.readLine());

      food = Integer.parseInt(reader.readLine());

      egg = Integer.parseInt(reader.readLine());

      for(int i = 0; i < chickenNum; i++){
        getName = reader.readLine();
        getGender = reader.readLine();
        getType = reader.readLine();
        getCondition = Integer.parseInt(reader.readLine());
        getHp = Integer.parseInt(reader.readLine());
        getHappiness = Integer.parseInt(reader.readLine());            

        switch(getType){
          case "Gatherer":
            chicken.add(new Gatherer(getName, getGender, getType));
            chicken.get(i).set_all_int(getCondition, getHp, getHappiness);
            break;

          case "Cook":
            chicken.add(new Cook(getName, getGender, getType));
            chicken.get(i).set_all_int(getCondition, getHp, getHappiness);
            break;

          case "Healer":
            chicken.add(new Healer(getName, getGender, getType));
            chicken.get(i).set_all_int(getCondition, getHp, getHappiness);
            break;
        }
      }
      System.out.println("  讀取成功");
    }
    catch(IOException ex){
      System.out.println("  讀取失敗");
    }
  }
}
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import chicken.*;

public class ChickenCoop{

  ArrayList<Chicken> chicken = new ArrayList<Chicken>();
  int chickenNum = 0;
  int ingredient = 100;
  int food = 80;
  int egg = 0;



  //產生新小雞
  public static void hatch(String Intput_name,String Intput_gender,String Intput_type){
    if(chickenNum > 0){
      boolean judge = true;
      for(int i = 0; i < chickenNum; i++){
        judge = Support.check_name(Intput_name,chicken.get(i).getName());
        if(judge){
          System.out.println("  姓名重複");
          i = chickenNum;
        }
      }
      if(!judge){
        if(Support.check_gender(Intput_gender)){
          if(Support.check_type(Intput_type)){
            switch(Intput_type){
              case "cook":
               chicken.add(new cook(Intput_name, Intput_gender, Intput_type));
               break;

              case "gatherer":
               chicken.add(new gatherer(Intput_name, Intput_gender, Intput_type));
               break;

              case "healer":
               chicken.add(new healer(Intput_name, Intput_gender, Intput_type));
               break;
            }
            System.out.println(" ★一隻小雞誕生了");
            chicken.get(chickenNum).getMessage();
            chickenNum++;
          }
        }
      }
    }

    else{
      if(Support.check_gender(Intput_gender)){
        if(Support.check_type(Intput_type)){
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
      }
    }
  }


  //餵食
  public static void feed(String Intput_name){
    if(chickenNum > 0){
      int Label = -1;
      for(int i = 0; i < chickenNum; i++){
        Label = Support.findName(Intput_name,chicken.get(i).getName(),i);
        if(Label != -1){
          i = chickenNum;
        }
      }
      if(Label != -1){
        //死亡與否
        if(chicken.get(Label).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label).getName() +"已死亡");
        }
        if(chicken.get(Label).feed_require() < food){
          food = food - chicken.get(Label).feed();
          System.out.println("  食材存量:" + ingredient);
          System.out.println("  食物存量:" + food);
          chicken.get(Label).getMessage();
        }

        else{
          System.out.println("  食物存量不足");
        }
      }
      else{
        System.out.println("  您沒有一隻叫做"+ Intput_name +"的小雞");
      }
    }

    else{
      System.out.println("  您沒有任何一隻小雞");
    }
  }


  //跳舞
  public static void danceWith(String Intput_name){
    if(chickenNum > 0){
      int Label = -1;
      for(int i = 0; i < chickenNum; i++){
        Label = Support.findName(Intput_name,chicken.get(i).getName(),i);
        if(Label != -1){
          i = chickenNum;
        }
      }
      if(Label != -1){
        //死亡與否
        if(chicken.get(Label).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label).getName() +"已死亡");
        }
        chicken.get(Label).danceWith();
        chicken.get(Label).getMessage();
      }
      else{
        System.out.println("  您沒有一隻叫做"+ Intput_name +"的小雞");
      }
    }

    else{
      System.out.println("  您沒有任何一隻小雞");
    }
  }


  //野餐
  public static void picnic(String Intput_name){
    if(chickenNum > 0){
      int Label = -1;
      for(int i = 0; i < chickenNum; i++){
        Label = Support.findName(Intput_name,chicken.get(i).getName(),i);
        if(Label != -1)
        {
          i = chickenNum;
        }
      }
      if(Label != -1){
        //死亡與否
        if(chicken.get(Label).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label).getName() +"已死亡");
        }
        else{
          if(chicken.get(Label).picnic_require() < food){
            food = food - chicken.get(Label).picnic();
            System.out.println("  食材存量:" + ingredient);
            System.out.println("  食物存量:" + food);
            chicken.get(Label).getMessage();
          }
          else{
            System.out.println("  食物存量不足");
          }
        }
      }
      else{
        System.out.println("  您沒有一隻叫做"+ Intput_name +"的小雞");
      }
    }
    else{
      System.out.println("  您沒有任何一隻小雞");
    }
  }

  //打架
  public static void fight(String Intput_name_1,String Intput_name_2){
    if(chickenNum > 1){
      int Label_1 = -1;
      int Label_2 = -1;
      for(int i = 0; i < chickenNum; i++){
        Label_1 = Support.findName(Intput_name_1,chicken.get(i).getName(),i);
        if(Label_1 != -1){
          i = chickenNum;
        }
      }
      for(int i = 0; i < chickenNum; i++){
        Label_2 = Support.findName(Intput_name_2,chicken.get(i).getName(),i);
        if(Label_2 != -1){
          i = chickenNum;
        }
      }
      if(Label_1 != -1 && Label_2 != -1){
        //死亡與否
        if(chicken.get(Label_1).getCondition() == 0 && chicken.get(Label_2).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_1).getName() +"以及"+ chicken.get(Label_2).getName() +"已死亡");
        }
        else if(chicken.get(Label_1).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_1).getName() +"已死亡");
        }
        else if(chicken.get(Label_2).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_2).getName() +"已死亡");
        }
        else{
          chicken.get(Label_1).fight(chicken.get(Label_2));
          chicken.get(Label_1).getMessage();
          chicken.get(Label_2).getMessage();
        }
      }
      else if(Label_1 == -1 && Label_2 == -1){
        System.out.println("  您沒有一隻叫做"+ Intput_name_1 +"的小雞");
        System.out.println("  也沒有一隻叫做"+ Intput_name_2 +"的小雞");
      }
      else if(Label_1 == -1){
        System.out.println("  您沒有一隻叫做"+ Intput_name_1 +"的小雞");
      }
      else if(Label_2 == -1){
        System.out.println("  您沒有一隻叫做"+ Intput_name_2 +"的小雞");
      }
    }
    else{
      System.out.println("  小雞數量不足");
    }
  }


  //求偶
  public static void mate(String Intput_name_1,String Intput_name_2){
    if(chickenNum > 1){
      int Label_1 = -1;
      int Label_2 = -1;
      for(int i = 0; i < chickenNum; i++){
        Label_1 = Support.findName(Intput_name_1,chicken.get(i).getName(),i);
        if(Label_1 != -1){
          i = chickenNum;
        }
      }
      for(int i = 0; i < chickenNum; i++){
        Label_2 = Support.findName(Intput_name_2,chicken.get(i).getName(),i);
        if(Label_2 != -1){
          i = chickenNum;
        }
      }
      if(Label_1 != -1 && Label_2 != -1){
        //死亡與否
        if(chicken.get(Label_1).getCondition() == 0 && chicken.get(Label_2).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_1).getName() +"以及"+ chicken.get(Label_2).getName() +"已死亡");
        }
        else if(chicken.get(Label_1).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_1).getName() +"已死亡");
        }
        else if(chicken.get(Label_2).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_2).getName() +"已死亡");
        }
        else{
          chicken.mate(chicken.get(Label_1),chicken.get(Label_2));
          chicken.get(Label_1).getMessage();
          chicken.get(Label_2).getMessage();
        }
      }
      else if(Label_1 == -1 && Label_2 == -1){
        System.out.println("  您沒有一隻叫做"+ Intput_name_1 +"的小雞");
        System.out.println("  也沒有一隻叫做"+ Intput_name_2 +"的小雞");
      }
      else if(Label_1 == -1){
        System.out.println("  您沒有一隻叫做"+ Intput_name_1 +"的小雞");
      }
      else if(Label_2 == -1){
        System.out.println("  您沒有一隻叫做"+ Intput_name_2 +"的小雞");
      }
    }
    else{
      System.out.println("  小雞數量不足");
    }
  }


  //生蛋
  public static void layEgg(String Intput_name){
    if(chickenNum > 0){
      int Label = -1;
      for(int i = 0; i < chickenNum; i++){
        Label = Support.findName(Intput_name,chicken.get(i).getName(),i);
        if(Label != -1){
          i = chickenNum;
        }
      }
      if(Label != -1){
        //死亡與否
        if(chicken.get(Label).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label).getName() +"已死亡");
        }
        else{
          //是否為母雞
          if(chicken.get(Label).getGender().equals("male")){
            System.out.println("  "+ chicken.get(Label).getName() +"為公雞，無法生蛋!!!");
          }
          else{
            System.out.println("  獲得了一顆蛋!");
            egg = egg + chicken.get(Label).layEgg();
            chicken.get(Label).getMessage();
          }
        }
      }
      else{
        System.out.println("  您沒有一隻叫做"+ Intput_name +"的小雞");
      }
    }
    else{
      System.out.println("  您沒有任何一隻小雞");
    }
  }


  //工作
  public static void work(String Intput_name){
    if(chickenNum > 0){
      int Label = -1;
      for(int i = 0; i < chickenNum; i++){
        Label = Support.findName(Intput_name,chicken.get(i).getName(),i);
        if(Label != -1){
          i = chickenNum;
        }
      }
      if(Label != -1){
        //死亡與否
        if(chicken.get(Label).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label).getName() +"已死亡");
        }
        else{
          switch(chicken.get(Label).get_type()){
            case "gatherer":
              System.out.println("  食材增加:"+ chicken.get(Label).work());
              ingredient = chicken.get(Label).work(ingredient);
              System.out.println("  食材存量:" + ingredient);
              System.out.println("  食物存量:" + food);
              System.out.println("");
              chicken.get(Label).getMessage();
              break;

            case "cook":
              if(ingredient > 60){
                ingredient = ingredient - 60;
                System.out.println("  食物增加:"+ chicken.get(Label).work());
                food = chicken.get(Label).work(food);
                System.out.println("  食材存量:" + ingredient);
                System.out.println("  食物存量:" + food);
                System.out.println("");
                chicken.get(Label).getMessage();
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
                chicken.get(Label).heal(chicken.get(i));
              }
              chicken.get(Label).work();
              chicken.get(Label).getMessage();
              break;
          }
        }
      }
      else{
        System.out.println("  您沒有一隻叫做"+ Intput_name +"的小雞");
      }
    }
    else{
      System.out.println("  您沒有任何一隻小雞");
    }
  }


  //查詢
  public static void query(){
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
  public static void checkScore(){
    int now_point = 0;
    int now_totalpoint = 0;

    now_totalpoint = egg*300;

    for(int i = 0; i < chickenNum; i++){
      if(chicken.get(i).get_hp() == 100 && chicken.get(i).get_happiness() == 100){
        now_point = 1000;
      }

      else if(chicken.get(i).get_hp() >= 51 && chicken.get(i).get_happiness() > 0){
        now_point = 500;
      }

      else if(chicken.get(i).get_hp() > 0 && chicken.get(i).get_happiness() > 0){
        now_point = 100;
      }

      else if(chicken.get(i).get_hp() == 0 && chicken.get(i).get_happiness() == 0){
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
  public static void help(){
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
    System.out.println("  10.查詢分數:      checkpoint");
    System.out.println("  11.呼叫指令集:    help");
    System.out.println("  12.存檔:          save [檔名] ");
    System.out.println("  13.讀檔:          load [檔名] ");
    System.out.println("  14.結束:          exit");
  }

  //存檔
  public static void save(String filename){
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
        writer.write(chicken.get(i).get_type());
        writer.newLine();
        writer.write(Integer.toString(chicken.get(i).getCondition()));
        writer.newLine();
        writer.write(Integer.toString(chicken.get(i).get_hp()));
        writer.newLine();
        writer.write(Integer.toString(chicken.get(i).get_happiness()));
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
  public static void load(String filename){
    //清空Arraylist
    if(chickenNum != 0){
      for(int i = (chickenNum-1); i >= 0; i--){ 
        chicken.remove(i);
      }
    }

    try{
      String getName = null;
      String getGender = null;
      String get_type = null;
      int getCondition = 0;
      int get_hp = 0;
      int get_happiness = 0;

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
        get_type = reader.readLine();
        getCondition = Integer.parseInt(reader.readLine());
        get_hp = Integer.parseInt(reader.readLine());
        get_happiness = Integer.parseInt(reader.readLine());            

        switch(get_type){
          case "gatherer":
            chicken.add(new gatherer(getName, getGender, get_type));
            chicken.get(i).set_all_int(getCondition, get_hp, get_happiness);
            break;

          case "cook":
            chicken.add(new cook(getName, getGender, get_type));
            chicken.get(i).set_all_int(getCondition, get_hp, get_happiness);
            break;

          case "healer":
            chicken.add(new healer(getName, getGender, get_type));
            chicken.get(i).set_all_int(getCondition, get_hp, get_happiness);
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
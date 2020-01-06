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


  //�j�M�p��
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

  //�˹�p���O�_���`
  public boolean isAlive(Chicken Intput_chicken){
    if(Intput_chicken.getCondition() == 0){
      return false;
    }
    else{
      return true;
    }
  }

  //���ͷs�p��
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
    System.out.println(" ���@���p���ϥͤF");
    chicken.get(chickenNum).getMessage();
    chickenNum++;
  }


  //����
  public void feed(Chicken Intput_chicken){
    if(Intput_chicken.feedRequire() <= food){
      food = food - Intput_chicken.feed();
      System.out.println("  �����s�q:" + ingredient);
      System.out.println("  �����s�q:" + food);
      Intput_chicken.getMessage();
    }
    else{
        System.out.println("  �����s�q����");
    }
  }


  //���R
  public void danceWith(Chicken Intput_chicken){
    Intput_chicken.danceWith();
    Intput_chicken.getMessage();
  }


  //���\
  public void picnic(Chicken Intput_chicken){
    if(Intput_chicken.picnicRequire() < food){
      food = food - Intput_chicken.picnic();
      System.out.println("  �����s�q:" + ingredient);
      System.out.println("  �����s�q:" + food);
      Intput_chicken.getMessage();
    }
    else{
      System.out.println("  �����s�q����");
    }
  }

  //���[
  public void fight(Chicken Intput_chicken_1,Chicken Intput_chicken_2){
    Intput_chicken_1.fight(Intput_chicken_2);
    Intput_chicken_1.getMessage();
    Intput_chicken_2.getMessage();
  }

  //�D��
  public void mate(Chicken Intput_chicken_1,Chicken Intput_chicken_2){
    Chicken.mate(Intput_chicken_1,Intput_chicken_2);
    Intput_chicken_1.getMessage();
    Intput_chicken_2.getMessage();
  }


  //�ͳJ
  public void layEgg(Chicken Intput_chicken){
    //�O�_������
    if(Intput_chicken.getGender().equals("male")){
      System.out.println("  "+ Intput_chicken.getName() +"�������A�L�k�ͳJ!!!");
    }
    else{
      System.out.println("  ��o�F�@���J!");
      egg = egg + Intput_chicken.layEgg();
      Intput_chicken.getMessage();
    }
  }


  //�u�@
  public void work(Chicken Intput_chicken){
      switch(Intput_chicken.getType()){
        case "gatherer":
          System.out.println("  �����W�[:"+ Intput_chicken.work());
          ingredient = Intput_chicken.work(ingredient);
          System.out.println("  �����s�q:" + ingredient);
          System.out.println("  �����s�q:" + food);
          System.out.println("");
          Intput_chicken.getMessage();
          break;

        case "cook":
          if(ingredient > 60){
            ingredient = ingredient - 60;
            System.out.println("  �����W�[:"+ Intput_chicken.work());
            food = Intput_chicken.work(food);
            System.out.println("  �����s�q:" + ingredient);
            System.out.println("  �����s�q:" + food);
            System.out.println("");
            Intput_chicken.getMessage();
          }
          else{
            System.out.println("  �����s�q����");      
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


  //�d��
  public void query(){
    System.out.println("  �����s�q:" + ingredient);
    System.out.println("  �����s�q:" + food);
    System.out.println("");
    System.out.println("  ���J�ƶq:" + egg);
    System.out.println("");
    for(int i = 0; i <= (chickenNum-1); i++){
      chicken.get(i).getMessage();
      System.out.println("");
    }
  }


  //�d�ߤ���
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

    System.out.println("  �z�ثe�����ƬO:"+ now_totalpoint +"��");
  }


  //�I�s���O��
  public void help(){
    System.out.println(" �m���O���n");
    System.out.println("  1.���ͷs�p��:     hatch [�W�r] [�ʧO] [���O] ");
    System.out.println("  2.����:           feed [�����W�r]");
    System.out.println("  3.���R:           danceWith [�����W�r]");
    System.out.println("  4.���\:           picnic [�����W�r]");    
    System.out.println("  5.���[:           fight [�W�r A] [�W�r B]");
    System.out.println("  6.�u�@:           work [�����W�r]");
    System.out.println("  7.�D��:           mate [�W�r A] [�W�r B]");
    System.out.println("  8.�ͳJ:           layEgg [�����W�r]");
    System.out.println("  9.�d��:           query");
    System.out.println("  10.�d�ߤ���:      checkScore");
    System.out.println("  11.�I�s���O��:    help");
    System.out.println("  12.�s��:          save [�ɦW] ");
    System.out.println("  13.Ū��:          load [�ɦW] ");
    System.out.println("  14.����:          exit");
  }

  //�s��
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
      System.out.println("  �s�ɦ��\");
    }
    catch(IOException ex){
      System.out.println("  �s�ɥ���");
    }

  }

  //Ū��
  public void load(String filename){
    //�M��Arraylist
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
      System.out.println("  Ū�����\");
    }
    catch(IOException ex){
      System.out.println("  Ū������");
    }
  }
}
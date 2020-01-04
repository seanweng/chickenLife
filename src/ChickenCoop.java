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


  //���ͷs�p��
  public void hatch(String Intput_name,String Intput_gender,String Intput_type){
    if(chickenNum > 0){
      boolean judge = true;
      for(int i = 0; i < chickenNum; i++){
        judge = Support.checkName(Intput_name,chicken.get(i).getName());
        if(judge){
          System.out.println("  �m�W����");
          i = chickenNum;
        }
      }
      if(!judge){
        if(Support.checkGender(Intput_gender)){
          if(Support.checkType(Intput_type)){
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
        }
      }
    }

    else{
      if(Support.checkGender(Intput_gender)){
        if(Support.checkType(Intput_type)){
          switch(Intput_type){
            case "cook":
             chicken.add(new Cook(Intput_name, Intput_gender, Intput_type));
             break;

            case "gatherer":
             chicken.add(new Gatherer(Intput_name, Intput_gender, Intput_type));
             break;

            case "healer":
             chicken.add(new Healer(Intput_name, Intput_gender, Intput_type));
             System.out.println("sss");
             break;
          }
          System.out.println(" ���@���p���ϥͤF");
          chicken.get(chickenNum).getMessage();
          chickenNum++;
        }
      }
    }
  }


  //����
  public void feed(String Intput_name){
    if(chickenNum > 0){
      int Label = -1;
      for(int i = 0; i < chickenNum; i++){
        Label = Support.findName(Intput_name,chicken.get(i).getName(),i);
        if(Label != -1){
          i = chickenNum;
        }
      }
      if(Label != -1){
        //���`�P�_
        if(chicken.get(Label).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label).getName() +"�w���`");
        }
        if(chicken.get(Label).feedRequire() < food){
          food = food - chicken.get(Label).feed();
          System.out.println("  �����s�q:" + ingredient);
          System.out.println("  �����s�q:" + food);
          chicken.get(Label).getMessage();
        }

        else{
          System.out.println("  �����s�q����");
        }
      }
      else{
        System.out.println("  �z�S���@���s��"+ Intput_name +"���p��");
      }
    }

    else{
      System.out.println("  �z�S������@���p��");
    }
  }


  //���R
  public void danceWith(String Intput_name){
    if(chickenNum > 0){
      int Label = -1;
      for(int i = 0; i < chickenNum; i++){
        Label = Support.findName(Intput_name,chicken.get(i).getName(),i);
        if(Label != -1){
          i = chickenNum;
        }
      }
      if(Label != -1){
        //���`�P�_
        if(chicken.get(Label).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label).getName() +"�w���`");
        }
        chicken.get(Label).danceWith();
        chicken.get(Label).getMessage();
      }
      else{
        System.out.println("  �z�S���@���s��"+ Intput_name +"���p��");
      }
    }

    else{
      System.out.println("  �z�S������@���p��");
    }
  }


  //���\
  public void picnic(String Intput_name){
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
        //���`�P�_
        if(chicken.get(Label).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label).getName() +"�w���`");
        }
        else{
          if(chicken.get(Label).picnicRequire() < food){
            food = food - chicken.get(Label).picnic();
            System.out.println("  �����s�q:" + ingredient);
            System.out.println("  �����s�q:" + food);
            chicken.get(Label).getMessage();
          }
          else{
            System.out.println("  �����s�q����");
          }
        }
      }
      else{
        System.out.println("  �z�S���@���s��"+ Intput_name +"���p��");
      }
    }
    else{
      System.out.println("  �z�S������@���p��");
    }
  }

  //���[
  public void fight(String Intput_name_1,String Intput_name_2){
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
        //���`�P�_
        if(chicken.get(Label_1).getCondition() == 0 && chicken.get(Label_2).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_1).getName() +"�H��"+ chicken.get(Label_2).getName() +"�w���`");
        }
        else if(chicken.get(Label_1).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_1).getName() +"�w���`");
        }
        else if(chicken.get(Label_2).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_2).getName() +"�w���`");
        }
        else{
          chicken.get(Label_1).fight(chicken.get(Label_2));
          chicken.get(Label_1).getMessage();
          chicken.get(Label_2).getMessage();
        }
      }
      else if(Label_1 == -1 && Label_2 == -1){
        System.out.println("  �z�S���@���s��"+ Intput_name_1 +"���p��");
        System.out.println("  �]�S���@���s��"+ Intput_name_2 +"���p��");
      }
      else if(Label_1 == -1){
        System.out.println("  �z�S���@���s��"+ Intput_name_1 +"���p��");
      }
      else if(Label_2 == -1){
        System.out.println("  �z�S���@���s��"+ Intput_name_2 +"���p��");
      }
    }
    else{
      System.out.println("  �p���ƶq����");
    }
  }


  //�D��
  public void mate(String Intput_name_1,String Intput_name_2){
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
        //���`�P�_
        if(chicken.get(Label_1).getCondition() == 0 && chicken.get(Label_2).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_1).getName() +"�H��"+ chicken.get(Label_2).getName() +"�w���`");
        }
        else if(chicken.get(Label_1).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_1).getName() +"�w���`");
        }
        else if(chicken.get(Label_2).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label_2).getName() +"�w���`");
        }
        else{
          Chicken.mate(chicken.get(Label_1),chicken.get(Label_2));
          chicken.get(Label_1).getMessage();
          chicken.get(Label_2).getMessage();
        }
      }
      else if(Label_1 == -1 && Label_2 == -1){
        System.out.println("  �z�S���@���s��"+ Intput_name_1 +"���p��");
        System.out.println("  �]�S���@���s��"+ Intput_name_2 +"���p��");
      }
      else if(Label_1 == -1){
        System.out.println("  �z�S���@���s��"+ Intput_name_1 +"���p��");
      }
      else if(Label_2 == -1){
        System.out.println("  �z�S���@���s��"+ Intput_name_2 +"���p��");
      }
    }
    else{
      System.out.println("  �p���ƶq����");
    }
  }


  //�ͳJ
  public void layEgg(String Intput_name){
    if(chickenNum > 0){
      int Label = -1;
      for(int i = 0; i < chickenNum; i++){
        Label = Support.findName(Intput_name,chicken.get(i).getName(),i);
        if(Label != -1){
          i = chickenNum;
        }
      }
      if(Label != -1){
        //���`�P�_
        if(chicken.get(Label).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label).getName() +"�w���`");
        }
        else{
          //�O�_������
          if(chicken.get(Label).getGender().equals("male")){
            System.out.println("  "+ chicken.get(Label).getName() +"�������A�L�k�ͳJ!!!");
          }
          else{
            System.out.println("  ��o�F�@���J!");
            egg = egg + chicken.get(Label).layEgg();
            chicken.get(Label).getMessage();
          }
        }
      }
      else{
        System.out.println("  �z�S���@���s��"+ Intput_name +"���p��");
      }
    }
    else{
      System.out.println("  �z�S������@���p��");
    }
  }


  //�u�@
  public void work(String Intput_name){
    if(chickenNum > 0){
      int Label = -1;
      for(int i = 0; i < chickenNum; i++){
        Label = Support.findName(Intput_name,chicken.get(i).getName(),i);
        if(Label != -1){
          i = chickenNum;
        }
      }
      if(Label != -1){
        //���`�P�_
        if(chicken.get(Label).getCondition() == 0){
          System.out.println("  "+ chicken.get(Label).getName() +"�w���`");
        }
        else{
          switch(chicken.get(Label).getType()){
            case "Gatherer":
              System.out.println("  �����W�[:"+ chicken.get(Label).work());
              ingredient = chicken.get(Label).work(ingredient);
              System.out.println("  �����s�q:" + ingredient);
              System.out.println("  �����s�q:" + food);
              System.out.println("");
              chicken.get(Label).getMessage();
              break;

            case "Cook":
              if(ingredient > 60){
                ingredient = ingredient - 60;
                System.out.println("  �����W�[:"+ chicken.get(Label).work());
                food = chicken.get(Label).work(food);
                System.out.println("  �����s�q:" + ingredient);
                System.out.println("  �����s�q:" + food);
                System.out.println("");
                chicken.get(Label).getMessage();
              }
              else{
                System.out.println("  �����s�q����");      
              }
              break;

            case "Healer":
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
        System.out.println("  �z�S���@���s��"+ Intput_name +"���p��");
      }
    }
    else{
      System.out.println("  �z�S������@���p��");
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
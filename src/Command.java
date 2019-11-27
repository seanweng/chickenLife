import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import chicken.*;
public class Command
{


  static int num = 0;//�����ƶq
  static int ingredient = 100;
  static int food = 80;

  static int egg = 0;



  //���ͷs�p��
  public static void hatch(String Intput_name,String Intput_sex,String Intput_type,ArrayList<chicken> chicks)
  {
    if(num > 0)
    {
      boolean judge = true;
      for(int i = 0; i < num; i++)
      {
        judge = Support.check_name(Intput_name,chicks.get(i).get_name());
        if(judge)
        {
          System.out.println("  �m�W����");
          i = num;
        }
      }
      if(!judge)
      {
        if(Support.check_sex(Intput_sex))
        {
          if(Support.check_type(Intput_type))
          {
            switch(Intput_type)
            {
              case "cook":
               chicks.add(new cook(Intput_name, Intput_sex, Intput_type));
               break;

              case "gatherer":
               chicks.add(new gatherer(Intput_name, Intput_sex, Intput_type));
               break;

              case "healer":
               chicks.add(new healer(Intput_name, Intput_sex, Intput_type));
               break;
            }
            System.out.println(" ���@���p���ϥͤF");
            chicks.get(num).get_Message();
            num++;
          }
        }
      }
    }

    else
    {
      if(Support.check_sex(Intput_sex))
      {
        if(Support.check_type(Intput_type))
        {
          switch(Intput_type)
          {
            case "cook":
             chicks.add(new cook(Intput_name, Intput_sex, Intput_type));
             break;

            case "gatherer":
             chicks.add(new gatherer(Intput_name, Intput_sex, Intput_type));
             break;

            case "healer":
             chicks.add(new healer(Intput_name, Intput_sex, Intput_type));
             break;
          }
          System.out.println(" ���@���p���ϥͤF");
          chicks.get(num).get_Message();
          num++;
        }
      }
    }

  }


  //����
  public static void feed(String Intput_name,ArrayList<chicken> chicks)
  {
    if(num > 0)
    {
      int Label = -1;
      for(int i = 0; i < num; i++)
      {
        Label = Support.find_name(Intput_name,chicks.get(i).get_name(),i);
        if(Label != -1)
        {
          i = num;
        }
      }
      if(Label != -1)
      {
        //���`�P�_
        if(chicks.get(Label).get_condition() == 0)
        {
          System.out.println("  "+ chicks.get(Label).get_name() +"�w���`");
        }
        if(chicks.get(Label).feed_require() < food)
        {
          food = food - chicks.get(Label).feed();
          System.out.println("  �����s�q:" + ingredient);
          System.out.println("  �����s�q:" + food);
          chicks.get(Label).get_Message();
        }

        else
        {
          System.out.println("  �����s�q����");
        }
      }
      else
      {
        System.out.println("  �z�S���@���s��"+ Intput_name +"���p��");
      }
    }

    else
    {
      System.out.println("  �z�S������@���p��");
    }
  }


  //���R
  public static void danceWith(String Intput_name,ArrayList<chicken> chicks)
  {
    if(num > 0)
    {
      int Label = -1;
      for(int i = 0; i < num; i++)
      {
        Label = Support.find_name(Intput_name,chicks.get(i).get_name(),i);
        if(Label != -1)
        {
          i = num;
        }
      }
      if(Label != -1)
      {
        //���`�P�_
        if(chicks.get(Label).get_condition() == 0)
        {
          System.out.println("  "+ chicks.get(Label).get_name() +"�w���`");
        }
        chicks.get(Label).danceWith();
        chicks.get(Label).get_Message();
      }
      else
      {
        System.out.println("  �z�S���@���s��"+ Intput_name +"���p��");
      }
    }

    else
    {
      System.out.println("  �z�S������@���p��");
    }
  }


  //���\
  public static void picnic(String Intput_name,ArrayList<chicken> chicks)
  {
    if(num > 0)
    {
      int Label = -1;
      for(int i = 0; i < num; i++)
      {
        Label = Support.find_name(Intput_name,chicks.get(i).get_name(),i);
        if(Label != -1)
        {
          i = num;
        }
      }
      if(Label != -1)
      {
        //���`�P�_
        if(chicks.get(Label).get_condition() == 0)
        {
          System.out.println("  "+ chicks.get(Label).get_name() +"�w���`");
        }
        else
        {
          if(chicks.get(Label).picnic_require() < food)
          {
            food = food - chicks.get(Label).picnic();
            System.out.println("  �����s�q:" + ingredient);
            System.out.println("  �����s�q:" + food);
            chicks.get(Label).get_Message();
          }
          else
          {
            System.out.println("  �����s�q����");
          }
        }
      }
      else
      {
        System.out.println("  �z�S���@���s��"+ Intput_name +"���p��");
      }
    }
    else
    {
      System.out.println("  �z�S������@���p��");
    }
  }

  //���[
  public static void fight(String Intput_name_1,String Intput_name_2,ArrayList<chicken> chicks)
  {
    if(num > 1)
    {
      int Label_1 = -1;
      int Label_2 = -1;
      for(int i = 0; i < num; i++)
      {
        Label_1 = Support.find_name(Intput_name_1,chicks.get(i).get_name(),i);
        if(Label_1 != -1)
        {
          i = num;
        }
      }
      for(int i = 0; i < num; i++)
      {
        Label_2 = Support.find_name(Intput_name_2,chicks.get(i).get_name(),i);
        if(Label_2 != -1)
        {
          i = num;
        }
      }
      if(Label_1 != -1 && Label_2 != -1)
      {
        //���`�P�_
        if(chicks.get(Label_1).get_condition() == 0 && chicks.get(Label_2).get_condition() == 0)
        {
          System.out.println("  "+ chicks.get(Label_1).get_name() +"�H��"+ chicks.get(Label_2).get_name() +"�w���`");
        }
        else if(chicks.get(Label_1).get_condition() == 0)
        {
          System.out.println("  "+ chicks.get(Label_1).get_name() +"�w���`");
        }
        else if(chicks.get(Label_2).get_condition() == 0)
        {
          System.out.println("  "+ chicks.get(Label_2).get_name() +"�w���`");
        }
        else
        {
          chicks.get(Label_1).fight(chicks.get(Label_2));
          chicks.get(Label_1).get_Message();
          chicks.get(Label_2).get_Message();
        }
      }
      else if(Label_1 == -1 && Label_2 == -1)
      {
        System.out.println("  �z�S���@���s��"+ Intput_name_1 +"���p��");
        System.out.println("  �]�S���@���s��"+ Intput_name_2 +"���p��");
      }
      else if(Label_1 == -1)
      {
        System.out.println("  �z�S���@���s��"+ Intput_name_1 +"���p��");
      }
      else if(Label_2 == -1)
      {
        System.out.println("  �z�S���@���s��"+ Intput_name_2 +"���p��");
      }

    }
    else
    {
      System.out.println("  �p���ƶq����");
    }
  }


  //�D��
  public static void mate(String Intput_name_1,String Intput_name_2,ArrayList<chicken> chicks)
  {
    if(num > 1)
    {
      int Label_1 = -1;
      int Label_2 = -1;
      for(int i = 0; i < num; i++)
      {
        Label_1 = Support.find_name(Intput_name_1,chicks.get(i).get_name(),i);
        if(Label_1 != -1)
        {
          i = num;
        }
      }
      for(int i = 0; i < num; i++)
      {
        Label_2 = Support.find_name(Intput_name_2,chicks.get(i).get_name(),i);
        if(Label_2 != -1)
        {
          i = num;
        }
      }
      if(Label_1 != -1 && Label_2 != -1)
      {
        //���`�P�_
        if(chicks.get(Label_1).get_condition() == 0 && chicks.get(Label_2).get_condition() == 0)
        {
          System.out.println("  "+ chicks.get(Label_1).get_name() +"�H��"+ chicks.get(Label_2).get_name() +"�w���`");
        }
        else if(chicks.get(Label_1).get_condition() == 0)
        {
          System.out.println("  "+ chicks.get(Label_1).get_name() +"�w���`");
        }
        else if(chicks.get(Label_2).get_condition() == 0)
        {
          System.out.println("  "+ chicks.get(Label_2).get_name() +"�w���`");
        }
        else
        {
          chicken.mate(chicks.get(Label_1),chicks.get(Label_2));
          chicks.get(Label_1).get_Message();
          chicks.get(Label_2).get_Message();
        }
      }
      else if(Label_1 == -1 && Label_2 == -1)
      {
        System.out.println("  �z�S���@���s��"+ Intput_name_1 +"���p��");
        System.out.println("  �]�S���@���s��"+ Intput_name_2 +"���p��");
      }
      else if(Label_1 == -1)
      {
        System.out.println("  �z�S���@���s��"+ Intput_name_1 +"���p��");
      }
      else if(Label_2 == -1)
      {
        System.out.println("  �z�S���@���s��"+ Intput_name_2 +"���p��");
      }

    }
    else
    {
      System.out.println("  �p���ƶq����");
    }
  }


  //�ͳJ
  public static void layEgg(String Intput_name,ArrayList<chicken> chicks)
  {
    if(num > 0)
    {
      int Label = -1;
      for(int i = 0; i < num; i++)
      {
        Label = Support.find_name(Intput_name,chicks.get(i).get_name(),i);
        if(Label != -1)
        {
          i = num;
        }
      }
      if(Label != -1)
      {
        //���`�P�_
        if(chicks.get(Label).get_condition() == 0)
        {
          System.out.println("  "+ chicks.get(Label).get_name() +"�w���`");
        }
        else
        {
          //�O�_������
          if(chicks.get(Label).get_sex().equals("male"))
          {
            System.out.println("  "+ chicks.get(Label).get_name() +"�������A�L�k�ͳJ!!!");
          }
          else
          {
            System.out.println("  ��o�F�@���J!");
            egg = egg + chicks.get(Label).layEgg();
            chicks.get(Label).get_Message();
          }
        }
      }
      else
      {
        System.out.println("  �z�S���@���s��"+ Intput_name +"���p��");
      }
    }
    else
    {
      System.out.println("  �z�S������@���p��");
    }
  }


  //�u�@
  public static void work(String Intput_name,ArrayList<chicken> chicks)
  {
    if(num > 0)
    {
      int Label = -1;
      for(int i = 0; i < num; i++)
      {
        Label = Support.find_name(Intput_name,chicks.get(i).get_name(),i);
        if(Label != -1)
        {
          i = num;
        }
      }
      if(Label != -1)
      {
        //���`�P�_
        if(chicks.get(Label).get_condition() == 0)
        {
          System.out.println("  "+ chicks.get(Label).get_name() +"�w���`");
        }
        else
        {
          switch(chicks.get(Label).get_type())
          {
            case "gatherer":
              System.out.println("  �����W�[:"+ chicks.get(Label).work());
              ingredient = chicks.get(Label).work(ingredient);
              System.out.println("  �����s�q:" + ingredient);
              System.out.println("  �����s�q:" + food);
              System.out.println("");
              chicks.get(Label).get_Message();
              break;

            case "cook":
              if(ingredient > 60)
              {
                ingredient = ingredient - 60;
                System.out.println("  �����W�[:"+ chicks.get(Label).work());
                food = chicks.get(Label).work(food);
                System.out.println("  �����s�q:" + ingredient);
                System.out.println("  �����s�q:" + food);
                System.out.println("");
                chicks.get(Label).get_Message();
              }
              else
              {
                System.out.println("  �����s�q����");      
              }
              break;

            case "healer":
              for(int i = 0; i < num; i++)
              {
                if(i == Label)
                {
                  continue;
                }
                chicks.get(Label).heal(chicks.get(i));
              }
              chicks.get(Label).work();
              chicks.get(Label).get_Message();
              break;
          }
        }
      }
      else
      {
        System.out.println("  �z�S���@���s��"+ Intput_name +"���p��");
      }
    }
    else
    {
      System.out.println("  �z�S������@���p��");
    }
  }


  //�d��
  public static void query(ArrayList<chicken> chicks)
  {
    System.out.println("  �����s�q:" + ingredient);
    System.out.println("  �����s�q:" + food);
    System.out.println("");
    System.out.println("  ���J�ƶq:" + egg);
    System.out.println("");
    for(int i = 0; i <= (num-1); i++)
    {
      chicks.get(i).get_Message();
      System.out.println("");
    }
  }


  //�d�ߤ���
  public static void checkpoint(ArrayList<chicken> chicks)
  {
    int now_point = 0;
    int now_totalpoint = 0;

    now_totalpoint = egg*300;

    for(int i = 0; i < num; i++)
    {
      if(chicks.get(i).get_hp() == 100 && chicks.get(i).get_happiness() == 100)
      {
        now_point = 1000;
      }

      else if(chicks.get(i).get_hp() >= 51 && chicks.get(i).get_happiness() > 0)
      {
        now_point = 500;
      }

      else if(chicks.get(i).get_hp() > 0 && chicks.get(i).get_happiness() > 0)
      {
        now_point = 100;
      }

      else if(chicks.get(i).get_hp() == 0 && chicks.get(i).get_happiness() == 0)
      {
        now_point = -500;
      }

      else
      {
        now_point = 0;
      }

      now_totalpoint = now_totalpoint + now_point;
    }

    System.out.println("  �z�ثe�����ƬO:"+ now_totalpoint +"��");
  }


  //�I�s���O��
  public static void help(ArrayList<chicken> chicks)
  {
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
    System.out.println("  10.�d�ߤ���:      checkpoint");
    System.out.println("  11.�I�s���O��:    help");
    System.out.println("  12.�s��:          save [�ɦW] ");
    System.out.println("  13.Ū��:          load [�ɦW] ");
    System.out.println("  14.����:          exit");
  }

  //�s��
  public static void save(String filename,ArrayList<chicken> chicks)
  {
    try
    {
      filename = filename+ ".txt";
      File file = new File(filename);
      FileWriter file_writer = new FileWriter(file);
      BufferedWriter writer = new BufferedWriter(file_writer);

      writer.write(Integer.toString(num));
      writer.newLine();

      writer.write(Integer.toString(ingredient));
      writer.newLine();

      writer.write(Integer.toString(food));
      writer.newLine();

      writer.write(Integer.toString(egg));
      writer.newLine();

      for(int i = 0; i < num; i++)
      {            
        writer.write(chicks.get(i).get_name());
        writer.newLine();
        writer.write(chicks.get(i).get_sex());
        writer.newLine();
        writer.write(chicks.get(i).get_type());
        writer.newLine();
        writer.write(Integer.toString(chicks.get(i).get_condition()));
        writer.newLine();
        writer.write(Integer.toString(chicks.get(i).get_hp()));
        writer.newLine();
        writer.write(Integer.toString(chicks.get(i).get_happiness()));
        writer.newLine();
      }
      writer.close();
      System.out.println("  �s�ɦ��\");
    }
    catch(IOException ex)
    {
      System.out.println("  �s�ɥ���");
    }

  }

  //Ū��
  public static void load(String filename,ArrayList<chicken> chicks)
  {
    //�M��Arraylist
    if(num != 0)
    {
      for(int i = (num-1); i >= 0; i--)
      { 
        chicks.remove(i);
      }
    }

    try
    {
      String get_name = null;
      String get_sex = null;
      String get_type = null;
      int get_condition = 0;
      int get_hp = 0;
      int get_happiness = 0;

      filename = filename + ".txt";
      File file = new File(filename);
      FileReader file_reader = new FileReader(file);
      BufferedReader reader = new BufferedReader(file_reader);

      num = Integer.parseInt(reader.readLine());

      ingredient = Integer.parseInt(reader.readLine());

      food = Integer.parseInt(reader.readLine());

      egg = Integer.parseInt(reader.readLine());

      for(int i = 0; i < num; i++)
      {
        get_name = reader.readLine();
        get_sex = reader.readLine();
        get_type = reader.readLine();
        get_condition = Integer.parseInt(reader.readLine());
        get_hp = Integer.parseInt(reader.readLine());
        get_happiness = Integer.parseInt(reader.readLine());            

        switch(get_type)
        {
          case "gatherer":
            chicks.add(new gatherer(get_name, get_sex, get_type));
            chicks.get(i).set_all_int(get_condition, get_hp, get_happiness);
            break;

          case "cook":
            chicks.add(new cook(get_name, get_sex, get_type));
            chicks.get(i).set_all_int(get_condition, get_hp, get_happiness);
            break;

          case "healer":
            chicks.add(new healer(get_name, get_sex, get_type));
            chicks.get(i).set_all_int(get_condition, get_hp, get_happiness);
            break;
        }
      }
      System.out.println("  Ū�����\");
    }
    catch(IOException ex)
    {
      System.out.println("  Ū������");
    }
  }



}
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import chicken.*;

public class hw5
{
  public static void main(String[] args)
  {
    int Again = 1;

    ArrayList<chicken> chicks = new ArrayList<chicken>();
    Scanner x = new Scanner(System.in);
    String command;

    System.out.println("�����p���H�͡���");
    System.out.println("");

    System.out.println("�m���Сn");
    System.out.println(" �z�i�}�|�T�ؤ��P���p��(cook�Bgatherer�Bhealer)");
    System.out.println(" �z�L�e�̪�����");
    System.out.println(" �յۮ���̰������Ƨa!!!");
    System.out.println("");


    System.out.println("   \\\\ �C���}�l //");


    do
    {
      try
      {
        System.out.println("");
        System.out.print(" ���п�J���O:");
        command = x.nextLine();
        String [] command_split = command.split(" ");

        switch(command_split[0])
        {
          //���ͷs�p��
          case "hatch":
            //�ˬd���O����
            if(command_split.length != 4)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else
            {
              Command.hatch(command_split[1],command_split[2],command_split[3],chicks);
              break;
            }
            

          //�����p��
          case "feed":
            //�ˬd���O����
            if(command_split.length != 2)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else
            {
              Command.feed(command_split[1],chicks);
              break;
            }


          //���R
          case "danceWith":

            //�ˬd���O����
            if(command_split.length != 2)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else
            {
              Command.danceWith(command_split[1],chicks);
              break;
            }


          //���\
          case "picnic":

            //�ˬd���O����
            if(command_split.length != 2)
            {
              System.out.println("  ��J���~");
              continue;
            }

            //����
            else
            {
              Command.picnic(command_split[1],chicks);
              break;
            }

          //���[
          case "fight":

            //�ˬd���O����
            if(command_split.length != 3)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else
            {
              Command.fight(command_split[1],command_split[2],chicks);
              break;
            }



          //�D��
          case "mate":

            //�ˬd���O����
            if(command_split.length != 3)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else
            {
              Command.mate(command_split[1],command_split[2],chicks);
              break;
            }


          //�ͳJ
          case "layEgg":
            //�ˬd���O����
            if(command_split.length != 2)
            {
              System.out.println("  ��J���~");
              continue;
            }

            //����
            else
            {
              Command.layEgg(command_split[1],chicks);
              break;
            }


          //�u�@
          case "work":

            //�ˬd���O����
            if(command_split.length != 2)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else
            {
              Command.work(command_split[1],chicks);
              break;
            }


          //�d��
          case "query":

            //�ˬd���O����
            if(command_split.length != 1)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else
            {
              Command.query(chicks);
              break;
            }


          //�d�ߤ���
          case "checkpoint":

            //�ˬd���O����
            if(command_split.length != 1)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }
            //����
            else
            {
              Command.checkpoint(chicks);
              break;
            }


          //�I�s���O��
          case "help":

            //�ˬd���O����
            if(command_split.length != 1)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }
            //����
            else
            {
              Command.help(chicks);
              break;
            }


          //�s��
          case "save":

            //�ˬd���O����
            if(command_split.length != 2)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }
            //����
            else	
            {
              Command.save(command_split[1],chicks);
              break;
            }


          //Ū��
          case "load":

            //�ˬd���O����
            if(command_split.length != 2)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }
            //����
            else	
            {
              Command.load	(command_split[1],chicks);
              break;
            }


          //���}
          case "exit":

            //�ˬd���O����
            if(command_split.length != 1)
            {
              System.out.println("  ���O���׿��~");
              continue;
            }

            System.out.println("   \\\\�C������//");
            Again = 0;
            break;

          default:
            System.out.println("  ���O���~");
            break;
        }
      }

      catch(ArrayIndexOutOfBoundsException e)
      {
        System.out.println("  ���O���~");
        continue;
      }
    }while(Again == 1);

    //�������
    Command.checkpoint(chicks);

  }

}
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import chicken.*;

public class hw5{
  public static void main(String[] args){
    int again = 1;

    ChickenCoop chickenCoop = new ChickenCoop();

    ArrayList<Chicken> chicken = new ArrayList<Chicken>();
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


    do{
      try{
        System.out.println("");
        System.out.print(" ���п�J���O:");
        command = x.nextLine();
        String [] command_split = command.split(" ");

        switch(command_split[0]){
          //���ͷs�p��
          case "hatch":
            //�ˬd���O����
            if(command_split.length != 4){
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else{
              chickenCoop.hatch(command_split[1],command_split[2],command_split[3]);
              break;
            }
            

          //�����p��
          case "feed":
            //�ˬd���O����
            if(command_split.length != 2){
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else{
              chickenCoop.feed(command_split[1]);
              break;
            }


          //���R
          case "danceWith":

            //�ˬd���O����
            if(command_split.length != 2){
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else{
              chickenCoop.danceWith(command_split[1]);
              break;
            }


          //���\
          case "picnic":

            //�ˬd���O����
            if(command_split.length != 2){
              System.out.println("  ��J���~");
              continue;
            }

            //����
            else{
              chickenCoop.picnic(command_split[1]);
              break;
            }

          //���[
          case "fight":

            //�ˬd���O����
            if(command_split.length != 3){
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else{
              chickenCoop.fight(command_split[1],command_split[2]);
              break;
            }



          //�D��
          case "mate":

            //�ˬd���O����
            if(command_split.length != 3){
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else{
              chickenCoop.mate(command_split[1],command_split[2]);
              break;
            }


          //�ͳJ
          case "layEgg":
            //�ˬd���O����
            if(command_split.length != 2){
              System.out.println("  ��J���~");
              continue;
            }

            //����
            else{
              chickenCoop.layEgg(command_split[1]);
              break;
            }


          //�u�@
          case "work":

            //�ˬd���O����
            if(command_split.length != 2){
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else{
              chickenCoop.work(command_split[1]);
              break;
            }


          //�d��
          case "query":

            //�ˬd���O����
            if(command_split.length != 1){
              System.out.println("  ���O���׿��~");
              continue;
            }

            //����
            else{
              chickenCoop.query();
              break;
            }


          //�d�ߤ���
          case "checkScore":
            //�ˬd���O����
            if(command_split.length != 1){
              System.out.println("  ���O���׿��~");
              continue;
            }
            //����
            else{
              chickenCoop.checkScore();
              break;
            }


          //�I�s���O��
          case "help":
            //�ˬd���O����
            if(command_split.length != 1){
              System.out.println("  ���O���׿��~");
              continue;
            }
            //����
            else{
              chickenCoop.help();
              break;
            }


          //�s��
          case "save":
            //�ˬd���O����
            if(command_split.length != 2){
              System.out.println("  ���O���׿��~");
              continue;
            }
            //����
            else{
              chickenCoop.save(command_split[1]);
              break;
            }


          //Ū��
          case "load":
            //�ˬd���O����
            if(command_split.length != 2){
              System.out.println("  ���O���׿��~");
              continue;
            }
            //����
            else{
              chickenCoop.load(command_split[1]);
              break;
            }


          //���}
          case "exit":
            //�ˬd���O����
            if(command_split.length != 1){
              System.out.println("  ���O���׿��~");
              continue;
            }

            System.out.println("   \\\\�C������//");
            again = 0;
            break;

          default:
            System.out.println("  ���O���~");
            break;
        }
      }

      catch(ArrayIndexOutOfBoundsException e){
        System.out.println("  ���O���~");
        continue;
      }
    }while(again == 1);
    //�������
    chickenCoop.checkScore();
  }

}
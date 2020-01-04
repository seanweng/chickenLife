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

    System.out.println("★☆小雞人生☆★");
    System.out.println("");

    System.out.println("《介紹》");
    System.out.println(" 您可飼育三種不同的小雞(cook、gatherer、healer)");
    System.out.println(" 透過牠們的互動");
    System.out.println(" 試著拿到最高的分數吧!!!");
    System.out.println("");


    System.out.println("   \\\\ 遊戲開始 //");


    do{
      try{
        System.out.println("");
        System.out.print(" ☆請輸入指令:");
        command = x.nextLine();
        String [] command_split = command.split(" ");

        switch(command_split[0]){
          //產生新小雞
          case "hatch":
            //檢查指令長度
            if(command_split.length != 4){
              System.out.println("  指令長度錯誤");
              continue;
            }

            //執行
            else{
              chickenCoop.hatch(command_split[1],command_split[2],command_split[3]);
              break;
            }
            

          //餵食小雞
          case "feed":
            //檢查指令長度
            if(command_split.length != 2){
              System.out.println("  指令長度錯誤");
              continue;
            }

            //執行
            else{
              chickenCoop.feed(command_split[1]);
              break;
            }


          //跳舞
          case "danceWith":

            //檢查指令長度
            if(command_split.length != 2){
              System.out.println("  指令長度錯誤");
              continue;
            }

            //執行
            else{
              chickenCoop.danceWith(command_split[1]);
              break;
            }


          //野餐
          case "picnic":

            //檢查指令長度
            if(command_split.length != 2){
              System.out.println("  輸入錯誤");
              continue;
            }

            //執行
            else{
              chickenCoop.picnic(command_split[1]);
              break;
            }

          //打架
          case "fight":

            //檢查指令長度
            if(command_split.length != 3){
              System.out.println("  指令長度錯誤");
              continue;
            }

            //執行
            else{
              chickenCoop.fight(command_split[1],command_split[2]);
              break;
            }



          //求偶
          case "mate":

            //檢查指令長度
            if(command_split.length != 3){
              System.out.println("  指令長度錯誤");
              continue;
            }

            //執行
            else{
              chickenCoop.mate(command_split[1],command_split[2]);
              break;
            }


          //生蛋
          case "layEgg":
            //檢查指令長度
            if(command_split.length != 2){
              System.out.println("  輸入錯誤");
              continue;
            }

            //執行
            else{
              chickenCoop.layEgg(command_split[1]);
              break;
            }


          //工作
          case "work":

            //檢查指令長度
            if(command_split.length != 2){
              System.out.println("  指令長度錯誤");
              continue;
            }

            //執行
            else{
              chickenCoop.work(command_split[1]);
              break;
            }


          //查詢
          case "query":

            //檢查指令長度
            if(command_split.length != 1){
              System.out.println("  指令長度錯誤");
              continue;
            }

            //執行
            else{
              chickenCoop.query();
              break;
            }


          //查詢分數
          case "checkScore":
            //檢查指令長度
            if(command_split.length != 1){
              System.out.println("  指令長度錯誤");
              continue;
            }
            //執行
            else{
              chickenCoop.checkScore();
              break;
            }


          //呼叫指令集
          case "help":
            //檢查指令長度
            if(command_split.length != 1){
              System.out.println("  指令長度錯誤");
              continue;
            }
            //執行
            else{
              chickenCoop.help();
              break;
            }


          //存檔
          case "save":
            //檢查指令長度
            if(command_split.length != 2){
              System.out.println("  指令長度錯誤");
              continue;
            }
            //執行
            else{
              chickenCoop.save(command_split[1]);
              break;
            }


          //讀檔
          case "load":
            //檢查指令長度
            if(command_split.length != 2){
              System.out.println("  指令長度錯誤");
              continue;
            }
            //執行
            else{
              chickenCoop.load(command_split[1]);
              break;
            }


          //離開
          case "exit":
            //檢查指令長度
            if(command_split.length != 1){
              System.out.println("  指令長度錯誤");
              continue;
            }

            System.out.println("   \\\\遊戲結束//");
            again = 0;
            break;

          default:
            System.out.println("  指令錯誤");
            break;
        }
      }

      catch(ArrayIndexOutOfBoundsException e){
        System.out.println("  指令錯誤");
        continue;
      }
    }while(again == 1);
    //結算分數
    chickenCoop.checkScore();
  }

}
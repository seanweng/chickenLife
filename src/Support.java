public class Support
{

  //檢查姓名
  public static boolean check_name(String Intput_name,String Key_name)
  {
    if(Intput_name.equals(Key_name))
    {
      return true;
    }
    else
    {
      return false;
    }
  }


  //檢查性別
  public static boolean check_sex(String Intput_sex)
  {
    if(!Intput_sex.equals("male") && !Intput_sex.equals("female"))
    {
      System.out.println("  性別輸入錯誤");
      return false;
    }
    else
    {
      return true;
    }
  }


  //檢查類別
  public static boolean check_type(String Intput_type)
  {
    if(!Intput_type.equals("gatherer") && !Intput_type.equals("cook") && !Intput_type.equals("healer"))
    {
      System.out.println("  類型輸入錯誤");
      return false;
    }
    else
    {
      return true;
    }
  }


  //尋找相同姓名
  public static int find_name(String Intput_name,String Key_name,int Label)
  {
    if(check_name(Intput_name,Key_name))
    {
      return Label;
    }
    else
    {
      return -1;
    }
  }



}
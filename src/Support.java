public class Support
{

  //�ˬd�m�W
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


  //�ˬd�ʧO
  public static boolean check_sex(String Intput_sex)
  {
    if(!Intput_sex.equals("male") && !Intput_sex.equals("female"))
    {
      System.out.println("  �ʧO��J���~");
      return false;
    }
    else
    {
      return true;
    }
  }


  //�ˬd���O
  public static boolean check_type(String Intput_type)
  {
    if(!Intput_type.equals("gatherer") && !Intput_type.equals("cook") && !Intput_type.equals("healer"))
    {
      System.out.println("  ������J���~");
      return false;
    }
    else
    {
      return true;
    }
  }


  //�M��ۦP�m�W
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
public class CommandProcessor{
	private String [] Input_command;
	private String commandType;
	private int commandLength;
	private ChickenCoop chickenCoop = new ChickenCoop();
	private Invoker invoker = new Invoker();

	public Process(String Input_command){
		this.Input_command = Input_command.split(" ");
		this.commandType = command_split[0];
		this.commandLength = commandLength;
	}
	public boolean CreateCommand(){
		switch(commandType){
			//產生新小雞
			case "hatch":
			//檢查指令長度
			if(commandLength != 4){
				System.out.println("  指令長度錯誤");
				return false;
			}
			else{
				Hatch hatch = new Hatch(chickenCoop);
				hatch.setCommand(Input_command[1],Input_command[2],Input_command[3])
				if(hatch.Check()){
					invoker.addCommand(hatch);
					invoker.execute();
					return true;
				}
				else{
					return false;
				}				
			}

			//餵食小雞
			case "feed":
			//檢查指令長度
			if(commandLength != 2){
				System.out.println("  指令長度錯誤");
				return false;
			}
			//執行
			else{
				invoker.addCommand(new Feed);
				invoker.execute();
				return true;
			}


			//跳舞
			case "danceWith":

			//檢查指令長度
			if(commandLength != 2){
				System.out.println("  指令長度錯誤");
				return false;
			}
			//執行
			else{
				invoker.addCommand(new DanceWith);
				invoker.execute();
				return true;
			}


			//野餐
			case "picnic":

			//檢查指令長度
			if(commandLength != 2){
				System.out.println("  輸入錯誤");
				return false;
			}
			//執行
			else{
				invoker.addCommand(new Picnic);
				invoker.execute();
				return true;
			}

			//打架
			case "fight":

			//檢查指令長度
			if(commandLength != 3){
				System.out.println("  指令長度錯誤");
				return false;
			}

			//執行
			else{
				invoker.addCommand(new Fight);
				invoker.execute();
				return true;
			}



			//求偶
			case "mate":

			//檢查指令長度
			if(commandLength != 3){
				System.out.println("  指令長度錯誤");
				return false;
			}

			//執行
			else{
				invoker.addCommand(new Mate);
				invoker.execute();
				return true;
			}


			//生蛋
			case "layEgg":
			//檢查指令長度
			if(commandLength != 2){
				System.out.println("  輸入錯誤");
				return false;
			}
			//執行
			else{
				invoker.addCommand(new LayEgg);
				invoker.execute();
				return true;
			}


			//工作
			case "work":

			//檢查指令長度
			if(commandLength != 2){
				System.out.println("  指令長度錯誤");
				return false;
			}
			//執行
			else{
				invoker.addCommand(new Work);
				invoker.execute();
				return true;
			}


			//查詢
			case "query":

			//檢查指令長度
			if(commandLength != 1){
				System.out.println("  指令長度錯誤");
				return false;
			}

			//執行
			else{
				invoker.addCommand(new Query);
				invoker.execute();
				return true;
			}


			//查詢分數
			case "checkScore":
			//檢查指令長度
			if(commandLength != 1){
				System.out.println("  指令長度錯誤");
				return false;
			}
			//執行
			else{
				invoker.addCommand(new CheckScore);
				invoker.execute();
				return true;
			}


			//呼叫指令集
			case "help":
			//檢查指令長度
			if(commandLength != 1){
				System.out.println("  指令長度錯誤");
				return false;
			}
			//執行
			else{
				invoker.addCommand(new Help);
				invoker.execute();
				return true;
			}


			//存檔
			case "save":
			//檢查指令長度
			if(commandLength != 2){
				System.out.println("  指令長度錯誤");
				return false;
			}
			//執行
			else{
				invoker.addCommand(new Save);
				invoker.execute();
				return true;
			}


			//讀檔
			case "load":
			//檢查指令長度
			if(commandLength != 2){
				System.out.println("  指令長度錯誤");
				return false;
			}
			//執行
			else{
				invoker.addCommand(new Load);
				invoker.execute();
				return true;
			}


			//離開
			case "exit":
			//檢查指令長度
			if(commandLength != 1){
				System.out.println("  指令長度錯誤");
				return false;
			}
			else{
				System.out.println("   \\\\遊戲結束//");
				return true;
			}
			default:
			System.out.println("  指令錯誤");
			return false;
		}
	}
	
}
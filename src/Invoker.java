import java.util.ArrayList;

public class Invoker{
	private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command){
        commandList.add(command);
    }

    public void deleteCommand(Command command) {
        commandList.remove(command);
    }

    public void execute(){
    	command.execute();
    }
	
}
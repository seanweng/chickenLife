public class Feed extends Command{
	Chicken chicken;

	public Feed(ChickenCoop chickenCoop){
		this.chickenCoop = chickenCoop;
	}
	public void setCommand(String name){
		this.chicken = chickenCoop.findChicken(name);
	}
	public boolean Check(){
		if(chicken != null){
			if(chickenCoop.isAlive(chicken)){
				return true;
			}
		}
		return false;
	}
    public void execute(){
    	chickenCoop.feed(chicken);
    }
}
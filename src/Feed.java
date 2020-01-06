public class Feed extends Command{
	Chicken chicken;

	public Hatch(ChickenCoop chickenCoop){
		this.chickenCoop = chickenCoop;
	}
	public void setCommand(String name){
		this.chicken = chickenCoop.findChicken(name);
	}
	public boolean Check(){
		if(chickenCoop.findChicken(name) != null){
			if(chickenCoop.isAlive(chicken)){
				return true;
			}
		}
		return false;
	}
    public void execute(){
    	chickenCoop.feed();
    }
}
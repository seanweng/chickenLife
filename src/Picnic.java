public class Picnic extends Command{
	Chicken chicken;

	public Picnic(ChickenCoop chickenCoop){
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
    	chickenCoop.picnic(chicken);
    }
}
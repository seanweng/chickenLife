public class Fight extends Command{
	Chicken chicken_1;
	Chicken chicken_2;

	public Fight(ChickenCoop chickenCoop){
		this.chickenCoop = chickenCoop;
	}
	public void setCommand(String name_1,String name_2){
		this.chicken = chickenCoop.findChicken(name_1);
		this.chicken = chickenCoop.findChicken(name_2);
	}
	public boolean Check(){
		if(chicken_1 == chicken_2){
			return false;
		}
		if(chicken_1 != null && chicken_2 != null){
			if(chickenCoop.isAlive(chicken_1) && chickenCoop.isAlive(chicken_2)){
				return true;
			}
		}
		return false;
	}
    public void execute(){
    	chickenCoop.fight(chicken_1,chicken_2);
    }
}
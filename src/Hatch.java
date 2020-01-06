public class Hatch extends Command{
	private String name;
	private String gender;
	private String type;

	public Hatch(ChickenCoop chickenCoop){
		this.chickenCoop = chickenCoop;
	}
	public void setCommand(String name,String gender,String type){
		this.name = name;
		this.gender = gender;
		this.type = type;
	}
	public boolean Check(){
		if(chickenCoop.findChicken(name) == null){
			if(Support.checkGender(gender) && Support.checkType(type)){
				return true;
			}
		}
		return false;
	}
    public void execute(){
    	chickenCoop.hatch(name,gender,type);
    }
}
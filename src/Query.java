public class Query extends Command{

	public Query(ChickenCoop chickenCoop){
		this.chickenCoop = chickenCoop;
	}

    public void execute(){
    	chickenCoop.query();
    }
}
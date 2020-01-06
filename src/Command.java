public abstract class Command{
	ChickenCoop chickenCoop;

	public Command(ChickenCoop chickenCoop){
		this.chickenCoop = chickenCoop;
	}

    public abstract void execute();
}
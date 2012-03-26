public class Alpha
{
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		Resource res = new Resource();
		GameState stat = new GameState();
		stat.init();
		Collision col = new Collision(stat);
		stat.addMe(col);
		Control con = new Control(stat);
	}
}
public class Alpha
{
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		GameState stat = new GameState();
		stat.init();
		Control con = new Control(stat);
	}
}
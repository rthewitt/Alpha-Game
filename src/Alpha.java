public class Alpha
{
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		Resource res = new Resource();
		GameState state = new GameState();
		state.init();
		Collision col = new Collision(state);
		state.addMe(col);
		Control con = new Control(state);
	}
}
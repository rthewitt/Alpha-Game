public class Alpha
{
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		Resource.init(); // this should not have been an object
		Stats stat = new Stats();
		stat.init();
		Control con = new Control(stat);
	}
}
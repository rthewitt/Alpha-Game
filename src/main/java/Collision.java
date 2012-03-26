import java.util.Vector;

public class Collision extends Thread
{
	private Vector<Scout> ships = new Vector<Scout>();
	
	private int X = 0;
	private int Y = 0;
	@SuppressWarnings("unused")
	private GameState state;
	@SuppressWarnings("unused")
	private Beam beam;
	private boolean Running = true;
	
	Collision(GameState s)
	{
		state = s;
	}
	
	public void addShip(Scout s)
	{
		ships.addElement(s);
	}
	
	public void TestBeam(Beam b)
	{
		if(Running)
		{
			beam = b;
			X = b.getX();
			Y = b.getY();
			Running = false;
			run();
		}
	}
	
	public void run()
	{
		boolean True = false;
		for(int i = 0; i < ships.size(); i++)
		{
			int ShipX = ships.elementAt(i).getX();
			int ShipY = ships.elementAt(i).getY();
			
			if(X >= ShipX && X <= (ShipX + 30))
			{
				True = true;
			}
			
			if(True)
			{
				if(Y >= (ShipY - 30) && Y <= ShipY)
				{
					ships.elementAt(i).kill();
					ships.remove(i);
				}
			}
		}
		Running = true;
	}
}
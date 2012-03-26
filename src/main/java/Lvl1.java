
import java.util.Timer;
import java.util.TimerTask;

public class Lvl1
{
	private Timer timer;
	private int Sprites = 10;
	private int Width, Height;
	private Game game;
	private GameState stat;
	
	Lvl1(int x, int y, Game g, GameState s)
	{
		Width = x;
		Height = y;
		game = g;
		stat = s;
		stat.setEnemies(Sprites);
   	timer = new Timer();
		timer.schedule(new Task(), 3000, 1000);
	}
	
	private class Task extends TimerTask
	{
		public void run()
		{
			if(Sprites > 0)
			{
				Scout s = new Scout(Width, Height, game, stat, 1);
				game.Scouts.addElement(s);
				s.start();
				Sprites --;
			}
		}
	}
}
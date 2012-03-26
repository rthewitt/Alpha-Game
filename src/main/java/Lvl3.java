
import java.util.Timer;
import java.util.TimerTask;

public class Lvl3
{
	private Timer timer;
	private int Sprites = 27;
	private int S = 17;
	private int Width, Height;
	private Game game;
	private GameState state;
	private int Mod1 = 190;
	private int Mod2 = 280;
	private int Type = 1;
	
	Lvl3(int x, int y, Game g, GameState s)
	{
		Width = x;
		Height = y;
		game = g;
		state = s;
		state.setEnemies(Sprites);
		timer = new Timer();
		timer.schedule(new Task(), 1000, 1000);
	}
	
	private class Task extends TimerTask
	{	
		public void run()
		{
			switch(S)
			{
				case 21: S = 15; Type = 2; Mod1 = 190; Mod2 = 280; break;
				
				case 15: S = 9; Type = 1; Mod1 = 190; Mod2 = 280; break;
				
				case 9: S = 3; Type = 2; Mod1 = 190; Mod2 = 280; break;
				
				case 3: S = 0; Type = 3; Mod1 = 190; Mod2 = 280; break;
			}
			
			if(Sprites > S)
			{
				Scout s = new Scout(Width, Height, game, state, Type);
				s.setPosition(Mod1);
				game.Scouts.addElement(s);
				s.start();
				
				Scout s2 = new Scout(Width, Height, game, state, Type);
				s2.setPosition(Mod2);
				game.Scouts.addElement(s2);
				s2.start();
				
				Sprites --;
			}
			Mod1 -= 30;
			Mod2 += 30;
		}
	}
}
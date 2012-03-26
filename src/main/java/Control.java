
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Control extends JFrame
{
	private static final long serialVersionUID = 1L;
	private Menu Menu;
	private Game game;
	private UpgradeMenu Up;
	private int Width = 500, Height = 800;
	private GameState stat;
	
	Control(GameState s)
	{
		stat = s;
		
		this.setIconImage(Resource.ICON);
		
		setSize(Width, Height);
		setVisible(true);
		setResizable(false);
		setTitle("Alpha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		stat.addMe(this);
		
		RunMenu(0);
	}
	
	void RunMenu(int con)
	{
		if(con != 0)
		{
			nullIt(con);
		}
		Menu = new Menu(Width, Height, this);
		add(Menu, BorderLayout.CENTER);
	}
	
	void RunGame(int con)
	{
		if(con != 0)
		{
			nullIt(con);
		}
		game = new Game(Width, Height, this, stat);
		add(game, BorderLayout.CENTER);
	}
	
	void RunUpgrade(int con)
	{
		if(con != 0)
		{
			nullIt(con);
		}
		Up = new UpgradeMenu(Width, Height, this, stat);
		add(Up, BorderLayout.CENTER);
	}
	
	void nullIt(int con)
	{
		switch(con)
		{
			case 1: Menu = null; break;
			
			case 2: remove(game); game = null; break;
			
			case 3: remove(Up); Up = null; break;
		}
		System.gc();
	}
}
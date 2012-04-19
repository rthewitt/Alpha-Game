import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Vector;

public class Star extends Thread
	{
		private Vector<Ellipse2D> elipse = new Vector<Ellipse2D>();
		private Vector<Integer> StartX = new Vector<Integer>();
		private Vector<Integer> StartY = new Vector<Integer>();
		private Vector<Integer> size = new Vector<Integer>();
		private Vector<Integer> dir = new Vector<Integer>();
		
		private boolean ballStarted;
		private int Width, Height;
		private int arraySize;
		
		private Menu Menu;
		private Game gamePanel;
		private UpgradeMenu Up;
		
		public Star(int x, int y, Menu menu)
		{
			Menu = menu;
			Width = x;
			Height = y;
		}
		
		public Star(int x, int y, Game g)
		{
			gamePanel = g;
			Width = x;
			Height = y;
		}
		
		public Star(int x, int y, UpgradeMenu u)
		{
			Up = u;
			Width = x;
			Height = y;
		}
		
		public Star(int x, int y, NestedPanel np)
		{
			Width = x;
			Height = y;
		}
		
		public void setNumber(int s)
		{
			arraySize = s;
			init();
		}
		
		private void init()
		{
			for(int i = 0; i < arraySize; i++)
			{
				size.addElement(1 + (int)(Math.random() * 5));
				dir.addElement(1 + (int)(Math.random() * size.elementAt(i)));
				StartX.addElement((int)(Math.random() * Width));
				StartY.addElement((int)(Math.random() * Height));
				
				elipse.addElement(new Ellipse2D.Double(StartX.elementAt(i), StartY.elementAt(i), size.elementAt(i), size.elementAt(i)));
			}
			ballStarted = true;
		}
		
		public void draw(Graphics2D g2d)
		{
			g2d.setColor(Color.WHITE);
			
			for(int i = 0; i < arraySize; i++)
			{	
				g2d.fill(elipse.elementAt(i));
			}
		}
		
		public void run()
		{
			while(ballStarted)
			{
				try
				{
					Thread.sleep(7);
            	}
				catch (InterruptedException e)
				{
					System.out.println("Woke up prematurely");
				}
				
				for(int i = 0; i < arraySize; i++)
				{
					int OldY = (int) elipse.elementAt(i).getY();
					StartY.set(i, OldY + dir.elementAt(i));
					
					try
					{
						if (StartY.elementAt(i) > Height)
						{
							StartY.set(i, 0);
							StartX.set(i, (int)(Math.random() * Width));
						}
					}
					catch(NullPointerException e)
					{
					}
				      
					elipse.elementAt(i).setFrame(StartX.elementAt(i), StartY.elementAt(i), size.elementAt(i), size.elementAt(i));
				
					try
					{
						Menu.repaint();
					}
					catch(NullPointerException e)
					{
					}
				
					try	
					{
						gamePanel.repaint();
					}
					catch(NullPointerException e)
					{
					}
					
					try
					{
						Up.repaint();
					}
					catch(NullPointerException e)
					{
					}
				}
			}
		}
	}
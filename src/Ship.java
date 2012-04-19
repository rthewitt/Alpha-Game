import java.awt.Graphics2D;
import java.awt.Image;

public class Ship extends Thread
{
	private boolean ShipStarted =	true;
	private Image img;
	private Game gamePanel;
	
	public Ship(Game g, int ship, boolean hull)
	{
		gamePanel = g;
		img = Resource.currentShip;
	}

	public void	draw(Graphics2D g2d)
	{
		if(ShipStarted)
		{
			g2d.drawImage(img, gamePanel.getLocX() - 15, gamePanel.getLocY(), null);
		}
	}
}
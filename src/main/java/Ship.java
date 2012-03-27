
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Ship extends Thread
{
	private boolean ShipStarted =	true;
	private BufferedImage img;
	private Game gamePanel;
	
	public Ship(Game g, int ship, boolean hull)
	{
		gamePanel = g;
		
		if(ship == 1)
		{
			if(hull)
			{
				img = Resource.smallGreenArmor;
			}
			else
			{
				img = Resource.smallGreen;
			}
		}
		else if(ship == 2)
		{
			if(hull)
			{
				img = Resource.medGreenArmor;
			}
			else
			{
				img = Resource.medGreenArmor;
			}
		}
		else
		{
			if(hull)
			{
				img = Resource.largeGreenArmor;
			}
			else
			{
				img = Resource.largeGreen;
			}
		}
		 Resource.currentShip = Toolkit.getDefaultToolkit().createImage(img.getSource());
	}

	public void	draw(Graphics2D g2d)
	{
		if(ShipStarted)
		{
			g2d.drawImage(img, gamePanel.getLocX() - 15, gamePanel.getLocY(), null);
		}
	}
}
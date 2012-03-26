
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Ship extends Thread
{
	private boolean ShipStarted =	true;
	private BufferedImage img;
	private Game gamePanel;
	private Stats stat;
	@SuppressWarnings("unused")
	
	public Ship(Game g, int ship, boolean hull, Stats s)
	{
		gamePanel = g;
		stat = s;
		
		if(ship == 1)
		{
			if(hull)
			{
				img = Resource.getSmallGreenArmor();
			}
			else
			{
				img = Resource.getSmallGreen();
			}
		}
		else if(ship == 2)
		{
			if(hull)
			{
				img = Resource.getMedGreenArmor();
			}
			else
			{
				img = Resource.getMedGreen();
			}
		}
		else
		{
			if(hull)
			{
				img = Resource.getLargeGreenArmor();
			}
			else
			{
				img = Resource.getLargeGreen();
			}
		}
	}

	public void	draw(Graphics2D g2d)
	{
		if(ShipStarted)
		{
			g2d.drawImage(img, gamePanel.getLocX() - 15, gamePanel.getLocY(), null);
		}
	}
}
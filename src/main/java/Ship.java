
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Ship extends Thread
{
	private boolean ShipStarted =	true;
	private BufferedImage img;
	private Game gamePanel;
	
	public Ship(Game g, int ship, boolean hull)
	{
		gamePanel = g;
		
		if(hull)
		{
			switch(ship)
			{
				case 1: img = Resource.smallGreenArmor; break;
				
				case 2: img = Resource.medGreenArmor; break;
				
				case 3: img = Resource.largeGreenArmor; break;
			}
		}
		else
		{
			switch(ship)
			{
				case 1: img = Resource.smallGreen;
					Resource.hullShip = new ImageIcon(Resource.smallGreenArmor);
					Resource.nextShip = new ImageIcon(Resource.medGreen); break;
				
				case 2: img = Resource.medGreen;
					Resource.hullShip = new ImageIcon(Resource.medGreenArmor);
					Resource.nextShip = new ImageIcon((Image) Resource.largeGreen.getSource()); break;
				
				case 3: img = Resource.largeGreen;
					Resource.hullShip = new ImageIcon(Resource.largeGreenArmor); break;
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
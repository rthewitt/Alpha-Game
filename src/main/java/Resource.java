import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Resource
{
	
	File dir = new File(".");
	private static final String sep = System.getProperty("file.separator");
	
	private static BufferedImage smallGreen;
	private static BufferedImage smallGreenArmor;
	private static BufferedImage medGreen;
	private static BufferedImage medGreenArmor;
	private static BufferedImage largeGreen;
	private static BufferedImage largeGreenArmor;
	private static BufferedImage smallRed;
	private static BufferedImage smallRedArmor;
	private static BufferedImage medRed;
	private static BufferedImage medRedArmor;
	private static BufferedImage largeRed;
	private static BufferedImage largeRedArmor;
	private static BufferedImage smallBlue;
	private static BufferedImage smallBlueArmor;
	private static BufferedImage medBlue;
	private static BufferedImage medBlueArmor;
	private static BufferedImage largeBlue;
	private static BufferedImage largeBlueArmor;
	private static BufferedImage redFighter;
	//private static BufferedImage redHeavy;
	private static BufferedImage blueFighter;
	private static BufferedImage blueHeavy;

	private static Image icon;
	
	public static void init()
	{
		try
		{
			smallGreen = ImageIO.read(Resource.class.getResource("images" + sep + "smallGreen.png"));
			smallGreenArmor = ImageIO.read(Resource.class.getResource("images" + sep + "smallGreenArmor.png"));
			medGreen = ImageIO.read(Resource.class.getResource("images" + sep + "medGreen.png"));
			medGreenArmor = ImageIO.read(Resource.class.getResource("images" + sep + "medGreenArmor.png"));
			largeGreen = ImageIO.read(Resource.class.getResource("images" + sep + "largeGreen.png"));
			largeGreenArmor = ImageIO.read(Resource.class.getResource("images" + sep + "largeGreenArmor.png"));
			largeRed = ImageIO.read(Resource.class.getResource("images" + sep + "largeRed.png"));
			largeRedArmor = ImageIO.read(Resource.class.getResource("images" + sep + "largeRedArmor.png"));
			redFighter = ImageIO.read(Resource.class.getResource("images" + sep + "redFighter.png"));
			blueFighter = ImageIO.read(Resource.class.getResource("images" + sep + "blueFighter.png"));
			blueHeavy = ImageIO.read(Resource.class.getResource("images" + sep + "BlueHeavy.png"));
			icon = ImageIO.read(Resource.class.getResource("images" + sep + "Icon.png"));
			
			/*
			smallGreen = ImageIO.read(new File("images" + sep + "smallGreen.png"));
			smallGreenArmor = ImageIO.read(new File("images" + sep + "smallGreenArmor.png"));
			medGreen = ImageIO.read(new File("images" + sep + "medGreen.png"));
			medGreenArmor = ImageIO.read(new File("images" + sep + "medGreenArmor.png"));
			largeGreen = ImageIO.read(new File("images" + sep + "largeGreen.png"));
			largeGreenArmor = ImageIO.read(new File("images" + sep + "largeGreenArmor.png"));
			largeRed = ImageIO.read(new File("images" + sep + "largeRed.png"));
			largeRedArmor = ImageIO.read(new File("images" + sep + "largeRedArmor.png"));
			redFighter = ImageIO.read(new File("images" + sep + "redFighter.png"));
			blueFighter = ImageIO.read(new File("images" + sep + "blueFighter.png"));
			blueHeavy = ImageIO.read(new File("images" + sep + "BlueHeavy.png"));
			icon = ImageIO.read(new File("images" + sep + "Icon.png"));  // was a Microsoft compressed format
			*/
		}
		catch(IOException e)
		{
//			System.out.println("Cannot find ship");
			e.printStackTrace();
		}
	}
	
	public static BufferedImage getSmallGreen()
	{
		//currentShip = smallGreen;
		return smallGreen;
	}
	
	public static BufferedImage getSmallGreenArmor()
	{
		//currentShip = smallGreenArmor;
		return smallGreenArmor;
	}
	
	public static BufferedImage getMedGreen()
	{
		//currentShip = medGreen;
		return medGreen;
	}
	
	public static BufferedImage getMedGreenArmor()
	{
		//currentShip = medGreenArmor;
		return medGreenArmor;
	}
	
	public static BufferedImage getLargeGreen()
	{
		//currentShip = largeGreen;
		return largeGreen;
	}
	
	public static BufferedImage getLargeGreenArmor()
	{
		//currentShip = largeGreenArmor;
		return largeGreenArmor;
	}
	
	public static BufferedImage getSmallRed()
	{
		return smallRed;
	}
	
	public static BufferedImage getSmallRedArmor()
	{
		return smallRedArmor;
	}
	
	public static BufferedImage getMedRed()
	{
		return medRed;
	}
	
	public static BufferedImage getMedRedArmor()
	{
		return medRedArmor;
	}
	
	public static BufferedImage getLargeRed()
	{
		return largeRed;
	}
	
	public static BufferedImage getLargeRedArmor()
	{
		return largeRedArmor;
	}
	
	public static BufferedImage getSmallBlue()
	{
		return smallBlue;
	}
	
	public static BufferedImage getSmallBlueArmor()
	{
		return smallBlueArmor;
	}
	
	public static BufferedImage getMedBlue()
	{
		return medBlue;
	}
	
	public static BufferedImage getMedBlueArmor()
	{
		return medBlueArmor;
	}
	
	public static BufferedImage getLargeBlue()
	{
		return largeBlue;
	}
	
	public static BufferedImage getLargeBlueArmor()
	{
		return largeBlueArmor;
	}
	
	public static BufferedImage getRedFighter()
	{
		return redFighter;
	}
/*	
	public static BufferedImage getRedHeavy()
	{
		return redHeavy;
	}
*/
	
	public static BufferedImage getBlueFighter()
	{
		return blueFighter;
	}
	
	public static BufferedImage getBlueHeavy()
	{
		return blueHeavy;
	}
	/* PLEASE GOD NO
	public ImageIcon getCurrentShip()
	{
		ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(currentShip.getSource()));
		return icon;
	} */

	public static Image getIcon()
	{
		return icon;
	}
}

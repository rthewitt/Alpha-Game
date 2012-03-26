import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Resource
{
	
	public static final String sep = System.getProperty("file.separator");
	
	public static BufferedImage smallGreen;
	public static BufferedImage smallGreenArmor;
	public static BufferedImage medGreen;
	public static BufferedImage medGreenArmor;
	public static BufferedImage largeGreen;
	public static BufferedImage largeGreenArmor;
	public static BufferedImage smallRed;
	public static BufferedImage smallRedArmor;
	public static BufferedImage medRed;
	public static BufferedImage medRedArmor;
	public static BufferedImage largeRed;
	public static BufferedImage largeRedArmor;
	public static BufferedImage smallBlue;
	public static BufferedImage smallBlueArmor;
	public static BufferedImage medBlue;
	public static BufferedImage medBlueArmor;
	public static BufferedImage largeBlue;
	public static BufferedImage largeBlueArmor;
	public static BufferedImage redFighter;
	public static BufferedImage redHeavy;
	public static BufferedImage blueFighter;
	public static BufferedImage blueHeavy;
	
	public static ImageIcon dualLaser;
	
	Resource()
	{
		
	}
	
	static
	{
		try
		{
			smallGreen = ImageIO.read(Resource.class.getResource("images" + sep + "smallGreen.png"));
			smallGreenArmor = ImageIO.read(Resource.class.getResource("images" + sep + "smallGreenArmor.png"));
			medGreen = ImageIO.read(Resource.class.getResource("images" + sep + "medGreen.png"));
			medGreenArmor = ImageIO.read(Resource.class.getResource("images" + sep + "medGreenArmor.png"));
			largeGreen = ImageIO.read(Resource.class.getResource("images" + sep + "largeGreen.png"));
			largeGreenArmor = ImageIO.read(new File("images" + sep + "largeGreenArmor.png"));
			smallRed = ImageIO.read(Resource.class.getResource("images" + sep + "smallRed.png"));
			smallRedArmor = ImageIO.read(Resource.class.getResource("images" + sep + "smallRedArmor.png"));
			medRed = ImageIO.read(Resource.class.getResource("images" + sep + "medRed.png"));
			medRedArmor = ImageIO.read(Resource.class.getResource("images" + sep + "medRedArmor.png"));
			largeRed = ImageIO.read(Resource.class.getResource("images" + sep + "largeRed.png"));
			largeRedArmor = ImageIO.read(Resource.class.getResource("images" + sep + "largeRedArmor.png"));
			smallBlue = ImageIO.read(Resource.class.getResource("images" + sep + "smallBlue.png"));
			smallBlueArmor = ImageIO.read(Resource.class.getResource("images" + sep + "smallBlueArmor.png"));
			medBlue = ImageIO.read(Resource.class.getResource("images" + sep + "medBlue.png"));
			medBlueArmor = ImageIO.read(Resource.class.getResource("images" + sep + "medBlueArmor.png"));
			largeBlue = ImageIO.read(Resource.class.getResource("images" + sep + "largeBlue.png"));
			largeBlueArmor = ImageIO.read(Resource.class.getResource("images" + sep + "largeBlueArmor.png"));
			redFighter = ImageIO.read(Resource.class.getResource("images" + sep + "redFighter.png"));
//			redHeavy = ImageIO.read(Resource.class.getResource("images" + sep + "RedHeavy.png"));
			blueFighter = ImageIO.read(Resource.class.getResource("images" + sep + "blueFighter.png"));
			blueHeavy = ImageIO.read(Resource.class.getResource("images" + sep + "BlueHeavy.png"));
			
//	        dualLaser = new ImageIcon(Resource.class.getResource("images" + sep + "menuDual.png"));
//	        dualLaser = new ImageIcon(Resource.class.getResource("images" + sep + "menuSpread.png"));
//	        dualLaser = new ImageIcon(Resource.class.getResource("images" + sep + "menuRapid.png"));
		}
		catch(IOException e)
		{
			System.out.println("Cannot find ship");
		}
	}
}

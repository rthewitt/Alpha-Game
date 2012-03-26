import java.awt.Image;
import java.awt.Toolkit;
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
	public static BufferedImage RED_FIGHTER;
	public static BufferedImage redHeavy;
	public static BufferedImage blueFighter;
	public static BufferedImage blueHeavy;
	
	public static Image ICON;
	
	static {
		
		try {
			smallGreen = ImageIO.read(Resource.class.getResource("images" + sep + "smallGreen.png"));
			smallGreenArmor = ImageIO.read(Resource.class.getResource("images" + sep + "smallGreenArmor.png"));
			medGreen = ImageIO.read(Resource.class.getResource("images" + sep + "medGreen.png"));
			medGreenArmor = ImageIO.read(Resource.class.getResource("images" + sep + "medGreenArmor.png"));
			largeGreen = ImageIO.read(Resource.class.getResource("images" + sep + "largeGreen.png"));
			largeGreenArmor = ImageIO.read(Resource.class.getResource("images" + sep + "largeGreenArmor.png"));
			largeRed = ImageIO.read(Resource.class.getResource("images" + sep + "largeRed.png"));
			largeRedArmor = ImageIO.read(Resource.class.getResource("images" + sep + "largeRedArmor.png"));
			RED_FIGHTER = ImageIO.read(Resource.class.getResource("images" + sep + "redFighter.png"));
			blueFighter = ImageIO.read(Resource.class.getResource("images" + sep + "blueFighter.png"));
			blueHeavy = ImageIO.read(Resource.class.getResource("images" + sep + "BlueHeavy.png"));
			ICON = ImageIO.read(Resource.class.getResource("images" + sep + "Icon.png")); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
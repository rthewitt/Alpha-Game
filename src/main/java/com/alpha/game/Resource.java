package com.alpha.game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.apache.log4j.Logger;
import com.alpha.error.AlphaResourceException;

public class Resource extends Thread {
	public static final Logger alphaLog = Logger.getLogger(Resource.class);
	
	public static final String SEPARATOR;
	public static final ClassLoader classLoader;
	public static final URL resourceURL;
//	public static final String root;
//	public static final String rootPath;
	public static final String imagesPath;
//	public static final String fullImagesPath;
//	public static final String codePath;
	
	public static String levelsPath;
	
	static {
		SEPARATOR = System.getProperty("file.separator");
		classLoader = Resource.class.getClassLoader();
		resourceURL = Resource.class.getResource(".");
//		root = Resource.class.getResource("/").toString();
//		rootPath = Resource.class.getResource("/").getPath(); // is this OS agnostic?
		imagesPath = "images" + SEPARATOR;
//		fullImagesPath = rootPath + imagesPath;
		
//		codePath = Resource.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	}
	
/* TODO convert these images to "my" method

	public static BufferedImage bolt;
	public static BufferedImage exploding;
	public static BufferedImage laser;
	public static BufferedImage pen;
	public static BufferedImage poison;
	public static BufferedImage wave;
	public static BufferedImage currentBeam;
	
	public static Image currentShip;
*/
	
	// TODO talk to me about a better way to get the your ships' current image
	//User Ship Choices
	public static BufferedImage IMG_SMALL_GREEN;
	public static BufferedImage IMG_SMALL_GREEN_ARMOR;
	public static BufferedImage IMG_MED_GREEN;
	public static BufferedImage IMG_MED_GREEN_ARMOR;
	public static BufferedImage IMG_LARGE_GREEN;
	public static BufferedImage IMG_LARGE_GREEN_ARMOR;
	public static BufferedImage IMG_SMALL_RED;
	public static BufferedImage IMG_SMALL_RED_ARMOR;
	public static BufferedImage IMG_MED_RED;
	public static BufferedImage IMG_MED_RED_ARMOR;
	public static BufferedImage IMG_LARGE_RED;
	public static BufferedImage IMG_LARGE_RED_ARMOR;
	public static BufferedImage IMG_SMALL_BLUE;
	public static BufferedImage IMG_SMALL_BLUE_ARMOR;
	public static BufferedImage IMG_MED_BLUE;
	public static BufferedImage IMG_MED_BLUE_ARMOR;
	public static BufferedImage IMG_LARGE_BLUE;
	public static BufferedImage IMG_LARGE_BLUE_ARMOR;
	
	//Enemy Ships
	public static BufferedImage IMG_RED_FIGHTER;
	public static BufferedImage IMG_RED_HEAVY;
	public static BufferedImage IMG_BLUE_FIGHTER;
	public static BufferedImage IMG_BLUE_HEAVY;
	public static BufferedImage IMG_MED_YELLOW;
	public static BufferedImage IMG_BIG_YELLOW;
	public static BufferedImage IMG_BOSS_ONE;
	
	//Images dropped by Enemies
	public static BufferedImage IMG_BOLT;
	public static BufferedImage IMG_EXPLODING;
	public static BufferedImage IMG_LASER;
	public static BufferedImage IMG_PEN;
	public static BufferedImage IMG_POISON;
	public static BufferedImage IMG_WAVE;
	
	//Dynamic Image field for current games beam
	public static BufferedImage IMG_CURRENT_BEAM;
	
	//Menu Images
	public static BufferedImage IMG_DUAL_LASER;
	public static BufferedImage IMG_SPREAD_LASER;
	public static BufferedImage IMG_RAPID_LASER;
	public static BufferedImage IMG_HEALTH;
	public static BufferedImage IMG_SPEED;
	public static BufferedImage IMG_DAMAGE;
	
	//Menu Icons
	public static ImageIcon ICON_SMALL_GREEN_ICON;
	public static ImageIcon ICON_SMALL_RED_ICON;
	public static ImageIcon ICON_SMALL_BLUE_ICON;
	
	//Icon
	public static ImageIcon ICON_DUAL_LASER;
	
	/*
	static {
			try
			 {
				IMG_SMALL_GREEN = getImage("smallGreen.png");
				IMG_SMALL_GREEN_ARMOR = getImage("smallGreenArmor.png");
				IMG_MED_GREEN= getImage("medGreen.png");
				IMG_MED_GREEN_ARMOR = getImage("medGreenArmor.png");
				IMG_LARGE_GREEN = getImage("largeGreen.png");
				IMG_LARGE_GREEN_ARMOR = getImage("largeGreenArmor.png");
				IMG_SMALL_RED = getImage("smallRed.png");
				IMG_SMALL_RED_ARMOR = getImage("smallRedArmor.png");
				IMG_MED_RED = getImage("medRed.png");
				IMG_MED_RED_ARMOR = getImage("medRedArmor.png");
				IMG_LARGE_RED = getImage("largeRed.png");
				IMG_LARGE_RED_ARMOR = getImage("largeRedArmor.png");
				IMG_SMALL_BLUE = getImage("smallBlue.png");
				IMG_SMALL_BLUE_ARMOR = getImage("smallBlueArmor.png");
				IMG_MED_BLUE = getImage("medBlue.png");
				IMG_MED_BLUE_ARMOR = getImage("medBlueArmor.png");
				IMG_LARGE_BLUE = getImage("largeBlue.png");
				IMG_LARGE_BLUE_ARMOR = getImage("largeBlueArmor.png");
				IMG_RED_FIGHTER = getImage("redFighter.png");
//				redHeavy = ImageIO.read( getImagePath("RedHeavy.png");
				IMG_BLUE_FIGHTER = getImage("blueFighter.png");
				IMG_BLUE_HEAVY = getImage("BlueHeavy.png");
			}
			catch(IOException ioe) {
				alphaLog.error("Problem encountered while loading ship images", ioe);
				
			}
		
	} */
	
	// TODO boolean values will allow you to handle things gracefully
	public static void init() throws AlphaResourceException {
		initializeShips();
		initializeLevels();
	}
	
	public static void initializeShips() throws AlphaResourceException {
		try {
			IMG_SMALL_GREEN = getImage("smallGreen.png");
			IMG_SMALL_GREEN_ARMOR = getImage("smallGreenArmor.png");
			IMG_MED_GREEN= getImage("medGreen.png");
			IMG_MED_GREEN_ARMOR = getImage("medGreenArmor.png");
			IMG_LARGE_GREEN = getImage("largeGreen.png");
			IMG_LARGE_GREEN_ARMOR = getImage("largeGreenArmor.png");
			IMG_SMALL_RED = getImage("smallRed.png");
			IMG_SMALL_RED_ARMOR = getImage("smallRedArmor.png");
			IMG_MED_RED = getImage("medRed.png");
			IMG_MED_RED_ARMOR = getImage("medRedArmor.png");
			IMG_LARGE_RED = getImage("largeRed.png");
			IMG_LARGE_RED_ARMOR = getImage("largeRedArmor.png");
			IMG_SMALL_BLUE = getImage("smallBlue.png");
			IMG_SMALL_BLUE_ARMOR = getImage("smallBlueArmor.png");
			IMG_MED_BLUE = getImage("medBlue.png");
			IMG_MED_BLUE_ARMOR = getImage("medBlueArmor.png");
			IMG_LARGE_BLUE = getImage("largeBlue.png");
			IMG_LARGE_BLUE_ARMOR = getImage("largeBlueArmor.png");
			
			IMG_RED_FIGHTER = getImage("redFighter.png");
			IMG_RED_HEAVY = getImage("redHeavy.png");
			IMG_BLUE_FIGHTER = getImage("blueFighter.png");
			IMG_BLUE_HEAVY = getImage("blueHeavy.png");
			IMG_MED_YELLOW = getImage("medYellow.png");
			IMG_BIG_YELLOW = getImage("bigYellow.png");
			IMG_BOSS_ONE = getImage("bossOne.png");

			IMG_BOLT = getImage("dropBolt.png");
			IMG_EXPLODING = getImage("dropExploding.png");
			IMG_LASER = getImage("dropLaser.png");
			IMG_PEN = getImage("dropPen.png");
			IMG_POISON = getImage("dropPoison.png");
			IMG_WAVE = getImage("dropWave.png");
			
			IMG_DUAL_LASER = getImage("menuDual.png");
			IMG_SPREAD_LASER = getImage("menuSpread.png");
			IMG_RAPID_LASER = getImage("menuRapid.png");
			IMG_HEALTH = getImage("Health.png");
			IMG_SPEED = getImage("Speed.png");
			IMG_DAMAGE = getImage("Damage.png");

	        // Making these conform to API call
	        ICON_SMALL_GREEN_ICON = new ImageIcon( getImage("smallGreen.png") );
	        ICON_SMALL_RED_ICON = new ImageIcon( getImage("smallRed.png") );
	        ICON_SMALL_BLUE_ICON = new ImageIcon( getImage("smallBlue.png") );

		}
		catch(IOException ioe) {
			alphaLog.error("Problem encountered while loading ship images", ioe);
			throw new AlphaResourceException(ioe);
		}
		catch(Exception e) {
			throw new AlphaResourceException(e);
		}
	}
	
	public static void initializeLevels() {
		File file = new File(".");  
		File[] files = file.listFiles();  
		 
		for (int fileInList = 0; fileInList < files.length; fileInList++)  {
			levelsPath = files[fileInList].toString() + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR + "levels" + SEPARATOR;
			
			if(levelsPath.contains(SEPARATOR + "src" + SEPARATOR + "main" + SEPARATOR + "resources" + SEPARATOR + "levels" + SEPARATOR)) {
				break;
			}
		}
	}
	
	public static String getInformation () {
		StringBuilder sb = new StringBuilder();
		
		return sb
		.append(String.format("\nSystem Separator URL: %s", SEPARATOR))
		.append(String.format("\nResource Classloader: %s", classLoader))
		.append(String.format("\nResource URL: %s", resourceURL))
//		.append(String.format("\nroot: %s", root))
//		.append(String.format("\nroot path: %s", rootPath))
		.append(String.format("\nimages path: %s", imagesPath))
//		.append(String.format("\ncode path: %s", codePath))
		.toString();
	}
	
	
	// to swap out strategies more easily
	private static BufferedImage getImage(String name) throws IOException {
		
		return (BufferedImage)(ImageIO.read( getImageStream(name) ));
//		return (BufferedImage)(ImageIO.read(Resource.class.getResource("images" + SEPARATOR + name)));
//		return (BufferedImage) (ImageIO.read(Resource.class.getResource(codePath + "images" + SEPARATOR + name)));
	}
	
	@SuppressWarnings("unused")
	private static URL getImageURL(String name) throws MalformedURLException {
		return null;
//		return new URL("file://" + imagesPath + name);
//		return new URL("file://" + codePath + "images" + SEPARATOR + name);
//		return Resource.class.getResource("../../../" + imagesPath + SEPARATOR + name); // works unzipped
	}
	
	private static InputStream getImageStream(String name) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(imagesPath+name);
//		return Resource.class.getResourceAsStream(SEPARATOR+imagesPath+name);
	}
	
	// used for testing different classloaders during different build phases
	@SuppressWarnings("static-access")
	public static BufferedImage getImageFromSystemPath(String imgName) throws IOException {
		return (BufferedImage)( ImageIO.read(
				classLoader.getSystemResourceAsStream("images" + SEPARATOR + imgName)) );
	}	
}

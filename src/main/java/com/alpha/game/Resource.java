package com.alpha.game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import org.apache.log4j.Logger;
import com.alpha.error.AlphaResourceException;

public class Resource extends Thread {
	public static final Logger alphaLog = Logger.getLogger(Resource.class);
	
	public static final String SEPARATOR;
	public static final ClassLoader classLoader;
	public static final URL resourceURL;
	public static final String imagesPath;
	public static String levelsPath;
	
	static {
		SEPARATOR = System.getProperty("file.separator");
		classLoader = Resource.class.getClassLoader();
		resourceURL = Resource.class.getResource(".");
		imagesPath = "images" + SEPARATOR;
		levelsPath = "levels" + SEPARATOR;
	}
	
	public static BufferedImage IMG_YIN;
	
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
	public static BufferedImage IMG_PINK_CORVETTE;
	public static BufferedImage IMG_BOSS_ONE;
	
	//Beam Options
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
	public static BufferedImage IMG_WAVE_LASER;
	public static BufferedImage IMG_EXPLOSIVE_LASER;
	public static BufferedImage IMG_PIERCE_LASER;
	public static BufferedImage IMG_HEALTH;
	public static BufferedImage IMG_SPEED;
	public static BufferedImage IMG_DAMAGE;
	
	public static void init() throws AlphaResourceException {
		initializeShips();
	}
	
	public static void initializeShips() throws AlphaResourceException {
		try {
			IMG_YIN = getImage("yin.png");
			
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
			IMG_PINK_CORVETTE = getImage("pinkCorvette.png");
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
			IMG_PIERCE_LASER = getImage("menuPierce.png");
			IMG_WAVE_LASER = getImage("menuWave.png");
			IMG_EXPLOSIVE_LASER = getImage("menuExplosive.png");
			IMG_HEALTH = getImage("health.png");
			IMG_SPEED = getImage("speed.png");
			IMG_DAMAGE = getImage("damage.png");
		} catch(IOException ioe) {
			alphaLog.error("Problem encountered while loading ship images", ioe);
			throw new AlphaResourceException(ioe);
		} catch(Exception e) {
			throw new AlphaResourceException(e);
		}
	}
	
	public static String getInformation () {
		StringBuilder sb = new StringBuilder();
		
		return sb
		.append(String.format("\nSystem Separator URL: %s", SEPARATOR))
		.append(String.format("\nResource Classloader: %s", classLoader))
		.append(String.format("\nResource URL: %s", resourceURL))
		.append(String.format("\nimages path: %s", imagesPath))
		.toString();
	}
	
	
	private static BufferedImage getImage(String name) throws IOException {
		try {
			return (BufferedImage)(ImageIO.read( getImageStream(name) ));
		} catch(Exception e) {
			throw new IOException("Problem loading ship " + name, e);
		}
	}
	
	private static InputStream getImageStream(String name) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(imagesPath+name);
	}
	
	// used for testing different class loaders during different build phases
	@SuppressWarnings("static-access")
	public static BufferedImage getImageFromSystemPath(String imgName) throws IOException {
		return (BufferedImage)( ImageIO.read(
				classLoader.getSystemResourceAsStream("images" + SEPARATOR + imgName)));
	}
}
package com.alpha.game;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import com.alpha.error.AlphaResourceException;

public class Resource
{
	public static final Logger alphaLog = Logger.getLogger(Resource.class);
	
	public static final String SEPARATOR;
	public static final ClassLoader classLoader;
	public static final URL resourceURL;
//	public static final String root;
//	public static final String rootPath;
	public static final String imagesPath;
//	public static final String fullImagesPath;
//	public static final String codePath;
	
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
	
	
	
	// TODO talk to me about a better way to get the your ships' current image
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
	public static BufferedImage IMG_RED_FIGHTER;
	public static BufferedImage IMG_RED_HEAVY;
	public static BufferedImage IMG_BLUE_FIGHTER;
	public static BufferedImage IMG_BLUE_HEAVY;
	
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
	}
	
	public static void initializeShips() throws AlphaResourceException {
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
//			redHeavy = ImageIO.read( getImagePath("RedHeavy.png");
			IMG_BLUE_FIGHTER = getImage("blueFighter.png");
			IMG_BLUE_HEAVY = getImage("BlueHeavy.png");
		}
		catch(IOException ioe) {
			alphaLog.error("Problem encountered while loading ship images", ioe);
			throw new AlphaResourceException(ioe);
		} catch(Exception e) {
			throw new AlphaResourceException(e); // will add valuable information
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
	public static BufferedImage getImageFromSystemPath(String imgName) throws IOException {
		return (BufferedImage)( ImageIO.read(
				classLoader.getSystemResourceAsStream("images" + SEPARATOR + imgName)) );
	}
	
}

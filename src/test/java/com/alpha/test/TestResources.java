package com.alpha.test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.alpha.error.AlphaResourceException;
import com.alpha.game.Resource;


public class TestResources {
	
	private static final Logger testLogger = Logger.getLogger(TestResources.class);
	
	@Before
	public void logImportantInformation() {
		testLogger.info(Resource.getInformation());
	}
	
	
	@Test
	public void testShipImages() throws AlphaResourceException {
		Resource.initializeShips();
		// You can also test for undesired values when no exception
		// is found
		Assert.assertNotNull(Resource.IMG_BLUE_FIGHTER);
	}
	
	
	@Test
	public void testInit() throws AlphaResourceException {
		Resource.init();
		// You can also test for undesired values when no exception
		// is found
		Assert.assertNotNull(Resource.IMG_BLUE_FIGHTER);
	}
	
	@Test
	public void verifyGameLogic() {
		// Here you can test any method or game logic
		// verify that the output is what you expect
		assert(true);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testSystemResources() {
		BufferedImage testImage;
		// Should result in nullpointer exception
		try{
			testImage = Resource.getImageFromSystemPath("only-in-test");
			@SuppressWarnings("static-access")
			InputStream testStream = this.getClass().getClassLoader().getSystemResourceAsStream("/images" + System.getProperty("file.separator") + "only-in-test");
			if(testStream == null) throw new IOException();
			testImage = ImageIO.read(testStream);
			
			 Assert.fail("Image found from test classes");
//			 we wanted to fail, and we did.  
		} catch(Exception ioe) {
			// passes test
		}
	}
	
}
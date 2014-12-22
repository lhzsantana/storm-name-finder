package org.ecjfh.util;

import static org.junit.Assert.assertTrue;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
public class ImageUtilTest {

	@Test
	public void testSaveFileSuccess() throws IOException {
		
		File file = new File("C:/Users/Luiz/Desktop/086f2d5.jpg");
		
		InputStream logotipo = new FileInputStream(file);
		
		ImageUtil.saveToDiskImage(logotipo, file.getName(), "C:/Users/Luiz/Desktop");
		
		assertTrue(true);
	}

}

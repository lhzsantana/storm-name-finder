package org.ecjfh.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

public class ImageUtil {

	public static String saveToDiskImage(InputStream file, String name,
			String path) throws IOException {

		Date date = new Date();

		String finalName = name.substring(0, name.length() - 4) + "-"
				+ date.getTime();

		File originalFile = new File(path + "/" + finalName);

		FileUtils.copyInputStreamToFile(file, originalFile);

		String thumbname = finalName + "-thumb.jpg";

		saveThumb(originalFile, thumbname, path);

		return thumbname;
	}

	private static void saveThumb(File originalImage, String thumbname,
			String path) throws IOException {

		BufferedImage bufferedImage;

		try {

			// read image file
			bufferedImage = ImageIO.read(originalImage);

			int width = 40;
			int height = 40;

			BufferedImage newImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = newImage.createGraphics();

			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			try {
				g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
						RenderingHints.VALUE_INTERPOLATION_BICUBIC);
				g.setBackground(Color.BLACK);
				g.clearRect(0, 0, width, height);
				g.drawImage(bufferedImage, 0, 0, width, height, null);
				
				File thumbImage = new File(path + "/" +thumbname);
				ImageIO.write(newImage, "jpg", thumbImage);
			} finally {
				g.dispose();
			}

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}

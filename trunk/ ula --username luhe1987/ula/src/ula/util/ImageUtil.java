package ula.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图形处理工具类
 * 
 * @author Nanlei
 * 
 */
public class ImageUtil {
	private static final Log log = LogFactory.getLog(ImageUtil.class);

	/**
	 * 格式化图形并上传到指定目录，同时指定宽度和高度
	 * 
	 * @param is
	 *            图形文件输入流
	 * @param width
	 *            目标图形宽度
	 * @param height
	 *            目标图形高度
	 * @param filePath
	 *            目标文件路径
	 * @throws Exception
	 */
	public static void resizeImageToFile(InputStream is, int width, int height,
			String filePath) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Resize and upload image file begin");
		}
		// 读取文件并转为Image类型
		Image image = ImageIO.read(is);
		if (image.getWidth(null) == -1) {
			log.debug("The size of image file is illegal!");
			throw new IllegalArgumentException(
					"The size of image file is illegal!");
		} else {
			BufferedImage bi = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			bi.getGraphics().drawImage(
					image.getScaledInstance(width, height, Image.SCALE_SMOOTH),
					0, 0, null);
			// 文件上传
			FileOutputStream out = new FileOutputStream(filePath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(bi);
			out.close();
		}
		if (log.isDebugEnabled()) {
			log.debug("Resize and upload image file end");
		}
	}

	/**
	 * 格式化图形并上传到指定目录，指定宽度来计算高度
	 * 
	 * @param is
	 *            图形文件输入流
	 * @param width
	 *            目标图形宽度
	 * @param filePath
	 *            目标文件路径
	 * @throws Exception
	 */
	public static void resizeImageToFile(InputStream is, int width,
			String filePath) throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("Resize and upload image file begin");
		}
		// 读取文件并转为Image类型
		Image image = ImageIO.read(is);
		if (image.getWidth(null) == -1) {
			log.debug("The size of image file is illegal!");
			throw new IllegalArgumentException(
					"The size of image file is illegal!");
		} else {
			int originalWidth = image.getWidth(null);
			int originalHeight = image.getHeight(null);
			double rate = ((double) originalWidth) / ((double) originalHeight);
			int height = (int) (((double) width) / rate);
			BufferedImage bi = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			bi.getGraphics().drawImage(
					image.getScaledInstance(width, height, Image.SCALE_SMOOTH),
					0, 0, null);
			// 文件上传
			FileOutputStream out = new FileOutputStream(filePath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(bi);
			out.close();
		}
		if (log.isDebugEnabled()) {
			log.debug("Resize and upload image file end");
		}
	}
}

package ula.util;

import java.io.File;

public class FileUtil {
	/**
	 * tell if the specific file exists. Do not recommend to use this function.
	 * please directly use if(file.exists());
	 * 
	 * @param file
	 * @return
	 */
	public static boolean FileExists(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}

	/**
	 * get the extension of a file
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getFileExtension(String filePath) {
		return filePath.substring(filePath.lastIndexOf('.') + 1);
	}

	/**
	 * get the filename of a given full filePath
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getFileName(String filePath) {
		return filePath.substring(filePath.lastIndexOf("/") + 1);
	}

	/**
	 * get the standard UNIX file path
	 * 
	 * @param path
	 * @return
	 */
	public static String getUNIXPath(String path) {
		return path.replace(File.separator, "/");
	}

	public static boolean mkDirs(final String filePath) {
		File file = new File(getUNIXPath(filePath));
		if (!file.exists() && file.isDirectory()) {
			return file.mkdirs();
		}
		return false;
	}

	/**
	 * create file or folder under a given path if the file or folder does not
	 * exist
	 * 
	 * @param path
	 *            given path a file or folder will be created under
	 * @param fileName
	 *            file or folder to be created
	 * @return true if successful, otherwise false
	 */
	public static boolean mkDirs(final String path, final String fileName) {
		return mkDirs(path + fileName);
	}

	/**
	 * to merge two path or fileName
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static String pathMerge(String first, String second) {
		return getUNIXPath(first) + getUNIXPath(second);
	}
}

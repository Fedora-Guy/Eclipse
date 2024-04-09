package ventureSmith;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Custom {
	
	public static BufferedImage cropImage(String path, int x, int y, int width, int height) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(Main.class.getResource("images/" + path + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(img != null) {
			return img.getSubimage(x, y, width, height);
		}
		return null;
	}
	
	public static void writeFile(String path, String[] input) throws IOException {
		PrintWriter writer = new PrintWriter(new FileOutputStream(Main.class.getResource(path).getPath(), false), false);
		for(int i = 0; i < input.length; i++) {
			writer.println(input[i]);
		}
		writer.close();
	}
	
	public static String[] readFile(String path) {
		ArrayList<String> temp = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(Main.class.getResource(path).getPath()));
			String line = reader.readLine();
			while(line != null) {
				temp.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] ret = new String[temp.size()];
		for(int i = 0; i < temp.size(); i++)
			ret[i] = temp.get(i);
		return ret;
	}
	
}

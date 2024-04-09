import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class Testing {

	public static void main(String[] args) throws IOException {
		
		for(int i = 0; i <= 96; i++) {
			File tempFile = new File("C:/Users/Keith/Downloads/Fan/fan" + i + ".mtl");
			Scanner scan = new Scanner(tempFile);
			FileOutputStream temp = new FileOutputStream("C:/Users/Keith/Downloads/Fan/fan" + i + ".mtl");
			while(scan.hasNextLine()) {
				String tempString = scan.nextLine();
				
				if(tempString.equals("map_Kd C:/lambert1_baseColor.jpeg")) {
					tempString = "map_Kd C:/lambert1_baseColor.jpeg";
				}
				
				if(tempString.equals("map_Ke C:/lambert1_emissive.jpeg")) {
					tempString = "map_Ke C:/lambert1_emissive.jpeg";
				}
				char[] test = tempString.toCharArray();
				for(int j = 0; i < test.length; i++)
					temp.write((int)test[j]);
			}
		}

	}

}

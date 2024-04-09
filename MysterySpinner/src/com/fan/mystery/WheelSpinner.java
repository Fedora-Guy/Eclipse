package com.fan.mystery;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Random;

public class WheelSpinner {
	// The class that chooses the outcome for the MysteryBox
	
	// Firstly, it gets the location of the images folder in your system
	// Then it changes it into the correct format for the File Object
	private String x = getClass().getResource("/MysteryBox.png").toString().substring(6);
	private File f = new File(x.substring(0, x.length()-15));
	// Secondly, this will allow us to filter only for .png files, So please only use .pngs
	// If you want to change it to a different file extension, change it below
	private FilenameFilter filter = new FilenameFilter() {
        @Override
        public boolean accept(File f, String name) {
            return name.endsWith(".png");
        }
    };
    // Thirdly, it generates a random seed for selecting an outcome.
    private Random random = new Random();
    
    
	private String[] getDirectories() {
		String[] pathnames;
		pathnames = f.list(filter);
		return pathnames;
	}
	
	public String answer() {
		String[] potential = getDirectories();
		int outcomes = potential.length;
		String answer = potential[random.nextInt(outcomes)];
		while(answer == "MysteryBox.png") {
			answer = potential[random.nextInt(outcomes)];
		}
		return answer;
	}
	
}

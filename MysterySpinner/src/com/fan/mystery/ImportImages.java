package com.fan.mystery;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImportImages {
	
	
	public Image readImage(String streamString) {
	    try {
	        return ImageIO.read(getClass().getResourceAsStream("/" + streamString));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public int ImageWidth(String streamString) {
		BufferedImage bimg;
		try {
			bimg = ImageIO.read(getClass().getResourceAsStream("/" + streamString));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bimg = null;
		}
		return bimg.getWidth();
	}
	
	public int ImageHeight(String streamString) {
		BufferedImage bimg;
		try {
			bimg = ImageIO.read(getClass().getResourceAsStream("/" + streamString));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bimg = null;
		}
		return bimg.getHeight();
	}
}

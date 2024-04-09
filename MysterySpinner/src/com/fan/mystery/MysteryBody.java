package com.fan.mystery;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Desktop;
import javax.imageio.ImageIO;
import java.awt.Shape;
import java.awt.RenderingHints;
import java.awt.BasicStroke;

@SuppressWarnings("serial")
public class MysteryBody extends Component implements MouseListener, KeyListener {
	
	private MysteryBox mysteryBox = new MysteryBox();
	private WheelSpinner wheelSpinner = new WheelSpinner();
	private ImportImages importImages = new ImportImages();
	
	private String answer = "";
	private boolean startSpin = false;
	
	public MysteryBody() {
		addMouseListener(this);
		addKeyListener(this);
		requestFocusInWindow();
		setBackground(new Color(200, 200, 200));
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
//		//
//		URL url;
//		try {
//			url = new URL("http://i.stack.imgur.com/Nqf3H.jpg");
//		} catch (MalformedURLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			url = null;
//		}
//        BufferedImage originalImage;
//		try {
//			originalImage = ImageIO.read(url);
//		} catch (IOException e1) {
//			// TODO Autos-generated catch block
//			e1.printStackTrace();
//			originalImage = null;
//		}
//        final BufferedImage textImage = new BufferedImage(
//            originalImage.getWidth(),
//            originalImage.getHeight(),
//            BufferedImage.TYPE_INT_ARGB);
//        Graphics2D gE = textImage.createGraphics();
//        FontRenderContext frc = gE.getFontRenderContext();
//        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 250);
//        GlyphVector gv = font.createGlyphVector(frc, "Press F for Mystery Box [Cost: 1 Nuke]");
//        Rectangle2D box = gv.getVisualBounds();
//        int xOff = 25+(int)-box.getX();
//        int yOff = 80+(int)-box.getY();
//        Shape shape = gv.getOutline(xOff,yOff);
//        gE.setClip(shape);
//        gE.drawImage(originalImage,0,0,null);
//        gE.setClip(null);
//        gE.setStroke(new BasicStroke(2f));
//        gE.setColor(Color.BLACK);
//        gE.setRenderingHint(
//            RenderingHints.KEY_ANTIALIASING,
//            RenderingHints.VALUE_ANTIALIAS_ON);
//        gE.draw(shape);
//        
//        gE.dispose();
//        
//        FontRenderContext frc2 = g2.getFontRenderContext();
//        Font font2 = new Font(Font.SANS_SERIF, 0, 40);
//        String buyBoxText = "Press f for Mystery Box [Cost: 1 Nuke]";
//        GlyphVector gv2 = font2.createGlyphVector(frc2, buyBoxText.toCharArray());
//        Rectangle2D box2 = gv2.getVisualBounds();
//        int xOff2 = 25+(int)-box2.getX();
//        int yOff2 = 280+(int)-box2.getY();
//        Shape shape2 = gv2.getOutline(xOff2,yOff2);
//        g2.setClip(shape2);
//        
//        g2.setClip(null);
//        g2.setStroke(new BasicStroke(2f));
//        g2.setColor(Color.RED);
//        g2.setRenderingHint(
//            RenderingHints.KEY_ANTIALIASING,
//            RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.fill(shape2);
//        g2.drawChars(buyBoxText.toCharArray(), 0, 6, xOff2, yOff2+20);
//        g2.setColor(Color.YELLOW);
//        g2.drawChars(buyBoxText.toCharArray(), 6, 1, xOff2+40, yOff2+20);
//        g2.setColor(Color.RED);
//        g2.drawChars(buyBoxText.toCharArray(), 7, buyBoxText.toCharArray().length-7, xOff2+50, yOff2+20);
//        
//        File file = new File("cat-text.png");
//        try {
//        	ImageIO.write(textImage,"png",file);
//        	Desktop.getDesktop().open(file);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
       
//		exit();
/*		g2.setColor(new Color (200, 200, 200));
		g2.fillRect(15, 15, 1200-45, 1000-65);
		g2.drawImage(importImages.readImage("MysteryBox.png"), 300, 700, 1000-300, 200, null);
		
		for(int i = 0; i < 1200; i+=100) {
			g2.setColor(Color.red);
			g2.fillRect(i, 700, 10, 100);
		}
		if(startSpin != true) {
			int textX = 100;
			g2.setFont(new Font(Font.SANS_SERIF, 0, 30));
			g2.setColor(Color.white);
			g2.drawString("Press ", textX, 100);
			g2.setColor(Color.YELLOW);
			g2.drawString("f", textX+36, 100);
			g2.setColor(Color.white);
			g2.drawString(" for Mystery Box [Cost: 1 Nuke]", textX+39, 100);
		} else {
			g2.drawImage(importImages.readImage(answer), 100, 100, null);
		} */
		
		g2.setColor(getBackground());
		g2.fillRect(10, 10, 1200-20, 675-20);
		// CANVAS SIZE OF 1180 by 655; Midpoint of X = 590; Midpoint of Y = 327.5
		g2.drawImage(importImages.readImage("MysteryBox.png"), 295, 262, 590, 393, null);
		g2.setColor(Color.red);
		g2.fillRect(580, 15, 20, 640);
		
		if(startSpin != true) {
			g2.setFont(new Font(Font.SANS_SERIF, 0, 30));
			int textX = 393;
			int textY = 300;
			int textWidth = g2.getFontMetrics().stringWidth("Press ");
			g2.setColor(Color.white);
			g2.drawString("Press", textX, textY);
			g2.setColor(Color.YELLOW);
			g2.drawString("f ", textX+textWidth, textY);
			textWidth = g2.getFontMetrics().stringWidth("f ") + textWidth;
			g2.setColor(Color.white);
			g2.drawString("for Mystery Box [Cost: 1 Nuke]", textX+textWidth, textY);
		} else {
			int imageWidth = importImages.ImageWidth(answer);
			int imageHeight = importImages.ImageHeight(answer);
			if(imageWidth > 200) {
				imageWidth = 200;
			}
			if(imageHeight > 200) {
				imageHeight = 200;
			}
			g2.drawImage(importImages.readImage(answer), 590-(imageWidth/2), (int)150-(imageHeight/2), 200, 200, null);
		}
		
		
		repaint();
	}
	
	public void exit() {
		System.exit(0);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {
		if((e.getKeyChar() == 'f' || e.getKeyChar() == 'F') && startSpin != true) {
			System.out.println("F has been pressed");
			startSpin = true;
			answer = wheelSpinner.answer();
		} else if ((e.getKeyChar() == 'f' || e.getKeyChar() == 'F') && startSpin == true) {
			exit();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println("X: " + e.getX());
		System.out.println("Y: " + e.getY());
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

}

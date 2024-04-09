import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComponent;

// Paintings / Clickable methods / located here
// Class Represents: The Graphical interface and also the logic behind it.
// The Player utilizes this class to see the game.
@SuppressWarnings("serial")
public class PaintClasses extends JComponent implements MouseListener, MouseMotionListener, KeyListener{
	
	// My specific Screen Resolution is currently 1920 x 1080
	// However this program is set to work with any. 
	// If you cannot change your Resolution follow the comments below
	// Change your Resolution here; If you are unsure of your resolution is, use:
	// https://bestfirms.com/what-is-my-screen-resolution/
	private int sizeHorziontal = 1920;
	private int sizeVertical = 1080;
	Color background = new Color(0, 0, 0); // Black
	ArrayList <ButtonObj> list = new ArrayList<>(); // Adds clickability to items
	private boolean checkForWin = false;
	private boolean checkForWin2 = false;
	
	// Paint Class Objects
	Paint middleFloorPaint = new Paint();
	Paint topFloorPaint = new Paint();
	Paint bottomFloorPaint = new Paint();
	Paint upArrow = new Paint();
	Paint downArrow = new Paint();
	Paint actualDownArrow = new Paint();
	Paint brickPaint = new Paint();
	Paint rubikPaint = new Paint();
	Paint lampPaint = new Paint();
	Paint grandFatherClockPaint = new Paint();
	Paint grandFatherCompartmentPaint = new Paint();
	Paint exitSignPaint = new Paint();
	Paint computerPaint = new Paint();
	Paint computerBackPaint = new Paint();
	Paint paintPaint = new Paint();
	Paint woodenDoorPaint = new Paint();
	Paint combinationLockPadPaint = new Paint();
	
	
	// Non-Paint Classes Objects
	PlayerLocation playerLocation = new PlayerLocation();
	MismatchedWall mismatchedWall = new MismatchedWall();
	RubikPoster rubikPoster = new RubikPoster();
	Lamp lamp = new Lamp();
	GrandFatherClockFace grandFatherClockFace = new GrandFatherClockFace(mismatchedWall.getTimecode1(), lamp.getTimecode3(), rubikPoster.getTimecode4());
	GrandFatherClockCompartment grandFatherClockCompartment = new GrandFatherClockCompartment();
	ExitSign exitSign = new ExitSign();
	Computer computer = new Computer();
	PaintCan paintCan = new PaintCan();
	CombinationLockPad combinationLockPad = new CombinationLockPad(exitSign.getCombinationlockCode1(), computer.getCombinationlockCode2(), paintCan.getCombinationlockCode3());
	
	String combinationlockCode = "" + exitSign.getCombinationlockCode1() +  "-" + computer.getCombinationlockCode2() + "-" + paintCan.getCombinationlockCode3() + "";
	CombinationLock combinationLock = new CombinationLock(combinationlockCode);
	
	// Constructor
	public PaintClasses() {
		addMouseListener(this);
		addKeyListener(this);
		list.add(new ButtonObj("GrandFatherClockInput", 0, 0, 3));
		list.add(new ButtonObj("CombinationLockInput", 0 ,0, -3));
		list.add(new ButtonObj("MiddleFloorClosed", 0, 0, 0));
		list.add(new ButtonObj("MiddleFloorOpened", 0, 0, 0));
		list.add(new ButtonObj("MiddleFloorDoor", 0, 0, 0));
		list.add(new ButtonObj("TopFloor", 0, 0, 1));
		list.add(new ButtonObj("BottomFloor", 0,0, -1));
		list.add(new ButtonObj("Key", 999, 923, 0));
		
		list.add(new ButtonObj("ClockFace", 904, 628, 1074, 711, 0));
		list.add(new ButtonObj("Timecode1Up", 346, 374, 554, 481, 3));
		list.add(new ButtonObj("Timecode2Up", 678, 374, 884, 481, 3));
		list.add(new ButtonObj("Timecode3Up", 1067, 374, 1271, 481, 3));
		list.add(new ButtonObj("Timecode4Up", 1396, 374, 1604, 481, 3));
		list.add(new ButtonObj("Timecode1Down", 346, 741, 554, 844, 3));
		list.add(new ButtonObj("Timecode2Down", 678, 741, 884, 844, 3));
		list.add(new ButtonObj("Timecode3Down", 1067, 741, 1271, 844, 3));
		list.add(new ButtonObj("Timecode4Down", 1396, 741, 1604, 844, 3));
		list.add(new ButtonObj("Timecode1", 346, 374, 554, 481, 3));
		list.add(new ButtonObj("Timecode2", 346, 374, 554, 481, 3));
		list.add(new ButtonObj("Timecode3", 346, 374, 554, 481, 3));
		list.add(new ButtonObj("Timecode4", 346, 374, 554, 481, 3));
		list.add(new ButtonObj("Submit", 1800, sizeVertical-120, 1900, sizeVertical-80, Color.BLACK, 3));
		list.add(new ButtonObj("Correct", sizeHorziontal/2-320, 780, sizeHorziontal/2+230, 1000, 3));
		list.add(new ButtonObj("Incorrect", sizeHorziontal/2-320, 780, sizeHorziontal/2+230, 1000, 3));
		
		list.add(new ButtonObj("CombinationLock", 1300, 800, 1900, 900, -1));
		list.add(new ButtonObj("code1Up", 428, 346, 650, 487, -3));
		list.add(new ButtonObj("code2Up", 691, 346, 1000, 487, -3));
		list.add(new ButtonObj("code3Up", 1100, 346, 1450, 487, -3));
		list.add(new ButtonObj("code1Down", 468-40, 748, 674-40, 853, -3));
		list.add(new ButtonObj("code2Down", 793-40, 748, 1001-40, 853, -3));
		list.add(new ButtonObj("code3Down", 1125-40, 748, 1330-40, 853, -3));
		list.add(new ButtonObj("code1", 0, 0, -3));
		list.add(new ButtonObj("code2", 0, 0, -3));
		list.add(new ButtonObj("code3", 0, 0, -3));
		list.add(new ButtonObj("Submit", 1800, sizeVertical-120, 1900, sizeVertical-80, Color.BLACK, -3));
		list.add(new ButtonObj("Correct", sizeHorziontal/2-320, 780, sizeHorziontal/2+230, 1000, -3));
		list.add(new ButtonObj("Incorrect", sizeHorziontal/2-320, 780, sizeHorziontal/2+230, 1000, -3));
		
		list.add(new ButtonObj("Quit", 10, sizeVertical-45, 100, sizeVertical-5, Color.BLUE, 0));
		list.add(new ButtonObj("Quit", 10, sizeVertical-45, 100, sizeVertical-5, Color.BLUE, -1));
		list.add(new ButtonObj("Quit", 10, sizeVertical-45, 100, sizeVertical-5, Color.BLUE, 1));
		list.add(new ButtonObj("Quit", 10, sizeVertical-45, 100, sizeVertical-5, Color.BLUE, -3));
		list.add(new ButtonObj("Quit", 10, sizeVertical-45, 100, sizeVertical-5, Color.BLUE, 3));
		list.add(new ButtonObj("Back", 10, sizeVertical-120, 100, sizeVertical-80, Color.BLACK, 3));
		list.add(new ButtonObj("Back", 10, sizeVertical-120, 100, sizeVertical-80, Color.BLACK, -3));
    	list.add(new ButtonObj("UpArrow", sizeHorziontal-400, sizeVertical-750, 0));
    	list.add(new ButtonObj("UpArrow", sizeHorziontal-400, sizeVertical-750, -1));
    	list.add(new ButtonObj("DownArrow", sizeHorziontal-1600, sizeVertical-550, 1));
    	list.add(new ButtonObj("ActualDownArrow", sizeHorziontal-1850, sizeVertical-250, 0));
    	
    	
    	list.add(new ButtonObj("Brick", sizeHorziontal-1700, sizeVertical-900, 1));
    	list.add(new ButtonObj("Lamp", sizeHorziontal-1200, sizeVertical-900, sizeHorziontal-1000, sizeVertical-700, 1));
    	list.add(new ButtonObj("RubikPoster", sizeHorziontal-800, sizeVertical-900, sizeHorziontal-400, sizeVertical-700, 1));
    	
    	list.add(new ButtonObj("ExitSign", sizeHorziontal-1600, sizeVertical-900, sizeHorziontal-1200, sizeVertical-800, -1));
    	list.add(new ButtonObj("Computer", sizeHorziontal-1000, sizeVertical-900, sizeHorziontal-550, sizeVertical-800, -1));
    	list.add(new ButtonObj("PaintCans", sizeHorziontal-1700, sizeVertical-200, sizeHorziontal-1300, sizeVertical-100, -1));
    	
    	//! UNCOMMENT THESE IF YOU WANT TO CHECK WHAT THE CORRECT CODE FOR THIS ATTEMPT IS!
//    	System.out.println(combinationlockCode);
//    	System.out.println(mismatchedWall.getTimecode1() + " : " + mismatchedWall.getTimecode2() +  " " + lamp.getTimecode3()  + " " + rubikPoster.getTimecode4());
	}
	
	// Paints the jFrame Window.
	public void paint(Graphics g) { 
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(background);
		g2.fillRect(0, 0, 2000, 2000);
		g2.setColor(new Color ( 235, 235, 235));
		g2.fillRect(0, 50, sizeHorziontal, sizeVertical-100);
		disButtons(g2);
		repaint();
		if(checkForWin2) {
			combinationLock.unlock();
			if(combinationLock.isUnlocked()) {
				win();
			}
		}
		if(checkForWin) {
			checkForWin2 = true; 
		}
	}
	
	// displays all objects in the ButtonObj ArrayList
	public void disButtons (Graphics2D g2) { 
		ButtonObj b;
		g2.setFont(new Font("Serif", Font.PLAIN, 30));
		g2.setStroke(new BasicStroke(3));
		for(int i = 0; i < list.size(); i++) {
    		
    		b=list.get(i);
    		
    		if(playerLocation.getLocation() == 0) { // If the playerLocation has the player in the middle floor
    			if(list.get(i).getObjDisplay().equals("MiddleFloorClosed") && !grandFatherClockFace.getIsCodeCorrect()) {
    				middleFloorPaint.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
        		} 
    			else if(list.get(i).getObjDisplay().equals("MiddleFloorOpened") && grandFatherClockFace.getIsCodeCorrect() && !grandFatherClockCompartment.getHasKey()) {
    				middleFloorPaint.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
        		}
    			else if(list.get(i).getObjDisplay().equals("MiddleFloorDoor") && grandFatherClockCompartment.getHasKey() == true) {
    				middleFloorPaint.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
        		}
        		else if(list.get(i).getObjDisplay().equals("ActualDownArrow") && grandFatherClockCompartment.getHasKey()) {
    				actualDownArrow.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
        		}
        		else if (list.get(i).getObjDisplay().equals("UpArrow")) { 
        			upArrow.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
        		} 
    		} else if(playerLocation.getLocation() == 1) { // If the playerLocation has the player in the top floor
    			if(list.get(i).getObjDisplay().equals("TopFloor")) { 
    				topFloorPaint.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
    			}
    			else if(list.get(i).getObjDisplay().equals("DownArrow")) {
    				downArrow.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
        		}
        		else if(list.get(i).getObjDisplay().equals("Brick")) { 
        			if(!mismatchedWall.getRemovedBrick()) {
        				brickPaint.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
	        		} else {
	        			g2.setColor(Color.BLACK);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
	        			if(mismatchedWall.getTimecode2() >= 10)
		        			g2.drawString(Integer.toString(mismatchedWall.getTimecode1()) + " : " + Integer.toString(mismatchedWall.getTimecode2()), b.getObjX1(), b.getObjY1()+125);
	        			else 
	        				g2.drawString(Integer.toString(mismatchedWall.getTimecode1()) + " : 0 " + Integer.toString(mismatchedWall.getTimecode2()), b.getObjX1(), b.getObjY1()+125);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
	        			brickPaint.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), 800);
	        		}
        		} 
        		else if(list.get(i).getObjDisplay().equals("Lamp")) {
        			if(lamp.isLookingAtLamp() == false) {
        				g2.setColor(Color.BLACK);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 60));
	        			g2.drawString("Lamp", b.getObjX1()+50, b.getObjY1()+125);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        			} else {
        				g2.setColor(Color.GREEN);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
	        			g2.drawString(Integer.toString(lamp.getTimecode3()), b.getObjX1()+50, b.getObjY1()+125);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        			}
	        			
        		} 
        		else if(list.get(i).getObjDisplay().equals("RubikPoster")) { 
        			if(rubikPoster.isLookingAtPoster() == false) {
        				g2.setColor(Color.BLACK);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 60));
	        			g2.drawString("Rubik Poster", b.getObjX1()+50, b.getObjY1()+125);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        			} else {
        				g2.setColor(Color.CYAN);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
	        			g2.drawString(Integer.toString(rubikPoster.getTimecode4()), b.getObjX1()+50, b.getObjY1()+125);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        			}
    		}
    		} else if (playerLocation.getLocation() == -1) { // If the playerLocation has the player in the bottom floor
    			if(list.get(i).getObjDisplay().equals("BottomFloor")) { 
    				bottomFloorPaint.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
    			}
    			else if (list.get(i).getObjDisplay().equals("UpArrow")) { 
        			upArrow.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
        		} 
    			else if (list.get(i).getObjDisplay().equals("ExitSign")) {
    				if(exitSign.isLookingAtSign() == false) {
        				g2.setColor(Color.BLACK);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 60));
	        			g2.drawString("Exit Sign", b.getObjX1()+50, b.getObjY1()+50);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        			} else {
        				g2.setColor(Color.BLACK);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
	        			g2.drawString(Integer.toString(exitSign.getCombinationlockCode1()) + "-?-?", b.getObjX1()+50, b.getObjY1()+50);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        			}
        		}
    			else if (list.get(i).getObjDisplay().equals("Computer")) {
    				if(computer.isLookingAtComputer() == false) {
        				g2.setColor(Color.BLACK);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 60));
	        			g2.drawString("Computer", b.getObjX1()+50, b.getObjY1()+50);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        			} else {
        				g2.setColor(Color.BLACK);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
	        			g2.drawString("?-" + Integer.toString(computer.getCombinationlockCode2()) + "-?", b.getObjX1()+50, b.getObjY1()+50);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        			}
        		}
    			else if (list.get(i).getObjDisplay().equals("PaintCans")) {
    				if(paintCan.isLookingAtCans() == false) {
        				g2.setColor(Color.BLACK);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 60));
	        			g2.drawString("Paint Cans", b.getObjX1()+50, b.getObjY1()+50);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        			} else {
        				g2.setColor(Color.BLACK);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
	        			g2.drawString("?-?-" + Integer.toString(paintCan.getCombinationlockCode3()), b.getObjX1()+50, b.getObjY1()+50);
	        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        			}
        		} else if (list.get(i).getObjDisplay().equals("CombinationLock")) {
        			g2.setColor(Color.BLACK);
        			g2.setFont(new Font("Serif", Font.PLAIN, 60));
        			g2.drawString("CombinationLock", b.getObjX1()+50, b.getObjY1()+50);
        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        		}
    		} else if (playerLocation.getLocation() == 3) { // If the playerLocation has the player examining the ClockFace
    			if(list.get(i).getObjDisplay().equals("GrandFatherClockInput")) {
    				grandFatherClockPaint.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
    			} else if (list.get(i).getObjDisplay().equals("Back")) {
        			g2.setColor(b.getObjColor());
            		g2.fillRect(b.getObjX1(), b.getObjY1(), b.getObjX2()-b.getObjX1(), b.getObjY2()-b.getObjY1());
            		g2.setColor(Color.CYAN);
            		g2.drawRect(b.getObjX1()+2, b.getObjY1()+2, b.getObjX2()-b.getObjX1()-3, b.getObjY2()-b.getObjY1()-3);
            		g2.drawString(b.getObjDisplay(), b.getObjX1()+14, b.getObjY1()+34);
        		} else if (list.get(i).getObjDisplay().equals("Submit")) {
        			g2.setColor(b.getObjColor());
            		g2.fillRect(b.getObjX1(), b.getObjY1(), b.getObjX2()-b.getObjX1(), b.getObjY2()-b.getObjY1());
            		g2.setColor(Color.CYAN);
            		g2.drawRect(b.getObjX1()+2, b.getObjY1()+2, b.getObjX2()-b.getObjX1()-3, b.getObjY2()-b.getObjY1()-3);
            		g2.drawString(b.getObjDisplay(), b.getObjX1()+14, b.getObjY1()+34);
        		} else if (list.get(i).getObjDisplay().equals("Timecode1")) {
        			g2.setColor(Color.BLACK);
        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
        			g2.drawString(Integer.toString(grandFatherClockFace.getCurrentCode1()), 410, 675);
        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        		} else if (list.get(i).getObjDisplay().equals("Timecode2")) {
        			g2.setColor(Color.BLACK);
        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
        			g2.drawString(Integer.toString(grandFatherClockFace.getCurrentCode2()), 730, 675);
        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        		} else if (list.get(i).getObjDisplay().equals("Timecode3")) {
        			g2.setColor(Color.BLACK);
        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
        			g2.drawString(Integer.toString(grandFatherClockFace.getCurrentCode3()), 1130, 675);
        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        		} else if (list.get(i).getObjDisplay().equals("Timecode4")) {
        			g2.setColor(Color.BLACK);
        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
        			g2.drawString(Integer.toString(grandFatherClockFace.getCurrentCode4()), 1450, 675);
        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        		} else if(list.get(i).getObjDisplay().equals("Correct") && grandFatherClockFace.getIsCodeCorrect()) {
        			g2.setFont(new Font("Serif", Font.PLAIN, 120));
        			g2.setColor(Color.GREEN);
        			g2.drawString("CORRECT", b.getObjX1(), b.getObjY1()+190);
        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        		}
    		} else if (playerLocation.getLocation() == -3) { // If the PlayerLocation has the player examining the CombinationLock
    			if(list.get(i).getObjDisplay().equals("CombinationLockInput")) {
    				combinationLockPadPaint.imageDraw(g2, b.getObjDisplay(), b.getObjX1(), b.getObjY1());
    			} else if (list.get(i).getObjDisplay().equals("Back")) {
        			g2.setColor(b.getObjColor());
            		g2.fillRect(b.getObjX1(), b.getObjY1(), b.getObjX2()-b.getObjX1(), b.getObjY2()-b.getObjY1());
            		g2.setColor(Color.CYAN);
            		g2.drawRect(b.getObjX1()+2, b.getObjY1()+2, b.getObjX2()-b.getObjX1()-3, b.getObjY2()-b.getObjY1()-3);
            		g2.drawString(b.getObjDisplay(), b.getObjX1()+14, b.getObjY1()+34);
        		} else if (list.get(i).getObjDisplay().equals("Submit")) {
        			g2.setColor(b.getObjColor());
            		g2.fillRect(b.getObjX1(), b.getObjY1(), b.getObjX2()-b.getObjX1(), b.getObjY2()-b.getObjY1());
            		g2.setColor(Color.CYAN);
            		g2.drawRect(b.getObjX1()+2, b.getObjY1()+2, b.getObjX2()-b.getObjX1()-3, b.getObjY2()-b.getObjY1()-3);
            		g2.drawString(b.getObjDisplay(), b.getObjX1()+14, b.getObjY1()+34);
        		} else if (list.get(i).getObjDisplay().equals("code1")) {
        			g2.setColor(Color.BLACK);
        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
        			g2.drawString(Integer.toString(combinationLockPad.getCurrentCode1()), 500, 675);
        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        		} else if (list.get(i).getObjDisplay().equals("code2")) {
        			g2.setColor(Color.BLACK);
        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
        			g2.drawString(Integer.toString(combinationLockPad.getCurrentCode2()), 850, 675);
        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        		} else if (list.get(i).getObjDisplay().equals("code3")) {
        			g2.setColor(Color.BLACK);
        			g2.setFont(new Font("Serif", Font.PLAIN, 180));
        			g2.drawString(Integer.toString(combinationLockPad.getCurrentCode3()), 1200, 675);
        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        		} else if(list.get(i).getObjDisplay().equals("Correct") && combinationLockPad.getIsCodeCorrect()) {
        			g2.setFont(new Font("Serif", Font.PLAIN, 120));
        			g2.setColor(Color.GREEN);
        			g2.drawString("CORRECT", b.getObjX1(), b.getObjY1()+190);
        			g2.setFont(new Font("Serif", Font.PLAIN, 30));
        			g2.setColor(Color.black);
        			g2.drawString("Enter Into System prompt as X-X-X", 200, 900);
        			checkForWin = true;
        		} 
    		}
    		
    		if (list.get(i).getObjDisplay().equals("Quit")) {
    			g2.setColor(b.getObjColor());
        		g2.fillRect(b.getObjX1(), b.getObjY1(), b.getObjX2()-b.getObjX1(), b.getObjY2()-b.getObjY1());
        		g2.setColor(Color.CYAN);
        		g2.drawRect(b.getObjX1()+2, b.getObjY1()+2, b.getObjX2()-b.getObjX1()-3, b.getObjY2()-b.getObjY1()-3);
        		g2.drawString(b.getObjDisplay(), b.getObjX1()+14, b.getObjY1()+34);
    		}
		}
    		
	}
	
	// Quits the program
	public void quit() {
		System.exit(0);
	}
	
	public void win() {
		System.out.println("YOU WON!!!! Thanks for playing!");
		System.exit(0);
	}
	
	// Determines which ButtonObject the Player Clicked
	public ButtonObj whichClick(int clickx, int clicky) {
    	ButtonObj s;
    	for(int i = 0; i < list.size(); i++) {
    		s = list.get(i);
    		if((clickx > s.getObjX1() && clickx < s.getObjX2()) && (clicky > s.getObjY1() && clicky < s.getObjY2()) && playerLocation.getLocation() == s.getObjLocation()) {
    			return s;
    		}
    	}
    	return null;	
    }
	
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	// When a Click is detected, it runs this method, and where the click was detected at.
	public void mouseClicked(MouseEvent e) {
		if (whichClick(e.getX(), e.getY()) != null) {
			if(whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("Quit")) {
	        	quit();
	        } else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("UpArrow")) {
        		if(playerLocation.getLocation() == -1) {
        			playerLocation.changeLocation(0);
        		} else if (playerLocation.getLocation() == 0) {
        			playerLocation.changeLocation(1);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("DownArrow")) {
    			if(playerLocation.getLocation() == 1) {
        			playerLocation.changeLocation(0);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("ActualDownArrow")) {
    			if (playerLocation.getLocation() == 0 && grandFatherClockCompartment.getHasKey() == true) {
        			playerLocation.changeLocation(-1);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("brick") && playerLocation.getLocation() == 1) {
        		if(!mismatchedWall.getRemovedBrick()) {
        			mismatchedWall.setRemovedBrick(true);
        		} else {
        			System.out.println("The brick is just a mindset");
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("lamp") && playerLocation.getLocation() == 1) {
        		lamp.lookAtLamp();
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("RubikPoster") && playerLocation.getLocation() == 1) {
        		rubikPoster.lookAtPoster();
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("ExitSign") && playerLocation.getLocation() == -1) {
        		exitSign.lookAtSign();
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("Computer") && playerLocation.getLocation() == -1) {
        		computer.lookAtComputer();
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("PaintCans") && playerLocation.getLocation() == -1) {
        		paintCan.lookAtCans();
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("key") && mismatchedWall.getRemovedBrick() && playerLocation.getLocation() == 0) {
        		grandFatherClockCompartment.takeKey();        		
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("Clockface") && playerLocation.getLocation() == 0) {
        		playerLocation.changeLocation(3);
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("back") && playerLocation.getLocation() == 3) {
        		playerLocation.changeLocation(0);
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("TimeCode1Up") && playerLocation.getLocation() == 3) {
        		if(grandFatherClockFace.getCurrentCode1() == 0) {
        			grandFatherClockFace.setCurrentCode1(1);
        		} else if(grandFatherClockFace.getCurrentCode1() == 1) {
        			grandFatherClockFace.setCurrentCode1(0);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("TimeCode2Up") && playerLocation.getLocation() == 3) {
        		grandFatherClockFace.setCurrentCode2(grandFatherClockFace.getCurrentCode2() + 1);
        		if(grandFatherClockFace.getCurrentCode2() == 10) {
        			grandFatherClockFace.setCurrentCode2(0);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("TimeCode3Up") && playerLocation.getLocation() == 3) {
        		grandFatherClockFace.setCurrentCode3(grandFatherClockFace.getCurrentCode3() + 1);
        		if(grandFatherClockFace.getCurrentCode3() == 6) {
        			grandFatherClockFace.setCurrentCode3(0);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("TimeCode4Up") && playerLocation.getLocation() == 3) {
        		grandFatherClockFace.setCurrentCode4(grandFatherClockFace.getCurrentCode4() + 1);
        		if(grandFatherClockFace.getCurrentCode4() == 10) {
        			grandFatherClockFace.setCurrentCode4(0);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("TimeCode1Down") && playerLocation.getLocation() == 3) {
        		if(grandFatherClockFace.getCurrentCode1() == 0) {
        			grandFatherClockFace.setCurrentCode1(1);
        			
        		} else if(grandFatherClockFace.getCurrentCode1() == 1) {
        			grandFatherClockFace.setCurrentCode1(0);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("TimeCode2Down") && playerLocation.getLocation() == 3) {
        		grandFatherClockFace.setCurrentCode2(grandFatherClockFace.getCurrentCode2() - 1);
        		if(grandFatherClockFace.getCurrentCode2() == -1) {
        			grandFatherClockFace.setCurrentCode2(9);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("TimeCode3Down") && playerLocation.getLocation() == 3) {
        		grandFatherClockFace.setCurrentCode3(grandFatherClockFace.getCurrentCode3() - 1);
        		if(grandFatherClockFace.getCurrentCode3() == -1) {
        			grandFatherClockFace.setCurrentCode3(5);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("TimeCode4Down") && playerLocation.getLocation() == 3) {
        		grandFatherClockFace.setCurrentCode4(grandFatherClockFace.getCurrentCode4() - 1);
        		if(grandFatherClockFace.getCurrentCode4() == -1) {
        			grandFatherClockFace.setCurrentCode4(9);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("Submit") && playerLocation.getLocation() == 3) {
        		grandFatherClockFace.checkCode();
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("CombinationLock") && playerLocation.getLocation() == -1) {
        		playerLocation.changeLocation(-3);
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("Code1Up") && playerLocation.getLocation() == -3) {
        		combinationLockPad.setCurrentCode1(combinationLockPad.getCurrentCode1() + 1);
        		if(combinationLockPad.getCurrentCode1() == 10) {
        			combinationLockPad.setCurrentCode1(0);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("Code2Up") && playerLocation.getLocation() == -3) {
        		combinationLockPad.setCurrentCode2(combinationLockPad.getCurrentCode2() + 1);
        		if(combinationLockPad.getCurrentCode2() == 10) {
        			combinationLockPad.setCurrentCode2(0);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("Code3Up") && playerLocation.getLocation() == -3) {
        		combinationLockPad.setCurrentCode3(combinationLockPad.getCurrentCode3() + 1);
        		if(combinationLockPad.getCurrentCode3() == 10) {
        			combinationLockPad.setCurrentCode3(0);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("Code1Down") && playerLocation.getLocation() == -3) {
        		combinationLockPad.setCurrentCode1(combinationLockPad.getCurrentCode1() - 1);
        		if(combinationLockPad.getCurrentCode1() == -1) {
        			combinationLockPad.setCurrentCode1(9);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("Code2Down") && playerLocation.getLocation() == -3) {
        		combinationLockPad.setCurrentCode2(combinationLockPad.getCurrentCode2() - 1);
        		if(combinationLockPad.getCurrentCode2() == -1) {
        			combinationLockPad.setCurrentCode2(9);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("Code3Down") && playerLocation.getLocation() == -3) {
        		combinationLockPad.setCurrentCode3(combinationLockPad.getCurrentCode3() - 1);
        		if(combinationLockPad.getCurrentCode3() == -1) {
        			combinationLockPad.setCurrentCode3(9);
        		}
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("back") && playerLocation.getLocation() == -3) {
        		playerLocation.changeLocation(-1);
        	} else if (whichClick(e.getX(), e.getY()).getObjDisplay().equalsIgnoreCase("Submit") && playerLocation.getLocation() == -3) {
        		combinationLockPad.checkCode();
        	}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
	


}

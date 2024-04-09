package dndTracker;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.net.URL;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Body extends Component implements MouseListener, KeyListener{
        // TODO 
        // Create a Window Y
		// Window gives click option to "Add Enemy" Y
		// Click on Add Enemy, prompts for "Name", "Health", "Armor Class", and "How Many" Y
		// Depending on "How Many", create 'slots' Y
		// Show Name, Health, AC Y
		// Show Arrow to increase/Decrease Health Y 
		// Show cross to remove Y
		// Implement Adding Health, removing Health Y
		// Implement Removing [sorta]
		// MAYBE: Search for Enemy Name, add Image from Monster Manual 5th edition if daring.
		// TODO
		// Make it so numbers go "Creature -1", "Creature -2", "Creature -3", "Different Creature - 1", "Different Creature - 2"
		// When you clear a slot, make it so the images disappear.

	int size = 612;
    Color background = new Color(200, 200, 200);
    ArrayList <ButtonObj> 		list = new ArrayList <ButtonObj>();
    ArrayList <MonsterSheet> monster = new ArrayList <MonsterSheet>();
    
    public Body() {
        addMouseListener(this);
        addKeyListener(this);
        list.add(new ButtonObj("Create Enemy", 920, 430, 1120, 480, Color.CYAN));
        list.add(new ButtonObj("Clear All", 10, 430));
    }
    
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(background);
        g2.fillRect(0, 0, 1150, 525);
        g2.setColor(new Color (235, 235, 235));
        for(int x = 10; x < 1120; x += 160) {
        	for (int y = 10; y < 420; y += 210) {
        		g2.fillRect(x, y, 150, 200);
        	}
        }
        disButtons(g2);
        disEnemies(g2);
        repaint();
    }
    
    
    public void disButtons (Graphics2D g2) {
    	ButtonObj b;
    	g2.setFont(new Font("Serif", Font.PLAIN, 30));
    	g2.setStroke(new BasicStroke(3));
    	for(int i = 0; i < list.size(); i++) {
    		
    		b=list.get(i);
    		if(list.get(i).objdisplay.equals("DownArrow")) {
    			imageDraw(g2, "DownArrow", b.objx1, b.objy1);
    		} 
    		else if (list.get(i).objdisplay.equals("UpArrow")) { 
    			imageDraw(g2, "UpArrow",   b.objx1, b.objy1);
    		} 
    		else if (list.get(i).objdisplay.equals("Cross")) {
    			imageDraw(g2, "Cross",     b.objx1, b.objy1);
    		}
    		else if (list.get(i).objdisplay.equals("Clear All")) {
    			imageDraw(g2, "Cross",     b.objx1, b.objy1);
    			g2.drawString(b.objdisplay, b.objx1+40, b.objy1+30);
    		}else {
        		g2.setColor(b.objcolor);
        		g2.fillRect(b.objx1, b.objy1, b.objx2-b.objx1, b.objy2-b.objy1);
        		g2.setColor(Color.BLACK);
        		g2.drawRect(b.objx1+2, b.objy1+2, b.objx2-b.objx1-3, b.objy2-b.objy1-3);
        		g2.drawString(b.objdisplay, b.objx1+14, b.objy1+34);
    		}
    	}
    }
    
    public ButtonObj whichClick(int clickx, int clicky) {
    	ButtonObj s;
    	for(int i = 0; i < list.size(); i++) {
    		s = list.get(i);
    		if((clickx > s.objx1 && clickx < s.objx2) && (clicky > s.objy1 && clicky < s.objy2)) {
    			return s;
    		}
    	}
    	return null;	
    }
    
    public void createEnemy () {
    	int groupNumber = Integer.parseInt(JOptionPane.showInputDialog("How many enemies in the group?"));
    	if(monster.size() + groupNumber <= 14) {
    		String name 	= 	JOptionPane.showInputDialog("What is the Enemy's Name?");
        	int health 		= 	Integer.parseInt(JOptionPane.showInputDialog("What is the Enemy's Max Health?"));
        	int armorClass 	= 	Integer.parseInt(JOptionPane.showInputDialog("What is the Enemy's Armor Class?"));
        	for(int i = 0; i< groupNumber; i++) {
        		monster.add(new MonsterSheet(name, health, armorClass, i+1));
            	monster.get(monster.size()-1).setSlot(monster.size()-1);
            	int temp = monster.get(monster.size()-1).slot;
            	list.add(new ButtonObj("DownArrow", (160*(temp%7))+18, 	(210*(temp/7))+165));
            	list.add(new ButtonObj("UpArrow", 	(160*(temp%7))+63, 	(210*(temp/7))+165));
            	list.add(new ButtonObj("Cross", 	(160*(temp%7))+108, (210*(temp/7))+165));
        	}
    	}
    	
    }
    
    
    public void downPressed (int x, int y) {
    	int slotx = (x - 18) / 160;
    	int sloty = (y - 165) / 210;
    	slotPressed(slotx, sloty, "Down");
    }
    
    public void upPressed(int x, int y) {
    	int slotx = (x - 63) / 160;
    	int sloty = (y - 165) / 210;
    	slotPressed(slotx, sloty, "Up");
    }
    
    public void crossPressed(int x, int y) {
    	int slotx = (x - 108) / 160;
    	int sloty = (y - 165) / 210;
    	slotPressed(slotx, sloty, "Cross");
    }
    
    public void slotPressed(int x, int y, String n) {
    	int currentSlot = -1;
    	if(y == 1) { currentSlot += 7;}
    	for(int j = 0; j <= x; j++) {
    			currentSlot++;
    	}
    	System.out.println(currentSlot);
    	action(currentSlot, n);
    }
    
    public void action(int slot, String action) {
    	 if(action.equals("Up")) {
     		int temp = monster.get(slot).currentHealth;
     		temp++;
     		monster.get(slot).changeHealth(temp);
     	} else if ((monster.get(slot).currentHealth == 0)) {
    		int currentSlot = monster.size()-1;
    		list.remove(currentSlot*3+2);
    		list.remove(currentSlot*3+2);
    		list.remove(currentSlot*3+2);
    		monster.remove(slot);
    	} else if (action.equals("Down")) {
    		int temp = monster.get(slot).currentHealth;
    		temp--;
    		monster.get(slot).changeHealth(temp);
    	} else if (action.equals("Cross") && !(monster.get(slot).currentHealth == 0)) {
    		monster.get(slot).changeHealth(0);
    	} 
    }
    
   
    public void imageDraw(Graphics2D g2, String path, int x, int y) {
        BufferedImage img = null;
            try {
            	URL url = EnemyMain.class.getResource("/Images/" + path + ".png");
            	img = ImageIO.read(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        if(img != null) {
            g2.drawImage(img, x, y, null);
        }
    }
    
    public void disEnemies(Graphics2D g2) {
    	for(int temp = 0; temp < monster.size(); temp++) {
    		g2.drawRect((160*(temp%7))+10, (210*(temp/7))+10, 150, 200);
    		g2.drawString(monster.get(temp).name + " - " + (monster.get(temp).number), 					(160*(temp%7))+20, (210*(temp/7))+60);
    		if(monster.get(temp).currentHealth > monster.get(temp).maxHealth)
    			g2.setColor(Color.BLUE);
    		else if (monster.get(temp).currentHealth <= 0)
    			g2.setColor(Color.RED);
    		g2.drawString("HP: " + monster.get(temp).currentHealth + "/" + monster.get(temp).maxHealth, (160*(temp%7))+20, (210*(temp/7))+100);
    		g2.setColor(Color.BLACK);
    		g2.drawString("AC: " + monster.get(temp).armorClass, 										(160*(temp%7))+20, (210*(temp/7))+140);
    	}
    }
    
    
    
    public void keyTyped(KeyEvent e) {
       
        
    }

    
    public void keyPressed(KeyEvent e) {
        
        
    }

    public void keyReleased(KeyEvent e) {
        
        
    }

    public void mouseClicked(MouseEvent e) {
        
        if (whichClick(e.getX(), e.getY()) != null) {
        	if(whichClick(e.getX(), e.getY()).objdisplay.equalsIgnoreCase("Create Enemy")) {
        		createEnemy();
        	} else if (whichClick(e.getX(), e.getY()).objdisplay.equalsIgnoreCase("DownArrow")) {
        		System.out.println("Down pressed");
        		downPressed(e.getX(), e.getY());
        	} else if (whichClick(e.getX(), e.getY()).objdisplay.equalsIgnoreCase("UpArrow")) {
        		System.out.println("Up pressed");
        		upPressed(e.getX(), e.getY());
        	} else if (whichClick(e.getX(), e.getY()).objdisplay.equalsIgnoreCase("Cross")) {
        		System.out.println("Cross pressed");
        		crossPressed(e.getX(), e.getY());
        	} else if (whichClick(e.getX(), e.getY()).objdisplay.equalsIgnoreCase("Clear All")) {
        		System.out.println("Clear All choosen");
        		for(int temp = monster.size()-1; temp >= 0; temp--) {
        			monster.remove(temp);
            		list.remove(temp+2);
            		list.remove(temp+2);
            		list.remove(temp+2);
        		}
        	}


        } 
    }

    public void mousePressed(MouseEvent e) {
        
    }

    public void mouseReleased(MouseEvent e) {
        
        
    }

    public void mouseEntered(MouseEvent e) {
        
        
    }

    public void mouseExited(MouseEvent e) {
        
        
    }  
}
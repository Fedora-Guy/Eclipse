package ventureSmith;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyEvent;
import java.awt.Polygon;
import java.awt.BasicStroke;

public class MapManager {
	
	int counter = 0;
	int[] screen = {800, 600};
	int zoom = 3;
	int[] mouse = {0, 0};
	BufferedImage map = Custom.cropImage("map", 0, 0, screen[0], screen[1]);
//	BufferedImage zoomMap = Custom.cropImage("zoomMap", 0, 0, screen[0]*zoom, screen[1]*zoom);
	BufferedImage townGraphic = Custom.cropImage("town", 0, 0, 16, 16);
	Town[] towns = new Town[0];
	MapPoint[] points = new MapPoint[0];
	ArrayList<Polygon> borders = new ArrayList<Polygon>();
	BufferedImage[] biomeHighlight = new BufferedImage[6];
	MapPoint mouseOver = null;
	int[][] biomeZooms = {{100*zoom, 275*zoom}, {175*zoom, 200*zoom}, {300*zoom, 325*zoom}, {275*zoom, 125*zoom}, {50*zoom, 75*zoom}, {425*zoom, 350*zoom}};
	int[] zoomLoc;
	
	public MapManager() {
		for(int i = 0; i < biomeHighlight.length; i++)
			biomeHighlight[i] = Custom.cropImage("biome"+i, 0, 0, screen[0], screen[1]);
		startUp();
	}
	
	public void paint(Graphics2D g2, int[] state) {
		counter = (counter+1)%120;
		if(state[1] == 0) {
			g2.drawImage(map, 0, 0, screen[0], screen[1], null);
			for(int i = 0; i < borders.size(); i++) {
				if(borders.get(i).contains(mouse[0], mouse[1])) {
					g2.drawImage(biomeHighlight[i], 0, 0, null);
				}
			}
		} else if(state[1] == 1) {
			g2.translate(-zoomLoc[0], -zoomLoc[1]);
			g2.drawImage(map, 0, 0, screen[0]*zoom, screen[1]*zoom, null);
			g2.setColor(new Color(255, 127, 0));
			MapPoint[] list = new MapPoint[towns.length+points.length];
			int g = 0;
			while(g < towns.length+points.length) {
				while(g < towns.length) {
					list[g] = towns[g];
					g++;
				}
				list[g] = points[g-towns.length];
				g++;
			}
			for(int i = 0; i < list.length; i++) {
				for(int k = 0; k < list[i].links.length; k++) {
					if(list[i].linkLevel[k] == 0)
						g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[] {6, 6}, 0));
					else
						g2.setStroke(new BasicStroke((list[i].linkLevel[k]-1)*2+1));
					g2.drawLine(list[i].loc[0], list[i].loc[1], list[i].links[k].loc[0], list[i].links[k].loc[1]);
				}
			}
			for(int i = 0; i < towns.length; i++)
				g2.drawImage(townGraphic, towns[i].loc[0]-8, towns[i].loc[1]-8, null);
			for(int i = 0; i < points.length; i++)
				g2.fillOval(points[i].loc[0]-6, points[i].loc[1]-6, 12, 12);
			
			if(mouseOver != null) {
				g2.setStroke(new BasicStroke(1));
				g2.setColor(Color.red);
				g2.translate(mouseOver.loc[0], mouseOver.loc[1]);
				g2.rotate((((double) counter)/120)*Math.PI);
				g2.drawRect(-12, -12, 24, 24);
				g2.rotate(-((15+(double) counter)/120)*Math.PI*2);
				g2.drawRect(-12, -12, 24, 24);
				g2.rotate(((30+(double) counter)/120)*Math.PI);
				g2.translate(-mouseOver.loc[0], -mouseOver.loc[1]);
			}
			
			g2.translate(zoomLoc[0], zoomLoc[1]);
		}
	}
	
	public void startUp() {
		ArrayList<MapPoint> tempPts = new ArrayList<MapPoint>();
		String[] read = Custom.readFile("mapLayout");
		for(int i = 0; i < read.length; i++) {
			switch(read[i].substring(0, 1)) {
			case("b"):
				int[] temp0 = new int[read[i].split(":").length/2];
				int[] temp1 = new int[read[i].split(":").length/2];
				for(int k = 1; k < read[i].split(":").length; k+=2) {
					temp0[k/2] = Integer.valueOf(read[i].split(":")[k]);
					temp1[(k-1)/2] = Integer.valueOf(read[i].split(":")[k+1]);
				}
				borders.add(new Polygon(temp0, temp1, temp0.length));
				break;
			case("t"):
				tempPts.add(new Town(new int[] {Integer.valueOf(read[i].split(":")[2]), Integer.valueOf(read[i].split(":")[3])}, read[i].split(":")[1]));
				break;
			case("p"):
				tempPts.add(new MapPoint(new int[] {Integer.valueOf(read[i].split(":")[2]), Integer.valueOf(read[i].split(":")[3])}, read[i].split(":")[1]));
				break;
			case("l"):
				for(int k = 0; k < tempPts.size(); k++)
					if(tempPts.get(k).name.equals(read[i].split(":")[1]))
						for(int j = 0; j < tempPts.size(); j++)
							if(tempPts.get(j).name.equals(read[i].split(":")[2])) {
								tempPts.get(k).addLink(tempPts.get(j), true);
								break;
							}
				break;
			case("u"):
				for(int k = 0; k < tempPts.size(); k++)
					if(tempPts.get(k).name.equals(read[i].split(":")[1]))
						for(int j = 0; j < tempPts.size(); j++)
							if(tempPts.get(j).name.equals(read[i].split(":")[2])) {
								tempPts.get(k).upgradeLink(tempPts.get(j), true);
								break;
							}
				break;
			}
		}
		for(int i = 0; i < tempPts.size(); i++) {
			if(tempPts.get(i).checkType().equals("Town")) {
				Town[] temp = new Town[towns.length+1];
				for(int k = 0; k < towns.length; k++)
					temp[k] = towns[k];
				temp[temp.length-1] = (Town) tempPts.get(i);
				towns = temp;
			} else if(tempPts.get(i).checkType().equals("MapPoint")) {
				MapPoint[] temp = new MapPoint[points.length+1];
				for(int k = 0; k < points.length; k++)
					temp[k] = points[k];
				temp[temp.length-1] = tempPts.get(i);
				points = temp;
			}
		}
	}
	
	public void tooFar() {
		if(zoomLoc[0] < 0)
			zoomLoc[0] = 0;
		else if(zoomLoc[0] > (zoom-1)*screen[0])
			zoomLoc[0] = (zoom-1)*screen[0];
		if(zoomLoc[1] < 0)
			zoomLoc[1] = 0;
		else if(zoomLoc[1] > (zoom-1)*screen[1])
			zoomLoc[1] = (zoom-1)*screen[1];
	}
	
	public void mouseInputs(MouseEvent e, Body body) {
		switch(e.getButton()) {
		case(1):
			switch(e.getClickCount()) {
			case(1):
				if(body.state[1] == 0) {
					for(int i = 0; i < borders.size(); i++)
						if(borders.get(i).contains(mouse[0], mouse[1])) {
							body.addAnimation(new Aesthetic(true, 32, "screenTransition", new Object[] {"changeState[1]", 1}));
							zoomLoc = biomeZooms[i];
						}
				}
				if(body.state[0] == 1 && body.state[1] == 1) {
					System.out.print(e.getX()+zoomLoc[0] + ", ");
					System.out.println(e.getY()+zoomLoc[1]);
				}
				break;
			case(2):
				body.addAnimation(new Aesthetic(true, 32, "screenTransition", new Object[] {"changeState[0]", 2}));
				break;
			}
			break;
		case(3):
			if(body.state[0] == 1 && body.state[1] == 1)
				body.addAnimation(new Aesthetic(true, 32, "screenTransition", new Object[] {"changeState[1]", 0}));
			break;
		}
	}
	
	public void mouseMoveInputs(MouseEvent e, Body body, int[] mouse) {
		this.mouse[0] = mouse[0];
		this.mouse[1] = mouse[1];
		if(body.state[0] == 1 && body.state[1] == 1) {
			ArrayList<MapPoint> temp = new ArrayList<MapPoint>();
			for(int i = 0; i < towns.length; i++)
				temp.add(towns[i]);
			for(int i = 0; i < points.length; i++)
				temp.add(points[i]);
			for(int i = 0; i < temp.size(); i++)
				if(Math.sqrt(Math.pow(mouse[0]-temp.get(i).loc[0]+zoomLoc[0], 2) + Math.pow(mouse[1]-temp.get(i).loc[1]+zoomLoc[1], 2)) < 10) {
					mouseOver = temp.get(i);
					return;
				}
			mouseOver = null;
		}
	}
	
	public void mouseWheelInputs(MouseWheelEvent e, Body body) {
		if(body.state[1] == 1) {
			switch(e.getModifiersEx()) {
			case(0):
				zoomLoc[1] += e.getWheelRotation()*25;
				break;
			case(64):
				zoomLoc[0] += e.getWheelRotation()*25;
				break;
			}
			tooFar();
		}
	}
	
	public void keyInputs(KeyEvent e, Body body) {
		if(body.state[1] == 1) {
			switch(e.getKeyCode()) {
			case(87):
				zoomLoc[1] -= 25;
				break;
			case(83):
				zoomLoc[1] += 25;
				break;
			case(65):
				zoomLoc[0] -= 25;
				break;
			case(68):
				zoomLoc[0] += 25;
				break;
			}
			tooFar();
		}
	}
	
}

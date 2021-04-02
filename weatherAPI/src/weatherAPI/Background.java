package weatherAPI;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import com.sun.source.tree.Tree;

public class Background {
	
	Color soilColor;
	Color waterColor;
	ImageIcon tree = new ImageIcon("tree.png");
	ImageIcon clouds = new ImageIcon("clouds.png");
	ImageIcon house = new ImageIcon("house.png");
	ImageIcon mountain = new ImageIcon("mountain.png");
	ImageIcon water = new ImageIcon("water.png");
	
	double temperature;
	
	public Background() {
		// TODO Auto-generated constructor stub
		soilColor = new Color(227, 217, 181);
		waterColor = new Color(13, 153, 251);
		temperature= 0;
		
	}
	
	public void draw(Graphics2D g, int w, int h) {
		// this is the soil
		g.setColor(soilColor);
		g.fillRect(0, (int) (h*.3), w,(int) (h*.80));
		
		// draw the waters
//		g.setColor(waterColor);
//		g.fillRect(0,(int) (h*.5) , w, (int) (h*.2));
		water.paintIcon(null, g, 0, (int) (h*.3));
		
		

		
		mountain.paintIcon(null, g, 0, (int) (h*.01));

		tree.paintIcon(null, g, (int) (w*.01), (int) (h*.2));
		clouds.paintIcon(null, g, (int) (w*.01), (int) (h*.02));

		house.paintIcon(null, g, (int) (w*.5), (int) (h*.4));



		
		
		
	}
	
	public void setTemp(int temp) {
		
	}
	
	public void setClouds(String cloud) {
		
	}
	
	public void setHumidity(int hum) {
		
	}

}
 	
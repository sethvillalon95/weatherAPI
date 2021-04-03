package weatherAPI;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import com.sun.source.tree.Tree;

public class Background {
	
	Color sandColor;
	Color waterColor;
	Color cloudBG;
	Color grassColor;
	private boolean isCloudy = false;
	private boolean isScatteredCloudy = false;
	private boolean isRaining = false;

	
	
	
	ImageIcon tree = new ImageIcon("tree.png");
	ImageIcon clouds; 
	ImageIcon house; 
	ImageIcon mountain = new ImageIcon("mountain.png");
	ImageIcon water = new ImageIcon("water.png");
	ImageIcon bush;
	ImageIcon bush1;

	
	double temperature;
	
	public Background() {
		// TODO Auto-generated constructor stub
		sandColor = new Color(227, 217, 181);
		waterColor = new Color(13, 153, 251);
		cloudBG = new Color(135, 206, 255);
		grassColor = new Color(105, 190, 69);
		temperature= 0;
		

		
	}
	
	public void draw(Graphics2D g, int w, int h) {
		// this is the soil
		g.setColor(cloudBG);
		g.fillRect(0, 0, w, (int) (w*.2));
		
		// sand
		g.setColor(sandColor);
		g.fillRect(0, (int) (w*.2), w, (int) (w*.2));

		
		g.setColor(grassColor);
		g.fillRect(0, (int) (h*.5), w,(int) (h*.80));
		
		// draw the waters
//		g.setColor(waterColor);
//		g.fillRect(0,(int) (h*.5) , w, (int) (h*.2));
		water.paintIcon(null, g, 0, (int) (h*.3));
		
		

		
		mountain.paintIcon(null, g, 0, (int) (h*.01));
		
		bush1.paintIcon(null, g, -210, (int) (h*.65));
		bush1.paintIcon(null, g, (int)(w*.1), (int) (h*.65));
		bush1.paintIcon(null, g, (int)(w*.65), (int) (h*.65));


		tree.paintIcon(null, g, (int) (w*.01), (int) (h*.3));
		
		clouds.paintIcon(null, g, (int) (w*.01), (int) (h*.02));
		
		if(isScatteredCloudy) {
			clouds.paintIcon(null, g, (int) (w*.5), (int) (h*.02));

		}
		
		if(isRaining) {
			int x = 300;
			for(int i = 0; i<6;i++) {
				clouds.paintIcon(null, g, (int) (w*.01)+x, (int) (h*.02));
				x+=200;
			}
			isRaining = false;
		}
		
		if(isCloudy) {
			int x = 300;
			for(int i = 0; i<6;i++) {
				clouds.paintIcon(null, g, (int) (w*.01)+x, (int) (h*.02));
				x+=200;
			}
			isCloudy = false;
		}

		house.paintIcon(null, g, (int) (w*.5), (int) (h*.4));
		
		bush.paintIcon(null, g, (int) (w*.4), (int) (h*.6));
		bush.paintIcon(null, g, (int) (w*.6), (int) (h*.6));

		
	}
	
	public void setTemp(double temp) {
		String fileName = "";
		if(temp<20) {
			// cold
			fileName = "coldhouse.png";
			
		}else if(temp<25) {
			//ok
			fileName = "house.png";
		}else if(temp>25) {
			// hot
			fileName = "hothouse.png";
		}else {
			// ok 
			fileName = "house.png";
		}
		house = new ImageIcon(fileName);
	}
	
	public void setClouds(String cloud) {
		// switch is better
		String cloudName = "";

		if(cloud.contains("rain")) {
			// show pic of raining clouds
			cloudName = "rain.png";
			isRaining = true;
		}else if(cloud.contains("clear")) {
			// no clouds
			cloudName ="";
		}else if(cloud.contains("scattered")) {
			// only 4 clouds 
			isScatteredCloudy = true;
			cloudName  ="whiteclouds.png";
			
		}else if(cloud.contains("dark")) {
			// show blue clouds
		}else if(cloud.contains("cloudy")) {
			// draw many clouds
			isCloudy = true;
			cloudName  ="whiteclouds.png";

		}else {
			// default
			cloudName  ="whiteclouds.png";
		}
		clouds = new ImageIcon(cloudName);

		
	}
	
	public void setWind(double windSpeed) {
		String fileName = "";
		String fileName1 ="";
		
		if(windSpeed>50) {
			// no flowers
			fileName = "noflowerbush.png";
			fileName1 ="noFlowerbushBig.png";

			
		}else {
			// 
			fileName = "bush.png";
			fileName1 ="bushBig.png";

		}
		 bush = new ImageIcon(fileName);
		 bush1 = new ImageIcon(fileName1);
		
	}

}
 	
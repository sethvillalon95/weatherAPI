package weatherAPI;

import java.awt.Color;
import java.awt.Graphics2D;

public class Background {
	
	Color soilColor;
	Color waterColor;
	
	public Background() {
		// TODO Auto-generated constructor stub
		soilColor = new Color(227, 217, 181);
		waterColor = new Color(13, 153, 251);
	}
	
	public void draw(Graphics2D g, int w, int h) {
		// this is the soil
		g.setColor(soilColor);
		g.fillRect(0, (int) (h*.7), w,(int) (h*.75));
		
		// draw the water
		g.setColor(waterColor);
		g.fillRect(0,(int) (h*.5) , w, (int) (h*.2));
		
		
		
	}

}

package weatherAPI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Vis extends JPanel {
	Background bg = new Background();
	String cloudName;
	double temperature;
	double windSpeed;

    public Vis() {
        super();
		cloudName = "";
		temperature = 0;
		windSpeed = 0;

        
    }




    @Override
    public void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D)g1;
        int h= getHeight();
        int w = getWidth();
        int x=0, y =0;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        bg.setClouds(cloudName);
        bg.setTemp(temperature);
        bg.setWind(temperature);
        bg.draw(g, w, h);
               
    }
	public void setTemp(double temperature2) {
		temperature = temperature2;
		
	}
	
	public void setClouds(String cloud) {
		cloudName = cloud;
		
	}
	
	public void setWind(double spd) {
		windSpeed = spd;
		
	}
    
    

    



//****************************
}
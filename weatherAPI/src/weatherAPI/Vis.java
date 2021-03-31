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

import javax.swing.JPanel;

public class Vis extends JPanel {
	Background bg = new Background();

    public Vis() {
        super();
        
    }




    @Override
    public void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D)g1;
        int h= getHeight();
        int w = getWidth();
        int x=0, y =0;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        bg.draw(g, w, h);
        
             
        
       

    }
    
    

    



//****************************
}
package weatherAPI;
import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JFrame;

import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.google.*;
import com.google.gson.Gson;
import com.google.gson.reflect.*;

public class Main extends JFrame{
    private Vis mainPanel;

	
	public Main() {
		fetchData();
        mainPanel = new Vis();
        setContentPane(mainPanel);

        setSize(1000,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Seth's Data Visualization");
        setVisible(true);

		say("done fetchin data");
		
	}
	
	public void fetchData() {

		String API_KEY= APIKEY.get();
		String LOCATION ="Honolulu";
		String urlString = "https://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+API_KEY+"&units=metric";
		
		try {
			StringBuilder result = new StringBuilder();
			URL url = new URL(urlString);
			URLConnection conn= url.openConnection();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = rd.readLine())!=null) {
				result.append(line);
			}
			rd.close();
			say(result);
			
			Map<String, Object> respMap = jsonToMap(result.toString());
			Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
			
			say("Current temp: " + mainMap.get("temp"));

			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Map<String, Object> jsonToMap(String str){
		Map<String, Object> map = new Gson().fromJson(str,new TypeToken<HashMap<String, Object>>(){}.getType());
		return map;
	}
	public static void say(Object o) {
		System.out.println(o);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new Main();
	            }
	        });
	}

}

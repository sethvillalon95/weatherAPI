package weatherAPI;
import java.io.BufferedReader;
import java.io.IOException;

import javax.swing.JFrame;

import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.*;
import com.google.gson.Gson;
import com.google.gson.reflect.*;

public class Main extends JFrame{
    private Vis mainPanel;

	
	public Main() {
        mainPanel = new Vis();

        setContentPane(mainPanel);
        fetchData();

        setSize(1920,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Seth's Info Canvas Protype");
        setVisible(true);


		
	}
	
	public void fetchData() {

		String API_KEY= APIKEY.get();
		String LOCATION ="Laie";
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
			Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
			
			
			// getting the clouds or general weather
			String genWeather = respMap.get("weather").toString();
			mainPanel.setClouds(genWeather);



			// setting the temperature
			String dummy = mainMap.get("temp").toString();
			double temperature =Double.parseDouble(dummy);
			mainPanel.setTemp(26);
			
			String wind = windMap.get("speed").toString();
			mainPanel.setWind(Double.parseDouble(wind));
			
			
//			say(mainMap.get("humidity"));
//			say(mainMap.get("description"));


			
			
			
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

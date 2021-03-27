package weatherAPI;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.*;
import com.google.gson.Gson;
import com.google.gson.reflect.*;
public class Main {
	
	
	
	public static Map<String, Object> jsonToMap(String str){
		Map<String, Object> map = new Gson().fromJson(str,new TypeToken<HashMap<String, Object>>(){}.getType());
		return map;
	}
	public static void say(Object o) {
		System.out.println(o);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String API_KEY= "c382f83d09cb0dde54d4d2bb3e5121a5";
		String LOCATION ="Honolulu";
		String urlString = "api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+API_KEY+"&units=metric";
		
		try {
			URL url = new URL(API_KEY);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
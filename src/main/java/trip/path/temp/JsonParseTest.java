package trip.path.temp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonParseTest {

    public static void main(String ar[]) throws Exception{
        
    	
    	
        System.out.println(JsonText("신촌역","새절역"));
        String str=JsonText("서울역","강남역");
        
        
        String[] arr=str.split("value");
        System.out.println(arr[1].substring(arr[1].indexOf(":")+1,arr[1].indexOf("}")));
        System.out.println(arr[2].substring(arr[2].indexOf(":")+1,arr[2].indexOf("}")));
        
        
        String[] rr=new String[4];
        rr[0]="11";
        for(int i=0;i<=arr.length;i++) {
        	System.out.println(rr[i]);
        	if(rr[i]==null) {
        		break;
        	}
        	
        }
        

    }
    
    public static String JsonText(String start, String end) throws Exception {
    	String url = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&mode=transit&origins="+start+"&destinations="+end+"&region=KR&key=AIzaSyAv6HTx3FBJL21cr_hY6iH9EA6o19Q16No";
        JSONObject json = readJsonFromUrl(url);
		return json.toString();
    }

    private static String jsonReadAll(Reader reader) throws IOException{
        StringBuilder sb = new StringBuilder();

        int cp;
        while((cp = reader.read()) != -1){
            sb.append((char) cp);
        }

        return sb.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException{
        InputStream is = new URL(url).openStream();

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = jsonReadAll(br);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }
}

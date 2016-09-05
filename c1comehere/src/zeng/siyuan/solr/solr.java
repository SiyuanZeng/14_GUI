package zeng.siyuan.solr;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by SiyuanZeng's on 9/4/2016.
 */

public class solr {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {
        solr http = new solr();
        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet("");
    }

    public List<String> sendGet(String types) throws Exception {
        String url1 = "http://localhost:8983/solr/jcg/select?q=name:a&wt=json";
        String url22 = "http://localhost:8983/solr/jcg/select?q=name:%22"+types+"%22OR%20name_ngram:%22"+types+"%22&wt=json";


        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet getRequest = new HttpGet(
                    url22);
            getRequest.addHeader("accept", "application/json");

            HttpResponse response = httpClient.execute(getRequest);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            String str = "";
            while ((output = br.readLine()) != null) {
                str += output;
            }

            List<String> list = new ArrayList<String>();

            JSONObject json = new JSONObject(str);
            JSONArray jsonArray = json.getJSONObject("response").getJSONArray("docs");
            for (int i = 0, size = jsonArray.length(); i < size; i++) {
                JSONObject objectInArray = jsonArray.getJSONObject(i);
                list.add(objectInArray.getString("name"));
            }
            System.out.println(list);
            httpClient.getConnectionManager().shutdown();
            return list;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

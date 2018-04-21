/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Question {
    
    private final String questionType;
    private final String questionNumber;
    private final String question;
    
    private String questionUpdated;
    
    private ArrayList<String> domain;
    
    private ArrayList<JSONArray> queryResultArr;
    
    private JSONObject resultJSON;
    
    public Question(String questionType, String questionNumber, String question){
        this.questionType = questionType;
        this.questionNumber = questionNumber;
        this.question = question;
        
        this.questionUpdated = question;
        this.questionUpdated = this.questionUpdated.replaceAll(" ", "%20");
        
        domain = new ArrayList<>();
        queryResultArr = new ArrayList<>();
        
        resultJSON = new JSONObject();
    }
    
    @Override
    public String toString(){
        return "" + this.questionNumber + "." + this.question;
    }
    
    public ArrayList<String> getDomain(){
        return this.domain;
    }
    
    public ArrayList<JSONArray> getQueryResultsArray(){
        return this.queryResultArr;
    }
    
    public JSONObject getResultJSON(){
        return this.resultJSON;
    }
    
    public void addPossibleAnswer(String keyword){
        this.domain.add(keyword);
    }
    
    public void addQueryResults(JSONArray res){
        this.queryResultArr.add(res);
    }
     
    public void query(String key, String cx){
        JSONObject result;
        JSONParser jsonParser = new JSONParser();
        JSONArray items = null;
        
        String urlBind = "https://www.googleapis.com/customsearch/v1?key="+key+ "&cx="+ cx + "&" + "q=" + this.questionUpdated + "&alt=json";
        
        System.out.println(urlBind);
        
        try
        {
            URL url = new URL(urlBind);
           
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            output = "";
            
            String line;
            
            //Might need to change what we receive from output with jSON.
            
            while ((line = br.readLine()) != null) {
                output += line + "\n";
            }
            
            //System.out.println("Output: " + output);
            
            Object res = jsonParser.parse(output);
            result = (JSONObject) res;
                       
            items = (JSONArray) result.get("items");
            
            //System.out.println(items);
            
            conn.disconnect();
            
            this.addQueryResults(items);
            
            //Bunu file a yazabiliriz
            this.resultJSON.put(this.questionType + " " + this.questionNumber, items);
        }
        catch(IOException | ParseException ex)
        {
            System.out.println("are you here");
            ex.printStackTrace();
        }
        
        ArrayList<String> htmlLinks = new ArrayList<>();
        JSONArray arr;
        JSONObject linkObj;
        String link;
        
        Iterator iterator = items.iterator();
        
        while(iterator.hasNext()){
            Object obj = iterator.next();
            linkObj = (JSONObject) obj;
            link = (String) linkObj.get("link");
            htmlLinks.add(link);
        }
        
        System.out.println(htmlLinks);
    }
    
}

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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Question {
    
    private final String questionType;
    private final String questionNumber;
    private final String question;
    
    private String questionUpdated;
    
    private ArrayList<String> domain;
    
    private ArrayList<String> frequencyDomain;
    
    public ArrayList<Integer> gridIDsOfQuestion;
    
    private ArrayList<JSONArray> queryResultArr;
    
    private JSONObject resultJSON;
    
    private int clueLength;
    
    public Question(String questionType, String questionNumber, String question){
        this.questionType = questionType;
        this.questionNumber = questionNumber;
        this.question = question;
        
        this.questionUpdated = question;
        this.questionUpdated = this.questionUpdated.replaceAll(" ", "%20");
        
        domain = new ArrayList<>();
        queryResultArr = new ArrayList<>();
        gridIDsOfQuestion = new ArrayList<>();
        frequencyDomain = new ArrayList<>();
        
        resultJSON = new JSONObject();
    }
    
    public String getQuestionNumber(){
        return this.questionNumber;
    }
    
    public String getQuestion(){
        return this.question;
    }
    
    public String getQuestionType(){
        return this.questionType;
    }
    
    public void setQuestionClueLength(int clueLength){
        this.clueLength = clueLength;
    }
    
    public int getQuestionClueLength(){
        return this.clueLength;
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
        ArrayList<String> htmlLinks = new ArrayList<>();
        
        JSONObject objProp = new JSONObject();
        
        JSONArray arr;
        JSONObject linkObj;
        String link;
        
        Iterator iterator;
        
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
            this.resultJSON.put(this.questionType + " " + this.questionNumber, objProp);  
        }
        catch(IOException | ParseException ex)
        {
            System.out.println("are you here");
            ex.printStackTrace();
        }
        
        iterator = items.iterator();
            
        while(iterator.hasNext()){
            Object obj = iterator.next();
            linkObj = (JSONObject) obj;
            link = (String) linkObj.get("link");
            htmlLinks.add(link);
        }
        
        System.out.println(htmlLinks);
        
        try {
            retrieveWordsInTheHTMLs(htmlLinks);
        } catch (IOException ex) {
            Logger.getLogger(Question.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void retrieveWordsInTheHTMLs(ArrayList<String> htmlLinks) throws IOException {
        
        int size = htmlLinks.size();
        
        Document[] htmlDocs = new Document[size];
        String[] htmlTexts = new String[size];
        
        for(int i = 0; i < size; i++){
            if(!htmlLinks.get(i).contains("wikipedia")){
                htmlDocs[i] = Jsoup.connect(htmlLinks.get(i)).get();
                
                //it may or may not work with this (Probably works)
                htmlTexts[i] = Jsoup.parse(htmlDocs[i].toString()).text();
                //htmlTexts[i] = htmlDocs[i].toString().replaceAll("<>", question);
                
                //Reference: https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
                String[] parts = htmlTexts[i].split("\\s+");
                
                for(int j = 0; j < parts.length; j++){
                    this.domain.add(parts[j]);
                }
            }
        }
        
        processTheDomain();
        
        /*
        System.out.println("----------------------");
        System.out.println(htmlTexts[0]);
        System.out.println("----------------------");
        */
    }

    private void processTheDomain() {
        
        int clueL = this.getQuestionClueLength();
        int size = this.domain.size();
              
        String word;
        
        for(int i = 0; i < size; i++){
            word = this.domain.get(i);
            if(word.length() - 1 == clueL){
                //if the last character is 's', remove it the add it to the domain list
                if(word.charAt(word.length() -1) == 's'){
                    this.domain.remove(i);
                    this.domain.add(word.substring(0, word.length() - 1));
                }
                else{
                    this.domain.remove(i);
                }
            }
            else if(word.length() + 1 == clueL){
                //if the last character is not 's', put a 's' and add it to the domain list
                if(word.charAt(word.length()-1) != 's'){
                    this.domain.remove(i);
                    String newWord = word + "s";
                    this.domain.add(newWord);
                }
                else{
                    this.domain.remove(i);
                }
            }
            else if(word.length() > clueL){
                this.domain.remove(i);
            }
            else if(clueL > word.length()){
                this.domain.remove(i);
            }
        }
        
        findFrequencies();
    }   
    
    public void setGridIDS(ArrayList<Integer> ids)
    {
        for(int i = 0; i < ids.size(); i++ )
        {
           this.gridIDsOfQuestion.set(i, ids.get(i));
        }
        
    }
    
    private void findFrequencies() {
        int size = this.domain.size();
        
        
    }
}

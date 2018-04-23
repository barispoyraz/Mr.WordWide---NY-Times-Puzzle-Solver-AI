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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
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
    private HashMap<String, Integer> frequencyDomain;
    
    public HashMap<Integer, Integer> gridIDsOfQuestion;
    
    private ArrayList<JSONArray> queryResultArr;
    
    private JSONObject resultJSON;
      
    private int clueLength;
    
    private ArrayList<String> googleFriendly;
    
    public Question(String questionType, String questionNumber, String question){
        this.questionType = questionType;
        this.questionNumber = questionNumber;
        this.question = question;
        
        this.questionUpdated = question;
        this.questionUpdated = this.questionUpdated.replaceAll(" ", "%20");
        
        domain = new ArrayList<>();
        queryResultArr = new ArrayList<>();
        gridIDsOfQuestion = new HashMap<>();
        frequencyDomain = new HashMap<>();
        
        this.googleFriendly = new ArrayList<>();
        
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
    public HashMap<String, Integer> getFrequencyDomain()
    {
        return this.frequencyDomain;
    }
    public void setQuestionClueLength(int clueLength){
        this.clueLength = clueLength;
    }
    
    public int getQuestionClueLength(){
        return this.clueLength;
    }
    
    public void setQuestionGridIDs(HashMap<Integer, Integer> ids){
        this.gridIDsOfQuestion = ids;
    }
    
    public HashMap<Integer, Integer> getQuestionGridIds(){
        return this.gridIDsOfQuestion;
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
    
    public void setGoogleFriendly(ArrayList<String> googleFriendly){
        this.googleFriendly = googleFriendly;
    }
    
    public ArrayList<String> getGoogleFriendly(){
        return this.googleFriendly;
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
        
        String urlBind = "https://www.googleapis.com/customsearch/v1?key="+key+ "&cx="+ cx + "&" + "q=" + this.questionUpdated + "&alt=json&lr=lang_en";
        
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
                htmlTexts[i] = htmlTexts[i].replaceAll("[^\\=-w\\s]", "");
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
    
    public void findFrequencies() {
        String added_words = "";
        int frequency;
        int domainSize = this.domain.size();
        
        //Program is case insensitive.
        for(int i = 0; i < domainSize; i++)
        {
            this.domain.set(i,this.domain.get(i).toLowerCase() );
        }
        
        for(int i = 0; i < domainSize; i++)
        {   
            String keyword = this.domain.get(i);
            if(!added_words.contains(keyword))
            {
                added_words += keyword + " ";
                frequency = Collections.frequency(this.domain, keyword);
                frequencyDomain.put(keyword, frequency);
            }
        }
        sortFrequencyDomain(frequencyDomain);
//        for ( String keyword : frequencyDomain.keySet() ) {
//             System.out.println( keyword + ": " + frequencyDomain.get(keyword) + " times." );
//        }
    }
    
    private void sortFrequencyDomain(HashMap<String, Integer> freqs)
    {
        List<Entry<String, Integer>> list;
        list = new LinkedList<>(freqs.entrySet());
        
//        Collections.sort(list, new Comparator<Entry<String, Integer>>()
//        {
//            @Override
//            public int compare(Entry<String, Integer> o1,
//                    Entry<String, Integer> o2)
//            {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//                
//        });
//        Below is the lambda version! DO NOT DELETE THE ABOVE CODE SEGMENT FOR READABILITY!
        
        Collections.sort(list, (Entry<String, Integer> o1, Entry<String, Integer> o2) -> o2.getValue().compareTo(o1.getValue()));
        
        frequencyDomain = new LinkedHashMap<>();
        for (Entry<String, Integer> entry : list)
        {
            frequencyDomain.put(entry.getKey(), entry.getValue());
        }

    }
}

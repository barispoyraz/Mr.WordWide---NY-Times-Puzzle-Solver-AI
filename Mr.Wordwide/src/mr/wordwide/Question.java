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
import java.util.Locale;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;

public class Question {
    
    private final String questionType;
    private final String questionNumber;
    private final String question;
    
    private String questionUpdated;
    
    private ArrayList<String> domain;
    private ArrayList<String> newDomain;
    private HashMap<String, Integer> frequencyDomain;
    private HashMap<String, Integer> tempFrequencyDomain;
    
    public HashMap<Integer, Integer> gridIDsOfQuestion;
    
    private ArrayList<JSONArray> queryResultArr;
    
    private String answer;
    
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
        tempFrequencyDomain = frequencyDomain;
        
        this.googleFriendly = new ArrayList<>();
        this.answer = "";
        
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
    public HashMap<String, Integer> getTempDomain()
    {
        return this.tempFrequencyDomain;
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
    
    public void setFrequencyDomain(HashMap<String, Integer> freqs){
        this.frequencyDomain = freqs;
    }
    public void setTempDomain(HashMap<String, Integer> freqs){
        this.tempFrequencyDomain = freqs;
    }
    
    public HashMap<Integer, Integer> getQuestionGridIds(){
        return this.gridIDsOfQuestion;
    }
    
    public String getAnswer(){
        return this.answer;
    }
    
    public void setAnswer(String answer){
        this.answer = answer;
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
        
        String query = this.getGoogleFriendly().get(0).replaceAll(" ", "%20");
        
        String urlBind = "https://www.googleapis.com/customsearch/v1?key="+key+ "&cx="+ cx + "&" + "q=" + query + "&alt=json&lr=lang_en";
        
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
            if(!(htmlLinks.get(i).contains("wikipedia") || htmlLinks.get(i).contains("youtube")  || htmlLinks.get(i).contains("wordplays") || htmlLinks.get(i).contains("crossword")
                    || htmlLinks.get(i).contains(".pdf") || htmlLinks.get(i).contains(".ppt") || htmlLinks.get(i).contains(".pptx") || htmlLinks.get(i).contains(".doc") 
                    || htmlLinks.get(i).contains(".docx") || htmlLinks.get(i).contains("riteaid") || htmlLinks.get(i).contains("facebook") || htmlLinks.get(i).contains("te.com/commerce/DocumentDelivery"))){
                
                System.out.println("Link: " + htmlLinks.get(i));
                
                try{
                    Connection.Response response = Jsoup.connect(htmlLinks.get(i)).execute();
                    if(response.statusCode()  == 200){
                        try{
                            htmlDocs[i] = Jsoup.connect(htmlLinks.get(i)).get();
                            //htmlDocs[i] = Jsoup.connect(question)
                            
                            //it may or may not work with this (Probably works)
                            htmlTexts[i] = Jsoup.parse(htmlDocs[i].toString()).text().toLowerCase(Locale.US);
                            //htmlTexts[i] = htmlDocs[i].toString().replaceAll("<>", question);
                            htmlTexts[i] = htmlTexts[i].replaceAll("[^a-zA-Z\\s]", "");
                            //Reference: https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
                            String[] parts = htmlTexts[i].split("\\s+");
                
                            for(int j = 0; j < parts.length; j++){
                                if(!(parts[j].equals("the") || parts[j].equals("and") || parts[j].equals("be") || parts[j].equals("to") || parts[j].equals("too") || parts[j].equals("of")
                                    || parts[j].equals("in") || parts[j].equals("that") || parts[j].equals("this") || parts[j].equals("it") || parts[j].equals("for") || parts[j].equals("not")
                                    || parts[j].equals("on") || parts[j].equals("with") || parts[j].equals("as") || parts[j].equals("you") || parts[j].equals("at") || parts[j].equals("but")
                                    || parts[j].equals("his") || parts[j].equals("her") || parts[j].equals("she") || parts[j].equals("or") || parts[j].equals("an") || parts[j].equals("my")
                                    || parts[j].equals("all") || parts[j].equals("would") || parts[j].equals("there") || parts[j].equals("their") || parts[j].equals("what") || parts[j].equals("so")
                                    || parts[j].equals("if") || parts[j].equals("from") || parts[j].equals("more") || parts[j].equals("will") || parts[j].equals("word") || parts[j].equals("words")
                                    || parts[j].equals("your") || parts[j].equals("are") || parts[j].equals("our") || parts[j].equals("new") || parts[j].equals("news") || parts[j].equals("like")
                                    || parts[j].equals("edt") || parts[j].equals("gmt") || parts[j].equals("show") || parts[j].equals("wave") || parts[j].equals("war") || parts[j].equals("wars")
                                    || parts[j].equals("color") || parts[j].equals("ares")))
                                {
                                    if(!this.question.toLowerCase(Locale.US).contains(parts[j]))
                                        this.domain.add(parts[j]);
                                }
                            }

                            for(int j = 0; j < parts.length; j++){
                                if(!(parts[j].equals("the") || parts[j].equals("and") || parts[j].equals("be") || parts[j].equals("to") || parts[j].equals("too") || parts[j].equals("of")
                                    || parts[j].equals("in") || parts[j].equals("that") || parts[j].equals("this") || parts[j].equals("it") || parts[j].equals("for") || parts[j].equals("not")
                                    || parts[j].equals("on") || parts[j].equals("with") || parts[j].equals("as") || parts[j].equals("you") || parts[j].equals("at") || parts[j].equals("but")
                                    || parts[j].equals("his") || parts[j].equals("her") || parts[j].equals("she") || parts[j].equals("or") || parts[j].equals("an") || parts[j].equals("my")
                                    || parts[j].equals("all") || parts[j].equals("would") || parts[j].equals("there") || parts[j].equals("their") || parts[j].equals("what") || parts[j].equals("so")
                                    || parts[j].equals("if") || parts[j].equals("from") || parts[j].equals("more") || parts[j].equals("will") || parts[j].equals("word") || parts[j].equals("words")
                                    || parts[j].equals("your") || parts[j].equals("are") || parts[j].equals("our") || parts[j].equals("new") || parts[j].equals("news") || parts[j].equals("like")
                                    || parts[j].equals("news") || parts[j].equals("edt") || parts[j].equals("gmt") || parts[j].equals("news")))
                                {
                                if(!this.question.toLowerCase().contains(parts[j]))
                                    this.domain.add(parts[j]);
                                }
                            }
                        }catch(Exception e){  
                            
                        }
                    }                               
                }catch(Exception ex){
                    
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
        
        this.newDomain = new ArrayList<>();
        
        //for(int i = 0; i < size; i++){
        //    newDomain.add(this.domain.get(i));
        //}
        
        for(int i = 0; i < size; i++){
            word = this.domain.get(i);
            if(word.length() - 1 == clueL){
                //if the last character is 's', remove it the add it to the domain list
                if(word.charAt(word.length() -1) == 's'){
                    //this.domain.remove(i);
                    this.newDomain.add(word.substring(0, word.length() - 1));
                    //this.domain.add(word.substring(0, word.length() - 1));
                }
                //else{
                //    this.domain.remove(i);
                //}
            }
            else if(word.length() + 1 == clueL){
                //if the last character is not 's', put a 's' and add it to the domain list
                if(word.charAt(word.length()-1) != 's'){
                    //this.domain.remove(i);
                    String newWord = word + "s";
                    //this.domain.add(newWord);
                    this.newDomain.add(newWord);
                }
                //else{
                //    this.domain.remove(i);
                //}
            }
            else if(word.length() == clueL){
                this.newDomain.add(word);
            }
            //else if(word.length() > clueL){
            //    this.domain.remove(i);
            //}
            //else if(clueL > word.length()){
            //    this.domain.remove(i);
            //}
        }
        
        findFrequencies();
    }   
    
    public void findFrequencies() {
        String added_words = "";
        int frequency;
        int newDomainSize = this.newDomain.size();
        
        //Program is case insensitive.
        for(int i = 0; i < newDomainSize; i++)
        {   
            String keyword = this.newDomain.get(i);
            if(!added_words.contains(keyword))
            {
                added_words += keyword + " ";
                frequency = Collections.frequency(this.newDomain, keyword);
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

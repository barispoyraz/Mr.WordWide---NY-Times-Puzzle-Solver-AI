/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

import java.util.ArrayList;
import org.json.simple.JSONArray;

public class Question {
    
    private final String questionType;
    private final String questionNumber;
    private final String question;
    
    private ArrayList<String> domain;
    
    private ArrayList<JSONArray> queryResultArr;
    
    public Question(String questionType, String questionNumber, String question){
        this.questionType = questionType;
        this.questionNumber = questionNumber;
        this.question = question;
        
        domain = new ArrayList<>();
        queryResultArr = new ArrayList<>();
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
    
    public void addPossibleAnswer(String keyword){
        this.domain.add(keyword);
    }
    
    public void addQueryResults(JSONArray res){
        this.queryResultArr.add(res);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class PuzzleQuestions {

    private final String CLUE_LIST_CLASS = "ClueList-title--1-3oW";
    private final String CLUE_TEXT_CLASS = "Clue-text--3lZl7";
    private final String CLUE_TEXT_CLASS_2 = "ClueList-list--2dD5- ClueList-obscured--UdyXT";  
    private final String CLUE_NUMBER_CLASS = "Clue-label--2IdMY";
    
    private String url;
    
    private Question[] acrossQuestions;
    private Question[] downQuestions;
    
    private Document document;

    public PuzzleQuestions(String url){
        this.url = url;

        connectAndParseThePuzzleQuestions(url);
    }

    private void connectAndParseThePuzzleQuestions(String url) {
        
        try{
            if(checkDownloaded() == false)
            {
                this.document = Jsoup.connect(url).get();
            }
            else
            {
                String path = new File("CS461--ArtificialIntelligence/ai-puzzles")
                .getAbsolutePath();
                LocalDate localDate = LocalDate.now();
                
                path = path + "/" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue()
                + "-" + localDate.getYear();
                
                File puzzle = new File(path);
                this.document = Jsoup.parse(puzzle, "UTF-8", "https://www.nytimes.com/crosswords/game/mini");
            }
            
            Elements questions = this.document.getElementsByClass(CLUE_TEXT_CLASS_2);
            Elements numbers = this.document.getElementsByClass(CLUE_NUMBER_CLASS);
            
            int numberOfAcrossQuestions = questions.eq(0).select("." + CLUE_TEXT_CLASS).size();
            int numberOfDownQuestions = questions.eq(1).select("." + CLUE_TEXT_CLASS).size();
            
            this.acrossQuestions = new Question[numberOfAcrossQuestions];
            this.downQuestions = new Question[numberOfDownQuestions];
            
            String numberOfTheQuestion;
            String question;
            
            for(int i = 0; i < numberOfAcrossQuestions; i++){
                this.acrossQuestions[i] = new Question("Across", questions.eq(0)
                        .select("." + CLUE_NUMBER_CLASS).eq(i).text() 
                        ,questions.eq(0).select("." + CLUE_TEXT_CLASS).eq(i).text());
            }
            
            for(int i = 0; i < numberOfDownQuestions; i++){
                this.downQuestions[i] = new Question("Down", questions.eq(1)
                        .select("." + CLUE_NUMBER_CLASS).eq(i).text() 
                        ,questions.eq(1).select("." + CLUE_TEXT_CLASS).eq(i).text());
            }
                 
            //for (Element element : questions){
            /*System.out.println("SIZE!!!");
            System.out.println(questions.size());
            
            System.out.println(questions.eq(0).toString());
            System.out.println("-------------------------------");
            System.out.println(questions.eq(0).select("." + CLUE_TEXT_CLASS).eq(0).toString());
            System.out.println(questions.eq(0).select("." + CLUE_TEXT_CLASS).size());
            System.out.println("-------------------------------");
            System.out.println(questions.eq(1).select("." + CLUE_NUMBER_CLASS).eq(1).toString());
            System.out.println(questions.first().select("." + CLUE_NUMBER_CLASS).size());*/
            //System.out.println(questions.eq(1).text());
               
            //}
            
            //System.out.println("-------------------------------------------");
            
            /*for(int i = 0; i < numberOfAcrossQuestions; i++){
                System.out.println(this.acrossQuestions[i].toString());
                System.out.println("----");
            }
            
            for(int i = 0; i < numberOfDownQuestions; i++){
                System.out.println(this.downQuestions[i].toString());
                System.out.println("----");
            }*/
            
            
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
        
        
    }
    private boolean checkDownloaded() {
        String path = new File("")
                .getAbsolutePath();
        
        LocalDate localDate = LocalDate.now();
                
        path = path + "/" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue() 
                + "-" + localDate.getYear();
        
        Path p = Paths.get(path);
        
        return Files.exists(p);
    }
    
    public Document getDocument(){
        return this.document;
    }
    
    public Question[] getAcrossQuestions(){
        return this.acrossQuestions;
    }
    
    public Question[] getDownQuestions(){
        return this.downQuestions;
    }
    
}

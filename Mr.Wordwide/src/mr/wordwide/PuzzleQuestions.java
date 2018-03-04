/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class PuzzleQuestions {

    private final String CLUE_TEXT_CLASS = "Clue-text--3lZl7";
    private final String CLUE_TEXT_CLASS_2 = "ClueList-list--2dD5- ClueList-obscured--UdyXT";  
    private final String CLUE_NUMBER_CLASS = "Clue-label--2IdMY";
    
    private final String url;
    private final boolean today = true;
    
    private Question[] acrossQuestions;
    private Question[] downQuestions;
    
    private Document document;

    public PuzzleQuestions(String url, boolean today) throws IOException{
        this.url = url;

        if(today){
            connectAndGetThePuzzleQuestions(url);
        }
        else{
            File puzzle = new File(url);
            parseThePuzzleQuestions(puzzle);
        }
    }

    private void connectAndGetThePuzzleQuestions(String url) {
        
        try{
            LocalDate localDate = LocalDate.now();
            if(localDate.getDayOfWeek().getValue() == 6)
            {
                localDate = localDate.minusDays(1);
            }
            if(checkDownloaded() == false)
            {
                //this.document = Jsoup.connect(url).get();
                        
                Document doc = Jsoup.connect(this.url).get();
                String htmlText = doc.toString();
                

                
                File newDir = new File("ai-puzzles\\" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue() 
                + "-" + localDate.getYear());
                
                if (!newDir.exists()) {
                    if (newDir.mkdir()) {
                        System.out.println("Directory is created!");
                    } else {
                        System.out.println("Failed to create directory!");
                    }
                }
                
                FileWriter fileWriter = new FileWriter("ai-puzzles/" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue() 
                + "-" + localDate.getYear() + "/puzzle.html");
                
                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.write(htmlText);
                    bufferedWriter.newLine();
                }
            }
            
            String path = new File("ai-puzzles")
            .getAbsolutePath();

            path = path + "/" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue()
            + "-" + localDate.getYear() + "/puzzle.html";
            
            

            File puzzle = new File(path);
            
            parseThePuzzleQuestions(puzzle);
                    
            
            
        }catch(IOException ioException){
            ioException.printStackTrace();
        }
        
        
    }
    
    private void parseThePuzzleQuestions(File puzzle) throws IOException{
       
        this.document = Jsoup.parse(puzzle, "UTF-8");
            
        Elements questions = this.document.getElementsByClass(CLUE_TEXT_CLASS_2);
        
        int numberOfAcrossQuestions = questions.eq(0).select("." + CLUE_TEXT_CLASS).size();
        int numberOfDownQuestions = questions.eq(1).select("." + CLUE_TEXT_CLASS).size();
            
        this.acrossQuestions = new Question[numberOfAcrossQuestions];
        this.downQuestions = new Question[numberOfDownQuestions];
           
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
            
    }
    
    private boolean checkDownloaded() {
        String path = new File("ai-puzzles")
                .getAbsolutePath();
        
        LocalDate localDate = LocalDate.now();
                
        path = path + "\\" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue() 
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
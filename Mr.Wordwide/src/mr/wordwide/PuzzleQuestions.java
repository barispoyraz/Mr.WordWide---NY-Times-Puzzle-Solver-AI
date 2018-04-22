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
import java.util.ArrayList;
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
    
    private PuzzleStructure puzzleStructure;

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
    
    public void setPuzzleStructure(PuzzleStructure puzzleStructure){
        this.puzzleStructure = puzzleStructure;
    }
    
    public void findClueLengths(){
        Grid[] puzzleGrid = this.puzzleStructure.getGrids();
        Question[] acrossQ = this.getAcrossQuestions();
        Question[] downQ = this.getDownQuestions();
        
        int[] acrossLimits = {4, 9, 14, 19, 24};
        int[] downLimits = {20, 21, 22, 23, 24};
        
        int sizeAcross = acrossQ.length;
        int sizeDown = downQ.length;  
        int size = puzzleGrid.length;
        
        for(int i = 0; i < size; i++){
            String gridNumber = puzzleGrid[i].getQNumber(); 
            
            //If it has a question number
            if(!gridNumber.equals("")){
                int length = 1;
                ArrayList<Integer> gridIds = new ArrayList<>();
                gridIds.add(i);
                //Look across Questions
                for(int j = 0; j < sizeAcross; j++){
                    Question temp = acrossQ[j];
                    
                    String qN = temp.getQuestionNumber().replaceAll("\\s+", "");
                    String qGN = gridNumber.replaceAll("\\s+", "");
                    
                    if(qN.equals(qGN)){
                        //Look to the right of the grid
                        if(i <= 4){
                            for(int k = i + 1; k <= 4 && puzzleGrid[k].getActive().equals("ACTIVE"); k++){
                                length++;
                                gridIds.add(k);
                            }
                            System.out.println(gridIds);
                            acrossQ[j].setQuestionClueLength(length);
                            acrossQ[j].setQuestionGridIDs(gridIds);
                        }
                        else if(i > 4 && i <= 9){
                            length = 1;
                            for(int k = i + 1; k <= 9 && puzzleGrid[k].getActive().equals("ACTIVE"); k++){
                                length++;
                                gridIds.add(k);
                            }
                            acrossQ[j].setQuestionClueLength(length);
                            acrossQ[j].setQuestionGridIDs(gridIds);
                        }
                        else if(i > 9 && i <= 14){
                            length = 1;
                            for(int k = i + 1; k <= 14 && puzzleGrid[k].getActive().equals("ACTIVE"); k++){
                                length++;
                                gridIds.add(k);
                            }
                            acrossQ[j].setQuestionClueLength(length);
                            acrossQ[j].setQuestionGridIDs(gridIds);
                        }
                        else if(i > 14 && i <= 19){
                            length = 1;
                            for(int k = i + 1; k <= 19 && puzzleGrid[k].getActive().equals("ACTIVE"); k++){
                                length++;
                                gridIds.add(k);
                            }
                            acrossQ[j].setQuestionClueLength(length);
                            acrossQ[j].setQuestionGridIDs(gridIds);
                        }
                        else{
                            length = 1;
                            for(int k = i + 1; k <= 24 && puzzleGrid[k].getActive().equals("ACTIVE"); k++){
                                length++;
                                gridIds.add(k);
                            }
                            acrossQ[j].setQuestionClueLength(length);
                            acrossQ[j].setQuestionGridIDs(gridIds);
                        }
                    }
                }
                //Look down Questions
                length = 1;
                gridIds = new ArrayList<>();
                gridIds.add(i);
                for(int j = 0; j < sizeDown; j++){
                    Question temp = downQ[j];
                    
                    String qN = temp.getQuestionNumber().replaceAll("\\s+", "");
                    String qGN = gridNumber.replaceAll("\\s+", "");
                    
                    if(qN.equals(qGN)){
                        //Look to the right of the grid
                        if(i % 5 == 20 % 5){
                            for(int k = i + 5; k <= 20 && puzzleGrid[k].getActive().equals("ACTIVE"); k+=5){
                                length++;
                                gridIds.add(k);
                            }               
                            downQ[j].setQuestionClueLength(length);
                            downQ[j].setQuestionGridIDs(gridIds);
                        }
                        else if(i % 5 == 21 % 5){
                            length = 1;
                            for(int k = i + 5; k <= 21 && puzzleGrid[k].getActive().equals("ACTIVE"); k+=5){
                                length++;
                                gridIds.add(k);
                            }
                            downQ[j].setQuestionClueLength(length);
                            downQ[j].setQuestionGridIDs(gridIds);
                        }
                        else if(i % 5 == 22 % 5){
                            length = 1;
                            for(int k = i + 5; k <= 22 && puzzleGrid[k].getActive().equals("ACTIVE"); k+=5){
                                length++;
                                gridIds.add(k);
                            }
                            downQ[j].setQuestionClueLength(length);
                            downQ[j].setQuestionGridIDs(gridIds);
                        }
                        else if(i % 5 == 23 % 5){
                            length = 1;
                            for(int k = i + 5; k <= 23 && puzzleGrid[k].getActive().equals("ACTIVE"); k+=5){
                                length++;
                                gridIds.add(k);
                            }
                            downQ[j].setQuestionClueLength(length);
                            downQ[j].setQuestionGridIDs(gridIds);
                        }
                        else{
                            length = 1;
                            for(int k = i + 5; k <= 24 && puzzleGrid[k].getActive().equals("ACTIVE"); k+=5){
                                length++;
                                gridIds.add(k);
                            }
                            downQ[j].setQuestionClueLength(length);
                            downQ[j].setQuestionGridIDs(gridIds);
                        }
                    }
                }        
            }
        }
        
        for(int i = 0; i < sizeAcross; i++){
            System.out.println(acrossQ[i].toString() + " length: " + acrossQ[i].getQuestionClueLength());
        }
        
        for(int i = 0; i < sizeDown; i++){
            System.out.println(downQ[i].toString() + " length: " + downQ[i].getQuestionClueLength());
        }
        
        System.out.println("\n");
        System.out.println("----------------");
        System.out.println("\n");        
        
        for(int i = 0; i < sizeAcross; i++){
            System.out.println(acrossQ[i].toString() + " ids: " + acrossQ[i].getQuestionGridIds());
        }
        
        for(int i = 0; i < sizeDown; i++){
            System.out.println(downQ[i].toString() + " ids: " + downQ[i].getQuestionGridIds());
        }
    }
    
    //Based on A COMPARISON OF KEYWORD-BASED AND SEMANTICS-BASED SEARCHING By David E. Goldschmidt
    public void findGoogleFriendlyQueries(){
        Question[] acrossQ = this.getAcrossQuestions();
        Question[] downQ = this.getDownQuestions();
        
        int sizeAcross = acrossQ.length;
        int sizeDown = downQ.length;
        
        ArrayList<String> googleFriendly;
        
        for(int i = 0; i < sizeAcross; i++){
            Question temp = acrossQ[i];
            String tempQuestion = temp.getQuestion();          
            googleFriendly = new ArrayList<>();
            if(tempQuestion.contains("_")){
                String friendly = tempQuestion.replaceAll("_", "* ");
                googleFriendly.add(friendly);
                acrossQ[i].setGoogleFriendly(googleFriendly);
            }
            else if(!tempQuestion.contains(" ")){
                googleFriendly.add(tempQuestion);
                googleFriendly.add("synonyms of " + tempQuestion);
                acrossQ[i].setGoogleFriendly(googleFriendly);
            }
            else if(tempQuestion.contains("abbr")){
                googleFriendly.add(tempQuestion);
                googleFriendly.add("abbrevations " + tempQuestion);
                acrossQ[i].setGoogleFriendly(googleFriendly);
            }
            else if(tempQuestion.startsWith("type of")){
                googleFriendly.add(tempQuestion);
                googleFriendly.add(tempQuestion.replaceAll("type of", "*"));
                acrossQ[i].setGoogleFriendly(googleFriendly);
            }
            else if(tempQuestion.contains("not")){
                googleFriendly.add(tempQuestion);
                googleFriendly.add(tempQuestion.replaceAll("not", "opposite of"));
                googleFriendly.add(tempQuestion.replaceAll("not", "antonyms of"));
                acrossQ[i].setGoogleFriendly(googleFriendly);
            }
            //last two remaining
            else if(tempQuestion.contains("or"))
            {
                googleFriendly.add(tempQuestion);
                String[] splitted = tempQuestion.split(" or ");
                for(int j = 0; j < splitted.length; j++)
                {
                    googleFriendly.add(splitted[j]);
                }
            }
            else if(tempQuestion.contains("sounds like") || tempQuestion.contains("sound like"))
            {
                tempQuestion = tempQuestion.replaceAll("(", "").replaceAll(")", "");
                googleFriendly.add(tempQuestion);
                tempQuestion = tempQuestion.replaceAll("sounds like", "rhymes with");
                tempQuestion = tempQuestion.replaceAll("sound like", "rhymes with");
                googleFriendly.add(tempQuestion);
                tempQuestion = "synonyms of" + tempQuestion;
                googleFriendly.add(tempQuestion);
            }
        }
    }
}
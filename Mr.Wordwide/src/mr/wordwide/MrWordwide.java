/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MrWordwide extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        URL puzzle = new URL("https://www.nytimes.com/crosswords/game/mini");
        BufferedReader in = new BufferedReader(new InputStreamReader(puzzle.openStream()));
        
        String inputLine;
        String htmlText = "";
        while((inputLine = in.readLine()) != null){
            //System.out.println(inputLine);
            htmlText += inputLine;
        }
        in.close();
        
        FileWriter fileWriter = new FileWriter("puzzle.html");
        BufferedWriter bufferedWriter  = new BufferedWriter(fileWriter);
        bufferedWriter.write(htmlText);
        bufferedWriter.newLine();
        bufferedWriter.close();
        
        /*PuzzleQuestions puzzleQuestions = 
                new PuzzleQuestions("https://www.nytimes.com/crosswords/game/mini"); 
        
        PuzzleStructure puzzleStructure =
                new PuzzleStructure(puzzleQuestions.getDocument());
         */
        launch(args);
    }
    
}
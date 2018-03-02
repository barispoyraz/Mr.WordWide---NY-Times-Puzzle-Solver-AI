/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MrWordwide extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        PuzzleQuestions puzzleQuestions = 
                new PuzzleQuestions("https://www.nytimes.com/crosswords/game/mini"); 
        
        PuzzleStructure puzzleStructure =
                new PuzzleStructure(puzzleQuestions.getDocument());
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Mr.Wordwide");
        stage.show();
        
        FXMLDocumentController controller = loader.getController();
        controller.setPuzzleGrid(puzzleStructure);
        controller.setAcrossQuestions(puzzleQuestions);
        controller.setDownQuestions(puzzleQuestions);
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        launch(args);
    }
    
}
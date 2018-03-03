/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;


public class FXMLDocumentController implements Initializable {
  
    @FXML
    private Label puzzleGrid0;
    @FXML
    private Label puzzleGrid1;
    @FXML
    private Label puzzleGrid2;
    @FXML
    private Label puzzleGrid3;
    @FXML
    private Label puzzleGrid4;
    @FXML
    private Label puzzleGrid5;
    @FXML
    private Label puzzleGrid6;
    @FXML
    private Label puzzleGrid7;
    @FXML
    private Label puzzleGrid8;
    @FXML
    private Label puzzleGrid9;
    @FXML
    private Label puzzleGrid10;
    @FXML
    private Label puzzleGrid11;
    @FXML
    private Label puzzleGrid12;
    @FXML
    private Label puzzleGrid13;
    @FXML
    private Label puzzleGrid14;
    @FXML
    private Label puzzleGrid15;
    @FXML
    private Label puzzleGrid16;
    @FXML
    private Label puzzleGrid17;
    @FXML
    private Label puzzleGrid18;
    @FXML
    private Label puzzleGrid19;
    @FXML
    private Label puzzleGrid20;
    @FXML
    private Label puzzleGrid21;
    @FXML
    private Label puzzleGrid22;
    @FXML
    private Label puzzleGrid23;
    @FXML
    private Label puzzleGrid24;
    
    @FXML
    private Label across1;
    @FXML
    private Label across2;
    @FXML
    private Label across3;
    @FXML
    private Label across4;
    @FXML
    private Label across5;
    
    @FXML
    private Label down1;
    @FXML
    private Label down2;
    @FXML
    private Label down3;
    @FXML
    private Label down4;
    @FXML
    private Label down5;
   
    @FXML
    private JFXDatePicker dateSelector;
    
    @FXML
    private JFXButton puzzleSelectFolder;  
    
    @FXML
    private JFXButton solveButton; 
    
    @FXML
    public void setPuzzleGrid(PuzzleStructure structure)
    {
        Grid[] grids = structure.getGrids();
        
        if(grids[0].getActive().equals("BLOCKED"))
            puzzleGrid0.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid0.setStyle(null);
        
        if(grids[1].getActive().equals("BLOCKED"))
            puzzleGrid1.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid1.setStyle(null);
        
        if(grids[2].getActive().equals("BLOCKED"))
            puzzleGrid2.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid2.setStyle(null);
        
        if(grids[3].getActive().equals("BLOCKED"))
            puzzleGrid3.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid3.setStyle(null);
        
        if(grids[4].getActive().equals("BLOCKED"))
            puzzleGrid4.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid4.setStyle(null);
        
        if(grids[5].getActive().equals("BLOCKED"))
            puzzleGrid5.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid5.setStyle(null);
        
        if(grids[6].getActive().equals("BLOCKED"))
            puzzleGrid6.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid6.setStyle(null);
        
        if(grids[7].getActive().equals("BLOCKED"))
            puzzleGrid7.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid7.setStyle(null);
        
        if(grids[8].getActive().equals("BLOCKED"))
            puzzleGrid8.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid8.setStyle(null);
        
        if(grids[9].getActive().equals("BLOCKED"))
            puzzleGrid9.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid9.setStyle(null);
        
        if(grids[10].getActive().equals("BLOCKED"))
            puzzleGrid10.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid10.setStyle(null);
        
        if(grids[11].getActive().equals("BLOCKED"))
            puzzleGrid11.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid11.setStyle(null);
        
        if(grids[12].getActive().equals("BLOCKED"))
            puzzleGrid12.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid12.setStyle(null);
        
        if(grids[13].getActive().equals("BLOCKED"))
            puzzleGrid13.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid13.setStyle(null);
        
        if(grids[14].getActive().equals("BLOCKED"))
            puzzleGrid14.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid14.setStyle(null);
        
        if(grids[15].getActive().equals("BLOCKED"))
            puzzleGrid15.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid15.setStyle(null);
        
        if(grids[16].getActive().equals("BLOCKED"))
            puzzleGrid16.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid16.setStyle(null);
        
        if(grids[17].getActive().equals("BLOCKED"))
            puzzleGrid17.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid17.setStyle(null);
        
        if(grids[18].getActive().equals("BLOCKED"))
            puzzleGrid18.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid18.setStyle(null);
        
        if(grids[19].getActive().equals("BLOCKED"))
            puzzleGrid19.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid19.setStyle(null);
        
        if(grids[20].getActive().equals("BLOCKED"))
            puzzleGrid20.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid20.setStyle(null);
        
        if(grids[21].getActive().equals("BLOCKED"))
            puzzleGrid21.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid21.setStyle(null);
        
        if(grids[22].getActive().equals("BLOCKED"))
            puzzleGrid22.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid22.setStyle(null);
        
        if(grids[23].getActive().equals("BLOCKED"))
            puzzleGrid23.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid23.setStyle(null);
        
        if(grids[24].getActive().equals("BLOCKED"))
            puzzleGrid24.setStyle("-fx-background-color:ff5900");
        else
            puzzleGrid24.setStyle(null);
    }
    
    @FXML
    public void setAcrossQuestions(PuzzleQuestions puzzleQuestions)
    {
        Question[] acrossQuestions = puzzleQuestions.getAcrossQuestions();
        if(acrossQuestions.length == 5)
        {
            across1.setText(acrossQuestions[0].toString());
            across2.setText(acrossQuestions[1].toString());
            across3.setText(acrossQuestions[2].toString());
            across4.setText(acrossQuestions[3].toString());
            across5.setText(acrossQuestions[4].toString());
        }
        
    }
    
    @FXML
    public void setDownQuestions(PuzzleQuestions puzzleQuestions)
    {
        Question[] downQuestions = puzzleQuestions.getDownQuestions();
        if(downQuestions.length == 5)
        {
            down1.setText(downQuestions[0].toString());
            down2.setText(downQuestions[1].toString());
            down3.setText(downQuestions[2].toString());
            down4.setText(downQuestions[3].toString());
            down5.setText(downQuestions[4].toString());
        } 
    }
    
    @FXML
    private void openDirectoryChooser(ActionEvent event) throws IOException{
    
        Node node = (Node)event.getSource();
        Window stage = node.getScene().getWindow();
        
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose a folder to open a puzzle");
        
        String path = new File("ai-puzzles")
                .getAbsolutePath();
           
        File firstDirectory = new File(path);
        directoryChooser.setInitialDirectory(firstDirectory);
        
        File directoryChoosen = directoryChooser.showDialog(stage);
        
        System.out.println("choosen: " + directoryChoosen );
        
        File puzzle = 
                new File(directoryChoosen.getAbsolutePath() + "/puzzle.html");
        
        PuzzleQuestions puzzleQuestionsChoosen = 
                new PuzzleQuestions(puzzle.getAbsolutePath(), false);
        
        PuzzleStructure puzzleStructure = 
                new PuzzleStructure(puzzleQuestionsChoosen.getDocument());
        
        this.setAcrossQuestions(puzzleQuestionsChoosen);
        this.setDownQuestions(puzzleQuestionsChoosen);
        this.setPuzzleGrid(puzzleStructure);
        

    }
    
    @FXML
    private void handleMouseEntered(){
        solveButton.setStyle("-fx-background-color: blue;");
    }
    
    @FXML
    private void handleMouseExited(){
        solveButton.setStyle("-fx-background-color: black;");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dateSelector.setValue(LocalDate.now());
    }    
    
}

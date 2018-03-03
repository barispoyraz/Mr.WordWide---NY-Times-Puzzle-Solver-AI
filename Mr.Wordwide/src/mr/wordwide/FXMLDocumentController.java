/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. Hi
 */
package mr.wordwide;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView solutionImage = new ImageView();
    
    @FXML
    public void setPuzzleGrid(PuzzleStructure structure)
    {
        Grid[] grids = structure.getGrids();
        
        if(grids[0].getActive().equals("BLOCKED"))
        {
            puzzleGrid0.setStyle("-fx-background-color:ff5900");
            puzzleGrid0.setDisable(true);
        }
        else
        {
            puzzleGrid0.setStyle(null);
            puzzleGrid0.setDisable(false);
        }
        
        if(grids[1].getActive().equals("BLOCKED"))
        {
            puzzleGrid1.setStyle("-fx-background-color:ff5900");
            puzzleGrid1.setDisable(true);
        }
        else
        {
            puzzleGrid1.setStyle(null);
            puzzleGrid1.setDisable(false);
        }
        
        if(grids[2].getActive().equals("BLOCKED"))
        {
            puzzleGrid2.setStyle("-fx-background-color:ff5900");
            puzzleGrid2.setDisable(true);
        }
        else
        {
            puzzleGrid2.setStyle(null);
            puzzleGrid2.setDisable(false);
        }
        
        if(grids[3].getActive().equals("BLOCKED"))
        {
            puzzleGrid3.setStyle("-fx-background-color:ff5900");
            puzzleGrid3.setDisable(true);
        }
        else
        {
            puzzleGrid3.setStyle(null);
            puzzleGrid3.setDisable(false);
        }
        
        if(grids[4].getActive().equals("BLOCKED"))
        {
            puzzleGrid4.setStyle("-fx-background-color:ff5900");
            puzzleGrid4.setDisable(true);
        }
        else
        {
            puzzleGrid4.setStyle(null);
            puzzleGrid4.setDisable(false);
        }
        
        if(grids[5].getActive().equals("BLOCKED"))
        {
            puzzleGrid5.setStyle("-fx-background-color:ff5900");
            puzzleGrid5.setDisable(true);
        }
        else
        {
            puzzleGrid5.setStyle(null);
            puzzleGrid5.setDisable(false);
        }
        
        if(grids[6].getActive().equals("BLOCKED"))
        {
            puzzleGrid6.setStyle("-fx-background-color:ff5900");
            puzzleGrid6.setDisable(true);
        }
        else
        {
            puzzleGrid6.setStyle(null);
            puzzleGrid6.setDisable(false);
        }
        
        if(grids[7].getActive().equals("BLOCKED"))
        {
            puzzleGrid7.setStyle("-fx-background-color:ff5900");
            puzzleGrid7.setDisable(true);
        }
        else
        {
            puzzleGrid7.setStyle(null);
            puzzleGrid7.setDisable(false);
        }
        
        if(grids[8].getActive().equals("BLOCKED"))
        {
            puzzleGrid8.setStyle("-fx-background-color:ff5900");
            puzzleGrid8.setDisable(true);
        }
        else
        {
            puzzleGrid8.setStyle(null);
            puzzleGrid8.setDisable(false);
        }
        
        if(grids[9].getActive().equals("BLOCKED"))
        {
            puzzleGrid9.setStyle("-fx-background-color:ff5900");
            puzzleGrid9.setDisable(true);
        }
        else
        {
            puzzleGrid9.setStyle(null);
            puzzleGrid9.setDisable(false);
        }
        
        if(grids[10].getActive().equals("BLOCKED"))
        {
            puzzleGrid10.setStyle("-fx-background-color:ff5900");
            puzzleGrid10.setDisable(true);
        }
        else
        {
            puzzleGrid10.setStyle(null);
            puzzleGrid10.setDisable(false);
        }
        
        if(grids[11].getActive().equals("BLOCKED"))
        {
            puzzleGrid11.setStyle("-fx-background-color:ff5900");
            puzzleGrid11.setDisable(true);
        }
        else
        {
            puzzleGrid11.setStyle(null);
            puzzleGrid11.setDisable(false);
        }
        
        if(grids[12].getActive().equals("BLOCKED"))
        {
            puzzleGrid12.setStyle("-fx-background-color:ff5900");
            puzzleGrid12.setDisable(true);
        }
        else
        {
            puzzleGrid12.setStyle(null);
            puzzleGrid12.setDisable(false);
        }
        
        if(grids[13].getActive().equals("BLOCKED"))
        {
            puzzleGrid13.setStyle("-fx-background-color:ff5900");
            puzzleGrid13.setDisable(true);
        }
        else
        {
            puzzleGrid13.setStyle(null);
            puzzleGrid13.setDisable(false);
        }
        
        if(grids[14].getActive().equals("BLOCKED"))
        {
            puzzleGrid14.setStyle("-fx-background-color:ff5900");
            puzzleGrid14.setDisable(true);
        }
        else
        {
            puzzleGrid14.setStyle(null);
            puzzleGrid14.setDisable(false);
        }
        
        if(grids[15].getActive().equals("BLOCKED"))
        {
            puzzleGrid15.setStyle("-fx-background-color:ff5900");
            puzzleGrid15.setDisable(true);
        }
        else
        {
            puzzleGrid15.setStyle(null);
            puzzleGrid15.setDisable(false);
        }
        
        if(grids[16].getActive().equals("BLOCKED"))
        {
            puzzleGrid16.setStyle("-fx-background-color:ff5900");
            puzzleGrid16.setDisable(true);
        }
        else
        {
            puzzleGrid16.setStyle(null);
            puzzleGrid16.setDisable(false);
        }
        
        if(grids[17].getActive().equals("BLOCKED"))
        {
            puzzleGrid17.setStyle("-fx-background-color:ff5900");
            puzzleGrid17.setDisable(true);
        }
        else
        {
            puzzleGrid17.setStyle(null);
            puzzleGrid17.setDisable(false);
        }
        
        if(grids[18].getActive().equals("BLOCKED"))
        {
            puzzleGrid18.setStyle("-fx-background-color:ff5900");
            puzzleGrid18.setDisable(true);
        }
        else
        {
            puzzleGrid18.setStyle(null);
            puzzleGrid18.setDisable(false);
        }
        
        if(grids[19].getActive().equals("BLOCKED"))
        {
            puzzleGrid19.setStyle("-fx-background-color:ff5900");
            puzzleGrid19.setDisable(true);
        }
        else
        {
            puzzleGrid19.setStyle(null);
            puzzleGrid19.setDisable(false);
        }
        
        if(grids[20].getActive().equals("BLOCKED"))
        {
            puzzleGrid20.setStyle("-fx-background-color:ff5900");
            puzzleGrid20.setDisable(true);
        }
        else
        {
            puzzleGrid20.setStyle(null);
            puzzleGrid20.setDisable(false);
        }
        
        if(grids[21].getActive().equals("BLOCKED"))
        {
            puzzleGrid21.setStyle("-fx-background-color:ff5900");
            puzzleGrid21.setDisable(true);
        }
        else
        {
            puzzleGrid21.setStyle(null);
            puzzleGrid21.setDisable(false);
        }
        
        if(grids[22].getActive().equals("BLOCKED"))
        {
            puzzleGrid22.setStyle("-fx-background-color:ff5900");
            puzzleGrid22.setDisable(true);
        }
        else
        {
            puzzleGrid22.setStyle(null);
            puzzleGrid22.setDisable(false);
        }
        
        if(grids[23].getActive().equals("BLOCKED"))
        {
            puzzleGrid23.setStyle("-fx-background-color:ff5900");
            puzzleGrid23.setDisable(true);
        }
        else
        {
            puzzleGrid23.setStyle(null);
            puzzleGrid23.setDisable(false);
        }
        
        if(grids[24].getActive().equals("BLOCKED"))
        {
            puzzleGrid24.setStyle("-fx-background-color:ff5900");
            puzzleGrid24.setDisable(true);
        }
        else
        {
            puzzleGrid24.setStyle(null);
            puzzleGrid24.setDisable(false);
        }
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
        
        File image =
                new File(directoryChoosen.getAbsolutePath() + "/solution.PNG");
        
        System.out.println(image.exists());
        
        solutionImage.setImage(null);
        solutionImage.setImage(new Image(image.toURI().toURL().toExternalForm()));
        
        System.out.println(solutionImage.isVisible());
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
        //dateSelector.setValue(LocalDate.now());
        
        LocalDate localDate = LocalDate.now();
        
        try{
            File imagePath = new File("ai-puzzles\\" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue() 
                    + "-" + localDate.getYear() + "/solution.PNG");
            
            if(imagePath.exists()){
                solutionImage.setImage(new Image(imagePath.getAbsolutePath()));
            }
        }catch(Exception e){
            solutionImage.setImage(null);
        }
        
    }    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. Hi
 */
package mr.wordwide;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.ResourceBundle.Control;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
    private Label qNumber0;
    @FXML
    private Label qNumber1;
    @FXML
    private Label qNumber2;
    @FXML
    private Label qNumber3;
    @FXML
    private Label qNumber4;
    @FXML
    private Label qNumber5;
    @FXML
    private Label qNumber6;
    @FXML
    private Label qNumber7;
    @FXML
    private Label qNumber8;
    @FXML
    private Label qNumber9;
    @FXML
    private Label qNumber10;
    @FXML
    private Label qNumber11;
    @FXML
    private Label qNumber12;
    @FXML
    private Label qNumber13;
    @FXML
    private Label qNumber14;
    @FXML
    private Label qNumber15;
    @FXML
    private Label qNumber16;
    @FXML
    private Label qNumber17;
    @FXML
    private Label qNumber18;
    @FXML
    private Label qNumber19;
    @FXML
    private Label qNumber20;
    @FXML
    private Label qNumber21;
    @FXML
    private Label qNumber22;
    @FXML
    private Label qNumber23;
    @FXML
    private Label qNumber24;
    
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
    private JFXButton puzzleSelectFolder;  
    
    @FXML
    private JFXButton solveButton; 
    
    @FXML
    private ImageView solutionImage = new ImageView();
    
    @FXML
    private StackPane currentPane = null;
    
    @FXML
    private final Color color = Color.rgb(79, 242, 155, 0.75);
    
    @FXML
    private final BackgroundFill fill = new BackgroundFill(color, CornerRadii.EMPTY,
            Insets.EMPTY);
    
    @FXML
    private final Background background = new Background(fill);
    
    @FXML
    private Grid[] theGrids;
    
    @FXML
    public void setPuzzleGrid(PuzzleStructure structure)
    {
        Grid[] grids = structure.getGrids();
        theGrids = grids;
        
        if(grids[0].getActive().equals("BLOCKED"))
        {
            puzzleGrid0.setStyle("-fx-background-color:ff5900");
            puzzleGrid0.setDisable(true);
            qNumber0.setText("");
        }
        else
        {
            puzzleGrid0.setStyle(null);
            puzzleGrid0.setDisable(false);
            if(grids[0].getQNumber() != null)
                qNumber0.setText(" " + grids[0].getQNumber());
            else
                qNumber0.setText("");
        }
        
        if(grids[1].getActive().equals("BLOCKED"))
        {
            puzzleGrid1.setStyle("-fx-background-color:ff5900");
            puzzleGrid1.setDisable(true);
            qNumber1.setText("");
        }
        else
        {
            puzzleGrid1.setStyle(null);
            puzzleGrid1.setDisable(false);
            if(grids[1].getQNumber() != null)
                qNumber1.setText(" " + grids[1].getQNumber());
            else
                qNumber1.setText("");
            
        }
        
        if(grids[2].getActive().equals("BLOCKED"))
        {
            puzzleGrid2.setStyle("-fx-background-color:ff5900");
            puzzleGrid2.setDisable(true);
            qNumber2.setText("");
        }
        else
        {
            puzzleGrid2.setStyle(null);
            puzzleGrid2.setDisable(false);
            if(grids[2].getQNumber() != null)
                qNumber2.setText(" " + grids[2].getQNumber());
            else
                qNumber2.setText("");
        }
        
        if(grids[3].getActive().equals("BLOCKED"))
        {
            puzzleGrid3.setStyle("-fx-background-color:ff5900");
            puzzleGrid3.setDisable(true);
            qNumber3.setText("");
        }
        else
        {
            puzzleGrid3.setStyle(null);
            puzzleGrid3.setDisable(false);
            if(grids[3].getQNumber() != null)
                qNumber3.setText(" " + grids[3].getQNumber());
            else
                qNumber3.setText("");
        }
        
        if(grids[4].getActive().equals("BLOCKED"))
        {
            puzzleGrid4.setStyle("-fx-background-color:ff5900");
            puzzleGrid4.setDisable(true);
            qNumber4.setText("");
        }
        else
        {
            puzzleGrid4.setStyle(null);
            puzzleGrid4.setDisable(false);
            if(grids[4].getQNumber() != null)
                qNumber4.setText(" " + grids[4].getQNumber());
            else
                qNumber4.setText("");
                
        }
        
        if(grids[5].getActive().equals("BLOCKED"))
        {
            puzzleGrid5.setStyle("-fx-background-color:ff5900");
            puzzleGrid5.setDisable(true);
            qNumber5.setText("");
        }
        else
        {
            puzzleGrid5.setStyle(null);
            puzzleGrid5.setDisable(false);
            if(grids[5].getQNumber() != null)
                qNumber5.setText(" " + grids[5].getQNumber());
            else
                qNumber5.setText("");
        }
        
        if(grids[6].getActive().equals("BLOCKED"))
        {
            puzzleGrid6.setStyle("-fx-background-color:ff5900");
            puzzleGrid6.setDisable(true);
            qNumber6.setText("");
        }
        else
        {
            puzzleGrid6.setStyle(null);
            puzzleGrid6.setDisable(false);
            if(grids[6].getQNumber() != null)
                qNumber6.setText(" " + grids[6].getQNumber());
            else
                qNumber6.setText("");
        }
        
        if(grids[7].getActive().equals("BLOCKED"))
        {
            puzzleGrid7.setStyle("-fx-background-color:ff5900");
            puzzleGrid7.setDisable(true);
            qNumber7.setText("");
        }
        else
        {
            puzzleGrid7.setStyle(null);
            puzzleGrid7.setDisable(false);
            if(grids[7].getQNumber() != null)
                qNumber7.setText(" " + grids[7].getQNumber());
            else
                qNumber7.setText("");
        }
        
        if(grids[8].getActive().equals("BLOCKED"))
        {
            puzzleGrid8.setStyle("-fx-background-color:ff5900");
            puzzleGrid8.setDisable(true);
            qNumber8.setText("");
        }
        else
        {
            puzzleGrid8.setStyle(null);
            puzzleGrid8.setDisable(false);
            if(grids[8].getQNumber() != null)
                qNumber8.setText(" " + grids[8].getQNumber());
            else
                qNumber8.setText("");
        }
        
        if(grids[9].getActive().equals("BLOCKED"))
        {
            puzzleGrid9.setStyle("-fx-background-color:ff5900");
            puzzleGrid9.setDisable(true);
            qNumber9.setText("");
        }
        else
        {
            puzzleGrid9.setStyle(null);
            puzzleGrid9.setDisable(false);
            if(grids[9].getQNumber() != null)
                qNumber9.setText(" " + grids[9].getQNumber());
            else
                qNumber9.setText("");
        }
        
        if(grids[10].getActive().equals("BLOCKED"))
        {
            puzzleGrid10.setStyle("-fx-background-color:ff5900");
            puzzleGrid10.setDisable(true);
            qNumber10.setText("");
        }
        else
        {
            puzzleGrid10.setStyle(null);
            puzzleGrid10.setDisable(false);
            if(grids[10].getQNumber() != null)
                qNumber10.setText(" " + grids[10].getQNumber());
            else
                qNumber10.setText("");
        }
        
        if(grids[11].getActive().equals("BLOCKED"))
        {
            puzzleGrid11.setStyle("-fx-background-color:ff5900");
            puzzleGrid11.setDisable(true);
            qNumber11.setText("");
        }
        else
        {
            puzzleGrid11.setStyle(null);
            puzzleGrid11.setDisable(false);
            if(grids[11].getQNumber() != null)
                qNumber11.setText(" " + grids[11].getQNumber());
            else
                qNumber11.setText("");
        }
        
        if(grids[12].getActive().equals("BLOCKED"))
        {
            puzzleGrid12.setStyle("-fx-background-color:ff5900");
            puzzleGrid12.setDisable(true);
            qNumber12.setText("");
        }
        else
        {
            puzzleGrid12.setStyle(null);
            puzzleGrid12.setDisable(false);
            if(grids[12].getQNumber() != null)
                qNumber12.setText(" " + grids[12].getQNumber());
            else
                qNumber12.setText("");
        }
        
        if(grids[13].getActive().equals("BLOCKED"))
        {
            puzzleGrid13.setStyle("-fx-background-color:ff5900");
            puzzleGrid13.setDisable(true);
            qNumber13.setText("");
        }
        else
        {
            puzzleGrid13.setStyle(null);
            puzzleGrid13.setDisable(false);
            if(grids[13].getQNumber() != null)
                qNumber13.setText(" " + grids[13].getQNumber());
            else
                qNumber13.setText("");
        }
        
        if(grids[14].getActive().equals("BLOCKED"))
        {
            puzzleGrid14.setStyle("-fx-background-color:ff5900");
            puzzleGrid14.setDisable(true);
            qNumber14.setText("");
        }
        else
        {
            puzzleGrid14.setStyle(null);
            puzzleGrid14.setDisable(false);
            if(grids[14].getQNumber() != null)
                qNumber14.setText(" " + grids[14].getQNumber());
            else
                qNumber14.setText("");
        }
        
        if(grids[15].getActive().equals("BLOCKED"))
        {
            puzzleGrid15.setStyle("-fx-background-color:ff5900");
            puzzleGrid15.setDisable(true);
            qNumber15.setText("");
        }
        else
        {
            puzzleGrid15.setStyle(null);
            puzzleGrid15.setDisable(false);
            if(grids[15].getQNumber() != null)
                qNumber15.setText(" " + grids[15].getQNumber());
            else
                qNumber15.setText("");
        }
        
        if(grids[16].getActive().equals("BLOCKED"))
        {
            puzzleGrid16.setStyle("-fx-background-color:ff5900");
            puzzleGrid16.setDisable(true);
            qNumber16.setText("");
        }
        else
        {
            puzzleGrid16.setStyle(null);
            puzzleGrid16.setDisable(false);
            if(grids[16].getQNumber() != null)
                qNumber16.setText(" " + grids[16].getQNumber());
            else
                qNumber16.setText("");
        }
        
        if(grids[17].getActive().equals("BLOCKED"))
        {
            puzzleGrid17.setStyle("-fx-background-color:ff5900");
            puzzleGrid17.setDisable(true);
            qNumber17.setText("");
        }
        else
        {
            puzzleGrid17.setStyle(null);
            puzzleGrid17.setDisable(false);
            if(grids[17].getQNumber() != null)
                qNumber17.setText(" " + grids[17].getQNumber());
            else
                qNumber17.setText("");
        }
        
        if(grids[18].getActive().equals("BLOCKED"))
        {
            puzzleGrid18.setStyle("-fx-background-color:ff5900");
            puzzleGrid18.setDisable(true);
            qNumber18.setText("");
        }
        else
        {
            puzzleGrid18.setStyle(null);
            puzzleGrid18.setDisable(false);
            if(grids[18].getQNumber() != null)
                qNumber18.setText(" " + grids[18].getQNumber());
            else
                qNumber18.setText("");
        }
        
        if(grids[19].getActive().equals("BLOCKED"))
        {
            puzzleGrid19.setStyle("-fx-background-color:ff5900");
            puzzleGrid19.setDisable(true);
            qNumber19.setText("");
        }
        else
        {
            puzzleGrid19.setStyle(null);
            puzzleGrid19.setDisable(false);
            if(grids[19].getQNumber() != null)
                qNumber19.setText(" " + grids[19].getQNumber());
            else
                qNumber19.setText("");
        }
        
        if(grids[20].getActive().equals("BLOCKED"))
        {
            puzzleGrid20.setStyle("-fx-background-color:ff5900");
            puzzleGrid20.setDisable(true);
            qNumber20.setText("");
        }
        else
        {
            puzzleGrid20.setStyle(null);
            puzzleGrid20.setDisable(false);
            if(grids[20].getQNumber() != null)
                qNumber20.setText(" " + grids[20].getQNumber());
            else
                qNumber20.setText("");
        }
        
        if(grids[21].getActive().equals("BLOCKED"))
        {
            puzzleGrid21.setStyle("-fx-background-color:ff5900");
            puzzleGrid21.setDisable(true);
            qNumber21.setText("");
        }
        else
        {
            puzzleGrid21.setStyle(null);
            puzzleGrid21.setDisable(false);
            if(grids[21].getQNumber() != null)
                qNumber21.setText(" " + grids[21].getQNumber());
            else
                qNumber21.setText("");
        }
        
        if(grids[22].getActive().equals("BLOCKED"))
        {
            puzzleGrid22.setStyle("-fx-background-color:ff5900");
            puzzleGrid22.setDisable(true);
            qNumber22.setText("");
        }
        else
        {
            puzzleGrid22.setStyle(null);
            puzzleGrid22.setDisable(false);
            if(grids[22].getQNumber() != null)
                qNumber22.setText(" " + grids[22].getQNumber());
            else
                qNumber22.setText("");
        }
        
        if(grids[23].getActive().equals("BLOCKED"))
        {
            puzzleGrid23.setStyle("-fx-background-color:ff5900");
            puzzleGrid23.setDisable(true);
            qNumber23.setText("");
        }
        else
        {
            puzzleGrid23.setStyle(null);
            puzzleGrid23.setDisable(false);
            if(grids[23].getQNumber() != null)
                qNumber23.setText(" " + grids[23].getQNumber());
            else
                qNumber23.setText("");
        }
        
        if(grids[24].getActive().equals("BLOCKED"))
        {
            puzzleGrid24.setStyle("-fx-background-color:ff5900");
            puzzleGrid24.setDisable(true);
            qNumber24.setText("");
        }
        else
        {
            puzzleGrid24.setStyle(null);
            puzzleGrid24.setDisable(false);
            if(grids[24].getQNumber() != null)
                qNumber24.setText(" " + grids[24].getQNumber());
            else
                qNumber24.setText("");
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
        
        
        File puzzle = 
                new File(directoryChoosen.getAbsolutePath() + "/puzzle.html");
        
        PuzzleQuestions puzzleQuestionsChoosen = 
                new PuzzleQuestions(puzzle.getAbsolutePath(), false);
        
        PuzzleStructure puzzleStructure = 
                new PuzzleStructure(puzzleQuestionsChoosen.getDocument());
        
        this.setAcrossQuestions(puzzleQuestionsChoosen);
        this.setDownQuestions(puzzleQuestionsChoosen);
        this.setPuzzleGrid(puzzleStructure);
        
        if(currentPane != null){
            currentPane.setBackground(null);
            currentPane = null;
        }
        
        File image =
                new File(directoryChoosen.getAbsolutePath() + "/solution.PNG");
        
        solutionImage.setImage(null);
        solutionImage.setImage(new Image(image.toURI().toURL().toExternalForm()));
    }
    
    @FXML
    private void handleMouseClickOnGrids(Event event){
        StackPane stackPane = (StackPane)event.getSource();
        System.out.println(stackPane.getId());
        
        int index = Integer.parseInt(stackPane.getId().substring(4));
        
        if(!theGrids[index].getActive().equals("BLOCKED")){
            if(currentPane == null){
                currentPane = stackPane;
                stackPane.setBackground(background);
                stackPane.requestFocus();
            }
            else{
                if(!stackPane.getId().equals(currentPane.getId())){
                    currentPane.setBackground(null);
                    currentPane = stackPane;
                    stackPane.setBackground(background);
                    stackPane.requestFocus();
                }
            }
        }
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
        LocalDate localDate = LocalDate.now();
        
        try{
            File imagePath = new File("ai-puzzles\\" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue() 
                    + "-" + localDate.getYear() + "/solution.PNG");
            
            if(imagePath.exists()){
                solutionImage.setImage(new Image(imagePath.toURI().toURL().toExternalForm()));
            }
        }catch(Exception e){
            solutionImage.setImage(null);
        }
        
    }    
    
}
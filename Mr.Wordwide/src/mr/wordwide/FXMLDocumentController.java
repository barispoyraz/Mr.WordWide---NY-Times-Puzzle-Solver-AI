/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. Hi
 */
package mr.wordwide;

import org.json.simple.JSONObject;
import com.jfoenix.controls.JFXButton;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FXMLDocumentController implements Initializable {
  
    LocalDate localDate = LocalDate.now();
    
    private boolean isDown;
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
    private Label solGrid0;
    @FXML
    private Label solGrid1;
    @FXML
    private Label solGrid2;
    @FXML
    private Label solGrid3;
    @FXML
    private Label solGrid4;
    @FXML
    private Label solGrid5;
    @FXML
    private Label solGrid6;
    @FXML
    private Label solGrid7;
    @FXML
    private Label solGrid8;
    @FXML
    private Label solGrid9;
    @FXML
    private Label solGrid10;
    @FXML
    private Label solGrid11;
    @FXML
    private Label solGrid12;
    @FXML
    private Label solGrid13;
    @FXML
    private Label solGrid14;
    @FXML
    private Label solGrid15;
    @FXML
    private Label solGrid16;
    @FXML
    private Label solGrid17;
    @FXML
    private Label solGrid18;
    @FXML
    private Label solGrid19;
    @FXML
    private Label solGrid20;
    @FXML
    private Label solGrid21;
    @FXML
    private Label solGrid22;
    @FXML
    private Label solGrid23;
    @FXML
    private Label solGrid24;
    
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
    
    //@FXML
    //private ImageView solutionImage = new ImageView();
    
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
    private GridPane solGrid;
    
    private String solPath = "";
    private String queryResultPath = "";
    private PuzzleQuestions puzzleQs;
    
    @FXML
    public void setPuzzleGrid(PuzzleStructure structure)
    {
        Grid[] grids = structure.getGrids();
        theGrids = grids;
        
        if(grids[0].getActive().equals("BLOCKED"))
        {
            puzzleGrid0.setStyle("-fx-background-color:ff5900");
            solGrid0.setStyle("-fx-background-color:ff5900");
            puzzleGrid0.setDisable(true);
            qNumber0.setText("");
        }
        else
        {
            puzzleGrid0.setStyle(null);
            solGrid0.setStyle(null);
            puzzleGrid0.setDisable(false);
            if(grids[0].getQNumber() != null)
                qNumber0.setText(" " + grids[0].getQNumber());
            else
                qNumber0.setText("");
        }
        
        if(grids[1].getActive().equals("BLOCKED"))
        {
            puzzleGrid1.setStyle("-fx-background-color:ff5900");
            solGrid1.setStyle("-fx-background-color:ff5900");
            puzzleGrid1.setDisable(true);
            qNumber1.setText("");
        }
        else
        {
            puzzleGrid1.setStyle(null);
            solGrid1.setStyle(null);
            puzzleGrid1.setDisable(false);
            if(grids[1].getQNumber() != null)
                qNumber1.setText(" " + grids[1].getQNumber());
            else
                qNumber1.setText("");
            
        }
        
        if(grids[2].getActive().equals("BLOCKED"))
        {
            puzzleGrid2.setStyle("-fx-background-color:ff5900");
            solGrid2.setStyle("-fx-background-color:ff5900");
            puzzleGrid2.setDisable(true);
            qNumber2.setText("");
        }
        else
        {
            puzzleGrid2.setStyle(null);
            solGrid2.setStyle(null);
            puzzleGrid2.setDisable(false);
            if(grids[2].getQNumber() != null)
                qNumber2.setText(" " + grids[2].getQNumber());
            else
                qNumber2.setText("");
        }
        
        if(grids[3].getActive().equals("BLOCKED"))
        {
            puzzleGrid3.setStyle("-fx-background-color:ff5900");
            solGrid3.setStyle("-fx-background-color:ff5900");
            puzzleGrid3.setDisable(true);
            qNumber3.setText("");
        }
        else
        {
            puzzleGrid3.setStyle(null);
            solGrid3.setStyle(null);
            puzzleGrid3.setDisable(false);
            if(grids[3].getQNumber() != null)
                qNumber3.setText(" " + grids[3].getQNumber());
            else
                qNumber3.setText("");
        }
        
        if(grids[4].getActive().equals("BLOCKED"))
        {
            puzzleGrid4.setStyle("-fx-background-color:ff5900");
            solGrid4.setStyle("-fx-background-color:ff5900");
            puzzleGrid4.setDisable(true);
            qNumber4.setText("");
        }
        else
        {
            puzzleGrid4.setStyle(null);
            solGrid4.setStyle(null);
            puzzleGrid4.setDisable(false);
            if(grids[4].getQNumber() != null)
                qNumber4.setText(" " + grids[4].getQNumber());
            else
                qNumber4.setText("");
                
        }
        
        if(grids[5].getActive().equals("BLOCKED"))
        {
            puzzleGrid5.setStyle("-fx-background-color:ff5900");
            solGrid5.setStyle("-fx-background-color:ff5900");
            puzzleGrid5.setDisable(true);
            qNumber5.setText("");
        }
        else
        {
            puzzleGrid5.setStyle(null);
            solGrid5.setStyle(null);
            puzzleGrid5.setDisable(false);
            if(grids[5].getQNumber() != null)
                qNumber5.setText(" " + grids[5].getQNumber());
            else
                qNumber5.setText("");
        }
        
        if(grids[6].getActive().equals("BLOCKED"))
        {
            puzzleGrid6.setStyle("-fx-background-color:ff5900");
            solGrid6.setStyle("-fx-background-color:ff5900");
            puzzleGrid6.setDisable(true);
            qNumber6.setText("");
        }
        else
        {
            puzzleGrid6.setStyle(null);
            solGrid6.setStyle(null);
            puzzleGrid6.setDisable(false);
            if(grids[6].getQNumber() != null)
                qNumber6.setText(" " + grids[6].getQNumber());
            else
                qNumber6.setText("");
        }
        
        if(grids[7].getActive().equals("BLOCKED"))
        {
            puzzleGrid7.setStyle("-fx-background-color:ff5900");
            solGrid7.setStyle("-fx-background-color:ff5900");
            puzzleGrid7.setDisable(true);
            qNumber7.setText("");
        }
        else
        {
            puzzleGrid7.setStyle(null);
            solGrid7.setStyle(null);
            puzzleGrid7.setDisable(false);
            if(grids[7].getQNumber() != null)
                qNumber7.setText(" " + grids[7].getQNumber());
            else
                qNumber7.setText("");
        }
        
        if(grids[8].getActive().equals("BLOCKED"))
        {
            puzzleGrid8.setStyle("-fx-background-color:ff5900");
            solGrid8.setStyle("-fx-background-color:ff5900");
            puzzleGrid8.setDisable(true);
            qNumber8.setText("");
        }
        else
        {
            puzzleGrid8.setStyle(null);
            solGrid8.setStyle(null);
            puzzleGrid8.setDisable(false);
            if(grids[8].getQNumber() != null)
                qNumber8.setText(" " + grids[8].getQNumber());
            else
                qNumber8.setText("");
        }
        
        if(grids[9].getActive().equals("BLOCKED"))
        {
            puzzleGrid9.setStyle("-fx-background-color:ff5900");
            solGrid9.setStyle("-fx-background-color:ff5900");
            puzzleGrid9.setDisable(true);
            qNumber9.setText("");
        }
        else
        {
            puzzleGrid9.setStyle(null);
            solGrid9.setStyle(null);
            puzzleGrid9.setDisable(false);
            if(grids[9].getQNumber() != null)
                qNumber9.setText(" " + grids[9].getQNumber());
            else
                qNumber9.setText("");
        }
        
        if(grids[10].getActive().equals("BLOCKED"))
        {
            puzzleGrid10.setStyle("-fx-background-color:ff5900");
            solGrid10.setStyle("-fx-background-color:ff5900");
            puzzleGrid10.setDisable(true);
            qNumber10.setText("");
        }
        else
        {
            puzzleGrid10.setStyle(null);
            solGrid10.setStyle(null);
            puzzleGrid10.setDisable(false);
            if(grids[10].getQNumber() != null)
                qNumber10.setText(" " + grids[10].getQNumber());
            else
                qNumber10.setText("");
        }
        
        if(grids[11].getActive().equals("BLOCKED"))
        {
            puzzleGrid11.setStyle("-fx-background-color:ff5900");
            solGrid11.setStyle("-fx-background-color:ff5900");
            puzzleGrid11.setDisable(true);
            qNumber11.setText("");
        }
        else
        {
            puzzleGrid11.setStyle(null);
            solGrid11.setStyle(null);
            puzzleGrid11.setDisable(false);
            if(grids[11].getQNumber() != null)
                qNumber11.setText(" " + grids[11].getQNumber());
            else
                qNumber11.setText("");
        }
        
        if(grids[12].getActive().equals("BLOCKED"))
        {
            puzzleGrid12.setStyle("-fx-background-color:ff5900");
            solGrid12.setStyle("-fx-background-color:ff5900");
            puzzleGrid12.setDisable(true);
            qNumber12.setText("");
        }
        else
        {
            puzzleGrid12.setStyle(null);
            solGrid12.setStyle(null);
            puzzleGrid12.setDisable(false);
            if(grids[12].getQNumber() != null)
                qNumber12.setText(" " + grids[12].getQNumber());
            else
                qNumber12.setText("");
        }
        
        if(grids[13].getActive().equals("BLOCKED"))
        {
            puzzleGrid13.setStyle("-fx-background-color:ff5900");
            solGrid13.setStyle("-fx-background-color:ff5900");
            puzzleGrid13.setDisable(true);
            qNumber13.setText("");
        }
        else
        {
            puzzleGrid13.setStyle(null);
            solGrid13.setStyle(null);
            puzzleGrid13.setDisable(false);
            if(grids[13].getQNumber() != null)
                qNumber13.setText(" " + grids[13].getQNumber());
            else
                qNumber13.setText("");
        }
        
        if(grids[14].getActive().equals("BLOCKED"))
        {
            puzzleGrid14.setStyle("-fx-background-color:ff5900");
            solGrid14.setStyle("-fx-background-color:ff5900");
            puzzleGrid14.setDisable(true);
            qNumber14.setText("");
        }
        else
        {
            puzzleGrid14.setStyle(null);
            solGrid14.setStyle(null);
            puzzleGrid14.setDisable(false);
            if(grids[14].getQNumber() != null)
                qNumber14.setText(" " + grids[14].getQNumber());
            else
                qNumber14.setText("");
        }
        
        if(grids[15].getActive().equals("BLOCKED"))
        {
            puzzleGrid15.setStyle("-fx-background-color:ff5900");
            solGrid15.setStyle("-fx-background-color:ff5900");
            puzzleGrid15.setDisable(true);
            qNumber15.setText("");
        }
        else
        {
            puzzleGrid15.setStyle(null);
            solGrid15.setStyle(null);
            puzzleGrid15.setDisable(false);
            if(grids[15].getQNumber() != null)
                qNumber15.setText(" " + grids[15].getQNumber());
            else
                qNumber15.setText("");
        }
        
        if(grids[16].getActive().equals("BLOCKED"))
        {
            puzzleGrid16.setStyle("-fx-background-color:ff5900");
            solGrid16.setStyle("-fx-background-color:ff5900");
            puzzleGrid16.setDisable(true);
            qNumber16.setText("");
        }
        else
        {
            puzzleGrid16.setStyle(null);
            solGrid16.setStyle(null);
            puzzleGrid16.setDisable(false);
            if(grids[16].getQNumber() != null)
                qNumber16.setText(" " + grids[16].getQNumber());
            else
                qNumber16.setText("");
        }
        
        if(grids[17].getActive().equals("BLOCKED"))
        {
            puzzleGrid17.setStyle("-fx-background-color:ff5900");
            solGrid17.setStyle("-fx-background-color:ff5900");
            puzzleGrid17.setDisable(true);
            qNumber17.setText("");
        }
        else
        {
            puzzleGrid17.setStyle(null);
            solGrid17.setStyle(null);
            puzzleGrid17.setDisable(false);
            if(grids[17].getQNumber() != null)
                qNumber17.setText(" " + grids[17].getQNumber());
            else
                qNumber17.setText("");
        }
        
        if(grids[18].getActive().equals("BLOCKED"))
        {
            puzzleGrid18.setStyle("-fx-background-color:ff5900");
            solGrid18.setStyle("-fx-background-color:ff5900");
            puzzleGrid18.setDisable(true);
            qNumber18.setText("");
        }
        else
        {
            puzzleGrid18.setStyle(null);
            solGrid18.setStyle(null);
            puzzleGrid18.setDisable(false);
            if(grids[18].getQNumber() != null)
                qNumber18.setText(" " + grids[18].getQNumber());
            else
                qNumber18.setText("");
        }
        
        if(grids[19].getActive().equals("BLOCKED"))
        {
            puzzleGrid19.setStyle("-fx-background-color:ff5900");
            solGrid19.setStyle("-fx-background-color:ff5900");
            puzzleGrid19.setDisable(true);
            qNumber19.setText("");
        }
        else
        {
            puzzleGrid19.setStyle(null);
            solGrid19.setStyle(null);
            puzzleGrid19.setDisable(false);
            if(grids[19].getQNumber() != null)
                qNumber19.setText(" " + grids[19].getQNumber());
            else
                qNumber19.setText("");
        }
        
        if(grids[20].getActive().equals("BLOCKED"))
        {
            puzzleGrid20.setStyle("-fx-background-color:ff5900");
            solGrid20.setStyle("-fx-background-color:ff5900");
            puzzleGrid20.setDisable(true);
            qNumber20.setText("");
        }
        else
        {
            puzzleGrid20.setStyle(null);
            solGrid20.setStyle(null);
            puzzleGrid20.setDisable(false);
            if(grids[20].getQNumber() != null)
                qNumber20.setText(" " + grids[20].getQNumber());
            else
                qNumber20.setText("");
        }
        
        if(grids[21].getActive().equals("BLOCKED"))
        {
            puzzleGrid21.setStyle("-fx-background-color:ff5900");
            solGrid21.setStyle("-fx-background-color:ff5900");
            puzzleGrid21.setDisable(true);
            qNumber21.setText("");
        }
        else
        {
            puzzleGrid21.setStyle(null);
            solGrid21.setStyle(null);
            puzzleGrid21.setDisable(false);
            if(grids[21].getQNumber() != null)
                qNumber21.setText(" " + grids[21].getQNumber());
            else
                qNumber21.setText("");
        }
        
        if(grids[22].getActive().equals("BLOCKED"))
        {
            puzzleGrid22.setStyle("-fx-background-color:ff5900");
            solGrid22.setStyle("-fx-background-color:ff5900");
            puzzleGrid22.setDisable(true);
            qNumber22.setText("");
        }
        else
        {
            puzzleGrid22.setStyle(null);
            solGrid22.setStyle(null);
            puzzleGrid22.setDisable(false);
            if(grids[22].getQNumber() != null)
                qNumber22.setText(" " + grids[22].getQNumber());
            else
                qNumber22.setText("");
        }
        
        if(grids[23].getActive().equals("BLOCKED"))
        {
            puzzleGrid23.setStyle("-fx-background-color:ff5900");
            solGrid23.setStyle("-fx-background-color:ff5900");
            puzzleGrid23.setDisable(true);
            qNumber23.setText("");
        }
        else
        {
            puzzleGrid23.setStyle(null);
            solGrid23.setStyle(null);
            puzzleGrid23.setDisable(false);
            if(grids[23].getQNumber() != null)
                qNumber23.setText(" " + grids[23].getQNumber());
            else
                qNumber23.setText("");
        }
        
        if(grids[24].getActive().equals("BLOCKED"))
        {
            puzzleGrid24.setStyle("-fx-background-color:ff5900");
            solGrid24.setStyle("-fx-background-color:ff5900");
            puzzleGrid24.setDisable(true);
            qNumber24.setText("");
        }
        else
        {
            puzzleGrid24.setStyle(null);
            solGrid24.setStyle(null);
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
        this.puzzleQs = puzzleQuestions;
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
        this.puzzleQs = puzzleQuestions;
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
    private void presentSolution(ActionEvent event) throws IOException
    {
        File f;
        
        if(solPath.length() == 0)
        {
            f = new File("ai-puzzles\\" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue() 
                + "-" + localDate.getYear() + "\\solution.txt");
        }
        else
            f = new File(solPath);
        if(f.exists() && !f.isDirectory()) 
        { 
            BufferedReader br;
            if(solPath.length() == 0)
            {   
                br = new BufferedReader(new FileReader("ai-puzzles/" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue() 
                + "-" + localDate.getYear() + "/solution.txt"));
            }
            else
                br = new BufferedReader(new FileReader(solPath));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                
                if(everything.charAt(0) != '-')
                    solGrid0.setText(everything.charAt(0) + "");
                if(everything.charAt(1) != '-')
                    solGrid1.setText(everything.charAt(1) + "");
                if(everything.charAt(2) != '-')
                    solGrid2.setText(everything.charAt(2) + "");
                if(everything.charAt(3) != '-')
                    solGrid3.setText(everything.charAt(3) + "");
                if(everything.charAt(4) != '-')
                    solGrid4.setText(everything.charAt(4) + "");
                if(everything.charAt(5) != '-')
                    solGrid5.setText(everything.charAt(5) + "");
                if(everything.charAt(6) != '-')
                    solGrid6.setText(everything.charAt(6) + "");
                if(everything.charAt(7) != '-')
                    solGrid7.setText(everything.charAt(7) + "");
                if(everything.charAt(8) != '-')
                    solGrid8.setText(everything.charAt(8) + "");
                if(everything.charAt(9) != '-')
                    solGrid9.setText(everything.charAt(9) + "");
                if(everything.charAt(10) != '-')
                    solGrid10.setText(everything.charAt(10) + "");
                if(everything.charAt(11) != '-')
                    solGrid11.setText(everything.charAt(11) + "");
                if(everything.charAt(12) != '-')
                    solGrid12.setText(everything.charAt(12) + "");
                if(everything.charAt(13) != '-')
                    solGrid13.setText(everything.charAt(13) + "");
                if(everything.charAt(14) != '-')
                    solGrid14.setText(everything.charAt(14) + "");
                if(everything.charAt(15) != '-')
                    solGrid15.setText(everything.charAt(15) + "");
                if(everything.charAt(16) != '-')
                    solGrid16.setText(everything.charAt(16) + "");
                if(everything.charAt(17) != '-')
                    solGrid17.setText(everything.charAt(17) + "");
                if(everything.charAt(18) != '-')
                    solGrid18.setText(everything.charAt(18) + "");
                if(everything.charAt(19) != '-')
                    solGrid19.setText(everything.charAt(19) + "");
                if(everything.charAt(20) != '-')
                    solGrid20.setText(everything.charAt(20) + "");
                if(everything.charAt(21) != '-')
                    solGrid21.setText(everything.charAt(21) + "");
                if(everything.charAt(22) != '-')
                    solGrid22.setText(everything.charAt(22) + "");
                if(everything.charAt(23) != '-')
                    solGrid23.setText(everything.charAt(23) + "");
                if(everything.charAt(24) != '-')
                    solGrid24.setText(everything.charAt(24) + "");
                    
            } finally {
                br.close();
            }
        }
        else
        {
            String solutionText = "";
            
            System.setProperty("webdriver.chrome.driver", 
                    "" + System.getProperty("user.dir") + "\\chromedriver\\chromedriver.exe");
                     
            WebDriver browser = new ChromeDriver();
            browser.get("https://www.nytimes.com/crosswords/game/mini");
            browser.findElement(By.className("buttons-modalButton--1REsR")).click();
            browser.findElement(By.xpath("//button[contains(text(),'reveal')]")).click();
            browser.findElement(By.xpath("/html/body/div/div/div/div[3]/div/main/div[2]/div/div/ul/div[1]/li[2]/ul/li[3]/a")).click();
            browser.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/article/div[2]/button[2]")).click();
            browser.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/a")).click();

            if(!theGrids[0].getActive().equals("BLOCKED"))
            {
                if(qNumber0.getText().length() == 1)
                    solGrid0.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(1) > text:nth-child(2)")).getText());
                else
                    solGrid0.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(1) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid0.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[1].getActive().equals("BLOCKED"))
            {
                if(qNumber1.getText().length() == 1)
                    solGrid1.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(2) > text:nth-child(2)")).getText());
                else
                    solGrid1.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(2) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid1.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[2].getActive().equals("BLOCKED"))
            {
                if(qNumber2.getText().length() == 1)
                    solGrid2.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(3) > text:nth-child(2)")).getText());
                else
                    solGrid2.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(3) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid2.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[3].getActive().equals("BLOCKED"))
            {
                if(qNumber3.getText().length() == 1)
                    solGrid3.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(4) > text:nth-child(2)")).getText());
                else
                    solGrid3.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(4) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid3.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[4].getActive().equals("BLOCKED"))
            {
                if(qNumber4.getText().length() == 1)
                    solGrid4.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(5) > text:nth-child(2)")).getText());
                else
                    solGrid4.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(5) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid4.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[5].getActive().equals("BLOCKED"))
            {
                if(qNumber5.getText().length() == 1)
                    solGrid5.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(6) > text:nth-child(2)")).getText());
                else
                    solGrid5.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(6) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid5.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[6].getActive().equals("BLOCKED"))
            {
                if(qNumber6.getText().length() == 1)
                    solGrid6.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(7) > text:nth-child(2)")).getText());
                else
                    solGrid6.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(7) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid6.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[7].getActive().equals("BLOCKED"))
            {
                if(qNumber7.getText().length() == 1)
                    solGrid7.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(8) > text:nth-child(2)")).getText());
                else
                    solGrid7.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(8) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid7.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[8].getActive().equals("BLOCKED"))
            {
                if(qNumber8.getText().length() == 1)
                    solGrid8.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(9) > text:nth-child(2)")).getText());
                else
                    solGrid8.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(9) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid8.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[9].getActive().equals("BLOCKED"))
            {
                if(qNumber9.getText().length() == 1)
                    solGrid9.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(10) > text:nth-child(2)")).getText());
                else
                    solGrid9.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(10) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid9.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[10].getActive().equals("BLOCKED"))
            {
                if(qNumber10.getText().length() == 1)
                    solGrid10.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(11) > text:nth-child(2)")).getText());
                else
                    solGrid10.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(11) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid10.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[11].getActive().equals("BLOCKED"))
            {
                if(qNumber11.getText().length() == 1)
                    solGrid11.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(12) > text:nth-child(2)")).getText());
                else
                    solGrid11.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(12) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid11.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[12].getActive().equals("BLOCKED"))
            {
                if(qNumber12.getText().length() == 1)
                    solGrid12.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(13) > text:nth-child(2)")).getText());
                else
                    solGrid12.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(13) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid12.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[13].getActive().equals("BLOCKED"))
            {
                if(qNumber13.getText().length() == 1)
                    solGrid13.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(14) > text:nth-child(2)")).getText());
                else
                    solGrid13.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(14) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid13.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[14].getActive().equals("BLOCKED"))
            {
                if(qNumber14.getText().length() == 1)
                    solGrid14.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(15) > text:nth-child(2)")).getText());
                else
                    solGrid14.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(15) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid14.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[15].getActive().equals("BLOCKED"))
            {
                if(qNumber15.getText().length() == 1)
                    solGrid15.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(16) > text:nth-child(2)")).getText());
                else
                    solGrid15.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(16) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid15.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[16].getActive().equals("BLOCKED"))
            {
                if(qNumber16.getText().length() == 1)
                    solGrid16.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(17) > text:nth-child(2)")).getText());
                else
                    solGrid16.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(17) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid16.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[17].getActive().equals("BLOCKED"))
            {
                if(qNumber17.getText().length() == 1)
                    solGrid17.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(18) > text:nth-child(2)")).getText());
                else
                    solGrid17.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(18) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid17.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[18].getActive().equals("BLOCKED"))
            {
                if(qNumber18.getText().length() == 1)
                    solGrid18.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(19) > text:nth-child(2)")).getText());
                else
                    solGrid18.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(19) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid18.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[19].getActive().equals("BLOCKED"))
            {
                if(qNumber19.getText().length() == 1)
                    solGrid19.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(20) > text:nth-child(2)")).getText());
                else
                    solGrid19.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(20) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid19.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[20].getActive().equals("BLOCKED"))
            {
                if(qNumber20.getText().length() == 1)
                    solGrid20.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(21) > text:nth-child(2)")).getText());
                else
                    solGrid20.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(21) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid20.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[21].getActive().equals("BLOCKED"))
            {
                if(qNumber21.getText().length() == 1)
                    solGrid21.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(22) > text:nth-child(2)")).getText());
                else
                    solGrid21.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(22) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid21.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[22].getActive().equals("BLOCKED"))
            {
                if(qNumber22.getText().length() == 1)
                    solGrid22.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(23) > text:nth-child(2)")).getText());
                else
                    solGrid22.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(23) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid22.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[23].getActive().equals("BLOCKED"))
            {
                if(qNumber23.getText().length() == 1)
                    solGrid23.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(24) > text:nth-child(2)")).getText());
                else
                    solGrid23.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(24) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid23.getText();
            }
            else
                solutionText = solutionText + "-";
            if(!theGrids[24].getActive().equals("BLOCKED"))
            {
                if(qNumber24.getText().length() == 1)
                    solGrid24.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(25) > text:nth-child(2)")).getText());
                else
                    solGrid24.setText(browser.findElement(By.cssSelector(".Board-svg--34be- > g:nth-child(2) > g:nth-child(25) > text:nth-child(3)")).getText());
                solutionText = solutionText + solGrid24.getText();
            }
            else
                solutionText = solutionText + "-";
        
            FileWriter fileWriter = new FileWriter("ai-puzzles/" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue() 
                + "-" + localDate.getYear() + "/solution.txt");
                
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(solutionText);
                bufferedWriter.newLine();
            }
        }
        
        solGrid.setVisible(true);
        
        
                
    }
    
    @FXML
    private void openDirectoryChooser(ActionEvent event) throws IOException{
    
        solGrid.setVisible(false);
        
        Node node = (Node)event.getSource();
        Window stage = node.getScene().getWindow();
        
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose a folder to open a puzzle");
        
        String path = new File("ai-puzzles")
                .getAbsolutePath();
           
        File firstDirectory = new File(path);
        directoryChooser.setInitialDirectory(firstDirectory);
        
        File directoryChoosen = directoryChooser.showDialog(stage);
        
        solPath = directoryChoosen.getAbsolutePath() + "/solution.txt";
        queryResultPath = directoryChoosen.getAbsolutePath() + "/queryResult.txt";
        File puzzle = 
                new File(directoryChoosen.getAbsolutePath() + "/puzzle.html");
        
        PuzzleQuestions puzzleQuestionsChoosen = 
                new PuzzleQuestions(puzzle.getAbsolutePath(), false);
        
        PuzzleStructure puzzleStructure = 
                new PuzzleStructure(puzzleQuestionsChoosen.getDocument());
        
        this.setAcrossQuestions(puzzleQuestionsChoosen);
        this.setDownQuestions(puzzleQuestionsChoosen);
        this.setPuzzleGrid(puzzleStructure);
        puzzleQuestionsChoosen.setPuzzleStructure(puzzleStructure);
        
        this.puzzleQs = puzzleQuestionsChoosen;
        
        //Testing
        this.puzzleQs.findClueLengths();
        
        
        if(currentPane != null){
            currentPane.setBackground(null);
            currentPane = null;
        }
        
        puzzleGrid0.setText("");
        puzzleGrid1.setText("");
        puzzleGrid2.setText("");
        puzzleGrid3.setText("");
        puzzleGrid4.setText("");
        puzzleGrid5.setText("");
        puzzleGrid6.setText("");
        puzzleGrid7.setText("");
        puzzleGrid8.setText("");
        puzzleGrid9.setText("");
        puzzleGrid10.setText("");
        puzzleGrid11.setText("");
        puzzleGrid12.setText("");
        puzzleGrid13.setText("");
        puzzleGrid14.setText("");
        puzzleGrid15.setText("");
        puzzleGrid16.setText("");
        puzzleGrid17.setText("");
        puzzleGrid18.setText("");
        puzzleGrid19.setText("");
        puzzleGrid20.setText("");
        puzzleGrid21.setText("");
        puzzleGrid22.setText("");
        puzzleGrid23.setText("");
        puzzleGrid24.setText("");
        
        
        solGrid0.setText("");
        solGrid1.setText("");
        solGrid2.setText("");
        solGrid3.setText("");
        solGrid4.setText("");
        solGrid5.setText("");
        solGrid6.setText("");
        solGrid7.setText("");
        solGrid8.setText("");
        solGrid9.setText("");
        solGrid10.setText("");
        solGrid11.setText("");
        solGrid12.setText("");
        solGrid13.setText("");
        solGrid14.setText("");
        solGrid15.setText("");
        solGrid16.setText("");
        solGrid17.setText("");
        solGrid18.setText("");
        solGrid19.setText("");
        solGrid20.setText("");
        solGrid21.setText("");
        solGrid22.setText("");
        solGrid23.setText("");
        solGrid24.setText("");
        
        //File image = new File(directoryChoosen.getAbsolutePath() + "/solution.PNG");
        
        //solutionImage.setImage(null);
        //solutionImage.setImage(new Image(image.toURI().toURL().toExternalForm()));
    }
    
    @FXML
    private void handleMouseClickOnGrids(Event event){
        StackPane stackPane = (StackPane)event.getSource();
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
                else
                    isDown = !isDown;
            }
        }
    }
    
    @FXML
    private void handleKeyPressed(KeyEvent keyEvent){
        KeyCode keyCode = keyEvent.getCode();

        if(keyCode != KeyCode.DELETE && keyCode != KeyCode.BACK_SPACE){  
            if(keyCode.isLetterKey()){
                ((Label)currentPane.getChildren().get(0)).setText(keyCode.getName());
                
                currentPane.setBackground(null);
                do
                {
                    if(!isDown)
                    {

                        if(Integer.parseInt(currentPane.getId().substring(4)) != 24)
                        {
                            currentPane = (StackPane)currentPane.getParent().getChildrenUnmodifiable().get(Integer.parseInt(currentPane.getId().substring(4)) + 1);

                        }
                        else
                        {
                            currentPane = (StackPane)currentPane.getParent().getChildrenUnmodifiable().get(0);
                            isDown = true;
                        }
                    }
                    else
                    {

                        if(Integer.parseInt(currentPane.getId().substring(4)) != 24)
                        {
                            if(Integer.parseInt(currentPane.getId().substring(4)) >= 20)
                            {
                                currentPane = (StackPane)currentPane.getParent().getChildrenUnmodifiable().get(Integer.parseInt(currentPane.getId().substring(4)) % 5 + 1);
                            }
                            else
                            {
                                currentPane = (StackPane)currentPane.getParent().getChildrenUnmodifiable().get(Integer.parseInt(currentPane.getId().substring(4)) + 5);
                            }
                        }
                        else
                        {
                            currentPane = (StackPane)currentPane.getParent().getChildrenUnmodifiable().get(0);
                            isDown = false;
                        }
                    }
                }while(currentPane.getChildren().get(0).isDisabled());
                
                currentPane.setBackground(background);
                currentPane.requestFocus();
            }
        }
        else{
            ((Label)currentPane.getChildren().get(0)).setText("");
            
            currentPane.setBackground(null);
            
            do
            {
                if(!isDown)
                {

                    if(Integer.parseInt(currentPane.getId().substring(4)) != 0)
                    {
                        currentPane = (StackPane)currentPane.getParent().getChildrenUnmodifiable().get(Integer.parseInt(currentPane.getId().substring(4)) - 1);

                    }
                    else
                    {
                        currentPane = (StackPane)currentPane.getParent().getChildrenUnmodifiable().get(24);
                        isDown = true;
                    }
                }
                else
                {
                    if(Integer.parseInt(currentPane.getId().substring(4)) != 0)
                    {
                        if(Integer.parseInt(currentPane.getId().substring(4)) <= 4)
                        {
                            currentPane = (StackPane)currentPane.getParent().getChildrenUnmodifiable().get(Integer.parseInt(currentPane.getId().substring(4)) - 1 + 20);
                        }
                        else
                        {
                            currentPane = (StackPane)currentPane.getParent().getChildrenUnmodifiable().get(Integer.parseInt(currentPane.getId().substring(4)) - 5);
                        }
                    }
                    else
                    {
                        currentPane = (StackPane)currentPane.getParent().getChildrenUnmodifiable().get(24);
                        isDown = false;
                    }
                }
            }while(currentPane.getChildren().get(0).isDisabled());

            currentPane.setBackground(background);
            currentPane.requestFocus();
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
    
    @FXML
    private void solve(ActionEvent event) throws IOException{
        File f;
        String key ="AIzaSyCiVLcICXumdXQNxD22D6iuYC-DwN-va7Q";
        String cx = "002788185550341638251:drb89hhatq8";
        
        
        JSONObject result;
        JSONParser jsonParser = new JSONParser();
        JSONArray items;

        int sizeAcross = this.puzzleQs.getAcrossQuestions().length;
        int sizeDown = this.puzzleQs.getDownQuestions().length;

        Question[] acrossQs = this.puzzleQs.getAcrossQuestions();
        Question[] downQs = this.puzzleQs.getDownQuestions();

        System.out.println("Across size: " + sizeAcross);
        System.out.println("Down size: " + sizeDown);
             
//            acrossQs[0].findFrequencies();
            //Çalışınca sizeAcross ile değiştirelim
            /*for(int i = 0; i < 1; i++){
                acrossQs[i].query(key, cx);
            }
        
            //Çalışınca sizeDown ile değiştirelim
            for(int i = 0; i < 1; i++){
                downQs[i].query(key, cx);
            }*/
            
            
        
                                
        /*try
        {
            URL url = new URL(
            "https://www.googleapis.com/customsearch/v1?key="+key+ "&cx="+ cx + "&" + "q=" + q + "&alt=json");
              
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
            
            Object res = jsonParser.parse(output);
            result = (JSONObject) res;
                       
            items = (JSONArray) result.get("items");
            
            conn.disconnect();
        }
        catch(IOException | ParseException ex)
        {
        }*/
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //LocalDate localDate = LocalDate.now();
        isDown = false;
        /*
        try{
            File imagePath = new File("ai-puzzles\\" + localDate.getDayOfMonth() + "-" + localDate.getMonthValue() 
                    + "-" + localDate.getYear() + "/solution.PNG");
            
            if(imagePath.exists()){
                solutionImage.setImage(new Image(imagePath.toURI().toURL().toExternalForm()));
            }
        }catch(Exception e){
            solutionImage.setImage(null);
        }
        */
    }    
}
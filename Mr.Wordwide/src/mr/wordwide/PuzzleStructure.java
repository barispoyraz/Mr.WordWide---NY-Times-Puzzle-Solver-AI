/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class PuzzleStructure {
    
    private final String PUZZLE_STRUCTURE_CLASS = "Board-svg--34be-";
    private final String ACTIVE_GRID_CLASS = "Cell-cell--1p4gH";
    private final String BLOCKED_GRID_CLASS = "Cell-block--1oNaD";
    
    private final Document document;
    
    private Grid[] grids;
    
    public PuzzleStructure(Document document){
        this.document = document;
        
        parseThePuzzleStructure(document);
    }

    private void parseThePuzzleStructure(Document document) {
        
        grids = new Grid[25];
        
        Elements structure = document.getElementsByClass(PUZZLE_STRUCTURE_CLASS);
        
        if(structure != null){
            //Grids start from index 4
        
            Elements gridProperties = structure.eq(0).select("g");

            int gridNo;
            String number; 
            String active;

            Elements grid;


            for(int i = 4; i < 29; i++){
                grid = gridProperties.eq(i);
                gridNo = i - 4;

                if(grid.select("rect").hasClass(ACTIVE_GRID_CLASS)){
                    active = "ACTIVE";
                }
                else{
                    active = "BLOCKED";
                }

                if(active.equals("BLOCKED")){
                    number = "";
                }
                else{
                    number = grid.select("text").text();
                }

                this.grids[gridNo] = new Grid(gridNo, number, active);

            }
        }
    }
    
    public Grid[] getGrids(){
        return this.grids;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class PuzzleStructure {
    
    private final String PUZZLE_STRUCTURE_CLASS = "Board-svg--34be-";
    private final String ACTIVE_GRID_CLASS = "Cell-cell--1p4gH";
    private final String BLOCKED_GRID_CLASS = "Cell-block--1oNaD";
    
    private Document document;
    
    private Grid[] grids;
    
    public PuzzleStructure(Document document){
        this.document = document;
        
        parseThePuzzleStructure(document);
    }

    private void parseThePuzzleStructure(Document document) {
        
        grids = new Grid[25];
        
        Elements structure = document.getElementsByClass(PUZZLE_STRUCTURE_CLASS);
        
        if(structure == null){
            System.out.println("it is null!");
        }
        
        System.out.println("SIZE: " + structure.eq(0).select("g").size());
        System.out.println("------------------------------");
        
        //Grids start from index 4
        
        Elements gridProperties = structure.eq(0).select("g");
        
        int gridNo;
        String number; 
        String active;
        
        Elements grid;
        
        
        for(int i = 4; i < 29; i++){
            grid = gridProperties.eq(i);
            gridNo = i -4;
            
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
        
        for(Grid theGrid : grids){
            System.out.println(theGrid.toString());
        }
        
        /*//System.out.println(gridProperties.eq(4).select("rect"));
        System.out.println(gridProperties.eq(4).select("text").text());
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        if(gridProperties.eq(8).select("text").text() == null){
            System.out.println("NULLLLLL");
        }
        System.out.println(gridProperties.eq(8).select("text").text());
        //Elements gridPropertiesChild = gridProperties.eq
        
        //System.out.println(structure.eq(0).select("g").eq(4).toString());
        
        //System.out.println(gridProperties.eq(4).select());
        
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println(gridProperties.eq(4).first().toString());
        System.out.println("------------------------------");
        System.out.println(gridProperties.eq(4).first().hasClass(ACTIVE_GRID_CLASS ));
        System.out.println("------------------------------");
        System.out.println(structure.eq(0).select("g").eq(8).toString());
        System.out.println("------------------------------");
        System.out.println(gridProperties.eq(8).select("." + BLOCKED_GRID_CLASS ));
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("------------------------------");*/
    }
}

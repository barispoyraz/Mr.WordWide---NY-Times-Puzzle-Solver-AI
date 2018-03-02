/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

public class Grid {
    
    private int gridNo;
    private String number;
    private String active;
    
    public Grid(int gridNo, String number, String active){
        this.gridNo = gridNo;
        this.number = number;
        this.active = active;
    }
    
    public String toString(){
        return "Grid no: " + this.gridNo + ", number: " 
                + this.number + ", active: " + this.active;
    }
    
    public String getActive()
    {
        return active;
    }
}

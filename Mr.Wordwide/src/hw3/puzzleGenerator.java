package hw3;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Can
 */
public class puzzleGenerator {
    static ArrayList<ArrayList<Integer>> existingPuzzles = new ArrayList<ArrayList<Integer>>();
    
    public static void shuffle(ArrayList<Integer> puzzle){
        int puzzleLength = puzzle.size();
        int change;
        int helper;
        Random random = new Random();
        random.nextInt();
        for(int i = 0; i < puzzleLength; i++){
            change = i + random.nextInt(puzzleLength - i);
            helper = puzzle.get(i);
            puzzle.set(i, puzzle.get(change));
            puzzle.set(change, helper);
        }
    }
    
    public static boolean inversionChecker(ArrayList<Integer> puzzle){
        int numberOfInversions = 0;
        int[] arrayWithoutZero  = new int[puzzle.size() - 1];
        int loc = 0;
        for(int i = 0; i < puzzle.size(); i++){
            if(puzzle.get(i) != 0){
                arrayWithoutZero[loc] = puzzle.get(i);
                loc++;
            }
        }
        
        for(int i = 0; i < arrayWithoutZero.length; i++){
            for(int j = i+1; j < arrayWithoutZero.length; j++){
                if(arrayWithoutZero[i] > arrayWithoutZero[j]){
                    numberOfInversions++;
                }
            }
        }
        
        System.out.println("numberOfInversion: " + numberOfInversions );
        return numberOfInversions % 2 == 0;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> puzzle = new ArrayList<>();
        puzzle.add(0);
        puzzle.add(1);
        puzzle.add(2);
        puzzle.add(3);
        puzzle.add(4);
        puzzle.add(5);
        puzzle.add(6);
        puzzle.add(7);
        puzzle.add(8);
        
        boolean check = false;
        int i= 0;
        
        while(i < 25){
            while(!check ){
                shuffle(puzzle);
                check = inversionChecker(puzzle);
            }
            existingPuzzles.add(puzzle);
            check = false;
            i++;
            puzzle.forEach((j) -> {
                System.out.println(j);
            });
        }
        
        

    }
    
}

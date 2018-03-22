
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

    public static void shuffle(int[] array){
        int arrayLength = array.length;
        Random random = new Random();
        random.nextInt();
        for(int i = 0; i < arrayLength; i++){
            int change = i + random.nextInt(arrayLength - i);
            int helper = array[i];
            array[i] = array[change];
            array[change] = helper;
        }
    }
    
    public static boolean inversionChecker(int[] array){
        int numberOfInversions = 0;
        int[] arrayWithoutZero  = new int[array.length-1];
        int loc = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] != 0){
                arrayWithoutZero[loc] = array[i];
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
        int[] array = {7,0,2,8,5,3,6,4,1};
        boolean check = false;
        int i= 0;
        
        while(i < 25){
            while(!check ){
            shuffle(array);
            check = inversionChecker(array);
        }
            check = false;
            i++;
            for(int j: array)
                System.out.println(j);
        }
        
        

    }
    
}

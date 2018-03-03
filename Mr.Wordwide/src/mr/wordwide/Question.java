/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mr.wordwide;

public class Question {
    
    private String questionType;
    private String questionNumber;
    private String question;
    
    public Question(String questionType, String questionNumber, String question){
        this.questionType = questionType;
        this.questionNumber = questionNumber;
        this.question = question;
    }
    
    public String toString(){
        return "" + this.questionNumber + "." + this.question;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loterry;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author matheusdiniz
 */
public class Loterry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create an array to store the winning numbers
        int[] winNumbers = new int[10];
        //variable to store the sum of the winning numbers
        int sum = 0;
        Random r = new Random();
        // for loop to create an array getting random numbers from 1 to 99
        for (int i = 0; i < winNumbers.length; i++) {
            winNumbers[i] = r.nextInt(1, 99);
            //print the array with a zero to the left if the number originaly has only one digit
            System.out.print(String.format("%02d",winNumbers[i])+ " ");
            // calculate the sum of the winning numbers
            sum += winNumbers[i];
        }
        // display the sum of them
        System.out.println("");
        System.out.println("The Winning Numbers' sum is: "+sum);
        System.out.println("************");

        //BONUS GAME
        //create arrays to store the sums numbers and to store the numbers which are going to be displayed... 
        //...regarding to the bonus prize if they get the right percentage to it.
        int[] bonusNumbers = {10,20,50,200,1000};
        int[] arrayBonus = new int[4];
        //number stores due to percentage
        int numberPercent = 0;
        //generate a random number between 0.0 and 0.99 to represent the percentage of the bonus game
        double randNum = r.nextDouble();
        //group of if's/else's which are going to check which the percentage got from randNum is related to which prize
        //50%
        if (randNum < 0.50) {
            //prize related to the respective percentage
            numberPercent = 10;
            //create and atribute to the array four prize sums and the one which comes twice regarded to the percentage asked on the question 
            arrayBonus[0] = 10; arrayBonus[1] = 10; arrayBonus[2] = 50; arrayBonus[3] = 200;
        }
        //27%
        else if (randNum > 0.50 && randNum < 0.77) {
            numberPercent = 20;
            arrayBonus[0] = 20; arrayBonus[1] = 50; arrayBonus[2] = 20; arrayBonus[3] = 1000;
        }
        //15%
        else if (randNum > 0.77 && randNum < 0.92) {
            numberPercent = 50;
            arrayBonus[0] = 10; arrayBonus[1] = 50; arrayBonus[2] = 20; arrayBonus[3] = 50;
        }
        //6%
        else if (randNum > 0.92 && randNum < 0.98) {
            numberPercent = 200;
            arrayBonus[0] = 10; arrayBonus[1] = 200; arrayBonus[2] = 20; arrayBonus[3] = 200;
        }
        //2%
        else {
            numberPercent = 1000;
            arrayBonus[0] = 1000; arrayBonus[1] = 10; arrayBonus[2] = 1000; arrayBonus[3] = 20;
        }
        // loop responsable to display the four prize sums due to the percentage
        for (int i = 0; i < arrayBonus.length; i++) { 
            System.out.println(arrayBonus[i]);
        }
        //shows the amount you've won due to the percentage
        System.out.println("Congratulations, you've just got €"+numberPercent+" added to you total prize.");
        
        //NUMBER 3
        Scanner sc = new Scanner(System.in);
        //create variables responsable to store the user input when asked to enter the 5 numbers in sequence
        //and responsable to store the guess the user will make about the sum of all winning numbers 
        //and a count to store how many times the for loop went through 
        int userInput = 0, guess = 0, coun=0;
        boolean valid = false;
        //create an array to store the numbers typed for the user which must be unique
        int[] uniqueTNumbers = new int[5];   
        //decided to use Set because as the question asked to ignore when the user entered a number that they had entered already...
        //... and as I searched how to do it because I had no idea, I found that the Set does that.
        Set<Integer> setUniqueNum = new HashSet<>();
        
        //create a loop that will run until the setUniqueNum size is iqual to 5  (it starts at 0)
        while (setUniqueNum.size() < 5) {
            //create a do while to ask at least once to the user to enter some number and try to see if it is an integer and if it's not, it asks again...
            //due to the try/catch
            do{
            
                System.out.println("Please enters a number that you want to play: ");
                // it tries to do the code inside the try and if it can't it goes to the catch
                try{
                    //gets the user number
                    userInput = sc.nextInt();
                    //add to the setUniqueNumber a number which has not been added yet, if the users type again the same number it doesn't add to it...
                    //... and it doesn't add to its size, making the loop keep runing until it's size 5
                    setUniqueNum.add(userInput);
                    valid = true;                  
                }
                catch(Exception e) {
                    System.out.println("That is NOT a number, please enter a number between 1 and 99!");
                    sc.nextLine();
                    valid = true;
                }
            
            }while(!valid);
        }
        // for loop that runs 5 times getting each setUniqueNum value. and put them to the "t" variable and after put them to our array
        for (Integer t : setUniqueNum){
            //add one by one setUniqueNum value to the uniqueTNumbers at position count which starts at 0 and goes until the array has its 5 values typed by the user
            uniqueTNumbers[coun] = t;
            coun++;           
        }
        //asks the user to guess the winning number sum
        System.out.println("Please guess the sum of all ten winning numbers: ");
        // stores the winning number sum guess
        guess = sc.nextInt();
        
        
        //NUMB 4
        int method1=0;
        int iqualCount = 0;
        for (int i = 0; i < uniqueTNumbers.length; i++) { 
            for (int j = 0 ; j < winNumbers.length; j++) {
                if (uniqueTNumbers[i] == winNumbers[j]) { 
                    iqualCount++;
                }     
            }   
        }
        switch(iqualCount) {
            case 1 :
                //System.out.println("Congratulation, you've got a €1,000 more.");
                method1 = 1000;
                break;
            case 2 : 
                //System.out.println("Congratulation, you've got a €6,000 more.");
                method1 = 6000;
                break;
            case 3 : 
                //System.out.println("Congratulation, you've got a €25,000 more.");
                method1 = 25000;
                break;
            case 4 : 
                //System.out.println("Congratulation, you've got a €100,000 more.");
                method1 = 100000;
                break;
            case 5 : 
                //System.out.println("Congratulation, you've got a €800,000 more.");
                method1 = 800000;
                break;
          }
        
        
        //NUMB 5
        int method2=0;
        if (guess == sum) {
            //System.out.println("Congratulation, you've just won €300,000 more.");
            method2 = 300000;
        }
        
        
        //NUMB6
        int total;
//        int number = Integer.parseInt(strNumber);
        if (method1 > method2) {
            total = (numberPercent+method1);
            System.out.println("Congratulation, you've just won in total a value of €"+total+".");
        }
        else{
            total = (numberPercent+method2);
            System.out.println("Congratulation, you've just won in total a value of €"+total+".");
        }
    }
}
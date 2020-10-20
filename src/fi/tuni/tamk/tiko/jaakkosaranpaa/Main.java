
package fi.tuni.tamk.tiko.jaakkosaranpaa;

import java.io.Console;
import fi.tuni.tamk.tiko.jaakkosaranpaa.util.Arrays;
import fi.tuni.tamk.tiko.jaakkosaranpaa.util.Math;
import fi.tuni.tamk.tiko.jaakkosaranpaa.util.MyConsole;
import fi.tuni.tamk.tiko.jaakkosaranpaa.util.Properties;

/**
 * The Main class has two methods, the main method for asking the user their lotterynumbers and calculating the time it takes to win,
 * and the private calculateLotto method for creating a random array of lotterynumbers
 * 
 * The Main class also uses classes Arrays, Math, MyConsole and Properties to function
 * 
 * @author Jaakko Saranpää
 */
public class Main {
    /**
     * Plays a lottery game, asking the user their lotterynumbers and calculating the time it takes to win
     * 
     */
    public static void main(String [] args) {
        Console c = System.console();
        boolean duplicate = false; //a boolean for breaking the loop if the user gives duplicate values

        System.out.println("Do you want to print your, and the correct lotterynumbers during the calculations? (true/false)");
        boolean printNumbers = Boolean.parseBoolean(c.readLine()); //if true, the app will print the users and the random lotteryarrays everytime

        System.out.println("Do you want to repeat the calculation until you win within a lifetime (120 years)? (true/false)");
        boolean repeat = Boolean.parseBoolean(c.readLine()); //if true, will repeat the app until it got 7 right in 120 years

        int [] userLotteryNumbers = new int [Properties.amountOfNumbers()]; //users lotterynumbers are stored here

        for(int i = 0; i < Properties.amountOfNumbers(); i++) { //asks the user their lotterynumbers
            System.out.println("Please give a unique number between [1, " + Properties.maxLottoNum() + "]");
            int tempNum = MyConsole.readIntMinMax(1, Properties.maxLottoNum(), "Please give a numerical value", "Please keep the numbers between [1, " + Properties.maxLottoNum() + "]");
            if(Arrays.contains(tempNum, userLotteryNumbers) == false) {
                userLotteryNumbers[i] = tempNum;
                tempNum = 0;
            } else {
                System.out.println("You already chose this number, please start again");
                duplicate = true;
                break;
            }
            
        }
        
        boolean withinLifetime = false;

        if(duplicate == false) { //if user entered duplicate lotterynumbers, the app won't run
            while (withinLifetime == false) {
                boolean won = false;
                int amount = 1;
                for(int week = 0; won == false; week++) {
                    int [] tempArrayUser = Arrays.sort(userLotteryNumbers); //makes a temporary array where the users lotterynumbers can be sorted into
                    int [] tempArrayNumbers = Arrays.sort(calculateLotto()); //makes a temporary array where the random lotterynumbers can be sorted into
                    if(Arrays.containsSameValues(tempArrayUser, tempArrayNumbers) == amount) {
                        if(week < 52) {
                            System.out.println("You got " + amount + " right! It took " + week + " weeks");
                        } else if (week > 51 && amount != Properties.amountOfNumbers()) {
                            System.out.println("You got " + amount + " right! It took " + (week/52) + " years");
                        } else if (amount == Properties.amountOfNumbers()) { //if every number is correct
                            System.out.println("You got " + amount + " right! It took " + (week/52) + " years");
                            System.out.println("You won!");
                            won = true;  //will end the for-loop running one iteration
                            if((week/52) > 120 && repeat == true) {
                                System.out.println("It took more than a lifetime, let's try again");
                            } else {
                                if(repeat == true) {
                                    System.out.println("You should go buy a lotteryticket, you got " + Properties.amountOfNumbers() + " right within a lifetime");
                                }
                                withinLifetime = true; //will end the while-loop running the whole game when won
                            }
                        }
                        amount++;

                        if (printNumbers == true) {
                            Arrays.printArray(tempArrayUser);
                            Arrays.printArray(tempArrayNumbers);
                        }
                    }
                    tempArrayUser = null; //makes the temporary array empty for a second iteration
                    tempArrayNumbers = null; //^^
                }
            
            }   
        }
        
    }
    /**
     * calculateLotto creates an array including unique random numbers between two values
     * 
     * 
     * @return lotteryNumbers, which is an int array with random lotterynumbers
     */

    private static int[] calculateLotto() {
        int [] lotteryNumbers = new int [Properties.amountOfNumbers()];
        for(int i = 0; i < Properties.amountOfNumbers(); i++) {
            int randomNumber = Math.getRandom(1, Properties.maxLottoNum());
            if(Arrays.contains(randomNumber, lotteryNumbers) == false) {
                lotteryNumbers[i] = randomNumber;
            } else {
                i--;
            }

        }
        return lotteryNumbers;
    }

    
}
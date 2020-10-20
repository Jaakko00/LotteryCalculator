package fi.tuni.tamk.tiko.jaakkosaranpaa.util;

/**
 * The Properties class includes properties for a lotterygame
 * 
 * @author Jaakko Saranpää
 * 
 */
public class Properties {
    /**
     * maxLottoNum stores the maximum numbervalue you can have as your lotterynumber, the default is set to 40
     * 
     * @return returns the maximum number set
     */
    public static int maxLottoNum() {
        int max = 40;
        return max;
    }

    /**
     * amountOfNumbers method stores the amount of numbers correct needed to win the jackpot, the default is set to 7
     * 
     * @return return the amount of numbers needed for a jackpot
     */
    public static int amountOfNumbers() {
        int amount = 7;
        return amount;
    }
}

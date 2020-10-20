package fi.tuni.tamk.tiko.jaakkosaranpaa.util;
/**
 * Math class has functions related to math
 * @author Jaakko Saranpää
 */
public class Math {
    /**
     * getRandom method creates a random number between the given minimum and maximum values
     * 
     * @param min
     * @param max
     * @return int
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}
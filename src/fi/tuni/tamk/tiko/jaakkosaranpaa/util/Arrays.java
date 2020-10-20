package fi.tuni.tamk.tiko.jaakkosaranpaa.util;



/**
 * class Arrays includes methods used for changing and printing arrays
 * @author Jaakko Saranpää
 */

public class Arrays {
    /**
     * toIntArray changes a String array to an Int array
     * @param array 
     * @return
     */
    public static int [] toIntArray(String [] array) {
        int [] IntegerArray = new int [array.length];
        for(int i = 0; i < array.length; i++) {
            IntegerArray[i] = Integer.parseInt(array[i]);
        }
        return IntegerArray;

    }
    /**
     * contains gives a boolean value whether the given int array contains the given integer value
     * @param value
     * @param array
     * @return
     */
    public static boolean contains(int value, int [] array) {
        boolean outcome = false;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == value) {
                outcome = true;
            }
        }
        return outcome;
    }
    /**
     * containsSameValues checks how many same value digits do two arrays contain
     * @param array1
     * @param array2
     * @return
     */
    public static int containsSameValues(int [] array1, int [] array2) { 
        int amount = 0;
        for(int i = 0; i < array1.length; i++) {
            for(int j = 0; j < array2.length; j++) {
                if(array1[i] == array2[j]) {
                    amount++;
                }
            }
        }
        return amount;
    }
    /**
     * sort method sorts an int array from smallest to biggest
     * @param array
     * @return
     */
    public static int [] sort(int [] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array [j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
        
    }
    /**
     * printArray prints an array, ex. [1, 2, 3, 4, 5]
     * @param array
     */
    public static void printArray(int [] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            if(i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else if (i == array.length - 1) {
                System.out.print(array[i]);
            }
        }
        System.out.print("]");
        System.out.println();
        
    }
}

    


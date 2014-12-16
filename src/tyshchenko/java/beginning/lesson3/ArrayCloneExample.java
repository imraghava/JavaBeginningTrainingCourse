package tyshchenko.java.beginning.lesson3;

/**
 * author Alexander Tyshchenko.
 */
public class ArrayCloneExample {
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1};
        int[] numbersClone = numbers.clone();

        System.out.println(
                numbersClone[0] +
                numbersClone[1] +
                numbersClone[2] +
                numbersClone[3]);
        System.out.println(numbers);
        System.out.println(numbersClone);
    }
}




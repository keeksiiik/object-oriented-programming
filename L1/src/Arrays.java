import java.util.*;

public class Arrays {

    public static void main(String[] args) {
        int[][] array = createArray(5, 5);
        printArray(array);
        Set<Integer> uniqueElements = getUniqueElements(array);
        printSortedUniqueElements(sortUniqueElements(uniqueElements));
    }

    public static int[][] createArray (int numRows, int numColumns) {

        Random random = new Random();

        int[][] array = new int[numRows][numColumns];
        for (int row = 0; row < numRows; row++) {
            for(int column = 0; column < numColumns; column++) {
                array[row][column] = random.nextInt(50) + 1;
            }
        }
        return array;
    }

    public static Set<Integer> getUniqueElements(int[][] array) {
        Set<Integer> uniqueElements = new HashSet<>();

        for (int[] row : array) {
            for (int element : row) {
                uniqueElements.add(element);
            }
        }
        return uniqueElements;
    }

    public static void printArray(int[][] array) {
        System.out.println(java.util.Arrays.deepToString(array).replace("], ", "]\n"));
    }

    public static List<Integer> sortUniqueElements (Set<Integer> uniqueElements) {
        List<Integer> sortedUniqueElements = new ArrayList<>(uniqueElements);
        Collections.sort(sortedUniqueElements);
        return sortedUniqueElements;
    }

    public static void printSortedUniqueElements(List<Integer> sortedUniqueElements) {
        System.out.print("Неповторяющиеся элементы двумерного массива: ");
        for (int element : sortedUniqueElements) {
            System.out.printf("%s; ", element);
        }
    }
}
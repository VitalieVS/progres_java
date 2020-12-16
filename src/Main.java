import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    int n = 0;
    int[] array;
    int[] resultArray;

    @Test
    public void progres() {
        readData();
        solve();
        showResult();
    }

    private void solve() {
        int j = 0;
        sortArray();
        int currentElem = array[0];
        int progression = getProgression();
        do {
            currentElem += progression;
            resultArray = addElem(j, resultArray, currentElem);
            j++;
        } while (currentElem != array[array.length - 1]);

    }

    private void showResult() {
        for (int elem : resultArray) {
            System.out.print(elem + " ");
        }
    }

    private void sortArray() {
        Arrays.sort(array);
    }

    private int getProgression() {
        if (array.length > 2) {
            return array[1] - array[0];
        } else {
            return 0;
        }
    }

    private void readData() {
        try {
            File file = new File("input.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(" ");
                for (String datum : data) {
                    array = addElem(n, array, Integer.parseInt(datum));
                    n++;
                }
            }
            reader.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private static int[] addElem(int n, int[] arr, int x) {
        int i;
        int[] newArr = new int[n + 1];
        for (i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        newArr[n] = x;

        return newArr;
    }
}

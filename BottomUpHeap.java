import java.util.*;
/**
 * Created by Tian on 11/6/14.
 */
public class BottomUpHeap {
    //Sorts a given array of ints by bottom up heap algorithm
    public static int[] bottomUpHeap(int[] array) {
        int n = array.length;

        for (int i = n/2; i > 0; i--) {
            int k = i;
            int v = array[k - 1];
            boolean heap = false;

            while (!heap && ((2 * k) <= n)) {
                int j = 2 * k;
                if (j < n) { //there are 2 children
                    if (array[j - 1] < array[j + 1]) {
                        j += 1;
                    }
                }
                if (v >= array[j - 1]) {
                    heap = true;
                } else {
                    array[k - 1] = array[j - 1];
                    k = j;
                }
            }
            array[k - 1] = v;
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter number of values to test: ");
        int input = in.nextInt(); //Number of nodes

        int[] array = new int[input];

        Random r = new Random();
        for (int i = 0; i < input; i++) {
            array[i] = r.nextInt(100); //from 0 to 99
        }

        long startTime = System.nanoTime();
        int[] newArray = bottomUpHeap(array);
        long endTime = System.nanoTime();
        System.out.println(Arrays.toString(newArray));
        long duration = (endTime - startTime);
        System.out.println("Run Time: " + duration + " milliseconds");
    }
}

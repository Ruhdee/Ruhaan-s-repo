import java.util.Scanner;

public class QuickSort_Java {

    int[] arr;
    static int length;

    public static void main(String[] args) {
        QuickSort_Java A = new QuickSort_Java();
        A.input();
        A.quicksort(0,length-1);

    }

    public void input() {
        System.out.println("Enter length of array");
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        arr=new int[length];
        for (int i = 0; i < length; i++) { //assigning values between 0 to 100 to array elements
            arr[i] = (int) (Math.random() * 100);
        }
        output();
    }

    public void output() {
        for(int i=0;i<length;i++)
            System.out.print(arr[i]+"   ");
        System.out.println();
    }

    public void quicksort(int low, int high) {
        if (low < high) {
            int pidx = part(low, high);
            quicksort(low, pidx - 1);
            quicksort(pidx + 1, high);
        }
    }

    public int part(int low, int high) {
        int i = high + 1;
        int temp;
        for (int j = high; j > low; j--) {
            if (arr[j] > arr[low]) {//pivot is arr[low]
                i--;
                temp = arr[i]; //swapping
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i--;
        temp = arr[i];  //swapping pivot to final location
        arr[i] = arr[low];
        arr[low] = temp;
        output();
        return i;
    }
}

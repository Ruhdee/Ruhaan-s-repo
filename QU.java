import java.util.Scanner;
//Program implementing weighted quick union algorithm with path compression.
public class QU {
    int[] id;   //parent value of element
    int[] height;   //height of longest root of element

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(); //N is number of elements
        QU qu=new QU(N);
    }

    public QU(int N) {  //constructor
        id = new int[N];
        height = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i; //Initializing id having same value as element
            height[i] = 0;    //height of all roots is initially 0
        }
    }

    public int root(int i) {
        if (id[i] != i) {
            id[i] = root(id[i]);//path compression using recursion
        }
        return id[i];
    }

    public boolean find(int p, int q) { //to check if two elements are connected
        return id[root(p)] == id[root(q)];
    }

    public void union(int p, int q) {   //to join 2 elements
        if (height[root(p)] < height[root(q)]) {
            id[root(p)] = id[root(q)];
        } else if (height[root(p)] > height[root(q)]) {
            id[root(q)] = id[root(p)];
        } else if (height[root(p)] == height[root(q)]) {
            id[root(q)] = id[root(p)];
            height[root(p)]++;
        }
    }

}

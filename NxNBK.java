import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

public class NxNBK
{
    // instance variables - replace the example below with your own
    private int n;
    private int[] oneDim = new int[n*n];
    private int[][] twoDim = new int[n][n];
    private ArrayList<Integer> myArrList = new ArrayList<Integer>();
    

    public NxNBK(int num)
    {
        // initialise instance variables
        n = num;
        oneDim = new int[n*n];
        twoDim = new int[n][n];
        for (int i = 0; i < n*n; i++){
            oneDim[i] = i+1;
            myArrList.add(i+1);
        }
        
        int count = 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                twoDim[i][j] = count;
                count++;
            }
        }
    }
    
    public void shake(){
        Random rand = new Random();
        int maxNum = n*n;
        int count = 0;
        
        for (int i = 0; i < maxNum; i++){
            int randomIndexToSwap = rand.nextInt(oneDim.length);
	    int temp = oneDim[randomIndexToSwap];
	    oneDim[randomIndexToSwap] = oneDim[i];
	    oneDim[i] = temp;
	    myArrList.set(randomIndexToSwap, myArrList.get(i));
	    myArrList.set(i, temp);
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                twoDim[i][j] = oneDim[count];
                count++;
            }
        }
    }
    
    int addRow(int rr){
        int total = 0;
        for (int i = rr; i < rr+1; i++){
            for (int j = 0; j < n; j++){
                total += twoDim[i][j];
            }
        }
        return total;
    }
    
    int addCol(int cc){
        int total = 0;
        for (int i = 0; i < n; i++){
            for (int j = cc; j < cc+1; j++){
                total += twoDim[i][j];
            }
        }
        return total;
    }
    
    int addDiag1(){
        int total = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < i+1; j++){
                total += twoDim[i][j];
            }
        }
        return total;
    }
    
    int addDiag2(){
        int total = 0;
        int index = n-1;
        for (int i = 0; i < n; i++){
            for (int j = index; j < index+1; j++){
                total += twoDim[i][j];
            }
            index--;
        }
        return total;
    }

    public void printMe()
    {
        System.out.println("\n\nONE DIM: ");
        for (int i = 0; i < n*n; i++){
            System.out.print(oneDim[i] + " ");
        }
        System.out.print("\n\nArrayList:\n");
        for (int i = 0; i < n*n; i++){
            System.out.print(myArrList.get(i) + " ");
        }
        System.out.print("\n\nTWO DIM: \n");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(twoDim[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}

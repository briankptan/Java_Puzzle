import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;

public class ClientNxNBK
{
    static void threeBythree(NxNBK x){
        int flag = 0;
        int count = 0;
        Instant start = Instant.now();
        
        while(flag == 0){
            
            int n = 3;
            int mySum = x.addDiag1();
            int mySignal = 0;
            
            x.shake();
            count++;
            
            for (int i = 0; i < n; i++){
                if (x.addRow(i) != mySum){
                    mySignal = 1;
                } 
            }
            
            for (int i = 0; i < n; i++){
                if (x.addCol(i) != mySum){
                    mySignal = 1;
                }
                    
            }
            if (x.addDiag2() != mySum)
                   mySignal = 1;
                   
            if (mySignal != 1){
                Instant end = Instant.now();
                
                x.printMe();
                System.out.println("BK GOT IT: " + count + " tries, Sum = " + mySum);
                
                Duration timeElapsed = Duration.between(start, end);
                
                System.out.println("Time elapsed: " + timeElapsed.toMillis() + " milliseconds.");
                
                Scanner obj = new Scanner(System.in);
                System.out.println("Again? 0 for yes.");
                flag = obj.nextInt();
                if (flag == 0)
                    start = Instant.now();
                count = 0;
            }
        }
    }
    
    static void fourByfour(NxNBK x){
        int flag = 0;
        int count = 0;
        Instant start = Instant.now();
        
        while (flag == 0){
            x.shake();
            count++;
            int mySum = x.addDiag1();
            
            if ((x.addRow(0) == mySum && x.addRow(1) == mySum &&
                x.addRow(2) == mySum && x.addRow(3) == mySum) &&
                
                (x.addCol(0) == mySum && x.addCol(1) == mySum &&
                x.addCol(2) == mySum && x.addCol(3) == mySum) &&
                
                (x.addDiag1() == x.addDiag2()))
                {
                    Instant end = Instant.now();
                    
                    x.printMe();
                    System.out.println("BK GOT IT: " + count + " tries, Sum = " + mySum);
                    
                    Duration timeElapsed = Duration.between(start, end);
                    System.out.println("Time elapsed: " + timeElapsed.toMinutes() + " minutes.");
                    
                    flag = 1;
            }
        }
    }
    
    public static void main(String[] args){
        Scanner n_obj = new Scanner(System.in);
        System.out.print("Enter a value for n: ");
        int n = n_obj.nextInt();
        
        NxNBK x = new NxNBK(n);
        
        if (n == 3)
            threeBythree(x);
        else if (n == 4)
            fourByfour(x);
        
        
        
            
            
            // System.out.println("ADD ROWS: ");
            // for (int i = 0; i < n; i++){
                // System.out.print(x.addRow(i) + " ");
            // }
            
            // System.out.println("\nADD COLS: ");
            // for (int i = 0; i < n; i++){
                // System.out.print(x.addCol(i) + " ");
            // }
            
            // System.out.print("\n\n");
            
            // System.out.print("\nDIAG1 " + x.addDiag1() + " ");
            // System.out.print("\nDIAG2 " + x.addDiag2() + " ");
            
            // System.out.print("\n\n");
            
            // x.printMe();
            // System.out.println("Sum = " + mySum);
            // System.out.println("Tries: " + count);
            // Scanner obj = new Scanner(System.in);
            // System.out.println("Again? 0 for yes.");
            // flag = obj.nextInt();
            
            // for (int i = 0; i < n; i++){
                // if (x.addRow(i) != mySum || x.addCol(i) != mySum)
                    // mySignal = 1;
            // }
            
            // if (x.addDiag1() == x.addDiag2() && x.addRow(0) == x.addDiag1() && x.addCol(0) == x.addDiag1() && mySignal != 1){
                // x.printMe();
                // System.out.println("Sum = " + mySum);
                // System.out.println("Tries: " + count);
                // Scanner obj = new Scanner(System.in);
                // System.out.println("Again? 0 for yes.");
                // flag = obj.nextInt();
                // count = 0;
            // }
            
            
            // if (x.addDiag2() == mySum){
                // for (int i = 0; i < n; i++){
                    // if (x.addRow(i) != mySum && x.addCol(i) != mySum){
                        // innerFlag = 1;
                    // }
                // }
                // if (innerFlag == 1)
                    // flag = 0;
                // else{
                    // x.printMe();
                    // System.out.println("Sum = " + mySum);
                    // System.out.println("Tries: " + count);
                    // Scanner obj = new Scanner(System.in);
                    // System.out.println("Again? 0 for yes.");
                    // flag = obj.nextInt();
                // }
            
            
            
            // if (x.addRow(1) == mySum && x.addCol(1) == mySum && x.addDiag1() == mySum && x.addDiag2() == mySum 
                    // && x.addRow(0) == mySum && x.addRow(2) == mySum && x.addCol(0) == mySum && x.addCol(2) == mySum)
            // {
                // x.printMe();
                // System.out.println("Sum = " + mySum);
                // System.out.println("Tries: " + count);
                // Scanner obj = new Scanner(System.in);
                // System.out.println("Again? 0 for yes.");
                // flag = obj.nextInt();
            // }
            System.out.println("\n\nProgram ended");
        }
        
        // mySum = x.addDiag1();
        // x.printMe();
        // System.out.println("Sum = " + mySum);
        
    
}

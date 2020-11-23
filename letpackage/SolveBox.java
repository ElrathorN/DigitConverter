package letpackage;
import java.lang.Math.*;

public class SolveBox {
    public final static int constant = 16;
    protected static int abstractOffset[] = new int[constant];

    public static int[] decToBin(int ourDec) {

        if(ourDec > 65535) {
            System.out.println("your number bigger than 65535");
            // 1111111111111111111 - is our offset and this number = 65535
        }
        int i = constant - 1;

        do {
            if((ourDec % 2) == 0) {
                abstractOffset[i] = 0;
            }
            else if((ourDec % 2) != 0) {
                abstractOffset[i] = 1;
                if(ourDec == 1) {
                    break;
                }
            }

            ourDec = ourDec/2;
            i -= 1;
        } while(true);

        return abstractOffset;
    }

    public static int binToDec(int[] ourBin) {
        int offsetFlag = 0;
        int digitCount = 0;
        int i, j, decNumber = 0;
        int startAt = 0;

        if(ourBin.length >= constant) {
            for(i = 0; i < constant; i++)
                if(ourBin[i] == 1) offsetFlag += 1;
        }
        if(offsetFlag > 15)
            System.out.println("your number bigger than our offset 65535");

        for(i = 0; i < ourBin.length; i += 1) {
            if(ourBin[i] == 1) {
                startAt += i;
                for(j = i; j < ourBin.length; j += 1) {
                    digitCount += 1;  //to count bin digit in our offset
                }
                break;
            }
        }

        j = digitCount-1;
        for(i = startAt; i < startAt+digitCount; i += 1) {
            decNumber = decNumber + (int)(ourBin[i] * (Math.pow(2, j)));
            j -=  1;
        }

        return decNumber;
    }
    //ElrathorN 24.11.2020
}

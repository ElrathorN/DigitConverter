import letpackage.SolveBox;
import java.util.*;

public class ClientClass {
    private static boolean exit = false;

    public static void main(String[] args) {
        startMenu();
    }

    public static void startMenu() {
        int i, j, choice, decNumber;
        int[] offsetNumber = new int[SolveBox.constant];
        Scanner inputObj = new Scanner(System.in);
        String stringOffsetNumber;

        while(!exit) {
            for(i = 0; i < SolveBox.constant * 2; i += 1)
                System.out.print("=");
            System.out.println("\n1.convert from dec to bin");
            System.out.println("2.convert from bin to dec");
            System.out.println("3.exit");

            choice = inputObj.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("put your dec num ->");
                    decNumber = inputObj.nextInt();
                    offsetNumber = SolveBox.decToBin(decNumber);
                    System.out.print(decNumber+" = ");
                    for(i = 0; i < offsetNumber.length; i += 1)
                        System.out.print(offsetNumber[i]);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("put your bin num ->");
                    inputObj.nextLine();
                    stringOffsetNumber = inputObj.nextLine();
                    System.out.print(stringOffsetNumber+" = ");
                    offsetNumber = fromStringToIntArr(stringOffsetNumber);
                    decNumber = SolveBox.binToDec(offsetNumber);
                    System.out.println(decNumber);
                    break;
                case 3:
                    exit = true;
                    break;
                default :
                    continue;
            }
        }
    }

    public static int[] fromStringToIntArr(String stringDigits) {
        int[] intDigits = new int[stringDigits.length()];
        String[] tmpBuffer = stringDigits.split("");

        for(int i = 0; i < stringDigits.length(); i += 1)
            intDigits[i] = Integer.parseInt(tmpBuffer[i]);

        return intDigits;
    }
//ElrathorN 24.11.2020
}

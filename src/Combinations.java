import java.util.Scanner;

public class Combinations {

    //Scanner s = new Scanner();

    public int singles(int[] diceRoll, int n) {
        int sum = 0;

        for (int die : diceRoll) {

            if (die == n) {

                sum += n;
            }
        }
        return sum;
    }


    public int nOfAKind(int[] diceRoll, int n) {    // n er antal 'ens' vi checker for. F.eks. 3 ens.

        int[] arr = sortingDice(diceRoll);    // Først sortere denne metode de fem terninge kast og smider dem ind i denne temp array.
                                                // Se eventuelt sortingDice metoden længere nede.

        for (int i = 1; i < arr.length + 1; i++) {  // arr består af 6 tal. Værdierne fra 1 til 6 og hvor mange point
                                                    // de hver især har opnået ved diceRoll. F.eks 3 femmer: arr[4] = 15

            if (arr[i - 1] == i*n) {     // i er sat til 1 (normalt 0), som repræsentere antal øjne på terningen.
                                         // Hvis arr[5-1] == 5 * 3 (sandt i dette tilfælde). Så:
                return i * n;    // Returnes værdien for i(antal øjne) gange med n(antal ens).   5 * 3 = 15

            } else if (arr[i - 1] == i*(n+1)) {   // Dette checker hvis der derimod var 4 femmer, men vi stadig kun søger 3 ens i dette tilfælde.

                return i * n;             // metoden skal stadig kun returner 5 * 3 = 15. Da vi ønsker at udfylde feltet for 3 ens.

            } else if (arr[i - 1] == i*(n+2)) {   // Og her er det for 5 femmer, men vi stadig kun søger 3 ens i dette tilfælde.

                return i * n;             // metoden skal stadig kun returner 5 * 3 = 15. Da vi ønsker at udfylde feltet for 3 ens.
            }
        }
        return 0;
    }

    public int[] sortingDice(int[] unSortedDice) {

        // eksempel på sortering:  int[]={2,2,6,6,4};
        // arr[0] = 0     (1'ere)
        // arr[1] = 4     (2'ere)
        // arr[2] = 0     (3'ere)
        // arr[3] = 4     (4'ere)
        // arr[4] = 0     (5'ere)
        // arr[5] = 12    (6'ere)

        int[] arr = new int[6];

        for (int value : unSortedDice) {   // Hver terningkast har en value fra 1 til 6.

            arr[value - 1] += value;  // eksempel unSortedDice[2] = 6. Derfor: arr[6-1] += 6

        }

        return arr;
    }

}

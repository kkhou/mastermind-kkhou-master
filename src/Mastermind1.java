import java.util.Scanner;
import java.util.Random;
/**
 * Mastermind game with code all in main and no non-constant data members defined
 */
public class Mastermind1 {
    public static final String colors="RGYBOP";

    public static void main(String args[]){
       
        // getGuess
        // you'll need to add code to validate that user entered four
        // valid colors, but leave that at end of project
        int exact=0;
        int partial=0;
        int correct = 0;
        String guess="";
        String answer="";

        //System.out.println("guess is:"+guess);  // remove this once working


        // Create random answer
        Random random = new Random();

        for (int i =0; i<4; i++){
            int index = random.nextInt(6);
            char ch = colors.charAt(index);
            //System.out.println(ch);
            answer +=ch;

        }

        // Read user input
        Scanner scanner = new Scanner(System.in);

        //while (guess.equals(answer) != true) {

            System.out.println("Guesses consist of 4 letters from:" + colors);
            System.out.println("Please enter a 4 letter guess:");

            while (correct != 4) {
                guess = scanner.nextLine();
                //check wrong input
                correct = 0;
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (guess.charAt(i) == colors.charAt(j)) {
                            correct++;
                            break;
                        }
                    }
                }
                if (correct != 4) {
                    System.out.println("Please re input: ");
                }
            }


            // Count exacts
            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == answer.charAt(i)) {
                    exact++;
                }
            }


            // Count partials
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i != j && guess.charAt(i) == answer.charAt(j)) {
                        partial++;
                    }
                }
            }


            // Output Result
            System.out.println("You got " + exact + " exact ," + partial + " partial");
            if (exact == 4){
                System.out.println("Congradulations");
        }
        //}

    }
}

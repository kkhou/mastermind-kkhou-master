import java.util.Scanner;
import java.util.Random;
/**
 * Mastermind game with code all in main and no non-constant data members defined
 */
public class Mastermind3 {
    public static final String colors="RGYBOP";
    public static int secretlength = 4 ;


    // Create random answer
    public static String generateSecret() {

        String ans = "";

        Random random = new Random();

        for (int i =0; i<secretlength; i++){
            int index = random.nextInt(6);
            char ch = colors.charAt(index);
            //System.out.println(ch);
            ans +=ch;
        }

        return ans;
    }

    public String getGuess() {


        int correct =0;
        String guess1="";

        while (correct != secretlength) {
            // Read user input
            Scanner scanner = new Scanner(System.in);

            guess1 = scanner.nextLine();
            //check wrong input
            correct = 0;
            for (int i = 0; i < secretlength; i++) {
                for (int j = 0; j < colors.length(); j++) {
                    if (guess1.charAt(i) == colors.charAt(j)) {
                        correct++;
                        break;
                    }
                }
            }
            if (correct != secretlength) {
                System.out.println("Please re input: ");
            }
        }
        return guess1;
    }

    public int computeExacts(String guess1, String answer1) {
        int exact = 0;
        for (int i = 0; i < secretlength; i++) {
            if (guess1.charAt(i) == answer1.charAt(i)) {
                exact++;
            }
        }
        return exact;
    }

    public int computePartials(String guess1, String secret1) {
        int partial = 0;
        for (int i = 0; i <secretlength; i++) {
            for (int j = 0; j < secretlength; j++) {
                if (i != j && guess1.charAt(i) == secret1.charAt(j)) {
                    partial++;
                }
            }
        }
        return partial;
    }
    public void main(String args[]){

        // getGuess
        // you'll need to add code to validate that user entered four
        // valid colors, but leave that at end of project

        int exact=0;
        int partial=0;
        int correct = 0;
        String guess="";
        String secret="";

        secret = generateSecret();
        System.out.println("Guesses consist of 4 letters from:" + colors);
        System.out.println("Please enter a 4 letter guess:");
        int i =0;
        for ( i=0; i < 3; i++) {
            guess = getGuess();
            exact = computeExacts(guess, secret);
            partial = computePartials(guess, secret);
            System.out.println("You got " + exact + " exact ," + partial + " partial");
            if (exact == secretlength) {
                System.out.println("Congradulations");
                break;
            }
        }
        if (i == 3){
            System.out.println("Try again soon!");
        }

    }
}

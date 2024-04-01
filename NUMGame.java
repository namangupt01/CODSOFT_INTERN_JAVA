import java.util.Scanner;
import java.util.Random;

public class NUMGame {
    public static void main(String[] args) {
        // first of all i have to generate a random number . I will do this with the
        // help of Random class in the util package

        Random x = new Random();

        Scanner sc = new Scanner(System.in);
            int round = 0;
            int won =0;


     int again=1;
     do {

         int generated_number = x.nextInt(10);
        
         System.out.println("Here the system has generated the random number " + " you have to guess the number on your"
                 + "own to match the generated number under fewer number of chances else  you will lose the match");

         System.out.println("Press 1 to start the game");
         System.out.println();

         System.out.print("Press = ");
         int ch = sc.nextInt();

         switch (ch) {
             case 1:
                 int guess_number;

                 boolean player_won = false;

                 System.out.println(
                         "");
                 System.out.println();

                 System.out.println("YOu have only three chances ");
                 System.out.println(
                         "");
                 System.out.println();

                 for (int chances = 1; chances <= 3; chances++) {

                     System.out.println("Chance Number  =" + chances);

                     System.out.print("Guess the number=");
                     guess_number = sc.nextInt();

                     if (guess_number == generated_number) {

                         player_won = true;

                         break;

                     } else if (guess_number < generated_number) {
                         System.out.println("Your guess is low ");
                         System.out.println(
                                 "");

                     } else if (guess_number > generated_number) {
                         System.out.println("your guess is high");
                         System.out.println(
                                 "");

                     }

                     if (player_won == true) {
                         break;
                     }

                 }
                 if (player_won) {
                     System.out.println("Congratulations ! You have guess the right number ");
                     won++;

                 } else {
                     System.out.println("Oops! you are not able to guess the number better luck next time");
                 }
                 System.out.println("");
                 System.out.println("----------------------------------------------------------------------------");





         }


         System.out.print("Do you want to play again? (1 = Yes, 0 = No):  ");
         again = sc.nextInt();
         round++;
     }while(again!=0);


        System.out.println("You have played "+ (round) + " rounds");
        System.out.println("Round Won=" + won );
        System.out.println("Round Lose="+ (round-won));
System.out.println("You are out of the game , HEHE");

        }



    }


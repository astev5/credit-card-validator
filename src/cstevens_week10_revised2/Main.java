package cstevens_week10_revised2;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Chad Stevens
 * @Assignment Name: Week 10 Assignment
 * @Date: July 23, 2021
 * @Description: Java Objects
 */

//Imports
import java.util.Scanner;

//Begin Class Main
public class Main {

    //Begin Main Method
    public static void main(String[] args) {

        //Declarations
        String again;       //used to rerun program
        String cardNum;
        String cardExp;

        //Create scanner object
        Scanner sc = new Scanner(System.in);

        //Begin do while loop to rerun card checker
        do {

            System.out.print("\nEnter Card Holder's Name: ");
            sc.nextLine();
            System.out.print("Enter Credit Card Number (With or Without Dashes): ");
            cardNum = sc.nextLine();
            System.out.print("Enter Credit Card Expiration Date (MM/YY): ");
            cardExp = sc.nextLine();

            //Instantiate subclass VerifyCard
            VerifyCard yourCard = new VerifyCard(cardNum, cardExp);
                       
            if(yourCard.getValid()){
                System.out.printf("\nCard number %s is a valid credit card.\n",
                        yourCard.getCardNumber());
            } else {
                System.out.printf("\nCard number %s is NOT a valid credit "
                        + "card.\n", yourCard.getCardNumber());
            }
            
            //Ask user if they want to calculate again
            System.out.print("\nRun program again? (Y for Yes, N for No): ");

            //Take input for continue selection
            again = sc.nextLine();

        } while (again.equalsIgnoreCase("Y"));

        System.out.print("\nThank you. Goodbye!\n\n");

    }

} //end Main method

package cstevens_week10;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Chad Stevens
 * @Assignment Name: Week 10 Assignment
 * @Date: July 23, 2021
 * @Description: Java Objects
 */

//import java.lang.reflect.Array;
public class VerifyCard {

    private String ccnum;
    private String ccexp;
    private int[] ccnumIntArray;
    private int[] ccexpIntArray;

    /**
     * Constructor - call to set values from Main
     *
     * @param cardNum
     * @param cardExp
     */
    public VerifyCard(String cardNum, String cardExp) {
        setDetails(cardNum, cardExp);
    }

    /**
     * Constructor - Initializes default values of 0
     */
    public VerifyCard() {
        this("0", "0");
    }

    /**
     * Method @setDetails: Method to set card number and expiration
     *
     * @param n
     * @param e
     */
    private void setDetails(String n, String e) {
        ccnum = n.replaceAll("-", "");
        ccexp = e.replaceAll("/", "");

        //Convert credit card number to integer array
        String[] ccnumArray = ccnum.split("");
        ccnumIntArray = new int[ccnumArray.length];
        for (int i = 0; i < ccnumArray.length; i++) {
            String numberAsString = ccnumArray[i];
            ccnumIntArray[i] = Integer.parseInt(numberAsString);
        }

        //Convert expiration date to integer array
        String[] ccexpArray = ccexp.split("");
        ccexpIntArray = new int[ccexpArray.length];
        for (int i = 0; i < ccexpArray.length; i++) {
            String numexpAsString = ccexpArray[i];
            ccexpIntArray[i] = Integer.parseInt(numexpAsString);
        }

        conditionOne();
    } //end setDetails method

    /**
     * Method @getCardNumber: Method to get card number
     *
     * @return
     */
    public boolean getCardNumber() {

        if (conditionOne() && conditionTwo() && conditionThree()
                && conditionFour() && conditionFive()
                && conditionSix() && conditionSeven()) {
            return true;
        } else {
            return false;
        }
    }
    //End getCardNumber method

    /**
     * Method @getCardExp: Method to get card expiration
     *
     * @return
     */
    public String getCardExp() {
        return ccexp;
    } //End getCardExp method

    /**
     * Method @conditionOne: first digit must be a 4
     */
    private boolean conditionOne() {

        if (ccnum.matches("^[4].*")) {
            return true;
        } else {
            return false;
        }
    } //End conditionOne method

    /**
     * Method @conditionTwo: fourth digit must be one greater than fifth digit
     */
    private boolean conditionTwo() {

        int a = ccnumIntArray[3] - 1;
        int b = ccnumIntArray[4];

        if (a == b) {
            return true;
        } else {
            return false;
        }
    } //End conditionTwo method

    /**
     * Method @conditionThree: product of first, fifth and ninth digits must
     * equal 24
     */
    private boolean conditionThree() {

        int a = ccnumIntArray[0];
        int b = ccnumIntArray[4];
        int c = ccnumIntArray[8];

        if ((a * b * c) == 24) {
            return true;
        } else {
            return false;
        }
    } //End condtionThree method

    /**
     * Method @conditionFour: sum of all digits must be evenly divisible by four
     */
    private boolean conditionFour() {

        //Find sum of digits in card number 
        int sum = 0;
        int y = 4;
        for (int value : ccnumIntArray) {
            sum += value;
        }

        //Test if divisible by 4
        if (sum % y == 0) {
            return true;
        } else {
            return false;
        }
    } //End conditionFour method

    /**
     * Method @conditionFive: sum of the four digits of the expiration date must
     * be less than the product of the last two digits of the card number
     */
    private boolean conditionFive() {

        //Find sum of digits in expiration date
        int sumexp = 0;
        for (int valexp : ccexpIntArray) {
            sumexp += valexp;
        }

        int d = ccnumIntArray[14];
        int e = ccnumIntArray[15];

        if (sumexp < (d * e)) {
            return true;
        } else {
            return false;
        }
    } //End conditionFive method

    /**
     * Method @conditionSix: sum of the first four digits must be one less than
     * the sum of the last four digits
     */
    private boolean conditionSix() {

        //Find sum of first four and last four digits
        int firstfour = (ccnumIntArray[0] + ccnumIntArray[1] + ccnumIntArray[2]
                + ccnumIntArray[3]);
        int lastfour = (ccnumIntArray[12] + ccnumIntArray[13]
                + ccnumIntArray[14] + ccnumIntArray[15]);

        if ((lastfour - 1) == firstfour) {
            return true;
        } else {
            return false;
        }
    } //End conditionSix method

    /**
     * Method @conditionSeven: the sum of the first two digits as a two digit
     * integer and the last two digits as a two digit integer must equal 100
     */
    private boolean conditionSeven() {

        String firsttwo = ccnum.substring(0, 2);
        String lasttwo = ccnum.substring(14, 16);

        int first2 = Integer.parseInt(firsttwo);
        int last2 = Integer.parseInt(lasttwo);

        if ((first2 + last2) == 100) {
            return true;
        } else {
            return false;
        }
    } //End conditionSeven method

}

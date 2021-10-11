# credit-card-validator
A program that performs a validation check on a credit card number.

## Assignment
Write a program that checks a credit card number to see if it is valid.

## Constraints
- The credit card number (CC#) must be 16 digits in length.
- The CC# can be in either form: ####-####-####-#### or ################.
- The Expiration Date (Exp) must be in the form: MM/YY (Example: 12/15).
- Notify user of correct entry form for CC# and Exp.
- Name, CC#, and Exp must be entered as Strings.
- Use a separate (external to the main class) subclass, VerifyCard() to validate the CC# with the following private method conditions:
  - Condition 1: The first digit must be a 4
  - Condition 2: The fourth digit must be one greater than the fifth digit
  - Condition 3: The product of the first, fifth, and ninth digits must be 24
  - Condition 4: The sum of all digits must be evenly divisible by 4
  - Condition 5: The sum of the four digits in the expiration date must be less than the product ofthe last two digits of the card number
  - Condition 6: The sum of the first four digits must be one less than the sum of the last fourdigits
  - Condition 7: If you treat the first two digits as a two-digit number, and the 15th and 16th digitsas a two digit number, their sum must be 100 (Example: 4643262531465454 -> 46 + 54 = 100)

## Requirements
- Ask the user for the name on the credit card.
- Ask the user for the credit card number.
- Ask the user for the expiration date.
- Use set and get methods in the subclass for the information entered by the user.
- Set methods must be private.
- All Condition listed in Constraints should be private methods.
- Use a regex String for Condition 1.
- Most Condition methods will use an if statement.
- Condition methods 4-6 will need one to two for loops to step through the int arrays.

## Notes
- CC# and Exp can be converted into int Arrays.
- The following CC#s can be used as test cases. Each of these numbers will return as valid. (Be sure to change them around or enter other CC#s that are not valid):
  - 4192112566331259
  - 4283253533222358
  - 4374398522116157
  - 4292154566732358
  - 4553223534333555
  - 4643262531465454
  - 4732169566119053
  - 4823287533234752
- Each of the CC#s will work with an Exp of 12/15.
- By increasing the YY a few of these cards will not be valid.
- Consider using the .replaceAll() method to remove slashes and/or dashes from entered Strings.
- Consider using the .split() method when converting the Strings to int Arrays.
- The .parseInt() method and the Integer class may be helpful.

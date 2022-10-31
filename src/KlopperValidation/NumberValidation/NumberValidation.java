package KlopperValidation.NumberValidation;

import KlopperValidation.NumberValidation.Tests.*;
import lombok.*;

import java.math.*;

/**
 *
 */
@NoArgsConstructor
public class NumberValidation {

    // TODO: javadocs
    // TODO: add comments to explain the code (ask someone else to read and find where there is ambiguity -> try fix var names
    // TODO: make better error messages
    // TODO: return BigInteger? benefits?
    // TODO: allow an array of numbers to be input
    // TODO: code against setting max < min / max == min
    // TODO: allow double, string setters for min, max, etc. and returning a double
    // TODO: move string parsing to a separate class and write a JavaDoc and better name
    // TODO: make better error messages

    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal numberDecimalPlaces;

    private String lessThanAllowedMessage;
    private String greaterThanAllowedMessage;
    private String tooManyDecimalPlacesMessage;

    /**
     * Method that validates string input as a BigDecimal against specified conditions.
     * If no conditions are set, no checks will take place.
     * Strings are parsed to become valid numbers as long as they only contain:
     * , or . which act as decimal point separators
     * * _ or ' ' which can be used as thousands separators (or as ones separators if you're a twat)
     * If the input string is not a valid number (i.e. contain characters other than the above),
     * then an exception is thrown.
     * If any of the conditions are not met by the input string, an exception is thrown.
     * The messages of the exceptions thrown when conditions are broken may be customised; if they are not,
     * default messages will be set.
     * @param userInput User input as a string. One is expected to use e.g. the nextLine() method of Scanner instead of nextDouble().
     * @return
     * @throws Exception
     */
    public BigDecimal validateBigInput(String userInput) throws Exception {
        // use mutable strings
        userInput = ParseEngine.parseNumberString(userInput);
        System.out.println(userInput);
        BigDecimal input = new BigDecimal(userInput); // does ,0 work?
        if (min != null && input.compareTo(min) == -1) throw new Exception(getLessThanAllowedMessage());
        if (max != null && input.compareTo(max) == 1) throw new Exception(getGreaterThanAllowedMessage());
        if (numberDecimalPlaces != null &&
                numberDecimalPlaces.compareTo(BigDecimal.valueOf(input.scale())) == -1) throw new Exception(getTooManyDecimalPlacesMessage());
        return input;
    }

    public double validateDoubleInput(String userInput) throws Exception {
        userInput = ParseEngine.parseNumberString(userInput); // TODO: needs a javadoc
        BigDecimal input = new BigDecimal(userInput); // first check if valid number
        if (input.doubleValue() == Double.NEGATIVE_INFINITY || input.doubleValue() == Double.POSITIVE_INFINITY)
            throw new Exception("Input is to large or too small to be converted to a double; consider using validateBigInput.");
        validateBigInput(userInput);
        return input.doubleValue();
    }

    // TODO: let this take a String
    public NumberValidation setMin(double min) {
        this.min = BigDecimal.valueOf(min);
        return this;
    }
    public NumberValidation setMax(double max) {
        this.max = BigDecimal.valueOf(max);
        return this;
    }
    public NumberValidation setNumberDecimalPlaces(double numberDecimalPlaces) {
        this.numberDecimalPlaces = BigDecimal.valueOf(numberDecimalPlaces);
        return this;
    }

    public NumberValidation setMin(BigDecimal min){
        this.min = min;
        return this;
    }
    public NumberValidation setMax(BigDecimal max){
        this.max = max;
        return this;
    }
    public NumberValidation setNumberDecimalPlaces(BigDecimal numberDecimalPlaces){
        this.numberDecimalPlaces = numberDecimalPlaces;
        return this;
    }

    public NumberValidation setLessThanAllowedMessage(String lessThanAllowedMessage){
        this.lessThanAllowedMessage = lessThanAllowedMessage;
        return this;
    }
    public NumberValidation setGreaterThanAllowedMessage(String greaterThanAllowedMessage){
        this.greaterThanAllowedMessage = greaterThanAllowedMessage;
        return this;
    }
    public NumberValidation setTooManyDecimalPlacesMessage(String tooManyDecimalPlacesMessage) {
        this.tooManyDecimalPlacesMessage = tooManyDecimalPlacesMessage;
        return this;
    }

    public BigDecimal getMin() {
        if (min == null) throw new NullPointerException("Min has not yet been set.");
        return this.min;
    }
    public BigDecimal getMax() {
        if (max == null) throw new NullPointerException("Max has not yet been set.");
        return this.max;
    }
    public BigDecimal getNumberDecimalPlaces() {
        if (numberDecimalPlaces == null) throw new NullPointerException("Number of decimal places has not yet been set.");
        return this.numberDecimalPlaces;
    }

    public String getLessThanAllowedMessage() {
        if (lessThanAllowedMessage == null) return "Input cannot be less than " + getMin();
        return lessThanAllowedMessage;
    }
    public String getGreaterThanAllowedMessage() {
        if (greaterThanAllowedMessage == null) return "Input cannot be greater than " + getMax();
        return greaterThanAllowedMessage;
    }
    public String getTooManyDecimalPlacesMessage() {
        if (tooManyDecimalPlacesMessage == null) return "Input cannot specify more than " + getNumberDecimalPlaces() + " decimal places";
        return tooManyDecimalPlacesMessage;
    }


//    /**
//     * @param min minimum value that input may be
//     * @param max maximum value that input may be
//     * @param numberDecimalPlaces maximum number of decimal places that input may specify
//     * @param inputPrompt
//     * @return
//     */
//    public static BigDecimal inputAndReturnValid(){
//        out.println(inputPrompt);
//
//        BigDecimal input;
//        while(true) {
//            input = BigDecimal.valueOf(scanner.nextDouble());
//            if (input.compareTo(new BigDecimal(min)) < 1) System.out.println("Below or equal to " + min);
//            else if (input.compareTo(new BigDecimal(max)) > -1) System.out.println("Greater than or equal to " + max);
//            else if (input.scale() > numberDecimalPlaces) System.out.println("More than " + numberDecimalPlaces + " decimal places entered.");
//            else break;
//        }
//        return input;
//    }


}

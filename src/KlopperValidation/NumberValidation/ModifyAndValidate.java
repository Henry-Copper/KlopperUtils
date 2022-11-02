package KlopperValidation.NumberValidation;

import KlopperValidation.NumberValidation.Converter.*;

import java.math.*;

abstract class ModifyAndValidate {

    protected BigDecimal modifyThrowExceptionIfInvalid(String toCheck, CanModifyToCompliance modifyToCompliance) throws Exception {
        if (modifyToCompliance != null) toCheck = modifyToCompliance.modify(toCheck);
        // fancy regex that checks whether this is now a valid number and throws an exception if not; set a list of invalid characters in order
        // check that string is not null
        boolean condition = false;
        if (condition == true) throw new Exception("Invalid characters: list of invalid characters");
        return new BigDecimal(toCheck);
    }

    // TODO: better name
    // TODO: make an API note that this will not throw an exception, but an error (for the setters)
    protected BigDecimal modifyThrowErrorIfInvalid(String toCheck, CanModifyToCompliance modifyToCompliance){
        // don't do the fancy regex -> doesn't throw an Exception if invalid toCheck
        // -> setters don't have to be wrapped in try... catch blocks
        // in most cases, the min, max and number of decimal places will be valid anyway
        // check that string is not null
        try{
            return modifyThrowExceptionIfInvalid(toCheck, modifyToCompliance);
        }
        catch (Exception e){
            // throwing an error in order to avoid try catch blocks in setters; this is under the assumption that most max, min, decimalPlaces setting will be valid
            throw new Error(e.getMessage());
        }
    }

}

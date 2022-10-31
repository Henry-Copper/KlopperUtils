package KlopperValidation.NumberValidation.Tests;


import KlopperValidation.NumberValidation.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.math.*;

import static org.junit.jupiter.api.Assertions.*;

public class NumberValidationTests {
    // test everything with null
    // assertNotNull
    // @NullSource

    @ParameterizedTest
    @CsvFileSource(resources = "testdata_givenValidX_underNoConditions_returnX", delimiter = ';', numLinesToSkip = 1)
    void givenValidX_underNoConditions_returnX(String actual, String expected) throws Exception {
        NumberValidation validate = new NumberValidation();
        BigDecimal actualNumber = validate.validateBigInput(actual);
        assertEquals(expected, actualNumber.toString());
        // fractional exponents do not work in the scientific notation of BigDecimal
        // scientific notation of BigDecimal takes in a string with E anywhere but returns a number where the . is before the 1st digit
    }

    @Test
    void testDoubleImpl() throws Exception {
        double input = new NumberValidation().validateDoubleInput(new BigDecimal(Double.MAX_VALUE).add(new BigDecimal(Double.MAX_VALUE)).toString());
        System.out.println(input);
    }

}

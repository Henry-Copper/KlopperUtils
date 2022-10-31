package KlopperValidation.NumberValidation.Tests;

import java.math.*;

public class ParseEngine {


    public static String parseNumberString(String toParse){
        toParse = toParse.replace(",", ".")
                .replace("_", "")
                .replace(" ", "")
                .replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1"); // magic regex that strips trailing decimal 0's // doesn't work on Android?
        return toParse;
    }
}

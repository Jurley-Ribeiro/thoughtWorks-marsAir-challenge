package TestCases;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testando {

    @Test
    void test (){

//        String[] monthsExceptJulyAndDecember = new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
//                "September", "October", "November", "December"};
//        String[] monthsJulyAndDecember = new String[]{"July", "December"};
//
//        // Convert String Array to List
//        List<String> wordslist = Arrays.asList(monthsJulyAndDecember);
//        String tochk = "June";
//        if(wordslist.contains(monthsExceptJulyAndDecember)){
//            System.out.println("The word " + monthsExceptJulyAndDecember + " present in string array");
//        }
//        else
//            System.out.println("The word " + monthsExceptJulyAndDecember + " not present in string array" );

        String[] semesterFlightSchedule = new String[]{
                "July", "December", "July (next year)", "December (next year)",
                "July (two years from now)", "December (two years from now)"
        };
        String[] monthsDeparture = {
                "July", "December", "July (next year)", "December (next year)",
                "July (two years from now)", "December (two years from now)"
        };

        boolean foundAll = Arrays.asList(monthsDeparture).containsAll(Arrays.asList(semesterFlightSchedule));


        System.out.println("Months Departure not contains all the elements in Expect = " + foundAll);


        assertTrue(foundAll);

    }

}

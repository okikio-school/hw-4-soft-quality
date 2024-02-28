package com.ontariotechu.sofe3980U;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Provides unit tests for the NextDate class to verify correct behavior across a variety of dates.
 * This includes handling of leap years, end-of-month scenarios, and validation of date inputs.
 */
public class NextDateTest {
    /**
     * Executes a series of parameterized tests for the NextDate.nextDate method to ensure it correctly
     * calculates the next date given various input scenarios. These scenarios include leap years, 
     * end-of-month transitions, year-end transitions, and invalid date checks.
     * 
     * Each test case provides a day, month, and year as input and expects a specific output date as a string,
     * along with a description for better understanding of the test context.
     *
     * @param day The input day for the test case.
     * @param month The input month for the test case.
     * @param year The input year for the test case.
     * @param expected The expected result of the nextDate calculation.
     * @param info A descriptive message explaining the specific scenario being tested.
     */
    @DisplayName("Next Date Test Cases")
    @ParameterizedTest(name = "{index} => {0}, {1}, {2} = {3} ({4})")
    @CsvSource({
        "28, 2, 1900, 1-3-1900, Non-leap year February end", // Tests non-leap year end of February.
        "29, 2, 2000, 1-3-2000, Leap year February end", // Tests leap year end of February.
        "30, 4, 2021, 1-5-2021, April end", // Tests end of April, which has 30 days.
        "31, 7, 2021, 1-8-2021, July end", // Tests end of July, transitioning to August.
        "31, 12, 2212, 1-1-2213, Year boundary", // Tests transition from end of year to new year.
        "15, 1, 1812, 16-1-1812, Normal day", // Tests a normal day, verifying increment.
        "29, 2, 1900, Invalid, Non-leap year February", // Tests an invalid leap year date.
        "32, 1, 2020, Invalid, Invalid day", // Tests an invalid day number.
        "31, 4, 2021, Invalid, Invalid April end", // Tests invalid date at April end.
        "1, 13, 2021, Invalid, Invalid month" // Tests an invalid month number.
    })
    public void nextDateTest(int day, int month, int year, String expected, String info) {
        // Execute the method with the provided inputs and compare the result to the expected outcome.
        String result = NextDate.nextDate(day, month, year);
        // Assert that the calculated next date matches the expected output for the given test scenario.
        assertEquals(expected, result, info + " failed");
        // Optional: Print a success message for passed tests (useful for debugging or verbose test output).
        System.out.println(info + " passed");
    }
}

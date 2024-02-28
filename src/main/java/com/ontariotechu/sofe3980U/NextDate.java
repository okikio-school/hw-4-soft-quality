package com.ontariotechu.sofe3980U;

/**
 * The NextDate class provides a method to calculate the next date given a current date.
 * The method handles various edge cases such as leap years, end of the month, and end of the year scenarios.
 */
public class NextDate {

    /**
     * Calculates the next date given the current day, month, and year.
     * The method validates input dates and considers leap years, and month lengths to return the correct next date.
     * 
     * @param day The day of the month (1-31).
     * @param month The month of the year (1-12).
     * @param year The year (1812-2212, chosen limits for demonstration).
     * @return The next date in "day-month-year" format or "Invalid" if input date is not valid.
     */
    public static String nextDate(int day, int month, int year) {
        // Validate the input date ranges.
        if (
            (day < 1 || day > 31) || 
            (month < 1 || month > 12) || 
            (year < 1812 || year > 2212)
        ) {
            return "Invalid";
        }

        // Handle the end of the year case, moving to the next year.
        if (day == 31 && month == 12) {
            return "1-1-" + (year + 1);
        }

        // Handle the end of months with 30 days.
        if (day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            return "1-" + (month + 1) + "-" + year;
        }

        // Leap year check for February 29.
        if (day == 29 && month == 2) {
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                return "1-3-" + year; // Next day is March 1st if leap year.
            } else {
                return "Invalid"; // Invalid since it's not a leap year.
            }
        }

        // Handle February 28, moving to March 1st regardless of leap year.
        if (day == 28 && month == 2) {
            return "1-3-" + year;
        }

        // Handle the end of months with 31 days, except December (already handled).
        if (day == 31) {
            if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)) {
                return "1-" + (month + 1) + "-" + year;
            } else {
                return "Invalid"; // Invalid since not all months have 31 days.
            }
        }

        // General case: Increment the day for all other situations.
        return (day + 1) + "-" + month + "-" + year;
    }
}

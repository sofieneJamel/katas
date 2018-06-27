package org.katas.fizzbuzz.implOne;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.katas.fizzbuzz.FizzBuzz;

import static org.junit.Assert.assertEquals;

public class FizzBuzzImplOneTest {

    private FizzBuzz fizzBuzz;

    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Before
    public void setUp(){
        fizzBuzz  = new FizzBuzz();
    }

    @Test
    public void should_return_Fizz_when_number_is_dividble_by_3() throws Exception {
        // Given
        Integer number = 21;

        // When
        String numberToDisplay = fizzBuzz.displayNumberImplOne(number);

        // Then
        assertEquals("Fizz",numberToDisplay);
    }

    @Test
    public void should_return_Buzz_when_number_is_dividble_by_5() throws Exception {
        // Given
        Integer number = 5;

        // When
        String numberToDisplay = fizzBuzz.displayNumberImplOne(number);

        // Then
        assertEquals("Buzz",numberToDisplay);
    }

    @Test
    public void should_return_FizzBuzz_when_number_is_dividble_by_5_and_3() throws Exception {
        // Given
        Integer number = 5;

        // When
        String numberToDisplay = fizzBuzz.displayNumberImplOne(number);

        // Then
        assertEquals("Buzz",numberToDisplay);
    }

    @Test
    public void should_return_number_when_number_is_not_dividble_by_5_nor_by_3() throws Exception {
        // Given
        Integer number = 2;

        // When
        String numberToDisplay = fizzBuzz.displayNumberImplOne(number);

        // Then
        assertEquals("2",numberToDisplay);
    }

    @Test
    public void should_return_Fizz_when_number_is_dividble_by_3_or_containing_3() throws Exception {
        // Given
        Integer number = 13;

        // When
        String numberToDisplay = fizzBuzz.displayNumberImplOne(number);

        // Then
        assertEquals("Fizz",numberToDisplay);
    }

    @Test
    public void should_throw_Exception_when_number_is_null_or_negative() throws Exception {
        // Given
        exception.expect(Exception.class);
        exception.expectMessage("Number should be greater than 0 .");
        Integer number = null;

        // When
        fizzBuzz.displayNumberImplOne(number);

        // Then ExpectedException

    }

}

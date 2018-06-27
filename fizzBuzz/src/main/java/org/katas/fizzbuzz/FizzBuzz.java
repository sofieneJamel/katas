package org.katas.fizzbuzz;

import java.util.Optional;
import java.util.function.Predicate;

public class FizzBuzz {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    private Predicate<Integer> fizzPredicate = (Integer p) -> (p % 3 == 0 || String.valueOf(p).contains("3")) ;
    private Predicate<Integer> buzzPredicate = (Integer p) -> (p % 5 == 0 || String.valueOf(p).contains("5")) ;

    public String displayNumberImplOne(Integer number) throws Exception {
        if(number == null || number <= 0)
            throw new Exception("Number should be greater than 0 .");

        StringBuilder returnedOutput = new StringBuilder();

        if(fizzPredicate.test(number)) {
            returnedOutput.append(FIZZ);
        }

        if(buzzPredicate.test(number)) {
            returnedOutput.append(BUZZ);
        }

        return (returnedOutput.length() == 0 ? String.valueOf(number) : returnedOutput.toString());
    }

    public String displayNumberImplTwo(Integer number) throws Exception {
        if(number == null || number <= 0)
            throw new Exception("Number should be greater than 0 .");

        String returnedNumber = Optional.of(number)
                .map(p -> (fizzPredicate.test(p) ? FIZZ : "").concat(buzzPredicate.test(p) ? BUZZ : ""))
                .get();

        return returnedNumber.isEmpty() ? Integer.toString(number) : returnedNumber;
    }
}

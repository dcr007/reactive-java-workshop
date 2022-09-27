package io.javabrains.reactiveworkshop;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println("Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream().map(i -> i).forEach(System.out::println);
        System.out.println("All Done");
        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here

        // Print the second and third numbers in intNumbersStream that's greater than 5

        System.out.println("Second and third numbers in intNumbersStream that's greater than 5");

        StreamSources.intNumbersStream().filter(num -> num>5).skip(1).limit(2)
                        .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        Integer number = StreamSources.intNumbersStream().filter(integer -> integer>5)
                .findFirst()
                .orElse(-1);
        System.out.println(" Print the first number in intNumbersStream that's greater than 5. If nothing is found, print -1\n"+number);

        // Print first names of all users in userStream
        // TODO: Write code here

        // Print first names in userStream for users that have IDs from number stream

        // TODO: Write code here
        System.out.println("Print first names in userStream for users that have IDs from number stream");

        StreamSources.userStream().filter(user ->
                StreamSources.intNumbersStream().anyMatch(getUserNumberMatchingPredicate(user)))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

    }

    private static Predicate<Integer> getUserNumberMatchingPredicate(User user) {
        return number -> number.equals(user.getId());
    }

}

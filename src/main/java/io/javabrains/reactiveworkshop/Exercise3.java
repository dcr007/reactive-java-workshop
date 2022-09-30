package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here
        Stream<Integer> intStream=  ReactiveSources.intNumbersFlux().toStream();

        System.out.println(intStream.collect(Collectors.toList()));


        System.out.println("Press a key to end");
        System.in.read();
    }

}

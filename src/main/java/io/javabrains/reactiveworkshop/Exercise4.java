package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(System.out::println);
        ReactiveSources.intNumberMono().subscribe(
                number -> System.out.println(number),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete"));


        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        Integer integerNumber=  ReactiveSources.intNumberMono().block();
        System.out.println("value from the Mono into an integer variable \t"+integerNumber);
        Optional<Integer> integerNumber1=  ReactiveSources.intNumberMono().blockOptional();
        System.out.println("value from the Mono into an OPTIONAL integer variable \t"+integerNumber1.get());

        User user= ReactiveSources.userMono().block();
        System.out.println("User : \n"+user.toString());

        System.out.println("Press a key to end");

        System.in.read();
    }

}

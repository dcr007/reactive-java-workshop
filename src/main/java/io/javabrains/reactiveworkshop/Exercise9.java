package io.javabrains.reactiveworkshop;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.List;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
//        ReactiveSources.intNumbersFlux().count()
//                .subscribe(size -> System.out.println("Size of flux: "+size));

        // Collect all items of intNumbersFlux into a single list and print it

//        ReactiveSources.intNumbersFlux().collectList().log()
//                .subscribe(ints -> System.out.println("List of Integers are "+ints));
        // Transform to a sequence of sums of adjacent two numbers

        ReactiveSources.intNumbersFlux().log()
                .buffer(2)
                        .map(list -> list.get(0)+list.get(1))
                                .subscribe(number -> System.out.println("Sum : "+number));


        System.out.println("Press a key to end");
        System.in.read();
    }

}

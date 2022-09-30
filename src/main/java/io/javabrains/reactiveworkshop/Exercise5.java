package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks

      /*  ReactiveSources.intNumbersFlux().subscribe(
                number -> System.out.println(number),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete")
        );

        ReactiveSources.userFlux().subscribe(user -> System.out.println(user),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete"));
*/
        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(
          new CustomSubscriber<>()
        );

        System.out.println("Press a key to end");
        System.in.read();
    }

    private static class CustomSubscriber<T> extends BaseSubscriber<T> {

        public void hookOnSubscribe(Subscription subscription) {
            System.out.println("Subscription happeneed");
            request(2); // request how much work load you want to receive
        }

        public void hookOnNext(T value) {
            System.out.println(value.toString() + "received");
            request(1); // request for more

        }
    }
}
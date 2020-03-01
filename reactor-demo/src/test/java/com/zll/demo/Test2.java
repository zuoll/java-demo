package com.zll.demo;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;

/**
 * sink(池)
 */
public class Test2 {

    /**
     * @see org.reactivestreams.Subscriber#onNext(Object)
     * @see org.reactivestreams.Subscriber#onError(Throwable)
     * @see Subscriber#onComplete()
     *
     */
    @Test
    public void test001(){
        Flux<Object> generate = Flux.generate(() -> 0, (state, sink) -> {
            sink.next("3 * " + state + " = " + 3 * state);
            if (state == 10) sink.complete();
            return state + 1;
        });

        generate.toStream().forEachOrdered(s-> System.out.println(s));
    }
}

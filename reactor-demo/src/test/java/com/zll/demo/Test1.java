package com.zll.demo;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;
import org.junit.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test1 {

    public static void main(String[] args) {
        test001();

//        test002();

    }


    /**
     * @see Flux
     */
    public static void test001() {
        Flux<String> just = Flux.just("foo", "bar", "foobar");
        just.toStream().forEach(a -> System.out.println(a));

        List<String> list = Arrays.asList("aa", "bb", "cc");
        Flux<String> stringFlux = Flux.fromIterable(list);
        stringFlux.toStream().forEachOrdered(a -> System.out.println(a));

        Flux<Integer> range = Flux.range(1, 10);
        Iterable<Integer> integers = range.toIterable();
        integers.forEach(a -> System.out.println(a));

    }


    /**
     * @see Mono
     */
    public static void test002() {
        Mono<Object> empty = Mono.empty();
        System.out.println(empty.block());

        Mono<String> aa = Mono.just("aa");
        System.out.println(aa.block());
        Mono<Object> objectMono = Mono.justOrEmpty(null);
        System.out.println(objectMono.block());
    }

    /**
     * //对流中的每个元素进行订阅
     *
     * @see Flux#subscribe()
     * @see Flux#subscribe(Consumer)
     */
    @Test
    public void test003() {
        Flux<Integer> range = Flux.range(1, 10);
        range.subscribe(i -> System.out.println(i));
    }

    /**
     * 当流中的元素错误时做出响应
     *
     * @see Flux#onErrorResume(Function)
     */
    @Test
    public void test004() {
        Flux<Integer> ints = Flux.range(1, 5).map(i -> {
            if (i <= 3) return i;
            throw new RuntimeException("goto to 4");
        });

        ints.subscribe(i -> System.out.println(i),
                error -> System.out.println("error," + error));

    }


    @Test
    public void test005() {
        Flux<Integer> ints = Flux.range(1, 5);

        ints.subscribe(i-> System.out.println(i),
                err-> System.out.println(err),
                ()-> System.out.println("done"));//runnable


    }

    @Test
    public void test006(){
        SampleSubscriber<Integer> ss = new SampleSubscriber<>();

        Flux<Integer> ints = Flux.range(1, 5);
        ints.subscribe(ss);
    }

    class SampleSubscriber<T> extends BaseSubscriber<T>{

        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            System.out.println("hookOnSubscribe");
            request(1);
        }

        @Override
        protected void hookOnNext(T value) {
            System.out.println("hookOnNext,"+value);
            request(1);
        }

    }

}

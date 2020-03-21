package singleton.test;

import org.junit.Test;

import java.util.function.Supplier;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public abstract class SingletonTest<S> {

    private final Supplier<S> singletonInstanceMethod;

    public SingletonTest(final Supplier<S> singletonInstanceMethod)

    {
        this.singletonInstanceMethod = singletonInstanceMethod;
    }


    @Test
    public void testMultiCallRetSameObject(){
        S s1 = this.singletonInstanceMethod.get();
        S s2 = this.singletonInstanceMethod.get();
        S s3 = this.singletonInstanceMethod.get();
    }
}

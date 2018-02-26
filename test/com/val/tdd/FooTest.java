package com.val.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {

    static private Foo foo;

    @BeforeAll
    static void beforeAll(){
        foo = new Foo();
    }

    @Test
    void whenDoFooThenThrowRuntimeException(){
        Foo foo = new Foo();
        assertThrows(RuntimeException.class, ()->{foo.doFoo();});
    }

}
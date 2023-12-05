package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClassTest {

    @Test
    public void test() {
        int x = 10 - 5;
        Assertions.assertEquals(5, x);

    }

}

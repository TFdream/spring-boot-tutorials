package io.dreamstudio.springboot.lettuce;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Ricky Fung
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LettuceApp.class)
public class BaseSpringBootJUnitTest {

    @Test
    @Ignore
    public void testContext() {

    }
}

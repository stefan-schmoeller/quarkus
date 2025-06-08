package io.quarkus.it.extension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@CustomResourceWithAttribute(value = "bar")
@QuarkusTest
public class EndTestWithAttribute {

    @Test
    public void test1() {
        assertEquals("bar", ConfigProvider.getConfig().getValue("attributeValue", String.class));
        assertTrue(Counter.endCounter.get() <= 1);
    }

    @Test
    public void test2() {
        assertTrue(Counter.endCounter.get() <= 1);
    }

}

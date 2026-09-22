package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DateSnippetTest {

    @Test
    void testMain() {
        assertDoesNotThrow(() -> DateSnippet.main(new String[]{}));
    }

    @Test
    void testCreateDate() {
        assertDoesNotThrow(() -> new DateSnippet().createDate());
    }

    @Test
    void testCreateTime() {
        assertDoesNotThrow(() -> new DateSnippet().createTime());
    }

    @Test
    void testCreateDateTime() {
        assertDoesNotThrow(() -> new DateSnippet().createDateTime());
    }

    @Test
    void testInstant() {
        assertDoesNotThrow(() -> new DateSnippet().instant());
    }
}

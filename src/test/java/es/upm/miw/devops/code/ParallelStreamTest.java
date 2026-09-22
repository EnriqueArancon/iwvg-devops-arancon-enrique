package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ParallelStreamTest {

    @Test
    void testMain() {
        assertDoesNotThrow(() -> ParallelStream.main(new String[]{}));
    }
}

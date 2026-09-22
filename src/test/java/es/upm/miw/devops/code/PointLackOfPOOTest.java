package es.upm.miw.devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointLackOfPOOTest {

    private PointLackOfPOO point;

    @BeforeEach
    void before() {
        point = new PointLackOfPOO(2, 3);
    }

    @Test
    void testConstructors() {
        PointLackOfPOO p1 = new PointLackOfPOO();
        assertEquals(0, p1.getX());
        assertEquals(0, p1.getY());

        PointLackOfPOO p2 = new PointLackOfPOO(5);
        assertEquals(5, p2.getX());
        assertEquals(5, p2.getY());
    }

    @Test
    void testModule() {
        assertEquals(5.0, point.module(3, 4), 0.0001);
    }

    @Test
    void testPhase() {
        assertEquals(Math.atan(4.0 / 3.0), point.phase(3, 4), 0.0001);
    }

    @Test
    void testTranslateXOrigin() {
        point.translateXOrigin(1);
        assertEquals(1, point.getX());
    }

    @Test
    void testTranslateOrigin() {
        point.translateOrigin(1, 1);
        assertEquals(1, point.getX());
        assertEquals(2, point.getY());
    }

    @Test
    void testToString() {
        assertEquals("Point{x=2, y=3}", point.toString());
    }
}

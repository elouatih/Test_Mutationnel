package com.geo;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestPolygonFromFile {
    @Test
    public void testPolygonFromFile(){
        Polygon polygonA = Polygon.createPolygonFromFile("poly1.txt");
        Polygon polygonB = Polygon.createPolygonFromFile("poly2.txt");
        Polygon polygonC = Polygon.createPolygonFromFile("poly3.txt");
        Polygon polygonD = Polygon.createPolygonFromFile("nothing");
        assertNull(polygonD);
        assertNotNull(polygonA);
        assertNotNull(polygonB);
        assertNotNull(polygonC);

        assertEquals(3, polygonA.getSegments().size());
        assertEquals(6, polygonB.getSegments().size());
        assertEquals(6, polygonC.getSegments().size());
        assertEquals(2, polygonA.getSegments().get(0).getOrigin().getX());
        assertEquals(2, polygonA.getSegments().get(0).getOrigin().getY());
        assertEquals(7, polygonB.getSegments().get(1).getEnd().getX());
        assertEquals(10, polygonB.getSegments().get(2).getEnd().getY());

        assertTrue(polygonA.isContaining(polygonA.getPoints().get(0)));
    }

}

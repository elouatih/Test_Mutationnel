package com.geo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestGeo {
    @Test
    public void testGeo() {
        Point pointA = new Point(2, 2);
        Point pointB = new Point(8, 4);
        Point pointC = new Point(4, 8);
        List<Point> points = new LinkedList<>();
        assertFalse(pointC.equals(2));
        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        Segment segment = new Segment(pointA, pointB);
        Polygon polygon = new Polygon(points);
        // Tests Point' getters
        assertEquals(2, pointA.getX());
        assertEquals(4, pointB.getY());
        // Tests Segment' getters
        assertEquals(4, segment.getEnd().getY());
        assertEquals(2, segment.getOrigin().getX());
        // Tests Polygon' getters
        assertEquals(4, polygon.getSegments().get(2).getOrigin().getX());
        assertEquals(2, polygon.getSegments().get(2).getEnd().getY());
        // Tests Polygon' checkPointInQuadrant
        assertTrue(polygon.checkPointInQuadrant(pointA));
        assertTrue(polygon.checkPointInQuadrant(pointB));
        assertTrue(polygon.checkPointInQuadrant(pointC));
        assertTrue(polygon.checkPointInQuadrant(new Point(4, 5)));
        assertTrue(polygon.checkPointInQuadrant(new Point(8, 8)));
        assertFalse(polygon.checkPointInQuadrant(new Point(0, 0)));
        assertFalse(polygon.checkPointInQuadrant(new Point(9, 0)));
    }


}

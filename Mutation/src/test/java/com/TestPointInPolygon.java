package com;

import com.geo.Point;
import com.geo.Polygon;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TestPointInPolygon {
    @Test
    public void testPointInPolygon() {
        Polygon polygon = Polygon.createPolygonFromFile("poly.txt");
        //Polygon polygonB = Polygon.createPolygonFromFile("poly2.txt");
        //Polygon polygonC = Polygon.createPolygonFromFile("poly3.txt");
        //Assure polygon, polygonB and polygonC not null
        assertNotNull(polygon);
        //assertNotNull(polygonB);
        //assertNotNull(polygonC);
        //Test points for polygon A
        List<Point> pointsIn = new LinkedList<>();
        List<Point> pointsOut = new LinkedList<>();
        /*pointsOut.add(new Point(5, 8));
        pointsOut.add(new Point(9, 4));
        pointsOut.add(new Point(8, 0));
        pointsOut.add(new Point(8, 7));*/
        pointsOut.add(new Point(5, 1));
        /*pointsOut.add(new Point(0, 7));
        pointsOut.add(new Point(0, 1));
        pointsOut.add(new Point(6, 7));*/

        pointsIn.add(new Point(5, 6));
        pointsIn.add(new Point(1, 1));
        pointsIn.add(new Point(3, 1));
        pointsIn.add(new Point(3, 6));
        pointsIn.add(new Point(5, 5));
        pointsIn.add(new Point(7, 5));
        pointsIn.add(new Point(4, 3));
        pointsIn.add(new Point(2, 2));
        pointsIn.add(new Point(5, 2));
        pointsIn.add(new Point(5, 3));
        pointsIn.addAll(polygon.getPoints());
        /*//Test points for polygon B
        Point pointBA = new Point(4, 4); // in
        Point pointBB = new Point(4, 7); // in
        Point pointBC = new Point(6, 9); // out
        Point pointBD = polygonB.getPoints().get(0); // in
        //Test points for polygon C
        Point pointCA = new Point(6, 0); // out
        Point pointCB = new Point(5, 2); // in
        Point pointCC = new Point(3, 3); // out
        Point pointCD = polygonC.getPoints().get(0); // in*/

        for(Point p : pointsIn){
            assertTrue(polygon.pointInPolygon(p));
        }
        for(Point p : pointsOut){
            assertFalse(polygon.pointInPolygon(p));
        }
    }
}

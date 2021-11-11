package com;

import com.geo.Point;
import com.geo.Polygon;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestPointInStarPolygon {
    @Test
    public void testPointInPolygon() {
        Polygon polygon = Polygon.createPolygonFromFile("star.txt");
        assertNotNull(polygon);
        for(int i=0; i<=8; i++){
            for(int j=0; j<=8; j++) {
                Point point = new Point(i, j);
                switch (j) {
                    case 1:
                    case 5:
                        assertTrue(polygon.pointInPolygon(point));
                        break;
                    case 2:
                    case 4:
                        if(i < 1 || i > 7) assertFalse(polygon.pointInPolygon(point));
                        else assertTrue(polygon.pointInPolygon(point));
                        break;
                    case 3:
                        if(i < 2 || i > 6) assertFalse(polygon.pointInPolygon(point));
                        else assertTrue(polygon.pointInPolygon(point));
                        break;
                    case 6:
                        if(i < 3 || i > 5) assertFalse(polygon.pointInPolygon(point));
                        else assertTrue(polygon.pointInPolygon(point));
                        break;
                    case 7:
                        if(i != 4) assertFalse(polygon.pointInPolygon(point));
                        else assertTrue(polygon.pointInPolygon(point));
                        break;
                    default:
                        assertFalse(polygon.pointInPolygon(point));
                }
            }
        }
    }
}

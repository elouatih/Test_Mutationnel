package com;

import com.geo.Point;
import com.geo.Polygon;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TestPointInHousePolygon {
    @Test
    public void testPointInPolygon() {
        Polygon polygon = Polygon.createPolygonFromFile("house.txt");
        assertNotNull(polygon);
        for(int i=0; i<=4; i++){
            for(int j=0; j<=7; j++) {
                Point point = new Point(i, j);
                if(i == 0 || i == 4 || j == 0 || j == 7){
                    assertFalse(polygon.pointInPolygon(point));
                } else {
                    if(j == 1){
                        assertTrue(polygon.pointInPolygon(point));
                    } else {
                        if(i == 1 || i == 3){
                            if(j > 4){
                                assertFalse(polygon.pointInPolygon(point));
                            } else {
                                assertTrue(polygon.pointInPolygon(point));
                            }
                        } else {
                            assertTrue(polygon.pointInPolygon(point));
                        }
                    }
                }
            }
        }
    }
}

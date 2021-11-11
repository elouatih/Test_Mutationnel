package com.geo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPointInSegment {
    @Test
    public void testPointInSegment(){
        Point originA = new Point(1, 1);
        Point endA = new Point(3, 1);
        Point endB = new Point(1, 3);
        Segment segmentA = new Segment(originA, endA);
        Segment segmentB = new Segment(originA, endB);

        //List<Point> pointsInA = new LinkedList<>();
        //List<Point> pointsOutA = new LinkedList<>();

        for(int i=0; i<5; i++){
            for(int j=0; j<3; j++){
                if(j != 1){
                    assertFalse(segmentA.pointInSegment(new Point(i, j)));
                    assertFalse(segmentB.pointInSegment(new Point(j, i)));
                } else{
                    if(i <= 3 && 1 <= i){
                        assertTrue(segmentA.pointInSegment(new Point(i, j)));
                        assertTrue(segmentB.pointInSegment(new Point(j, i)));
                    } else {
                        assertFalse(segmentA.pointInSegment(new Point(i, j)));
                        assertFalse(segmentB.pointInSegment(new Point(j, i)));
                    }
                }
            }
        }
        Point originC = new Point(1, 1);
        Point endC = new Point(3, 3);
        Point originD = new Point(3, 1);
        Point endD = new Point(1, 3);
        Segment segmentD = new Segment(originD, endD);
        Segment segmentF = new Segment(endD, originD);
        Segment segmentC = new Segment(originC, endC);
        Segment segmentE = new Segment(endC, originC);

        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                Point pTest = new Point(i, j);
                if(i == 0 || i == 4){
                    assertFalse(segmentC.pointInSegment(pTest));
                    assertFalse(segmentE.pointInSegment(pTest));
                    assertFalse(segmentD.pointInSegment(pTest));
                    assertFalse(segmentF.pointInSegment(pTest));
                } else {
                    if(i == 2 && j == 2){
                        assertTrue(segmentC.pointInSegment(pTest));
                        assertTrue(segmentE.pointInSegment(pTest));
                        assertTrue(segmentD.pointInSegment(pTest));
                        assertTrue(segmentF.pointInSegment(pTest));
                    } else {
                        if(i == j){
                            assertTrue(segmentC.pointInSegment(pTest));
                            assertTrue(segmentE.pointInSegment(pTest));
                            assertFalse(segmentD.pointInSegment(pTest));
                            assertFalse(segmentF.pointInSegment(pTest));
                        } else if(j == 4 - i){
                            assertTrue(segmentD.pointInSegment(pTest));
                            assertTrue(segmentF.pointInSegment(pTest));
                            assertFalse(segmentC.pointInSegment(pTest));
                            assertFalse(segmentE.pointInSegment(pTest));
                        }
                        else {
                            assertFalse(segmentC.pointInSegment(pTest));
                            assertFalse(segmentE.pointInSegment(pTest));
                            assertFalse(segmentD.pointInSegment(pTest));
                            assertFalse(segmentF.pointInSegment(pTest));
                        }
                    }
                }
            }
        }
    }
}

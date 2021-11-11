package com.geo;

public class Segment {
    private Point origin, end;

    public Segment(Point origin, Point end) {
        this.origin = origin;
        this.end = end;
    }

    public Point getOrigin() { return origin; }
    public Point getEnd() { return end; }
    public boolean pointInSegment(Point p){
        /*if(p.equals(origin) || p.equals(end)){
            return true;
        }*/
        if(origin.getX() == end.getX()){
            return p.getX() == origin.getX() && p.getY() <= end.getY() && p.getY() >= origin.getY();
        } else {
            double a = (end.getY() - origin.getY()) / (double)(end.getX() - origin.getX());
            double b = end.getY() - a * end.getX();
            return a * p.getX() + b == p.getY()
                    && (origin.getX() <= p.getX() && p.getX() <= end.getX() ||
                    end.getX() <= p.getX() && p.getX() <= origin.getX());
        }
    }
}

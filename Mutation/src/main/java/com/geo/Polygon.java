package com.geo;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Polygon {
    private List<Point> points;
    private List<Integer> quadrant;
    private List<Segment> segments;
    public static Polygon createPolygonFromFile(String fileString){
        List<Point> points = new LinkedList<>();
        try{
            File file = new File("src/test/files/"+ fileString);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                List<String> items = Arrays.asList(data.split("\\s*,\\s*"));
                points.add(new Point(Integer.parseInt(items.get(0)), Integer.parseInt(items.get(1))));
            }
        } catch (FileNotFoundException e) {
            return null;
        }
        return new Polygon(points);
    }

    public Polygon(@NotNull List<Point> points) {
        this.points = points;
        this.quadrant = new ArrayList<>();
        this.segments = new LinkedList<Segment>();
        for(int i=0; i<points.size(); i++){
            if(i != points.size() - 1){
                segments.add(new Segment(points.get(i), points.get(i + 1)));
            } else {
                segments.add(new Segment(points.get(i), points.get(0)));
            }
        }
    }

    public List<Segment> getSegments() { return segments; }
    public List<Point> getPoints() { return points; }
    private void quadrantPolygon(){
        int xMin, xMax, yMin, yMax;
        xMin = points.stream().mapToInt(Point::getX).min().orElseThrow(NoSuchElementException::new);
        xMax = points.stream().mapToInt(Point::getX).max().orElseThrow(NoSuchElementException::new);
        yMin = points.stream().mapToInt(Point::getY).min().orElseThrow(NoSuchElementException::new);
        yMax = points.stream().mapToInt(Point::getY).max().orElseThrow(NoSuchElementException::new);
        quadrant.add(xMin); quadrant.add(xMax);
        quadrant.add(yMin); quadrant.add(yMax);
    }
    public boolean isContaining(Point p){
        return this.points.stream().anyMatch(e -> p.equals(e));
    }

    public boolean checkPointInQuadrant(@NotNull Point p){
        quadrantPolygon();
        return (p.getX() >= quadrant.get(0)
                && p.getY() >= quadrant.get(2)
                 && p.getX() <= quadrant.get(1)
                  && p.getY() <= quadrant.get(3));
    }
    public boolean pointInPolygon(Point p){
        if(!this.checkPointInQuadrant(p)){
            return false;
        }
        if(this.isContaining(p)){
            return true;
        }
        int count = 0;
        for(Segment s:this.getSegments()){
            Point origin = s.getOrigin();
            Point end = s.getEnd();
            if(s.pointInSegment(p)){
                return true;
            }
            if((origin.getY() <= p.getY() && end.getY() > p.getY())
                    || (origin.getY() > p.getY() && end.getY() <= p.getY())) {
                double vt = (p.getY() - origin.getY()) / (double) (end.getY() - origin.getY());
                /*if (p.getX() == origin.getX() + vt * (end.getX() - origin.getX())) {
                    return true;
                }*/
                if (p.getX() < origin.getX() + vt * (end.getX() - origin.getX())) {
                    count++;
                }
            }
        }
        return (count % 2 == 1);
    }
}

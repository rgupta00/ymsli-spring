package com.demo;
import java.util.*;
public class Shape {
	private String shapeName;
	private List<Point> points;
	
	public String getShapeName() {
		return shapeName;
	}
	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void printShapeDetails() {
		System.out.println(shapeName);
		System.out.println("-------------------");
		points.forEach(p-> System.out.println(p));
		
	}
	
}

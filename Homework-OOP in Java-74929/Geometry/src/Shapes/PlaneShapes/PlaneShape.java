package Shapes.PlaneShapes;


import java.util.ArrayList;
import java.util.List;



import Interfaces.AreaMeasurable;
import Interfaces.PerimeterMeasurable;
import Shapes.Shape;
import Shapes.Vertex;


public abstract class PlaneShape extends Shape implements PerimeterMeasurable, AreaMeasurable, Comparable<PlaneShape> {

	@Override
	public void addVertices(ArrayList<Vertex> vertices) {
		if (vertices.size() != 1) {
			throw new IllegalArgumentException("Current shape should hold only one 2D vertix.");
		}
		
		List<Vertex> verticesList = super.getVertices();
		for (Vertex vertex : vertices) {
			if (vertex.getZCoordinate() == null) {
				verticesList.add(vertex);
			} else {
				throw new IllegalArgumentException("Current shape should hold a 2D vertix.");
			}
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public int compareTo(PlaneShape planeShape) {
		if(this.getPerimeter() > planeShape.getPerimeter()) {
			return 1;
		} else if (this.getPerimeter() == planeShape.getPerimeter()) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public abstract double getArea();

	@Override
	public abstract double getPerimeter();
	
}

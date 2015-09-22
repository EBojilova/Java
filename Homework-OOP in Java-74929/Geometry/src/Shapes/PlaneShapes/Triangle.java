package Shapes.PlaneShapes;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Shapes.Vertex;

public class Triangle extends PlaneShape {
	private final int NUMBER_OF_VERTICES = 3;

	private List<Double> getTriangleSides() {
		List<Vertex> vertices = super.getVertices();
		Vertex a = vertices.get(0);
		Vertex b = vertices.get(1);
		Vertex c = vertices.get(2);
		double sideOne = a.calculateDistanceBetweenTwo2DVertices(b);
		double sideTwo = b.calculateDistanceBetweenTwo2DVertices(c);
		double sideThree = c.calculateDistanceBetweenTwo2DVertices(a);
		List<Double> triangleSides = Arrays.asList(sideOne, sideTwo, sideThree);

		return triangleSides;
	}
	
	@Override
	public void addVertices(ArrayList<Vertex> vertices) {
		if (vertices.size() != NUMBER_OF_VERTICES) {
			throw new IllegalArgumentException("Triangle should hold three 2D vertices.");
		}
		
		Vertex a = vertices.get(0);
		Vertex b = vertices.get(1);
		Vertex c = vertices.get(2);
		if((a.getXCoordinate() == b.getXCoordinate() && b.getXCoordinate() == c.getXCoordinate()) ||
				(a.getYCoordinate() == b.getYCoordinate() && b.getYCoordinate() == c.getYCoordinate())) {
			throw new IllegalArgumentException(
					"Points with equal x coordinates or equal y coordinates cannot create a triangle shape.");
		}
		
		List<Vertex> verticesCollection = super.getVertices();
		for (Vertex vertex : vertices) {
			if (vertex.getZCoordinate() == null) {
				verticesCollection.add(vertex);
			} else {
				throw new IllegalArgumentException(
						"Triangle should hold only 2D vertices.");
			}
		}
	}

	@Override
	public double getArea() {
		List<Double> triangleSides = this.getTriangleSides();
		double sideOne = triangleSides.get(0);
		double sideTwo = triangleSides.get(1);
		double sideThree = triangleSides.get(2);
		double p = this.getPerimeter() / 2;
		double area = Math.sqrt(p * (p - sideOne) * (p - sideTwo)
				* (p - sideThree));
		return area;
	}

	@Override
	public double getPerimeter() {
		List<Double> triangleSides = this.getTriangleSides();
		double sideOne = triangleSides.get(0);
		double sideTwo = triangleSides.get(1);
		double sideThree = triangleSides.get(2);
		double perimeter = sideOne + sideTwo + sideThree;
		return perimeter;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Shape type: Triangle\n");
		result.append(super.toString());
		result.append(String.format("Perimeter: %.2f\n", this.getPerimeter()));
		result.append(String.format("Area: %.2f\n", this.getArea()));
		return result.toString();
	}

}

package Shapes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Shapes.PlaneShapes.Circle;
import Shapes.PlaneShapes.PlaneShape;
import Shapes.PlaneShapes.Rectangle;
import Shapes.PlaneShapes.Triangle;
import Shapes.SpaceShapes.Cuboid;
import Shapes.SpaceShapes.SpaceShape;
import Shapes.SpaceShapes.Sphere;
import Shapes.SpaceShapes.SquarePyramid;

public class ShapesInformation {

	public static void main(String[] args) {
		try {
			ArrayList<Vertex> triangleVertices = new ArrayList<Vertex>();
			triangleVertices.add(new Vertex("Ä", 0.0, 5));
			triangleVertices.add(new Vertex("B", 1, 5.5));
			triangleVertices.add(new Vertex("C", 2, 7));
			Shape triangle = new Triangle();
			triangle.addVertices(triangleVertices);
			
			ArrayList<Vertex> rectangleVertices = new ArrayList<Vertex>();
			rectangleVertices.add(new Vertex("O", 9, 2));
			Shape rectangle = new Rectangle(6, 4);
			rectangle.addVertices(rectangleVertices);
			
			ArrayList<Vertex> circleVertices = new ArrayList<Vertex>();
			circleVertices.add(new Vertex("O", 0, 7));
			Shape circle = new Circle(0.5);
			circle.addVertices(circleVertices);
			
			ArrayList<Vertex> squarePyramidVertices = new ArrayList<Vertex>();
			squarePyramidVertices.add(new Vertex("O", 0.0, 0.0, 0.0));
			Shape squarePyramid = new SquarePyramid(5.0, 7.8);
			squarePyramid.addVertices(squarePyramidVertices);
			
			ArrayList<Vertex> cuboidVertices = new ArrayList<Vertex>();
			cuboidVertices.add(new Vertex("A", 5.5, 6.6, 3.4));
			Shape cuboid = new Cuboid(5.6, 7.7, 4.44);
			cuboid.addVertices(cuboidVertices);
			
			ArrayList<Vertex> sphereVertices = new ArrayList<Vertex>();
			sphereVertices.add(new Vertex("O", 0.0, 0.0, 0.0));
			Shape sphere = new Sphere(2.1);
			sphere.addVertices(sphereVertices);
			
			List<Shape> shapes = Arrays.asList(triangle, rectangle, circle, squarePyramid, cuboid, sphere);
			System.out.println("Printed list of all shapes:");
			shapes.forEach(s -> System.out.println(s.toString()));
			
//			for (Shape shape : shapes) {
//				if(shape instanceof SpaceShape) {
//					if (((SpaceShape) shape).getVolume() > 40) {
//						System.out.println(((SpaceShape) shape));
//					}
//				}
//			}
			
			System.out.println("Space shapes with volume bigger than 40:");
			shapes.stream()
				.filter(s -> s instanceof SpaceShape)
				.map(s -> (SpaceShape) s)
				.filter(s -> s.getVolume() > 40)
				.forEach(s -> System.out.println(s));	
			
			System.out.println("Sorted pLane shapes by their perimeter in ascending order:");
			shapes.stream()
				.filter(s -> s instanceof PlaneShape)
				.map(s -> (PlaneShape) s)
				.sorted()
				.forEach(s -> System.out.println(s));
			
		} catch (IllegalArgumentException illegArgEx) {
			illegArgEx.getMessage();
			illegArgEx.printStackTrace();
		}
	}
}

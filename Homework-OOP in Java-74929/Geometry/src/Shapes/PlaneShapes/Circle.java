package Shapes.PlaneShapes;



public class Circle extends PlaneShape {
	private double radius;
	
	public Circle(double radius) {
		//super();
		this.setRadius(radius);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		double area = Math.PI * this.radius * this.radius;
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = 2 * Math.PI * this.radius;
		return perimeter;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Shape type: Circle\n");
		result.append(super.toString());
		result.append(String.format("Perimeter: %.2f\n", this.getPerimeter()));
		result.append(String.format("Area: %.2f\n", this.getArea()));
		return result.toString();
	}
	
}

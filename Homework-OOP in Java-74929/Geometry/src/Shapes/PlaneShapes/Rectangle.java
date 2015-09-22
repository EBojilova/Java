package Shapes.PlaneShapes;


public class Rectangle extends PlaneShape {
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		//super();
		this.setWidth(width);
		this.setHeight(height);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		double area = this.width * this.height;
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = 2 * this.width + 2 * this.height;
		return perimeter;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Shape type: Rectangle\n");
		result.append(super.toString());
		result.append(String.format("Perimeter: %.2f\n", this.getPerimeter()));
		result.append(String.format("Area: %.2f\n", this.getArea()));
		return result.toString();
	}
	
}

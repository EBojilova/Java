package Shapes.SpaceShapes;

public class Sphere extends SpaceShape {
	private double radius;
	
	public Sphere(double radius) {
		super();
		this.setRadius(radius);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Shape type: Sphere\n");
		result.append(super.toString());
		result.append(String.format("Volume: %.2f\n", this.getVolume()));
		result.append(String.format("Surface Area: %.2f\n", this.getArea()));
		return result.toString();
	}

	@Override
	public double getVolume() {
		double volume = (4 / 3) * Math.PI * (this.radius * this.radius * this.radius);
		return volume;
	}

	@Override
	public double getArea() {
		double area = 4 * Math.PI * (this.radius * this.radius);
		return area;
	}

}

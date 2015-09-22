package Shapes.SpaceShapes;

public class Cuboid extends SpaceShape {
	private final double NUMBER_OF_PARALLEL_CUBOID_SIDES = 2;
	private double width;
	private double height;
	private double depth;
	
	public Cuboid(double width, double height, double depth) {
		super();
		this.setWidth(width);
		this.setHeight(height);
		this.setDepth(depth);
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

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Shape type: Cuboid\n");
		result.append(super.toString());
		result.append(String.format("Volume: %.2f\n", this.getVolume()));
		result.append(String.format("Surface Area: %.2f\n", this.getArea()));
		return result.toString();
	}

	@Override
	public double getVolume() {
		double baseArea = this.getBaseArea();
		double volume = baseArea * this.height;
		return volume;
	}

	@Override
	public double getArea() {
		double baseArea = this.getBaseArea();
		double widthSideArea = this.getWidthSideArea();
		double depthSideArea = this.getDepthSideArea();
		double area = NUMBER_OF_PARALLEL_CUBOID_SIDES * (baseArea + depthSideArea + widthSideArea);
		return area;
	}

	private double getBaseArea() {
		double area = this.width * this.depth;
		return area;
	}
	
	private double getWidthSideArea() {
		double area = this.width * this.height;
		return area;
	}
	
	private double getDepthSideArea() {
		double area = this.depth * this.height;
		return area;
	}
}

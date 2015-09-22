package Shapes.SpaceShapes;

public class SquarePyramid extends SpaceShape {
	private final int NUMBER_OF_PYRAMID_SLANTS = 4;
	private double baseWidth;
	private double pyramidHeight;

	public SquarePyramid(double baseWidth, double pyramidHeight) {
		super();
		this.setBaseWidth(baseWidth);
		this.setPyramidHeight(pyramidHeight);
	}

	public double getBaseWidth() {
		return baseWidth;
	}

	public void setBaseWidth(double baseWidth) {
		this.baseWidth = baseWidth;
	}

	public double getPyramidHeight() {
		return pyramidHeight;
	}

	public void setPyramidHeight(double pyramidHeight) {
		this.pyramidHeight = pyramidHeight;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Shape type: Square Pyramid\n");
		result.append(super.toString());
		result.append(String.format("Volume: %.2f\n", this.getVolume()));
		result.append(String.format("Surface Area: %.2f\n", this.getArea()));
		return result.toString();
	}

	@Override
	public double getVolume() {
		double baseArea = this.getBaseArea();
		double volume = baseArea * this.pyramidHeight / 3;
		return volume;
	}

	@Override
	public double getArea() {
		double baseArea = this.getBaseArea();
		double slantArea = this.getSlantArea();
		double area = baseArea + (NUMBER_OF_PYRAMID_SLANTS * slantArea);
		return area;
	}

	
	private double getSlantHeight() {
		double slantHeight = Math.sqrt(this.pyramidHeight * this.pyramidHeight
				+ (this.baseWidth / 2) * (this.baseWidth / 2));
		return slantHeight;
	}

	private double getBaseArea() {
		double area = this.baseWidth * this.baseWidth;
		return area;
	}

	private double getSlantArea() {
		double slantHeight = this.getSlantHeight();
		double area = this.baseWidth * slantHeight / 2;
		return area;
	}
}

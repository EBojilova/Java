package Shapes;

public class Vertex {
	private String name;
	private double xCoordinate;
	private double yCoordinate;
	private Double zCoordinate;

	public Vertex(String name, double xCoordinate, double yCoordinate) {
		this.setName(name);
		this.setXCoordinate(xCoordinate);
		this.setYCoordinate(yCoordinate);
	}

	public Vertex(String name, double xCoordinate, double yCoordinate,
			Double zCoordinate) {
		this(name, xCoordinate, yCoordinate);
		this.setZCoordinate(zCoordinate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Vertex name cannot be empty.");
		}
		this.name = name;
	}

	public double getXCoordinate() {
		return xCoordinate;
	}

	public void setXCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getYCoordinate() {
		return yCoordinate;
	}

	public void setYCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public Double getZCoordinate() {
		return zCoordinate;
	}

	public void setZCoordinate(Double zCoordinate) {
		this.zCoordinate = zCoordinate;
	}

	public double calculateDistanceBetweenTwo2DVertices(Vertex vertex) {
		double distance = Math.sqrt((Math.pow(this.getXCoordinate()
				- vertex.getXCoordinate(), 2) + (Math.pow(this.getYCoordinate()
				- vertex.getYCoordinate(), 2))));
		return distance;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("Vertix %s: X = %.2f, Y = %.2f", this.name,
				this.xCoordinate, this.yCoordinate));
		if (this.zCoordinate != null) {
			result.append(String.format(", Z: %.2f\n", this.zCoordinate));
		} else {
			result.append("\n");
		}
		return result.toString();
	}

}

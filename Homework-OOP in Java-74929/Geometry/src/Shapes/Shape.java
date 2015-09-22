package Shapes;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {
	private List<Vertex> vertices;

	public Shape() {
		this.vertices = new ArrayList<Vertex>();
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

	public abstract void addVertices(ArrayList<Vertex> vertices);

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Vertex's coordinates:\n");
		for (Vertex vertex : vertices) {
			result.append(vertex.toString());
		}
		return result.toString();
	}

}

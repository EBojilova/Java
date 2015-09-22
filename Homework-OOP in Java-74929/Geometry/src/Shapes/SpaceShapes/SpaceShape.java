package Shapes.SpaceShapes;

import java.util.ArrayList;
import java.util.List;

import Interfaces.AreaMeasurable;
import Interfaces.VolumeMeasurable;
import Shapes.Shape;
import Shapes.Vertex;


public abstract class SpaceShape extends Shape implements AreaMeasurable, VolumeMeasurable {

	@Override
	public void addVertices(ArrayList<Vertex> vertices) {
		if (vertices.size() != 1) {
			throw new IllegalArgumentException("Current shape should hold only one 3D vertix.");
		}
		
		List<Vertex> verticesList = super.getVertices();
		for (Vertex vertex : vertices) {
			if (vertex.getZCoordinate() != null) {
				verticesList.add(vertex);
			} else {
				throw new IllegalArgumentException("Current shape should hold a 3D vertix.");
			}
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public abstract double getVolume();

	@Override
	public abstract  double getArea();

}

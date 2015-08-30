public class Triangle {

    private Integer[] coordinates;

    public void setCoordinates(Integer[] coordinates) {
        this.coordinates = coordinates;
    }

    private double calculateTriangleAre() {
        int Ax = this.coordinates[0];
        int Ay = this.coordinates[1];
        int Bx = this.coordinates[2];
        int By = this.coordinates[3];
        int Cx = this.coordinates[4];
        int Cy = this.coordinates[5];
        double area = 0;
        area += Ax * (By - Cy);
        area += Bx * (Cy - Ay);
        area += Cx * (Ay - By);
        area /= 2.0;
        area = Math.abs(area);
        return area;
    }

    public void printArea() {
        double area = this.calculateTriangleAre();

        if (area != 0) {
            System.out.printf("%nThe area of the triangle is %d.", (int) area);
        }
        else {
            System.out.printf("%nResult: 0.%nThese three points do not form a triangle; they are collinear.");
        }
    }
}

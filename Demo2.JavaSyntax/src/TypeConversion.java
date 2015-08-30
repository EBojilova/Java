
public class TypeConversion {
    public static void main(String[] args) {
        int i = 5;
        long l = i; // Implicit type conversion
        long lng = 5;
        System.out.println(lng);
        int intVal = (int) lng; // Explicit type conversion
        System.out.println(intVal);
        float heightInMeters = 1.74f; // Explicit conversion
        System.out.println(heightInMeters);
        double maxHeight = heightInMeters; // Implicit
        System.out.println(maxHeight);
        double minHeight = (double) heightInMeters; // Explicit
        System.out.println(minHeight);
        float actualHeight = (float) maxHeight; // Explicit
        System.out.println(actualHeight);
        //float maxHeightFloat = maxHeight; // Compilation error!
        // Explicit type conversion with data loss
        byte dataLoss = (byte) 12345; // 57
        System.out.println(dataLoss);
    }
}

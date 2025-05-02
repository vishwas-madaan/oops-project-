package lab7;
public class VolumeCalculator {
    public static void main(String[] args) {
        // Create a Cuboid object
        Cuboid cuboid = new Cuboid(5.0, 3.0, 4.0);
        double cuboidVolume = cuboid.calculateVolume();
        System.out.println("Volume of the Cuboid: " + String.format("%.2f", cuboidVolume));

        // Create a Sphere object
        Sphere sphere = new Sphere(2.5);
        double sphereVolume = sphere.calculateVolume();
        System.out.println("Volume of the Sphere: " + String.format("%.2f", sphereVolume));
    }
}
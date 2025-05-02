package lab7;
class Cuboid extends Solid {
    private double length;
    private double width;
    private double height;

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Override the abstract method to calculate the volume of the cuboid
    @Override
    public double calculateVolume() {
        return length * width * height;
    }
}

// Concrete class representing a sphere
class Sphere extends Solid {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    // Override the abstract method to calculate the volume of the sphere
    @Override
    public double calculateVolume() {
        return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
    }
}


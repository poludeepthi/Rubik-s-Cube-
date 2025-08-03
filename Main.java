package aerohack.com;

public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube();

        System.out.println("Initial state:");
        cube.printCube();

        cube.scramble(20); // Now prints "Cube scrambled." inside

        cube.printCube();  // Show scrambled cube

        cube.reset();
        System.out.println("After reset:");
        cube.printCube();  // Show reset state
    }
}


package aerohack.com;
import java.util.Random;
public class Cube {
    public char[][][] faces;

    // Face indices: 0=U, 1=D, 2=F, 3=B, 4=L, 5=R
    private final char[] colors = {'W', 'Y', 'R', 'O', 'G', 'B'};

    public Cube() {
        faces = new char[6][3][3];
        for (int f = 0; f < 6; f++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    faces[f][i][j] = colors[f];
                }
            }
        }
    }

    private void rotateFaceClockwise(char[][] face) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                temp[j][2 - i] = face[i][j];
        for (int i = 0; i < 3; i++)
            System.arraycopy(temp[i], 0, face[i], 0, 3);
    }

    private void rotateFaceCounterClockwise(char[][] face) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                temp[2 - j][i] = face[i][j];
        for (int i = 0; i < 3; i++)
            System.arraycopy(temp[i], 0, face[i], 0, 3);
    }

    // U move (Up face clockwise)
    public void moveU() {
        rotateFaceClockwise(faces[0]);
        char[] temp = faces[2][0].clone();
        faces[2][0] = faces[5][0].clone();
        faces[5][0] = faces[3][0].clone();
        faces[3][0] = faces[4][0].clone();
        faces[4][0] = temp;
    }

    // U' move (Up face counterclockwise)
    public void moveUPrime() {
        rotateFaceCounterClockwise(faces[0]);
        char[] temp = faces[2][0].clone();
        faces[2][0] = faces[4][0].clone();
        faces[4][0] = faces[3][0].clone();
        faces[3][0] = faces[5][0].clone();
        faces[5][0] = temp;
    }

    // Print cube state
    public void printCube() {
        String[] names = {"U", "D", "F", "B", "L", "R"};
        for (int f = 0; f < 6; f++) {
            System.out.println(names[f] + " face:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(faces[f][i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public void moveD() {
        rotateFaceClockwise(faces[1]);
        char[] temp = faces[2][2].clone();
        faces[2][2] = faces[4][2].clone();
        faces[4][2] = faces[3][2].clone();
        faces[3][2] = faces[5][2].clone();
        faces[5][2] = temp;
    }

    public void moveDPrime() {
        rotateFaceCounterClockwise(faces[1]);
        char[] temp = faces[2][2].clone();
        faces[2][2] = faces[5][2].clone();
        faces[5][2] = faces[3][2].clone();
        faces[3][2] = faces[4][2].clone();
        faces[4][2] = temp;
    }
    public void moveF() {
        rotateFaceClockwise(faces[2]);
        char[] temp = {faces[0][2][0], faces[0][2][1], faces[0][2][2]};
        for (int i = 0; i < 3; i++) faces[0][2][i] = faces[4][2 - i][2];
        for (int i = 0; i < 3; i++) faces[4][i][2] = faces[1][0][i];
        for (int i = 0; i < 3; i++) faces[1][0][i] = faces[5][2 - i][0];
        for (int i = 0; i < 3; i++) faces[5][i][0] = temp[i];
    }

    public void moveFPrime() {
        rotateFaceCounterClockwise(faces[2]);
        char[] temp = {faces[0][2][0], faces[0][2][1], faces[0][2][2]};
        for (int i = 0; i < 3; i++) faces[0][2][i] = faces[5][i][0];
        for (int i = 0; i < 3; i++) faces[5][i][0] = faces[1][0][2 - i];
        for (int i = 0; i < 3; i++) faces[1][0][i] = faces[4][i][2];
        for (int i = 0; i < 3; i++) faces[4][i][2] = temp[2 - i];
    }
    public void moveB() {
        rotateFaceClockwise(faces[3]);
        char[] temp = {faces[0][0][0], faces[0][0][1], faces[0][0][2]};
        for (int i = 0; i < 3; i++) faces[0][0][i] = faces[5][i][2];
        for (int i = 0; i < 3; i++) faces[5][i][2] = faces[1][2][2 - i];
        for (int i = 0; i < 3; i++) faces[1][2][i] = faces[4][i][0];
        for (int i = 0; i < 3; i++) faces[4][i][0] = temp[2 - i];
    }

    public void moveBPrime() {
        rotateFaceCounterClockwise(faces[3]);
        char[] temp = {faces[0][0][0], faces[0][0][1], faces[0][0][2]};
        for (int i = 0; i < 3; i++) faces[0][0][i] = faces[4][2 - i][0];
        for (int i = 0; i < 3; i++) faces[4][i][0] = faces[1][2][i];
        for (int i = 0; i < 3; i++) faces[1][2][i] = faces[5][2 - i][2];
        for (int i = 0; i < 3; i++) faces[5][i][2] = temp[i];
    }
    public void moveL() {
        rotateFaceClockwise(faces[4]);
        char[] temp = {faces[0][0][0], faces[0][1][0], faces[0][2][0]};
        for (int i = 0; i < 3; i++) faces[0][i][0] = faces[3][2 - i][2];
        for (int i = 0; i < 3; i++) faces[3][i][2] = faces[1][2 - i][0];
        for (int i = 0; i < 3; i++) faces[1][i][0] = faces[2][i][0];
        for (int i = 0; i < 3; i++) faces[2][i][0] = temp[i];
    }

    public void moveLPrime() {
        rotateFaceCounterClockwise(faces[4]);
        char[] temp = {faces[0][0][0], faces[0][1][0], faces[0][2][0]};
        for (int i = 0; i < 3; i++) faces[0][i][0] = faces[2][i][0];
        for (int i = 0; i < 3; i++) faces[2][i][0] = faces[1][i][0];
        for (int i = 0; i < 3; i++) faces[1][i][0] = faces[3][2 - i][2];
        for (int i = 0; i < 3; i++) faces[3][i][2] = temp[2 - i];
    }
    public void moveR() {
        rotateFaceClockwise(faces[5]);
        char[] temp = {faces[0][0][2], faces[0][1][2], faces[0][2][2]};
        for (int i = 0; i < 3; i++) faces[0][i][2] = faces[2][i][2];
        for (int i = 0; i < 3; i++) faces[2][i][2] = faces[1][i][2];
        for (int i = 0; i < 3; i++) faces[1][i][2] = faces[3][2 - i][0];
        for (int i = 0; i < 3; i++) faces[3][i][0] = temp[2 - i];
    }

    public void moveRPrime() {
        rotateFaceCounterClockwise(faces[5]);
        char[] temp = {faces[0][0][2], faces[0][1][2], faces[0][2][2]};
        for (int i = 0; i < 3; i++) faces[0][i][2] = faces[3][2 - i][0];
        for (int i = 0; i < 3; i++) faces[3][i][0] = faces[1][2 - i][2];
        for (int i = 0; i < 3; i++) faces[1][i][2] = faces[2][i][2];
        for (int i = 0; i < 3; i++) faces[2][i][2] = temp[i];
    }
    

public void scramble(int movesCount) {
    String[] moves = {"U", "U'", "D", "D'", "F", "F'", "B", "B'", "L", "L'", "R", "R'"};
    Random rand = new Random();

    for (int i = 0; i < movesCount; i++) {
        String move = moves[rand.nextInt(moves.length)];
        applyMove(move);
        System.out.print(move + " ");
    }
    System.out.println("\nCube scrambled.\n");
}

// Helper to apply a move by name
public void applyMove(String move) {
    switch (move) {
        case "U": moveU(); break;
        case "U'": moveUPrime(); break;
        case "D": moveD(); break;
        case "D'": moveDPrime(); break;
        case "F": moveF(); break;
        case "F'": moveFPrime(); break;
        case "B": moveB(); break;
        case "B'": moveBPrime(); break;
        case "L": moveL(); break;
        case "L'": moveLPrime(); break;
        case "R": moveR(); break;
        case "R'": moveRPrime(); break;
    }
}
public void reset() {
    for (int f = 0; f < 6; f++) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                faces[f][i][j] = colors[f];
            }
        }
    }
}

}

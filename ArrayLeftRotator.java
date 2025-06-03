import java.util.Arrays;

public class ArrayLeftRotator {
    public static int[] rotateLeft(int[] originalArray, int numPositions) {
        if (originalArray == null || originalArray.length == 0) {
            return originalArray;
        }

        if (numPositions < 0) {
            throw new IllegalArgumentException("Rotation positions cannot be negative. Received: " + numPositions);
        }

        int arrayLength = originalArray.length;
        int actualRotations = numPositions % arrayLength;
        if (actualRotations == 0) {
            return Arrays.copyOf(originalArray, arrayLength);
        }

        int[] rotatedArray = new int[arrayLength];
        System.arraycopy(originalArray, actualRotations, rotatedArray, 0, arrayLength - actualRotations);
        System.arraycopy(originalArray, 0, rotatedArray, arrayLength - actualRotations, actualRotations);

        return rotatedArray;
    }

    private static void rotate(int[] arr, int positions) {
        if (arr == null) {
            System.out.printf("Rotating null array by %d: Result: %s%n", positions, "null");
            return;
        }

        int[] result = rotateLeft(arr, positions);
        System.out.printf("Rotate '%s' left by %d: Result: %s%n", Arrays.toString(arr), positions, Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] myArray = {10, 20, 30, 40, 50, 60, 70};
        System.out.println("Original array: " + Arrays.toString(myArray));
        System.out.println("--- Test Cases ---");

        rotate(myArray, 2);
        rotate(myArray, 8);
        rotate(myArray, 0);
        rotate(new int[]{}, 3);
        rotate(null, 5);
        System.out.print("Testing negative rotation (-3): ");
        try {
            rotateLeft(myArray, -3);
            System.out.println("Error: Negative rotation didn't throw an exception!");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
        System.out.println("--------------------");
    }
}

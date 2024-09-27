package labs.lab0;



public class Variant5 {
    public int inputOutputTask(int a) {
        return (a*a*a);
    }
    public int integerNumbersTask(int A, int B) {
        return A%B;
    }


    public boolean booleanTask(int number1, int number2) {
        return (number1 > 0 || number2 < -2);
    }

    public int[] ifTask(int x, int y, int z) {
        int posCount = 0, negCount = 0;
        if (x > 0) posCount++; else if (x < 0) negCount++;
        if (y > 0) posCount++; else if (y < 0) negCount++;
        if (z > 0) posCount++; else if (z < 0) negCount++;
        return new int[] {posCount, negCount};
    }
    public double switchTask(int N, double A, double B) {
        return switch (N) {
            case 1 -> A + B;
            case 2 -> A - B;
            case 3 -> A * B;
            case 4 -> A / B;
            default -> throw new IllegalArgumentException("Invalid operation code");
        };
    }
    public double forTask(int price) {
        for (double i = 0.1; i <= 1.0; i += 0.1) {
            double result = Math.round(price * i * 10.0) / 10.0;
            double weight = Math.round(i * 10.0) / 10.0;
            System.out.println(weight + " kg: " + result);
        }
        return Math.round(price * 1.0 * 10.0) / 100.0;
    }
    public int whileTask(int N) {
        int K = 0;
        while (N > 1) {
            N /= 2;
            K++;
        }
        return K;
    }
    public int[] arrayTask(int N) {
        int[] fibonacci = new int[N];
        if (N > 0) fibonacci[0] = 1;
        if (N > 1) fibonacci[1] = 1;
        for (int i = 2; i < N; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci;
    }

    public int[][] twoDimensionArrayTask(int[][] array, int N, int D) {
        int M = array.length;
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            matrix[i][0] = array[i][0];
            for (int j = 1; j < N; j++) {
                matrix[i][j] = matrix[i][j-1] + D;
            }
        }
        return matrix;
    }
    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}

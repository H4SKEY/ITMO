import java.util.Random;

public class Main {
    public static void main(String[] args) {
        long[] f = new long[14];
        for (int i = 0; i < f.length; i++) {
            f[i] = 6 + i; // Заполнение массива f числами от 6 до 19
        }

        float[] x = new float[10];
        Random random = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] = -13.0f + random.nextFloat() * 16.0f; // Заполнение массива x случайными числами от -13.0 до 3.0
        }

        double[][] e = new double[14][10];
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < x.length; j++) {
                e[i][j] = calculateElement(f[i], x[j]); // Создание двумерного массива е
            }
        }
        printMatrix(e);
    }

    // Вычисление элемента двумерного массива
    public static double calculateElement(long fValue, float xValue) {
        if (fValue == 17) {
            return Math.asin(Math.cos(Math.tan(Math.asin((xValue - 5) / 16))));
        } else if (fValue == 7 || fValue == 8 || fValue == 10 || fValue == 12 || fValue == 13 || fValue == 14 || fValue == 18) {
            return Math.cbrt(Math.exp(Math.asin((xValue - 5) / 16)));
        } else {
            return Math.cbrt((Math.cbrt(Math.pow((xValue / 0.5), 2))) / 2);
        }
    }

    // Вывод матрицы
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%.4f ", value); // Форматирование вывода с 4 знаками после запятой
            }
            System.out.println();
        }
    }
}

import java.util.Random;

public class MatrixOperations {

    public static void main(String[] args) throws Exception {
        int rows = 3;
        int columns = 3;
        byte[][] mat1 = generateMatrix(rows, columns);
        System.out.println("Matrix A:");
        printMatrix(mat1);
        byte[][] mat2 = generateMatrix(rows, columns);
        System.out.println("Matrix B:");
        printMatrix(mat2);

        byte[][] resultMatrix = additionMatrices(mat1, mat2);
        System.out.println("Matrix C");
        printMatrix(resultMatrix);

        System.out.println("Sum of the least elements in every column is: " + findSumTheLeastElements(resultMatrix));
    }
    public static byte[][] additionMatrices(byte[][] firstMatrix, byte[][] secondMatrix) throws Exception{
        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            throw new Exception("Matrix dimensions do not match for addition.");
        }
        byte [][] resultMatrix = new byte[firstMatrix.length][firstMatrix[0].length];
        for(int i=0; i< firstMatrix.length; i++){
            for(int j=0; j<firstMatrix[0].length; j++){
                resultMatrix[i][j] = (byte) (firstMatrix[i][j] + secondMatrix[i][j]);
            }
        }
        return resultMatrix;
    }
    public static int findSumTheLeastElements(byte[][] resultMatrix){
        int sum = 0;
        for(int j=0; j<resultMatrix.length; j++){
            int minElement = 63;
            for(int i=0; i<resultMatrix[j].length; i++){
                if(resultMatrix[i][j]<minElement) minElement=resultMatrix[i][j];
            }
            sum += minElement;
        }
        return sum;
    }
    public static byte[][] generateMatrix(int rows, int columns){
        Random rand = new Random();
        byte [][] resMatrix = new byte[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                byte num = (byte) rand.nextInt(128);
                resMatrix[i][j] = (byte) (num - 64);
            }
        }
        return resMatrix;
    }
    public static void printMatrix(byte[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

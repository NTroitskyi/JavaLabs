import java.lang.Math;
import static java.lang.Math.round;

public class Matrix {
    double[][] matrix;
    int Rows;
    int Columns;
    public Matrix(int Rows, int Columns) {
        this.Rows = Rows;
        this.Columns = Columns;
        matrix = new double[Rows][Columns];
    }
    public void Random() {
        for (int i=0; i<this.Rows; i++)
            for (int j=0; j<this.Columns; j++) {
                Double r = Math.random();
                this.matrix[i][j] = round(r*(10 - 0 + 1) + 0);
            }
    }
    public void getRow(int Row){
        System.out.println("Row №"+Row+": ");
        for (int i=0;i<matrix[Row].length; i++){
            System.out.print(matrix[Row-1][i]+" ");
        }
        System.out.println();
    }
    public void getColumn(int Column){
        System.out.println("Column №"+Column+": ");
        for (int i=0; i<matrix.length; i++){
            System.out.println(matrix[i][Column-1]);
        }
    }
    public double getElement(int Row, int Column){
        return matrix[Row-1][Column - 1];
    }
    public int[] getDimension(){
        int[] dim = new int[2];
        dim[0] = Rows;
        dim[1] = Columns;
        return dim;
    }
    public boolean equals(Matrix matrix2) {
        if (matrix2.Rows != this.Rows || matrix2.Columns != this.Columns)
            return false;
        for (int i = 0; i < Rows; i++)
            for (int j = 0; j < Columns; j++)
                if (this.matrix[i][j] != matrix2.matrix[i][j])
                    return false;
        return true;
    }
    public Matrix getMultiple(Matrix m2) throws Exception {
        int Row1 = this.Rows;
        int Row2 = m2.Rows;
        int Column1 = this.Columns;
        int Column2 = m2.Columns;
        if (Column1 != Row2) throw new Exception("Wrong Dimensions!");
        Matrix temp = new Matrix(Row1, Column2);
        for (int i = 0; i < Row1; i++) {
            for (int j = 0; j < Column2; j++) {
                for (int k = 0; k < Column1; k++) {
                    //System.out.println(this.matrix[i][k] * m2.matrix[k][j]);
                    temp.matrix[i][j] += this.matrix[i][k] * m2.matrix[k][j];
                }
            }
        }
        return temp;
    }
    public static Matrix StringMatrix(int Columns) {
        Matrix temp = new Matrix(1, Columns);
        temp.Random();
        return temp;
    }
    public void show() {
        for (int i = 0; i < this.Rows; i++) {
            for (int j = 0; j < this.Columns; j++)
                System.out.print(this.matrix[i][j] + " ");
            System.out.println();
        }
    }
}
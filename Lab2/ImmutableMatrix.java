import static java.lang.Math.round;
final class ImmutableMatrix {
    private final double[][] matrix;
    private final int Rows, Columns;
    public ImmutableMatrix(int Rows, int Columns) {
        this.Rows = Rows;
        this.Columns = Columns;
        matrix = new double[Rows][Columns];
    }

    public ImmutableMatrix(Matrix matrix) {
        this(matrix.Rows, matrix.Columns);
        getCopy(matrix.matrix);
    }
    public void getCopy(double[][] m) {
        for (int i=0; i<m.length; i++)
            for (int j=0; j<m[0].length; j++)
                this.matrix[i][j]=m[i][j];
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
    public boolean equals(ImmutableMatrix matrix2) {
        if (matrix2.Rows != this.Rows || matrix2.Columns != this.Columns)
            return false;
        for (int i = 0; i < Rows; i++)
            for (int j = 0; j < Columns; j++)
                if (this.matrix[i][j] != matrix2.matrix[i][j])
                    return false;
        return true;
    }
    public ImmutableMatrix getMultiple(ImmutableMatrix m2) throws Exception {
        int Row1 = this.Rows;
        int Row2 = m2.Rows;
        int Column1 = this.Columns;
        int Column2 = m2.Columns;
        if (Column1 != Row2) throw new Exception("Wrong Dimensions!");
        ImmutableMatrix temp = new ImmutableMatrix(Row1, Column2);
        for (int i = 0; i < Row1; i++) {
            for (int j = 0; j < Column2; j++) {
                for (int k = 0; k < Column1; k++) {
                    temp.matrix[i][j] += this.matrix[i][k] * m2.matrix[k][j];
                }
            }
        }
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

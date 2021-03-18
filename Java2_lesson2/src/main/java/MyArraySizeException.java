import java.io.IOException;

public class MyArraySizeException extends RuntimeException {
    int row;
    int column;

    public MyArraySizeException(int row) {
        super("The array should have 4 rows, your input "+row);
        this.row =row;
        this.column=0;


    }
    public MyArraySizeException( int row, int column) {
        super("The array should have 4 rows and 4 columns, your entered "+row+"r ows and "+column+" columns");
        this.row =row;
        this.column=column;
    }
}

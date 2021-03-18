public class MyArrayDataException extends RuntimeException{
    private int row;
    private int column;
    String array;

    public MyArrayDataException(int row, int column, String[][] array){
        super("Wrong data in String array: rpw "+row+" column "+column+" with data "+array[row][column]);
        this.row=row;
        this.column=column;
        this.array=array[row][column];
    }
}

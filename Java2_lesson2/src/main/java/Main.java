public class Main {
    public static void main(String[] args) {
        String[][] array ={{"1", "1","2","2"},
                            {"2", "2","1","1"},
                            {"-2", "-2","1","1"},
                            {"0", "0","0","0"}};
        try {
        System.out.println("The result is "+new Main().method1(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
    public int method1(String[][] arr) throws MyArraySizeException,MyArrayDataException {
        int summary=0;
        for (int i = 0; i<arr.length; i++) {
            if(arr.length!=4){
                throw new MyArraySizeException(arr.length);
            }
            for (int j = 0;j<arr[i].length;j++){
                if(arr[i].length!=4){
                    throw new MyArraySizeException(arr.length,arr[i].length);
                }
                try {
                    summary+=Integer.parseInt(arr[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j,arr);
                }
            }
        }
        return summary;
    }
}

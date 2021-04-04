import java.util.Arrays;

public class MainApp {
    public static final int SIZE = 10000001;

    public static void main(String[] args){
        arrayInputOneThread();
        arrayInputMultyThread(12);
    }

    public static void arrayInputOneThread(){
        float[] arr = new float[SIZE];
        long currentTime = System.currentTimeMillis();
        Arrays.fill(arr, 1);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i <SIZE; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Время работы одного потока "+(System.currentTimeMillis()-currentTime)+" миллисекунд");
            //проверка вычислений
//            for (int i = 9999990; i < 10000001; i++) {
//                System.out.println(arr[i]);
//            }
        });
        t1.start();
    }


    public static void arrayInputMultyThread(int threadNumber){

        if (threadNumber<=0){
            throw new RuntimeException("Thread number must be more than 0, your thread number is "+threadNumber);
        }
        float[] arr = new float[SIZE];
        long currentTime = System.currentTimeMillis();
        Arrays.fill(arr, 1);
        Thread[] threads = new Thread[threadNumber];
        int newSubArraySize=SIZE/threadNumber;
        int additionalSize=SIZE%threadNumber;
        float [][] complexArray=new float[threadNumber][];

        for (int i = 0; i < threadNumber; i++) {
            if (i == threadNumber - 1) {
                int size = newSubArraySize + additionalSize;
                complexArray[i] = new float[size];
                System.arraycopy(arr, i * newSubArraySize, complexArray[i], 0, size);
            }
            else {
                complexArray[i] = new float[newSubArraySize];
                System.arraycopy(arr, i * newSubArraySize, complexArray[i], 0, newSubArraySize);
            }
            float[] tempArr = complexArray[i];          //для передачи в анонимный класс
            int count = i;                              //для передачи в анонимный класс
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0, j = count * newSubArraySize; k < tempArr.length; k++, j++) {
                        tempArr[k] = (float) (tempArr[k] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
                    }
                }
            });
            threads[i].start();
        }
        try {
                for (int i = 0; i < threadNumber; i++) {
                        threads[i].join();
                }
            for (int i = 0; i < threadNumber; i++) {
                if(i==threadNumber-1){
                    System.arraycopy(complexArray[i],0,arr,i*newSubArraySize,newSubArraySize+additionalSize);
                }
                else
                System.arraycopy(complexArray[i],0,arr,i*newSubArraySize,newSubArraySize);
            }
            System.out.println("Время вычислений в "+threadNumber +" потоков "+(System.currentTimeMillis()-currentTime)+" миллисекунд");
            //проверка вычислений
//            for (int i = 9999990; i < 10000001; i++) {
//                System.out.println(arr[i]);
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
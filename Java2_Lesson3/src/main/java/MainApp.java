import java.util.*;


//        Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//                Посчитать, сколько раз встречается каждое слово.

public class MainApp {
    public static void main(String[] args) {
        Random rand = new Random();
        String[] array = new String[20];
        System.out.println("Array initialization and output:");
        for (int i = 0; i < array.length; i++) {
            array[i]="string"+rand.nextInt(10);
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println();
        int value;
        HashMap<String,Integer>hashMap= new HashMap<>(20);
        for (String i : array) {
            value=1;
            if(hashMap.containsKey(i)){
                value=hashMap.get(i);
                hashMap.put(i,++value);
            }
            else{                
                hashMap.put(i,value);
            }
        }
        System.out.println("Unique words:");
        System.out.println(hashMap.keySet());
//        for (Map.Entry<String,Integer> el : hashMap.entrySet()) {
//            if(el.getValue()==1)
//            System.out.print(el.getKey()+" ");
//        }

        System.out.println();
        System.out.println("how many times every word repeats:");
        for (Map.Entry<String,Integer> element: hashMap.entrySet()) {
            System.out.println(element.getKey()+" repeats "+ element.getValue()+" times");
        }

//        Задача номер два

        System.out.println();
        System.out.println();

        ContactBook phone =new ContactBook("Denis","777");
        phone.add("Ivan","1234");
        phone.add("Denis","1235");
        phone.add("Petr","1236");
        phone.add("David","123");
        phone.add("Petr","1231");

        System.out.println(phone.get("Denis"));
    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class ContactBook {
    HashMap<String, HashSet<String>> book;

    public ContactBook(){
        book= new HashMap<>(16);
    }

    public ContactBook(String name, String phone) {
        this.book= new HashMap<>(16);
        this.book.put(name,new HashSet<>(4));
        this.book.get(name).add(phone);
    }

    public void add(String name, String phone){
        if (!this.book.containsKey(name)) {
            this.book.put(name, new HashSet<>(4));
        }
        this.book.get(name).add(phone);
    }

    public Set<String> get(String name){
        System.out.print(name+ " ");
           return book.get(name);
    }
}

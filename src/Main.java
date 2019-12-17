
public class Main {

    public static void main(String[] args) {
        MyList t = new MyList();
        Node p, q;
        Person x;
        Person y = new Person("z");
        int k;
        String[] a = {"A", "C", "B", "E", "D"};
        
        System.out.println("Begin: ");
        t.addMany(a);
        t.traverse();
        
        System.out.println("1. Search By Name: ");
        p = t.searchByName("B"); 
        if(p==null) {
            System.out.println("Not found");
        } else {
            t.visit(p);
        }
        
        System.out.println("2. Add Last: ");
        t.addLast(y);
        
        t.traverse();
        
        System.out.println("3. Add First: "); 
        t.addFirst(new Person("t"));
        t.traverse();
        
        System.out.println("4. Insert After: ");
        x = new Person("zzz");
        q = t.searchByName("B");
        t.insertAfter(q, x);
        t.traverse();
        
        System.out.println("5. Insert Before: ");
        x = new Person("asdasd");
        q = t.searchByName("C");
        t.insertBefore(q, x);
        t.traverse();
        
        System.out.println("6. remove(Node p)");
        p = t.searchByName("A");
        t.remove(p);
        t.traverse();
        t.clear();
        t.addMany(a);
        System.out.println("7. remove(Name)");
        t.remove("C");
        t.traverse();
        
        t.clear();
        t.addMany(a);
        
        System.out.println("8. search index"); 
        p=t.pos(3);
        t.visit(p);
        
        System.out.println("9. Sort"); 
        t.sortByName();
        t.traverse();
        
        System.out.println("10. reverse");
        t.reverse();
        t.traverse();
        System.out.println();
    }
}

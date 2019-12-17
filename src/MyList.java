
public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

 
    void addLast(Person x) {
        Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info);
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    void addMany(String[] a) {
        int n, i;
        n = a.length;
        for (i = 0; i < n; i++) {
            addLast(new Person(a[i]));
        }
    }

   
    Node searchByName(String xName) {
        Node p = head;
        while (p != null) {
            if (p.info.name.equals(xName)) {
                return (p);
            }
            p = p.next;
        }
        return (null);
    }



    void addFirst(Person x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }

 
    void insertAfter(Node q, Person x) {
        if (q == null) {
            return;
        }
        Node r = q.next;
        Node u = new Node(x, r);
        q.next = u;
        if (tail == q) {
            tail = u;
        }
    }

   
    void insertBefore(Node q, Person x) {
        if (q == null) {
            return;
        }
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (f == null) // p is the head 
        {
            addFirst(x);
            return;
        }
        insertAfter(f, x);
    }

 
    void remove(Node q) {
        if (q == null) {
            return;
        }
        if (isEmpty()) {
            return;
        }
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) {
                break;
            }
            f = p;
            p = p.next;
        }
        if (p == null) {
            return;
        }
        if (f == null) {
            head = head.next;
            return;
        }
        f.next = p.next;
        if (f.next == null) {
            tail = f;
        }
    }

 
    void remove(String xName) {
        Node q = searchByName(xName);
        remove(q);
    }




    void removeAll(String name) {
        Node q = null;
        while (true) {
            q = searchByName(name);
            if (q == null) {
                break;
            }
            remove(q);
        }
    }

 
    Node pos(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }


    void removePos(int k) {
        Node q = pos(k);
        remove(q);
    }

    void sortByName() {
        Node pi, pj;
        Person x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pj.info.name.compareTo(pi.info.name) < 0) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }



    int size() {
        int i = 0;
        Node p = head;
        while (p != null) {
            i++;
            p = p.next;
        }
        return (i);
    }

  
    Person[] toArray() {
        int n = size();
        Person[] a = new Person[n];
        int i = 0;
        Node p = head;
        while (p != null) {
            a[i++] = new Person(p.info.name);
            p = p.next;
        }
        return (a);
    }

   
    void reverse() {
        MyList h = new MyList();
        Node p = head;
        while (p != null) {
            h.addFirst(new Person(p.info.name));
            p = p.next;
        }
        clear();
        head = h.head;
        tail = h.tail;
    }



 

  
    void setData(Node p, Person x) {
        if (p == null) {
            return;
        }
        p.info = x;
    }


  
}

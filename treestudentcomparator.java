import java.util.*;

class student {
    String name;
    int age, rollno;

    public student(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "(name: " + name + " Age: " + age + ")";
    }
}

class agecomparator implements Comparator<student> {
    public int compare(student s1, student s2) {
        return s1.age - s2.age;
    }
}

class namecomparator implements Comparator<student> {
    public int compare(student s1, student s2) {
        return s1.name.compareTo(s2.name);
    }
}

class 
treestudentcomparator{
    public static void main(String args[]) {
        agecomparator a = new agecomparator();
        namecomparator n = new namecomparator();
        TreeSet<student> ts1 = new TreeSet<>(a);
        TreeSet<student> ts2 = new TreeSet<>(n);
        student s1 = new student(1, "jogo", 32);
        student s2 = new student(2, "jiko", 34);
        ts1.add(s1);
        ts1.add(s2);
        System.out.println("\nSorted names are " + ts1);
        ts2.add(s1);
        ts2.add(s2);
        System.out.println("\nSorted ages are " + ts2);
    }
}

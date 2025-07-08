//Comparator for sorting TreeMaps with userdefined keys in descending order

import java.util.*;

class Student             //declaration of student class
{
	String name;
	int age,rollno;
	public Student(int rollno,String name,int age)   //parameterized constructor
	{
		this.rollno=rollno;
		this.name=name;
		this.age=age;
	}
	
	public String toString()                         //toString class overridden
	{
		return ("(Rollno: "+rollno+" Name: "+name+" Age: "+age+" )");
	}
};

class nameComparator implements Comparator<Student>       //name comparator class
{
	
	public int compare(Student s1,Student s2)
	{
		
		return (s2.name).compareTo(s1.name);           //returns keys in descending order of names
	}
};

class ageComparator implements Comparator<Student>      //age comparator class
{
	public int compare(Student s1,Student s2)
	{
		
		if(s1.age==s2.age)
			return 0;
		else if(s2.age<s1.age)                        
			return -1;
		else
			return 1;                                  //returns keys in descending order of age
	}
};


class TreeMapStudentComparatorDemo                       //main class
{
	public static void main(String args[])
	{
		
		nameComparator nc= new nameComparator();                                       //object for nameComparator
		ageComparator ac= new ageComparator();										   //object for ageComparator
		TreeMap<Student,Integer> tm = new TreeMap<>(nc);                               //TreeMap with name comaprator 
		TreeMap<Student,Integer> tm1 = new TreeMap<>(ac);                              //Treemap with age comparator
		Student s1=new Student(01,"Maya",17);
		Student s2=new Student(02,"Sara",19);                                          //creating student objects
		Student s3=new Student(03,"Kiki",18);
 		tm.put(s1,1);                                                                 //adding values 
		tm.put(s2,2);
		tm.put(s3,3);
		tm1.put(s1,1);
		tm1.put(s2,2);
		tm1.put(s3,3);
		
		System.out.println("\nSort According to Name In descending order\n");
		for(Map.Entry<Student,Integer> entry:tm.entrySet())                          //Iterator of TreeMap
		{
			System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());   //getKey calls toString method
		}	
		
		System.out.println("\nSort According to Age In descending order\n");
		for(Map.Entry<Student,Integer> entry2:tm1.entrySet())                          //Iterator for TreeMap
		{
			System.out.println("Key: "+entry2.getKey()+" Value: "+entry2.getValue());   //getKey calls toString method
		}	
	
	}
};
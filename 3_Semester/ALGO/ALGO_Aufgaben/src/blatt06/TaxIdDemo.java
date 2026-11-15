package blatt06;

public class TaxIdDemo {

	public static void main(String[] args) {
		demo1();
		demo2();
	}
		public static void demo1() {
			System.out.println("demo1():");
			Person[] list = {
				new Person("E", "59430238937"),
				new Person("C", "37302328985"),
				new Person("F", "65432127285"),
				new Person("B", "10002834593"),
				new Person("I", "93728594380"),
				new Person("A", "09372859430"),
				new Person("G", "77656937285"),
				new Person("H", "89372859430"),
				new Person("D", "37892859343"),
		};
	
		Person.taxIdSort(list);
		
		for (Person p : list) {
			System.out.println(p);
		}
	}
		
	public static void demo2() {
		System.out.println("demo2():");
		
		Person[] list = Person.generatePersonList(20);
		
		Person.taxIdSort(list);
		
		for (Person p : list) {
			System.out.println(p);
		}

	}
}

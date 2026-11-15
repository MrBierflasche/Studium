package blatt06;

import java.util.*;


public class Person implements Comparable<Person> 
{
	private String name; 
	private String taxID; //key = 11 digit tax ID (SteuerID)
	
	public static final int ID_LENGTH = 11;
	
	public Person(String name, String taxID) {
		this.name = name;
		this.taxID = taxID;
	}
	
	public String getTaxId() {
		return taxID;
	}

	public String toString() {
		return name + ", ID: " + taxID;
	}


	
	public static void taxIdSort(Person[] alist) {
        int pos = 10;
        // TaxId ist 11 Stellen lang
        while(pos >= 0) {
            // Dictionary mit den jeweiligen Buckets für jede Ziffern anlegen
            Map<Integer, List<Person>> buckets = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                buckets.put(i, new ArrayList<>());
            }

            // Partitionierungsphase: Person ins Fach ihrer Ziffer bei Position pos
            for (Person p : alist) {
                int digit = p.getTaxId().charAt(pos) - '0';
                buckets.get(digit).add(p);
            }

            // Sammelphase: Fächer 0-9 der Reihe nach zurück in die Liste
            int i = 0;
            for (int j = 0; j < 10; j++) {
                for (Person p : buckets.get(j)) {
                    alist[i++] = p;
                }
            }

            pos--;
        }
	}
	
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Person) {
			Person pOther = (Person) other;
			return taxID.equals(pOther.taxID);
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(Person other) {
		return taxID.compareTo(other.taxID);
	}
	
	
	
	/** generates an array containing the specified number of persons with random tax IDs */
	public static Person[] generatePersonList(int number) {
		Person[] aliste = new Person[number];
		
		Random rand = new Random();
		
		for (int i = 0; i < aliste.length; i++) {
			String name = "P_" + i;
			//generate random tax ID
			StringBuffer taxID = new StringBuffer();
			for (int pos = 0; pos < Person.ID_LENGTH; pos++) {
				char nextDigit = (char) ('0' + rand.nextInt(10));
				taxID.append(nextDigit);
			}
			
			aliste[i] = new Person(name, taxID.toString());
		}
		
		return aliste;
	}
	
	
}

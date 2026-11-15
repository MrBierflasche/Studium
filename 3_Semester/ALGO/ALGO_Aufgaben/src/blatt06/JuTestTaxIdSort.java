package blatt06;

//JUnit 5 (Jupiter)
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class JuTestTaxIdSort {

	@Test
	public void testTaxIDSort_1() {
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

		assertEquals("A, ID: 09372859430", list[0].toString());
		assertEquals("B, ID: 10002834593", list[1].toString());
		assertEquals("C, ID: 37302328985", list[2].toString());
		assertEquals("D, ID: 37892859343", list[3].toString());
		assertEquals("E, ID: 59430238937", list[4].toString());
		assertEquals("F, ID: 65432127285", list[5].toString());
		assertEquals("G, ID: 77656937285", list[6].toString());
		assertEquals("H, ID: 89372859430", list[7].toString());
		assertEquals("I, ID: 93728594380", list[8].toString());	
	}

	
	@Test
	public void testTaxIDSort_2() {
		Person[] list = Person.generatePersonList(1000);
		Person.taxIdSort(list);
		
		// compare all adjacent values if they are ordered correctly
		//System.out.println(list[0]);		
		for (int i = 0; i < list.length-1; i++) {
			//System.out.println(list[i+1]);

			int res = list[i].getTaxId().compareTo(list[i+1].getTaxId());
			assertTrue(res <= 0);
			
		}
	}
	
	@Test
	public void testTaxIDSort_3() {
		Person[] list1 = Person.generatePersonList(1000);
		Person[] list2 = list1.clone();
		
 		Person.taxIdSort(list1);
		Arrays.sort(list2);
		
		for (int i = 0; i < list1.length; i++) {
			assertEquals(list2[i], list1[i]);
			
		}
	}
	
}

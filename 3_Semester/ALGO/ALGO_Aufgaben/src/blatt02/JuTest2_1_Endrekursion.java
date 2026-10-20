package blatt02;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JuTest2_1_Endrekursion {

	@Test
	void testFakIter_1() {
		for (int i = 1; i <= 20; i++) {
			assertEquals(Aufg2_1_Endrekursion.factorialIter(i), Aufg2_1_Endrekursion.factorialRec(i));
		}
		
	}
}

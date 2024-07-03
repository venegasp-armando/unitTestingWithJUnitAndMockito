package com.in28minutes.unit.testing.lab;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.in28minutes.unit.testing.lab.others.SomeDataService;


public class SomeBusinessServiceStubTest {
		
	@Test
	public void testCalculateSum() {	
		SomeDataService dataService = Mockito.mock(SomeDataService.class);
		when(dataService.retrieveData()).thenReturn(new int[] { 10, 20 });
		
		SomeBusinessService someBusinessService = new SomeBusinessService(dataService);
		assertEquals(30, someBusinessService.calculateSum());
	}
	
	
	
}

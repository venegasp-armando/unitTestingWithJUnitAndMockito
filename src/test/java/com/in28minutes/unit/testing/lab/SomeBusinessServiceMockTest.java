package com.in28minutes.unit.testing.lab;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unit.testing.lab.others.SomeDataService;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessServiceMockTest {
	
	@Mock
	SomeDataService dataService;
	
	@InjectMocks
	SomeBusinessService businessService;
	
	@Test
	public void testBasic() {	
		dataService = Mockito.mock(SomeDataService.class);
		
		//Basic
		when(dataService.retrieveData()).thenReturn(new int[] { 10, 20 });
		businessService = new SomeBusinessService(dataService);
		assertEquals(30, businessService.calculateSum());
		//Only one element
		when(dataService.retrieveData()).thenReturn(new int[] { 10 });
		businessService = new SomeBusinessService(dataService);
		assertEquals(10, businessService.calculateSum());
		//Empty
		when(dataService.retrieveData()).thenReturn(new int[] { });
		businessService = new SomeBusinessService(dataService);
		assertEquals(0, businessService.calculateSum());
		//Null
		when(dataService.retrieveData()).thenReturn(null);
		Exception exception = assertThrows(NullPointerException.class, () -> {
			businessService = new SomeBusinessService(dataService);
			businessService.calculateSum();
		});
	    assertTrue(exception.getMessage().contains("Cannot read the array length because \"array\" is null"));
		
	}
	
}

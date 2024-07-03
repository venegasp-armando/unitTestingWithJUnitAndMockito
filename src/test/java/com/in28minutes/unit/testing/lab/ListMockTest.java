package com.in28minutes.unit.testing.lab;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ListMockTest {

	List<String> mock = mock(List.class);

	@Test
	public void simpleMocking() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
		
		when(mock.get(0)).thenReturn(null);
		assertNull(mock.get(0));
		
		when(mock.get(anyInt())).thenReturn("Element valid");
		assertEquals("Element valid", mock.get(anyInt()));
		
		// Verify
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
		
		//Mock
		ArrayList listMock = mock(ArrayList.class);
		System.out.println(listMock.get(0));// null
		System.out.println(listMock.size());// 0
		listMock.add("Value 1");
		listMock.add("Value 2");
		System.out.println(listMock.size());// 0
		
		//Spy
		ArrayList listSpy = spy(ArrayList.class);
		listSpy.add("Value 0");
		System.out.println(listSpy.get(0));// Value 0
		System.out.println(listSpy.size());// 1
		listSpy.add("Value 1");
		listSpy.add("Value 2");
		System.out.println(listSpy.size());// 3
	}
}
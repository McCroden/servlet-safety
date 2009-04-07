package com.wesabe.servlet.normalizers.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import com.wesabe.servlet.normalizers.ValidationException;

@RunWith(Enclosed.class)
public class ValidationExceptionTest {
	public static class Throwing_A_Validation_Exception_Directly {
		@Test
		public void itHasAValue() throws Exception {
			ValidationException exception = new ValidationException("200", "is even");
			assertEquals("200", exception.getValue());
		}
		
		@Test
		public void itHasADescriptiveMessage() throws Exception {
			ValidationException exception = new ValidationException("200", "is even");
			assertEquals("Invalid value: 200 (is even)", exception.getMessage());
		}
	}
	
	public static class Throwing_A_Validation_Exception_With_An_Underlying_Cause {
		@Test
		public void itHasADescriptiveMessage() throws Exception {
			Exception cause = new Exception("eff");
			ValidationException exception = new ValidationException("200", cause);
			assertEquals("Invalid value: 200 (eff)", exception.getMessage());
		}
		
		@Test
		public void itHasACause() throws Exception {
			Exception cause = new Exception("eff");
			ValidationException exception = new ValidationException("200", cause);
			assertEquals(cause, exception.getCause());
		}
	}
}

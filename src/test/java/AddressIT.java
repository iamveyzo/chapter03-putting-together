package test.java;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import main.java.Address;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddressIT {

	private static ValidatorFactory vf;
	private static Validator validator;

	@BeforeClass
	public static void init() {
		vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();
	}

	@AfterClass
	public static void close() {
		vf.close();
	}

	@Test
	public void shouldRaiseConstraintViolationCauseInvalidZipCode() {

		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();

		Address address = new Address("233 Spring Street", null, "New York", "NY", "DummyZip", "USA");
		Set<ConstraintViolation<Address>> violations = validator.validate(address);
		assertEquals(1, violations.size());
	}
}

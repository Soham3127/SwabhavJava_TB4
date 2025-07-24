package com.aurionpro.testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AssertAllDemo {

	@Test
	public void testUserDetails() {
		String name = "Soham";
		int age = 30;
		String city = "Mumbai";

		assertAll("User details", () -> assertEquals("Soham", name), () -> assertTrue(age > 18),
				() -> assertEquals("Mumbai", city)

		);

	}

}

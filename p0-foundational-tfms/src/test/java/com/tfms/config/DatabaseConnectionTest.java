
package com.tfms.config;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;



public class DatabaseConnectionTest {
	@Test
	public void testConnection() {
		assertNotNull(new DatabaseConnection().getConnection());
	}

	
	@Test
	public void authenticateUserTest() {
		
		String username = "admin";
		
		assertEquals(username, "admin");
}
}
	
	
package com.emailchecker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.emailchecker.service.EmailCheckerService;

public class EmailCheckerServiceTest {
	
	EmailCheckerService emailCheckerService = new EmailCheckerService();
	
	List<String> emails = new ArrayList<String> ();
	
	@BeforeEach
	public void setup() {
		emails.clear();
	}
	
	@Test
	public void testInvalidEmailCount() {
		emails.add("test+x@.com");
		emails.add("test.x.com");
		emails.add("test@gmail.com");
		assertEquals(1,emailCheckerService.getUniqueEmail(emails));
	}

	@Test
	public void testDuplicateEmailCount() {
		emails.add("test@gmail.com");
		emails.add("test@gmail.com");
		assertEquals(1,emailCheckerService.getUniqueEmail(emails));
	}

	@Test
	public void testEmptyEmailCount() {
		assertEquals(0,emailCheckerService.getUniqueEmail(emails));
	}

	@Test
	public void testEmailCountForUserNameWithSpecialCharacters() {
		emails.add("testx+x@gmail.com");
		emails.add("test.x@gmail.com");
		assertEquals(1,emailCheckerService.getUniqueEmail(emails));
	}
	
	@Test
	public void testEmailCountWithNullValues() {
		emails.add(null);
		assertEquals(0,emailCheckerService.getUniqueEmail(emails));
	}
	
}

package com.emailchecker.service;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class EmailCheckerService {
	private static final String GMAIL_REGEX = "^[\\w.+\\-]+@gmail\\.com$";
	public int getUniqueEmail(List<String> emails) {
		Pattern pattern = Pattern.compile(GMAIL_REGEX);
		HashSet<String> uniqueUserNames = new HashSet<>();
		// match the gmail pattern
		for (String email : emails) {
			if(email != null) {
				Matcher emailMatcher = pattern.matcher(email);
				boolean isPatternMatched = emailMatcher.matches();
				// check for unique gmail
				if (isPatternMatched) {
					String uniqueUserName = getUniqueUserName(email);
					uniqueUserNames.add(uniqueUserName);
				}
			}
		}
		return uniqueUserNames.size();
	}

	private String getUniqueUserName(String email) {
		String uniqueUserName = "";
		String[] userName = email.split("@gmail.com");
		if (userName[0].contains("+")) {
			String[] splitUserName = userName[0].split("\\+");
			uniqueUserName = splitUserName[0].replace(".", "");
		} else {
			uniqueUserName = userName[0].replace(".", "");
		}
		return uniqueUserName;
	}
}

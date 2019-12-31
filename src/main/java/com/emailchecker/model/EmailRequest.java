package com.emailchecker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailRequest {
	@JsonProperty("emails")
	private List<String> emails;

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
}

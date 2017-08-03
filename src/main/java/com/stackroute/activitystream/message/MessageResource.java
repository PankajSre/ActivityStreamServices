package com.stackroute.activitystream.message;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class MessageResource extends ResourceSupport {
	@JsonUnwrapped
	private UserMessage userMessage;

	public UserMessage getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(UserMessage userMessage) {
		this.userMessage = userMessage;
	}

}

package com.stackroute.activitystream.message;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class UserMessageAssembler extends ResourceAssemblerSupport<UserMessage, MessageResource> {

	public UserMessageAssembler() {
		super(MessageRestController.class, MessageResource.class);
	}

	@Override
	public MessageResource toResource(UserMessage userMessage) {

		MessageResource messageResource = createResourceWithId(userMessage.getMessageId(), userMessage);
		 
		Link messageLink = ControllerLinkBuilder.linkTo(methodOn(MessageRestController.class).getAllMessagesByUser(userMessage)).withSelfRel();
		 
		messageResource.setUserMessage(userMessage);
		messageResource.add(messageLink);
		 
		return messageResource;
	}

}

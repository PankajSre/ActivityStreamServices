package com.stackroute.activitystream.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;


@RestController
@RequestMapping("/api/message")
public class MessageRestController {


	@Autowired
	UserMessageDAO userMessageDAO;
	
	
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public ResponseEntity<UserMessage> sendMessage(@RequestBody UserMessage userMessage) {

		if (userMessageDAO.sendMessage(userMessage) == true) {
			userMessage.setErrorCode("200");
			userMessage.setErrorMessage("Your Message have been sent Successfully");
		} else {
			userMessage.setErrorCode("404");
			userMessage.setErrorMessage("Your Circle has  been created");
		}
		return new ResponseEntity<UserMessage>(userMessage, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/messageById/{messageId}", method = RequestMethod.GET)
	public ResponseEntity<UserMessage> getMessageById(@PathVariable("messageId") int messageId) {
		UserMessage userMessage=userMessageDAO.getMessageByMessageId(messageId);
		if (userMessage == null) {
			userMessage = new UserMessage();
			userMessage.setErrorCode("404");
			userMessage.setErrorMessage("Circle does not exist");
			return new ResponseEntity<UserMessage>(userMessage, HttpStatus.OK);
		}
		System.out.println("MessaageId :"+messageId);
		userMessage.add(linkTo(MessageRestController.class).slash(userMessage.getMessageId()).withSelfRel());
		System.out.println("MessaageId :"+messageId);
		return new ResponseEntity<UserMessage>(userMessage, HttpStatus.OK);
	}
	@RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
	public ResponseEntity<?> deleteMessage(@RequestBody UserMessage userMessage) {
		userMessageDAO.deleteMessage(userMessage.getMessageId(), userMessage.getReceiverEmailId());
		userMessage.add(linkTo(methodOn(MessageRestController.class).deleteMessage(userMessage)).withSelfRel());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/getMyMessages")
	public ResponseEntity<List<UserMessage>> getAllMessagesByUser(@RequestBody UserMessage userMessage) {
		
		List<UserMessage> userMessages= userMessageDAO.getMyMessages(userMessage.getReceiverEmailId());	
		return new ResponseEntity<List<UserMessage>>(userMessages, HttpStatus.OK);
	}
	@GetMapping("/getAllMessagesByCircleName/{circleName}")
	public List<UserMessage> getAllMessagesByCircleName(@PathVariable("circleName") String circleName)
	{
		List<UserMessage> messageList=userMessageDAO.getAllMessageByCircleName(circleName);
		for(UserMessage message : messageList)
		{
			Link link=linkTo(MessageRestController.class).slash(message.getCircleName()).withSelfRel();
			message.add(link);
		}
		return messageList;
	}
}

package com.stackroute.activitystream.message;

import java.util.List;


public interface UserMessageDAO {

	boolean sendMessage(UserMessage message);
	boolean deleteMessage(int messageId, String emailId);
	List<UserMessage> getMyMessages(String emailId);
	UserMessage getMessageByMessageId(int messageId);
	List<UserMessage> getAllMessageByCircleName(String circleName);
}

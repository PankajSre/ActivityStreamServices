package com.stackroute.activitystream;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.activitystream.ActivityStreamUser;
import com.stackroute.activitystream.User;
import com.stackroute.activitystream.UserDAO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT,classes=ActivityStreamUser.class)
public class UserTest {

	@Autowired
	private  UserDAO userDAO;

  
	@Test
	public void testValidateUser()
	{
		
	}

}
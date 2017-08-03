package com.stackroute.activitystream.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.dao.UserCircleDAO;
import com.stackroute.activitystream.model.UserCircle;



@RestController
@RequestMapping("/api/circle")
public class CircleRestController {


	@Autowired
	UserCircleDAO userCircleDAO;
	
	@RequestMapping(value = "/createCircle", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserCircle> createCircle(@RequestBody UserCircle userCircle) {

		if (userCircleDAO.addCircle(userCircle) == true) {
			userCircle.setErrorCode("200");
			userCircle.setErrorMessage("you have Successfully created the Circle ");
		} else {
			userCircle.setErrorCode("404");
			userCircle.setErrorMessage("Your Circle has not been created");
		}
		return new ResponseEntity<UserCircle>(userCircle, HttpStatus.OK);
	}
	@RequestMapping(value = "/circleById/{circleName}", method = RequestMethod.GET)
	public ResponseEntity<UserCircle> getCircleById(@PathVariable("circleName") String circleName) {
		UserCircle userCircle =userCircleDAO.getCircleByName(circleName);
		if (userCircle == null) {
			userCircle = new UserCircle();
			userCircle.setErrorCode("404");
			userCircle.setErrorMessage("Circle does not exist");
			return new ResponseEntity<UserCircle>(userCircle, HttpStatus.OK);
		}
		
		return new ResponseEntity<UserCircle>(userCircle, HttpStatus.OK);
	}
	@RequestMapping(value = "/deactivateCircle/{circleName}", method = RequestMethod.PUT)
	public ResponseEntity<UserCircle> deleteCircleById(@PathVariable("circleName") String circleName) {
		UserCircle userCircle =userCircleDAO.getCircleByName(circleName);
		if (userCircle == null) {
			userCircle = new UserCircle();
			userCircle.setErrorCode("404");
			userCircle.setErrorMessage("Circle does not exist");
			return new ResponseEntity<UserCircle>(userCircle, HttpStatus.OK);
		}
		userCircleDAO.deleteCircle(userCircle, userCircle.getCreatedBy());
		return new ResponseEntity<UserCircle>(userCircle, HttpStatus.OK);
	}
}

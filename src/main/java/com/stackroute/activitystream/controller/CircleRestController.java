package com.stackroute.activitystream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.activitystream.dao.CircleDAO;
import com.stackroute.activitystream.model.Circle;
import com.stackroute.activitystream.model.UserCircle;
@RestController
@RequestMapping("/api/circles")
public class CircleRestController {

	@Autowired
	CircleDAO circleDAO;
	
	@RequestMapping(value = "/createCircle", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Circle> createCircle(@RequestBody Circle userCircle) {

		if (circleDAO.addCircle(userCircle) == true) {
			userCircle.setErrorCode("200");
			userCircle.setErrorMessage("you have Successfully created the Circle ");
		} else {
			userCircle.setErrorCode("404");
			userCircle.setErrorMessage("Your Circle has not been created");
		}
		return new ResponseEntity<Circle>(userCircle, HttpStatus.OK);
	}
	
	@GetMapping("/getAllCircles")
	public List<Circle> getAllCircles()
	{
		List<Circle> allCircles=circleDAO.getAllCircles();
		
		return allCircles;
	}
	
}

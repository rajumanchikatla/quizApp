package com.project.quizApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizApp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,
											 @RequestParam Integer numQ,
											 @RequestParam String title)
	{
		return quizService.createQuiz(category,numQ,title);
//		return new ResponseEntity<String>("im raju here",HttpStatus.OK);
		
	}

}

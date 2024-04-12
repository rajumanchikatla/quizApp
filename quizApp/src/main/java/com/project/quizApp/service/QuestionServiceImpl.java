package com.project.quizApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.quizApp.Dao.QuestionDao;
import com.project.quizApp.entity.Question;

@Service
public class QuestionServiceImpl {

	@Autowired
	private QuestionDao questionDao;

	public ResponseEntity<List<Question>>getAllQuestions(){
		// TODO Auto-generated method stub
		try {
			List<Question> questions = questionDao.findAll();
			return new ResponseEntity<>(questions,HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>(questionDao.findQuestionsByCategory(category),HttpStatus.OK);
		} catch(Exception e) {

			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {

		questionDao.save(question);
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>("saved succesfully",HttpStatus.CREATED);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}



}

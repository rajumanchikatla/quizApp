package com.project.quizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.quizApp.Dao.QuestionDao;
import com.project.quizApp.Dao.QuizDao;
import com.project.quizApp.entity.Question;
import com.project.quizApp.entity.Quiz;

@Service
public class QuizService {
	
	@Autowired
	private QuizDao quizDao;
	
	@Autowired
	private QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		List<Question> questions = questionDao.findQuestionByCategory(category,numQ);
				
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("sucess",HttpStatus.CREATED);
	}

}

package com.project.quizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.quizApp.Dao.QuestionDao;
import com.project.quizApp.Dao.QuizDao;
import com.project.quizApp.entity.Question;
import com.project.quizApp.entity.QuestionWrapper;
import com.project.quizApp.entity.Quiz;
import com.project.quizApp.entity.Response;

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

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDb = quiz.get().getQuestion();
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		
		for(Question q : questionsFromDb){
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4(), q.getQuestionTitle());
			
			questionForUser.add(qw);	
		}
		
		return new ResponseEntity<>(questionForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		
		Quiz quiz = quizDao.findById(id).get();
		
		List<Question> questions = quiz.getQuestion();
		
		int right = 0;
		int i = 0;
		for(Response response : responses){
			if(response.getRightAnswer().equalsIgnoreCase(questions.get(i).getRightAnswer()))
				right++;
				i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

}

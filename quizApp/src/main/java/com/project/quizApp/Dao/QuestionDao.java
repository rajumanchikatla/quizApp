package com.project.quizApp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.quizApp.entity.Question;

public interface QuestionDao extends JpaRepository<Question,Long> {

	List<Question> findQuestionsByCategory(String category);

	@Query(value= "SELECT * FROM question q where q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
	List<Question> findQuestionByCategory(@Param(value = "category") String category, @Param(value = "numQ") int numQ);

}

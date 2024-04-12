package com.project.quizApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quizApp.entity.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
